<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<head>
	<title>LOTTO MAIN</title>
</head>
<body> 
	<div class="container" style="height:100%;">
		<header>
			<div class="row align-items-end" style="min-height:30%;margin-bottom:1%;">
				<h2 class="font-weight-bold">Lotto Searcher</h2>
			</div>
		</header>
		<article>
			<div class="row font-italic" style="margin-bottom:4%;font-size: 4px;">
				회차 정보는 매주 토요일 21시에 업데이트 됩니다.
			</div>
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<div class="dropdown-menu">
				  		<a id="dateSearch" class="dropdown-item">날짜로 검색</a>
				    	<a id="drwSearch" class="dropdown-item">회차로 검색</a>
				  	</div>
				</div>
				<input type="number" id="order" class="form-control" placeholder="회자 정보를 입력해 주십시요" aria-label="Text input with dropdown button">
			</div>
			<div class="row">
				<div class="col-2">
					<font class="font-weight-bold" id="lottoDate"></font>
				</div>
				<div class="col-2 ml-auto">
					<font id="status" class="badge badge-success">Success</font>
				</div>
			</div>
			<div class="row font-weight-bold" style="margin-top:5%;">
				<div class="col text-primary">1</div>
				<div class="col text-primary">2</div>
				<div class="col text-primary">3</div>
				<div class="col text-primary">4</div>
				<div class="col text-primary">5</div>
				<div class="col text-primary">6</div>
				<div class="col text-danger">B</div>
			</div>
			<div class="row font-italic" style="margin-top:5%;">
				<div class="col" id="drwtNo1"></div>
				<div class="col" id="drwtNo2"></div>
				<div class="col" id="drwtNo3"></div>
				<div class="col" id="drwtNo4"></div>
				<div class="col" id="drwtNo5"></div>
				<div class="col" id="drwtNo6"></div>
				<div class="col" id="bnusNo"></div>
			</div>
		</article>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/Lotto.js?ver=12" />"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#order").on("propertychange change paste input", function() {
		if(this.value==='')
			return;
		lottoService.getLottoNumber(this.value,function(result){
			document.getElementById('status').className = "badge badge-success";
			document.getElementById('status').innerHTML = "Success";
			$("#drwtNo1").html(result.drwtNo1);
			$("#drwtNo2").html(result.drwtNo2);
			$("#drwtNo3").html(result.drwtNo3);
			$("#drwtNo4").html(result.drwtNo4);
			$("#drwtNo5").html(result.drwtNo5);
			$("#drwtNo6").html(result.drwtNo6);
			$("#bnusNo").html(result.bnusNo);
			$("#lottoDate").html(result.drwNoDate);
		},
		function(){
			document.getElementById('status').className = "badge badge-danger";
			document.getElementById('status').innerHTML = "Fail";
		});
	});
});
</script>
</html>
