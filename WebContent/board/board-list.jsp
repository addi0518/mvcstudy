<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<style>
	table {
		border-collapse:collapse;
	}
	table tr th {
		font-weight:700;
	}
	table tr td, table tr th {
		border:1px solid #818181;
		width:200px;
		text-align:center;
	}
</style>
<h1>글 목록</h1>
	<table>
		<tr>
			<th>No</th>
			<th>제목</th>
			<th>작성자</th>
			<th>시간</th>
		</tr>
		<tr>
			<%-- <td>${item.b_idx }</td>
			<td><%=b_title %></td>
			<td><%=b_writer %></td>
			<td><%=b_date %></td> --%>
		</tr>
		
	</table>
</body>
</html>