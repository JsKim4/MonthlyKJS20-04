<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<head>
	<title>LOTTO ADMIN</title>
</head>
<body> 
	<div class="container" style="height:100%;">
		<header style="height:10%;margin-bottom:5%;">
			<%@ include file="/WEB-INF/views/header.jsp" %>
		</header>
		<article>
			<div>
				<label for="id">ID  : </label>
				<input id="id" type="text">	
			</div>
			<div>
				<label for="pw">PW : </label>
				<input id="pw" type="password">		
			</div>
			<div>
				<button type="button" class="btn btn-primary btn-lg" id="loginBtn">Login</button>
			</div>
		</article>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/admin.js?ver=2" />"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#loginBtn").on("click",function(){
		var loginInfo = {"id":document.getElementById("id").value,"password":document.getElementById("pw").value};
		console.log(loginInfo);
		adminService.adminLogin(loginInfo,function(result){
			if(result==='success'){
				location.href="/Lotto/admin/tag";
			}
		});
	});
	
	
});
</script>
</html>
