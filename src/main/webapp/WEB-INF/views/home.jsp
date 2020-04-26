<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<head>
	<title>LOTTO MAIN</title>
</head>
<body> 
	<div class="container" style="height:100%;">
		<header style="height:30%;margin-bottom:4%;">
			<%@ include file="/WEB-INF/views/header.jsp" %>
		</header>
		<article>
			<div class="input-group mb-3">
				 <select class="custom-select" id="searchSelect" style="flex:1;">
				    <option value="drw" selected>회차 검색</option>
				    <option value="date">날짜 검색</option>
				 </select>
				<input type="number" id="order" style="flex:6;" class="form-control" placeholder="날짜입력은 하이폰(-) 없이 8자리의 숫자입니다." aria-label="Text input with dropdown button">
			</div>
			<div class="row">
				<div class="col-2">
					<font class="font-weight-bold" id="lottoDate"></font>
				</div>
				<div class="col-2 ml-auto">
					<font id="status" class="badge badge-success">Success</font>
				</div>
			</div>
			<div class="row font-italic font-weight-bold" style="margin-top:5%;height:5%;font-size:4vw;">
				<div class="col text-primary" id="drwtNo1">1</div>
				<div class="col text-primary" id="drwtNo2">2</div>
				<div class="col text-primary" id="drwtNo3">3</div>
				<div class="col text-primary" id="drwtNo4">4</div>
				<div class="col text-primary" id="drwtNo5">5</div>
				<div class="col text-primary" id="drwtNo6">6</div>
				<div class="col text-danger" id="bnusNo">B</div>
			</div>
			<button onclick="location.href='<c:url  value="/statistics"/>'" type="button" class="btn btn-primary btn-lg btn-block" style="margin-top:10%;">로또 통계</button>
			<button type="button" class="btn btn-secondary btn-lg btn-block">역대 로또 시뮬레이션</button>
		</article>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/Lotto.js?ver=132" />"></script>
<script type="text/javascript">
$(document).ready(function(){
	lottoService.getLottoNumber('drw','${lastDrwNo}',function(result){
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
	
	
	$("#order").on("propertychange change paste input", function() {
		console.log(this.value);
		if(this.value===''){
			lottoService.getLottoNumber('drw','${lastDrwNo}',function(result){
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
			return;
		}
		
		var data = this.value+"";
		var type = document.getElementById('searchSelect').value;
		if(type=='date'){
			if(data.length!=8)
				return;
			data = data.substr(0,4)+'-'+data.substr(4,2)+'-'+data.substr(6,2);
		}
		lottoService.getLottoNumber(type,data,function(result){
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
