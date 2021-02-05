<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<form action="/mvcstudy/user-insert-process.do" name="user" method="post">
<%--user-insert-process.do의 파라미터와 맞춰주어야 한다. --%>
	<p>	아이디 : <input type="text" name="u_id"><input type="button" value="아이디 중복 검사"></p>
	<p>	비밀번호 : <input type="password" name="u_pw"></p>
	<p>	이름 : <input type="text" name="u_name"></p>
	<p>	연락처 : <input type="text" maxlength="4" size="4" name="tel1"> -
				<input type="text" maxlength="4" size="4" name="tel2"> - 
				<input type="text" maxlength="4" size="4" name="tel3">
	</p>
	<p> 나이 : <input type="text" name="u_age"></p>
	<p> <input type="submit" value="가입하기"></p>
</form>
</body>
</html>
