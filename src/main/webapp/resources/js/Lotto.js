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
	
	function getLottoStatList(andSelectList,orSelectList,callback,error){
		console.log(orSelectList);
		console.log(andSelectList);
		$.ajax({
			type:'get',
			url:getContextPath()+'/statistics/list?orCondition='+orSelectList+'&andCondition='+andSelectList,
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
	
	function getLottoList(callback){
		$.ajax({
			type:'get',
			url:getContextPath()+'/lotto/list',
			success : function(result,status,xhr){ 
				if(callback){
					callback(result);
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
	
	
	function insertTag(name,callback,error){
		$.ajax({
			type:'post',
			url:getContextPath()+'/admin/tag',
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
	
	function removeTag(seq,callback,error){
		$.ajax({
			type:'delete',
			url:getContextPath()+'/admin/tag',
			data:seq,
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
	
	function modifyTag(tag,callback,error){
		$.ajax({
			type:'put',
			url:getContextPath()+'/admin/tag',
			data:JSON.stringify(tag),
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
	
	function getTagLottoList(seq,callback,error){
		$.ajax({
			type:'get',
			url:getContextPath()+'/admin/tag/'+seq,
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
	
	function insertTagLottoList(taginsertList,callback,error){
		console.log(taginsertList);
		$.ajax({
			type:'post',
			url:getContextPath()+'/admin/tag/list',
			data:JSON.stringify(taginsertList),
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
	
	function getSimluationList(search,callback,error){
		$.ajax({
			type:'get',
			url:getContextPath()+'/simulation/list?search='+search[0]+'&search='+search[1]+'&search='+search[2]+'&search='+search[3]+'&search='+search[4]+'&search='+search[5],
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
		getLottoList:getLottoList,
		getTagList:getTagList,
		insertTag:insertTag,
		removeTag:removeTag,
		modifyTag:modifyTag,
		getTagLottoList:getTagLottoList,
		insertTagLottoList:insertTagLottoList,
		getSimluationList:getSimluationList};
})();