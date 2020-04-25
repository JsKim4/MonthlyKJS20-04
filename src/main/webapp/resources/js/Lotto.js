var lottoService =(function(){
	console.log("Lotto Init");
	function getLottoNumber(type,data,callback,error){
		console.log(data);
		$.ajax({
			type:'get',
			url:type+'/'+data,
			contentType : "application/json; charset=utf-8", 
			success : function(result,status,xhr){ 
				if(callback){
					callback(result);
				}
			},
			error : function(xhr,status,er){
				if(error){
					error();
				}
			}
		});
	}
	
	function getLottoStatList(callback,error){
		$.ajax({
			type:'get',
			url:'statistics/list',
			contentType : "application/json; charset=utf-8", 
			success : function(result,status,xhr){ 
				if(callback){
					callback(result);
				}
			},
			error : function(xhr,status,er){
				if(error){
					error();
				}
			}
		});
	}
	return {getLottoNumber:getLottoNumber,
		getLottoStatList:getLottoStatList};
})();