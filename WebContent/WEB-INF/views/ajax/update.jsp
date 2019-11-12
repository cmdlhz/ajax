<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
</head>
<body>
<body>
	<div class="container">
		<h3 align="center"><b>게시물 수정</b></h3>
		<table class="table table-bordered">
			<tr>
				<th>제목</th>
				<td><input type="text" id="biTitle" value="${board.biTitle}"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea type="text" id="biContent" rows="10" cols="20">${board.biContent}</textarea></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="number" id="uiNum" value="61"></td>
			</tr>
			<tr>
				<th colspan="2"><button type="button" class="btn btn-outline-success" onclick="update()">UPDATE</button></th>
			</tr>
		</table>
	</div>
</body>
<button type="button" class="btn btn-outline-primary" onclick="goPage('/ajax/list')">목록</button>
<script>
	function update(){
		var xhr = new XMLHttpRequest();
		xhr.open('PUT', '/ajax/board/update');
		xhr.setRequestHeader('Content-Type', 'application/json');
		
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				var res = JSON.parse(xhr.responseText);
				alert(res.msg);
			}
		}
		var param = {
			biTitle : document.getElementById('biTitle').value,
			biContent : document.getElementById('biContent').value,
			uiNum : document.getElementById('uiNum').value
		}
		param = JSON.stringify(param);
		xhr.send(param);
	}
</script>
</body>
</html>