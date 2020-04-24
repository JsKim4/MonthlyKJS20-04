var lottoService =(function(){
	console.log("Lotto Init");
	function getLottoNumber(drwNo,callback,error){
		console.log(drwNo)
		$.ajax({
			type:'get',
			url:drwNo,
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
	return {getLottoNumber:getLottoNumber};
})();