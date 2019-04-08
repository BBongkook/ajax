<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" id="addrTable">
		<tr>
			<th>번호</th>
			<td>${addr.ad_num}</td>
		</tr>
		<tr>
			<th>주소코드</th>
			<td>${addr.ad_code}</td>
		</tr>
		<tr>
			<th>시도</th>
			<td>${addr.ad_sido}</td>
		</tr>
		<tr>
			<th>군구</th>
			<td>${addr.ad_gugn}</td>
		</tr>
		<tr>
			<th>동면읍</th>
			<td>${addr.ad_dong}</td>
		</tr>
		<tr>
			<th>리</th>
			<td>${addr.ad_lee}</td>
		</tr>
		<tr>
			<th>번지</th>
			<td>${addr.ad_bunji}</td>
		</tr>
		<tr>
			<th>호수</th>
			<td>${addr.ad_ho}</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button onclick="closeTable()">닫기</button>
		</tr>
	</table>
	
<script>
	function closeTable(){
		document.querySelector('#addrTable').style.display='none';
	}
</script>
</body>
</html>