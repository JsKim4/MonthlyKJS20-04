<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<head>
	<style>
		.lottoFrame{
			width:50%;
			float:left;
			min-height:80%;
			padding:1%;
		}
		ul{
			list-style:none;
			width:100%;
			height:100%;
			
		}
		li{
			width:14%;
			height:10%;
			padding:3%;
			font-size:100%;
			font-weight: 700!important;
			float:left;
			margin:0 0 -3px -3px;
			border:3px solid #df9498;
			color:#ac575a;
		}
		li.tag{
			width:33%;
			height:5%;
			padding:1%;
		}
		button{
			width:100%;
		}
	</style>
	<title>LOTTO Simulation</title>
</head>
<body> 
	<div class="container" style="height:100%;">
		<header style="height:10%;margin-bottom:5%;">
			<%@ include file="/WEB-INF/views/header.jsp" %>
		</header>
		<article>
			<div class="lottoFrame">
				<ul id="drwtNo">
					
				</ul>
			</div>
			<div class="lottoFrame" id="congratulation">
			</div>
		</article>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/Lotto.js?ver=4s" />"></script>
<script type="text/javascript">
var selected=new Array;
var str="";
for(var i=1;i<=45;i++){
	str+="<li name='num-"+i+"' value='"+i+"' clicked='false'>"+i+"</li>";
}
$("#drwtNo").html(str);
$("li[name^=num]").click(function(){
	var tf= $(this).attr("clicked");
	if(tf==='false'){
		var num =$(this).attr("value"); 
		$(this).attr("clicked",'true');
		$(this).css("background",'#000');
		selected.push(num);
		if(selected.length>6){
			$("li[name=num-"+selected[0]+"]").attr("clicked",'false');
			$("li[name=num-"+selected[0]+"]").css("background",'#fff');
			selected.splice(0,1);
		}
	}
	else{
		var num =$(this).attr("value");
		$(this).attr("clicked",'false');
		$(this).css("background",'#fff');
		for(var i=0;i<selected.length;i++){
			if(selected[i]==num){
				selected.splice(i,1);
			}
		}
	}
	if(selected.length==6){
		lottoService.getSimluationList(selected,function(result){
			var str="";
			var i = 0;
			console.log(result);
			for(; i<result.length&&i<result[i].rank=="1등";i++)
				str += "<h1>축 1등 : "+result[i].drwNo+"</h1>";
			for(; i<result.length&&i<result[i].rank=="2등";i++)
				str += "<h2>축 2등 : "+result[i].drwNo+"</h2>";
			for(; i<result.length&&i<result[i].rank=="3등";i++)
				str += "<h3>축 3등 : "+result[i].drwNo+"</h3>";
			for(; i<result.length&&i<result[i].rank=="4등";i++)
				str += "<h4>축 4등 : "+result[i].drwNo+"</h4>";
			if(result.length==0){
				str="<h2>당첨회차가 없습니다 ㅜㅡㅠ</h2>";
			}
			$("#congratulation").html(str);
		});
	}
});
</script>
</html>
