<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>글등록</h1>
<form action="write.board" method="post">
	<table>
		<tr>
			<td>제목</td>
			<td><input type="text" name="" value=""></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="25" cols="50"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center"><input type="submit" value="글등록"></td>
		</tr>
	</table>
</form>

</body>
</html>