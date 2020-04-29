var adminService =(function(){
	console.log("Admin Init");
	function adminLogin(loginInfo,callback,error){
		$.ajax({
			type:'post',
			url:'/Lotto/login',
			data : JSON.stringify(loginInfo),
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
	
	function adminLogout(callback,error){
		$.ajax({
			type:'post',
			url:'/Lotto/logout',
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
	
	return {adminLogin:adminLogin,
		adminLogout:adminLogout};
})();