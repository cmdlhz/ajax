<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax folder</title>
</head>
<body>
<h1>Ajax list</h1>
<script>
window.onload = function(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/ajax/board/list');
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.wriet(xhr.responseText);
		}
	}
	xhr.send();
}
</script>
</body>
</html>