<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<head>
	<style>
		ul{
			list-style:none;
			width:100%;
		}
		li{
			width:10%;
			height:10%;
			padding:3%;
			font-size:160%;
			margin:0;
			font-weight: 700!important;
			background-color:--blue;
			float:left;
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
			<ul id="drwtNo">
				
			</ul>
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
		var j = 0;
		for(var i=1;i<=45;i++){
			str+="<li value='"+((j<result.length)&&(parseInt(result[j].drwtNo)===i)?result[j++].count:0)+"'>"+i+"</li>"
		}
		$("#drwtNo").html(str);
	});
</script>
</html>
