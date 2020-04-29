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
			height:14%;
			padding:3%;
			font-size:100%;
			margin:0;
			font-weight: 700!important;
			background-color:--blue;
			float:left;
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
	<title>LOTTO STATISICS</title>
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
			<div class="lottoFrame">
				<div class="row align-items-end">
					<h2 class="font-weight-bold">Tag List</h2>
				</div>
				<div class="row  text-secondary" style="font-size: 4px;">
					<c:out value="Tag가 회색일때는 선택되지 않은 상태입니다."/>
				</div>
				<div class="row  text-primary" style="font-size: 4px;">
					<c:out value="Tag가 파란색일때는 Or조건으로 선택된 상태입니다."/>
				</div>
				<div class="row  text-danger" style="font-size: 4px;">
					<c:out value="Tag가 붉은색일때는 And 조건으로 선택된 상태입니다."/>
				</div>
				<div class="row  text-info" style="font-size: 4px;">
					<c:out value="Or 조건 연산이 완료된 후 And 조건을 연산합니다."/>
				</div>
				<ul id="tagList">
				</ul>
			</div>
		</article>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/Lotto.js?ver=2" />"></script>
<script type="text/javascript">


	lottoService.getLottoStatList(function(result){
		var str="";
		var max = 0;
		var min = 10000;
		var j = 0;
		for(var i=0;i<result.length;i++){
			if(parseInt(result[i].count) > max)
				max = parseInt(result[i].count);
			if(parseInt(result[i].count)< min)
				min = parseInt(result[i].count);
		}
		if(result.length<45)
			min = 0;
		min/=1.2;
		max-=min;
		for(var i=1;i<=45;i++){
			var num = ((j<result.length)&&(parseInt(result[j].drwtNo)===i)?result[j++].count:0);
			str+="<li style='background:rgba(31,154,223,"+(num-min)/max+")' value='"+num+"'>"+i+"</li>";
		}
		$("#drwtNo").html(str);
	});
	
	setTagList();
	
	function setTagList(){
		lottoService.getTagList(function(result){
			var str = ""; 
			for(var i=0;i<result.length;i++){
				console.log(result[i]);
				str+=getAddHtmlText(result[i]);
			}
			$("#tagList").html(str);	
		});	
	}
	
	function getAddHtmlText(tag){
		var str = "";
		str+='<li class="tag">';
		str+='	<button type="button" class="btn btn-secondary btn-sm" value="'+tag.tagSeq+'">'+tag.tagName+'</button>';
		str+='</li>';	
		return str;
	}
</script>
</html>
