<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th>번호</th>
		<th>시도</th>
		<th>구군</th>
	</tr>
	<c:forEach items="${list}" var="addr">
		<tr>
			<td>${addr.ad_num}</td>
			<td>${addr.ad_sido}</td>
			<td>${addr.ad_gugun}</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="3" align="center">
		<c:forEach var="page" begin="${fBlock}" end="${lBlock}">
			[${page}]
		</c:forEach>
		</td>
		
	</tr>
	<tr>
		<td colspan="3" align="right">총 갯수 : ${totalCnt}</td>
	</tr>
</table>
</form>
</body>
</html>