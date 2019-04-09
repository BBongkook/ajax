<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/js/common.js"></script>
</head>
<body>

<div id="rDiv"></div>
	<script>
	function callback(res){
		var res = JSON.parse(res);
		for(var addr of res.list){
			document.write(addr.ad_num + "," + addr.ad_sido);
		}
	}
	var au = new AjaxUtil();
	au.open('/addr2/list');
	au.setCallback(callback);
	au.send();
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
/* 	var AjaxUtil = function(){
		
		var xhr = new XMLHttpRequest();
		this.open = function(url, method, async){
			method = method?mehtod:'GET';
			async = async?async:true;
			xhr.open(method, url);
			xhr.onreadystatechange = function(){
				if(xhr.readyState==4 && xhr.status==200){
					this.callback(xhr.response);
				}
			}
		}
		this.callback = function(res){
			console.log(res);			
		}
		
		xhr.callback = this.callback; //없는 callback을 해줘야함
		
		this.setCallback = function(call){
			this.callback = call;
		}
		this.send = function(){
			xhr.send();
		}
	}
	var au = new AjaxUtil();
	au.open('/addr2/list');
	au.send(); */

	
/* 	
	var CPU = function(){
		this.core = 2;
		this.callback = function(){
			alert(1);
		}
	}
	var Computer = function(){
		this.cpu = new CPU();
		this.callback = function(){
			alert(this.cpu.core);
		}
		//this.cpu.callback();
		//this.callback();
	}
	var c = new Computer();
	c.callback();
	// c.cpu.callback(); // 에러
	//alert(c.cpu.core);
	 */
	
	
	
/* 	var func = function(){
		alert(this==window);
	}
	alert(this==window);
	new func(); */
	
	
	
	
/* 	
function _ge(id){
	return document.querySelector('#'+id);
}
_ge('rDiv').innerHTML = 'abc';
	 */
	
	
	/* 
	function test(n1,n2){
		console.log('n1 : '+n1);
		console.log('n2 : '+n2);
	}
	test();
	 */
	
/* 	var num=1;
	
	if(num==1){
		num='한개';
	}else{
		num='한개는 아닙니다';
	}
	num = (num==1)?'한개':(num==2)?'두개':'한개도 두개도 아니예요';
	alert(num); */
	
/* 		var callback = function(res) {
			console.log(res);
		}
		var AjaxUtil = function(method, url, callback) {
			method = method?method:'GET';
			var xhr = new XMLHttpRequest();
			xhr.open('GET', '/addr2/list');
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					callback(xhr.response);
				}
			}
			xhr.send();
		}
		var au = AjaxUtil('POST');
 */
		/* 
		 function callFunc(num1, num2){
		 alert('나는 첫번째 call');
		 }
		 function callFunc(num1){
		 alert('나는 두번째 call');
		 }
		 callFunc();
		
		 var a = 1;
		 a = 2;
		 alert(2); */

		/* 	function callFunc(num1, num2){
		 num1();
		 }
		 function test(){
		 alert(1);
		 }
		 callFunc(test); */

		/* 	var cf = new CommonFunc();
		 cf.callFunc();
		 cf.callFunc2(); */

		/* var Test = function(){
		 this.callback = function(f){
		 f();
		 }
		 }
		 var func = function(){
		 alert(1);
		 }
		 var t = new Test(function(){
		 alert(1);
		 });
		 t.callback(func); */

		/* var t = function(){
		 alert(1);
		 }
		 var num =1;
		 function test(f){
		 alert(f);
		 }
		 test(t);
		 */
	</script>
</body>
</html>