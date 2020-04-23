<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>LOTTO MAIN</title>
</head>
<body> 
	<div style="max-height:50vh;text-align:center;padding-top:30vh;font-size:10vh;display: flex;">
		<div style="flex:1;text-align: right;padding:1vw;">
			<label style="height:6vw;font-size:3vw;max-width:12vw;">회차 입력  </label>
			<input type="text" id="order" style="height:6vw;font-size:5vw;max-width:12vw;">
		</div>
		<div style="flex:1;text-align: left;padding-left:1vw;">
			<div >
				<label style="height:4vw;font-size:2.5vw;max-width:10vw;">Number : 5  4  6  7  23</label>
			</div>
			<div>
				<label style="height:4vw;font-size:2.5vw;max-width:10vw;color:#f66666;">Bonus : 16</label>
			</div>
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
</html>
