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
				<c:out value="회차 정보는 매주 토요일  21시 정각에 업데이트 됩니다."/>
			</div>
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
			<div class="row font-weight-bold" style="margin-top:5%;">
				<div class="col ">1</div>
				<div class="col ">2</div>
				<div class="col ">3</div>
				<div class="col ">4</div>
				<div class="col ">5</div>
				<div class="col ">6</div>
				<div class="col ">B</div>
			</div>
			<div class="row font-italic font-weight-bold" style="margin-top:5%;height:5%;">
				<div class="col text-primary" id="drwtNo1"></div>
				<div class="col text-primary" id="drwtNo2"></div>
				<div class="col text-primary" id="drwtNo3"></div>
				<div class="col text-primary" id="drwtNo4"></div>
				<div class="col text-primary" id="drwtNo5"></div>
				<div class="col text-primary" id="drwtNo6"></div>
				<div class="col text-danger" id="bnusNo"></div>
			</div>
			<button type="button" class="btn btn-primary btn-lg btn-block" style="margin-top:20%;">로또 통계</button>
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
	$("#order").on("propertychange change paste input", function() {
		console.log(this.value);
		if(this.value==='')
			return;
		
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
