<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>LOTTO MAIN</title>
</head>
<body> 
	<div style="max-height:50vh;text-align:center;padding-top:20vh;font-size:10vh;display: flex;">
		<div id="lottoDate" style="width:100%;text-align:center;font-size:1vw;"></div>
	</div>
	<div style="text-align:center;font-size:10vh;display: flex;">
		<div style="flex:1;text-align: right;padding:1vw;">
			<label style="height:6vw;font-size:3vw;max-width:12vw;">회차 입력  </label>
			<input type="number" id="order" style="height: 100%;font-size:5vw;max-width:12vw;" value="">
		</div>
		<div style="flex:1;text-align: left;padding-left:1vw;">
			<ul style="font-size:3vw;list-style-type:none;white-space:nowrap;">
				<li id="drwtNo1" style="float:left; margin:0 1vw 0 1vw"></li>
				<li id="drwtNo2" style="float:left; margin:0 1vw 0 1vw"></li>
				<li id="drwtNo3" style="float:left; margin:0 1vw 0 1vw"></li>
				<li id="drwtNo4" style="float:left; margin:0 1vw 0 1vw"></li>
				<li id="drwtNo5" style="float:left; margin:0 1vw 0 1vw"></li>
				<li id="drwtNo6" style="float:left; margin:0 1vw 0 1vw"></li>
				<li id="bnusNo" style="float:left; margin:0 1vw 0 1vw;color:red;"></li>
			</ul>
		</div>
	</div>
	
	<div style="max-height:50vh;text-align:center;font-size:10vh;display: flex;">
		<div style="flex:1;text-align: right;padding:1vw;">
			<input type="button" value="로또 분석 통계">
		</div>
		<div style="flex:1;text-align: left;padding:1vw;">
			<input type="button" value="역대 로또 시뮬레이션">
		</div>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/js/Lotto.js?ver=12" />"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#order").on("propertychange change paste input", function() {
		if(this.value==='')
			return;
		lottoService.getLottoNumber(this.value,function(result){
			if(result==='')
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
			document.getElementById('order').value = null;
			alert("존재하지 않는 회차번호 입니다.");
		});
	});
});
</script>
</html>
