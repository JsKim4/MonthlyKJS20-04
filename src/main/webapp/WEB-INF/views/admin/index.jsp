<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<head>
	<style>
		.lottoFrame{
			width:50%;
			float:left;
			padding:1%;
		}
		.mainFrame{
			min-height:80%;
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
		.lotto-check{
			width:20%;
			float:left;
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
			<div class="lottoFrame mainFrame">
				<div class="input-group mb-3">
					<input type="text" class="form-control" id="insertTagName" placeholder="TagName" aria-label="TagName" aria-describedby="button-addon2">
				  	<div class="input-group-append">
				    	<button class="btn btn-outline-secondary" type="button" id="tagRegister">Register</button>
				  	</div>
				</div>
				<div class="row align-items-end">
					<h2 class="font-weight-bold">Tag List</h2>
				</div>
				<div class="row text-primary" style="font-size: 4px;">
					<c:out value="Tag가 파란색일때는 현재 선택된 태그입니다."/>
				</div>
				<ul id="tagList">
					
				</ul>
				<a href="<c:url  value="/logout"/>">logout</a>
			</div>
			<div class="lottoFrame mainFrame">
				<div class="input-group mb-3">
					<input type="text" class="form-control" id="modifyTagName" placeholder="TagName" aria-label="TagName" aria-describedby="button-addon2">
				  	<div class="input-group-append">
				    	<button class="btn btn-outline-primary" type="button" id="tagmodify">Modify</button>
				    	<button class="btn btn-outline-danger" type="button" id="tagRemove">Remove</button>
				  	</div>
				</div>
				<div>
					<div style="width:50%;float:left;">
						<h2 class="font-weight-bold">Selected : </h2>
					</div>
					<div style="width:50%;float:left;">
						<h2 id="selectedTagName" class="font-weight-bold">No Selected</h2>
						<input type="hidden" id="selectedTagSeq" value="">
					</div>
				</div>
				<div>
					<div class="lottoFrame">
						<div class="input-group input-group-sm mb-3">
						 	<div class="input-group-prepend">
						   		<span class="input-group-text" id="inputGroup-sizing-sm">시작일</span>
						 	</div>
						 	<input type="date" id = "fromDate" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
						</div>
						
						<div class="input-group input-group-sm mb-3">
						 	<div class="input-group-prepend">
						   		<span class="input-group-text" id="inputGroup-sizing-sm">최소 당첨금</span>
						 	</div>
						 	<input type="number" id = "fromPrize" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
						</div>
						
						<div class="input-group input-group-sm mb-3">
						 	<div class="input-group-prepend">
						   		<span class="input-group-text" id="inputGroup-sizing-sm">최소 당첨자 수</span>
						 	</div>
						 	<input type="number" id = "fromWinner" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
						</div>
					</div>	
					
					<div class="lottoFrame">
						<div class="input-group input-group-sm mb-3">
						 	<div class="input-group-prepend">
						   		<span class="input-group-text" id="inputGroup-sizing-sm">종료일</span>
						 	</div>
						 	<input type="date" id = "toDate" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
						</div>	
						
						<div class="input-group input-group-sm mb-3">
						 	<div class="input-group-prepend">
						   		<span class="input-group-text" id="inputGroup-sizing-sm">최대 당첨금</span>
						 	</div>
						 	<input type="number" id = "toPrize" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
						</div>	
						
						<div class="input-group input-group-sm mb-3">
						 	<div class="input-group-prepend">
						   		<span class="input-group-text" id="inputGroup-sizing-sm">최대 당첨자 수</span>
						 	</div>
						 	<input type="number" id = "toWinner" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
						</div>	
					</div>
					<button id="searchBtn" type="button" class="btn btn-secondary">검색</button>
				</div>
				<div class="row" style="margin-top:5%; margin-bottom:5%;">
					<div class="col-4">
						<button type="button" class="btn btn-primary  " id="allCheck">전체 선택</button>
					</div>
					
					<div class="col-4">
						<button type="button" class="btn btn-danger  " id="allCheckDelete">전체 취소</button>
					</div>
					
					<div class="col-2">
						<button type="button" class="btn btn-warning  " id="registerLottoTagBtn">등록</button>
					</div>
				
				</div>
				<div id="lotto-list">
				</div>
			</div>
		</article>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/admin.js?ver=3" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/Lotto.js?ver=6" />"></script>
<script type="text/javascript">
$(document).ready(function(){
	var lottoList;
	var isVisibleLotto = new Array;
	/*lotto-check-form  */
	
	$("#registerLottoTagBtn").click(function(){
		var tagSeq = document.getElementById("selectedTagSeq").value;
		if(tagSeq===''){
			alert("선택된 태그 없음");
			return;
		}
		var drwList=new Array;
		$("input:checkbox[id^='lottoCheck']:checked").each(function(){ 
			drwList.push($(this).val());
		});
		lottoService.insertTagLottoList({"tagSeq":tagSeq,"drwList":drwList},function(result){
			if(result==='success'){
				alert("태그등록에 성공하였습니다.");
			}
		});

	});
	
	
	function setVisible(){
		$("div[id^='lotto-check-form']").css({'display':'none'});
		for(var i=0;i<isVisibleLotto.length;i++){
			if(isVisibleLotto[i]){
				$("div[id='lotto-check-form"+i+"']").css({'display':''});
			}
		}
	}
	
	function initVisible(){
		for(var i=0;i<isVisibleLotto.length;i++)
			isVisibleLotto[i]=false;
	}
	
	$("#searchBtn").on("click",function(){	
		var condition = getCondition();
		initVisible();
		console.log(condition);
		for(var i = 0 ;i<lottoList.length;i++){
			var lotto = lottoList[i];
			if(avail(lotto ,condition)){
				var num = parseInt(lotto.drwNo);
				isVisibleLotto[num]=true;;
			}
		}
		setVisible();
	});
	
	function getAddCheckHtmlText(drwNo){
		var str = "";
		str+='<div class="custom-control custom-checkbox lotto-check" id="lotto-check-form'+drwNo+'">';
		str+='	<input type="checkbox" class="custom-control-input" id="lottoCheck'+drwNo+'" value="'+drwNo+'">';
		str+='	<label class="custom-control-label" for="lottoCheck'+drwNo+'">'+drwNo+'</label>';
		str+='</div>';
		return str;
	}
	
	function avail(lotto,condition){
		var firstPrzwnerCo = parseInt(lotto.firstPrzwnerCo);
		var firstWinamnt = parseInt(lotto.firstWinamnt);
		var drwNoDate = lotto.drwNoDate;
		if(condition.minDate>drwNoDate||condition.maxDate<drwNoDate){
			return false;
		}
		if(parseInt(condition.minPrize)>firstWinamnt||parseInt(condition.maxPrize)<firstWinamnt){
			return false;
		}
		if(parseInt(condition.minWinner)>firstPrzwnerCo||parseInt(condition.maxWinner)<firstPrzwnerCo){
			return false;
		}
		return true;
	}
	
	function getCondition(){
		var minDate = document.getElementById("fromDate").value;
		var maxDate = document.getElementById("toDate").value;
		var minPrize = document.getElementById("fromPrize").value;
		var maxPrize = document.getElementById("toPrize").value;
		var minWinner = document.getElementById("fromWinner").value;
		var maxWinner = document.getElementById("toWinner").value;
		if(minDate==='')
			minDate='2000-01-01';
		if(maxDate==='')
			maxDate='2099-12-31';
		
		if(minPrize==='')
			minPrize="0";
		if(maxPrize==='')
			maxPrize="9999999999999";
		
		if(minWinner==='')
			minWinner="0";
		if(maxWinner==='')
			maxWinner="100";
		var condition={minDate,maxDate,minPrize,maxPrize,minWinner,maxWinner};
		return condition;
	}
	
	$("#allCheck").click(function(){
		var chk = $(this).is(":checked");
		$("div[id^='lotto-check-form']").not($("*[style*='none']")).children('input[id^="lottoCheck"]').prop('checked',true); 
	});
	
	$("#allCheckDelete").click(function(){
		var chk = $(this).is(":checked");
		$("div[id^='lotto-check-form']").not($("*[style*='none']")).children('input[id^="lottoCheck"]').prop('checked',false); 
	});
	
	
	
	
	
	
	
	
	
	
	
	init();
	
	function init(){
		setTagList();
		document.getElementById("modifyTagName").value='';
		document.getElementById("selectedTagSeq").value='';
		$("#selectedTagName").html('No Selected');
		getLottoList();
		console.log("Admin Page Init");
	}
	
	function getLottoList(){
		lottoService.getLottoList(function(result){
			lottoList = result;
			var str='';
			isVisibleLotto.push(true);
			for(var i = 1 ; i <= lottoList.length; i++){
				var drw = lottoList[lottoList.length-i].drwNo;
				str+=getAddCheckHtmlText(drw); 
			}
			$("#lotto-list").html(str);
		});
	}
	
	
	function setTagList(){
		lottoService.getTagList(function(result){
			var str = ""; 
			for(var i=0;i<result.length;i++){
				str+=getAddHtmlText(result[i]);
			}
			$("#tagList").html(str);
			
			$(".tag").on("click",function(){
				var tagSeq = $(this).children('button').attr('value');
				var tagName = $(this).children('button').html();
				document.getElementById("selectedTagSeq").value=tagSeq;
				document.getElementById("modifyTagName").value=tagName;
				$("#selectedTagName").html(tagName);
				lottoService.getTagLottoList(tagSeq,function(result){
					initVisible();
					$("div[id^='lotto-check-form']").children('input[id^="lottoCheck"]').prop('checked',false); 
					for(var i=0;i<result.length;i++){
						isVisibleLotto[result[i]]=true;
					}
					setVisible();
					$("div[id^='lotto-check-form']").not($("*[style*='none']")).children('input[id^="lottoCheck"]').prop('checked',true); 
				});
				
			});
		});	
	}
	
	function getAddHtmlText(tag){
		var str = "";
		str+='<li class="tag">';
		str+='	<button type="button" class="btn btn-secondary btn-sm" value="'+tag.tagSeq+'">'+tag.tagName+'</button>';
		str+='</li>';	
		return str;
	}
	
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
	
	$("#tagmodify").on("click",function(){
		var name = document.getElementById("modifyTagName").value;
		var tagSeq = document.getElementById("selectedTagSeq").value;
		lottoService.modifyTag({"tagName":name,"tagSeq":tagSeq},function(result){
			if(result==='success'){
				alert("태그 변경에 성공하였습니다.");
				init();
			}else
				alert(result);
		});
	});
	
	$("#tagRemove").on("click",function(){
		var tagSeq = document.getElementById("selectedTagSeq").value;
		lottoService.removeTag(tagSeq,function(result){
			if(result==='success'){
				alert("태그 삭제에 성공하였습니다.");
				init();
			}else
				alert(result);
		});
	});
});
</script>
</html>
