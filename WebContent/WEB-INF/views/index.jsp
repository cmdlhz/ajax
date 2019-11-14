<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// ContextPath가 "/"이 아니라 "/board"일 경우
String rPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
<a style="text-decoration:none" href="/views/ajax/list">ajax list 가기</a><br>
<a style="text-decoration:none" href="/jsp/board/list">jsp list 가기</a>
</body>

</html>