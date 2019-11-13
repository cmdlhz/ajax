<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
</head>
<body>
${param.biNum}
<!-- Custom Attribute : "data-" 붙이기 -->
<div class="container">
	<table class="table table-bordered">
		<tr>
			<th>번호 !</th>
			<td data-col="biNum"></td>
		</tr>
		<tr>
			<th>제목</th>
			<td data-col="biTitle"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td data-col="biContent"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td data-col="uiNum"></td>
		</tr>
		<tr>
			<th>작성일</th>
			<td data-col="credat"></td>
		</tr>
		<tr>
			<th>작성시간</th>
			<td data-col="cretim"></td>
		</tr>
		<tr>
			<th colspan="2">
				<button onclick="goPage('/ajax/update?biNum=${param.biNum}')">수정</button>
				<button onclick="goPage('/ajax/list')">리스트 가기</button>
			</th>
		</tr>
	</table>
</div>
<script>
window.onload = function(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/ajax/board/view?cmd=view&biNum=${param.biNum}');
	// http://localhost/views/ajax/view?biNum=121
	// 이거 때문에 에러남
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				var board = JSON.parse(xhr.responseText);
				console.log(board);
				var tds = document.querySelectorAll('[data-col]');
				for(var td of tds){
					var col = td.getAttribute('data-col');
					td.innerHTML = board[col];
				}
			}
		}
	}
	xhr.send();
}
</script>
</body>
</html>