<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp folder</title>
</head>
<body>
<h1>JSP list</h1>
<!-- BoardController "jsp".equals(kind)에서 list라고 해서 -->
${list}
<%-- <%= request.getAttribute("list") %> --%>
</body>
</html>