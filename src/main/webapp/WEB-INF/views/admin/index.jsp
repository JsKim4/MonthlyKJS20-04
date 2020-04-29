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
	<title>LOTTO ADMIN</title>
</head>
<body> 
	<div class="container" style="height:100%;">
		<header style="height:10%;margin-bottom:5%;">
			<%@ include file="/WEB-INF/views/header.jsp" %>
		</header>
		<article>
			<div class="lottoFrame">
				<form>
					<div class="input-group mb-3">
						<input type="text" class="form-control" id="insertTagName" placeholder="TagName" aria-label="TagName" aria-describedby="button-addon2">
					  	<div class="input-group-append">
					    	<button class="btn btn-outline-secondary" type="button" id="tagRegister">Register</button>
					  	</div>
					</div>
				</form>
				<div class="row align-items-end">
					<h2 class="font-weight-bold">Tag List</h2>
				</div>
				<div class="row text-primary" style="font-size: 4px;">
					<c:out value="Tag가 파란색일때는 현재 선택된 태그입니다."/>
				</div>
				<ul id="tagList">
					
				</ul>
			</div>
			<div class="lottoFrame">
			2
			</div>
		</article>
		<footer>
			<a href="<c:url  value="/logout"/>">logout</a>
		</footer>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/admin.js?ver=2" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/Lotto.js?ver=2" />"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	

	setTagList();
	
	$("#tagRegister").on("click",function(){
		var name = document.getElementById("insertTagName").value;
		lottoService.insertTag(name,function(result){
			if(result==='success'){
				alert("태그 등록에 성공하였습니다.");
				setTagList();
			}else
				alert(result);
		});
	});
	
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
});
</script>
</html>
