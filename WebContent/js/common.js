/**
 * 
 */
var CommonFunc = function(){
	this.callFunc = function(){
		alert('난 중요한 공통 함수!');
		callFunc2();
	}
	var callFunc2 = function(){
			alert('난 외부에서 호출 안됨');
		}
}



var AjaxUtil = function(){
	
	var xhr = new XMLHttpRequest();
	this.open = function(url, method, async){
		method = method?mehtod:'GET';
		async = async?async:true;
		xhr.open(method, url);
		xhr.onreadystatechange = function(){
			if(xhr.readyState==4 && xhr.status==200){
				//this.callback(xhr.response);
				xhr.callback(xhr.response);
			}
		}
	}
	xhr.callback = function(res){
		console.log(res);			
	}
	this.setCallback = function(call){

		xhr.callback=call;
	}
	this.send = function(){
		xhr.send();
	}
}