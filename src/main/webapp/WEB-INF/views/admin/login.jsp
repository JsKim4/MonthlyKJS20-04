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
			<div class="form-group">
			 	<label for="exampleDropdownFormEmail2">Email address</label>
			 	<input type="email" id="id" class="form-control" placeholder="email@example.com">
			</div>
			<div class="form-group">
			  <label for="exampleDropdownFormPassword2">Password</label>
			  <input type="password" id="pw" class="form-control" placeholder="Password">
			</div>
			<button type="submit" id="loginBtn" class="btn btn-primary">Sign in</button>
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
				location.reload();
			}else
				alert("로그인에 실패하였습니다.");
		});
	});
});
</script>
</html>
