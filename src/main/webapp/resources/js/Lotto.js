var lottoService =(function(){
	
	
	console.log("Lotto Init");
	function getContextPath() {
	  var hostIndex = location.href.indexOf( location.host ) + location.host.length;
	  return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
	};
	
	
	
	function getLottoNumber(type,data,callback,error){
		console.log(data);
		$.ajax({
			type:'get',
			url:getContextPath()+'/'+type+'/'+data,
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
			url:getContextPath()+'/statistics/list',
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
	
	
	function insertTag(name,callback,error){
		$.ajax({
			type:'post',
			url:getContextPath()+'/admin/tag/insert',
			data:name,
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
	
	
	function getTagList(callback,error){
		$.ajax({
			type:'get',
			url:getContextPath()+'/tag/list',
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
		getLottoStatList:getLottoStatList,
		insertTag:insertTag,
		getTagList:getTagList};
})();