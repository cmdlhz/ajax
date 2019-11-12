<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert !</title>
<!-- <script src="/test.js"></script> -->
<!-- <script> -->
<!--	window.onload = init;   -->
<!-- </script> -->
<!-- <link rel="stylesheet" href="/test.css"/> -->
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<h3 align="center"><b>게시물 작성</b></h3>
		<table class="table table-bordered">
			<tr>
				<th>제목</th>
				<td><input type="text" id="biTitle" placeholder="제목을 작성해주세요."></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea type="text" id="biContent" rows="10" cols="20" placeholder="내용을 작성해주세요."></textarea></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="number" id="uiNum" value="61"></td>
			</tr>
			<tr>
				<th colspan="2"><button type="button" class="btn btn-outline-success" onclick="save()">저장</button></th>
			</tr>
		</table>
	</div>
</body>
<button type="button" class="btn btn-outline-primary" onclick="goPage('/ajax/list')">목록</button>

<script type="text/javascript">
	function save(){
		var xhr = new XMLHttpRequest();
		xhr.open('POST', '/ajax/board/insert');
		xhr.setRequestHeader('Content-Type', 'application/json');
		
		xhr.onreadystatechange = function(){
			// if(xhr.readyState != 4) return; 이렇게 나눠도 됨 
			
			if(xhr.readyState == 4 && xhr.status == 200){
				var res = JSON.parse(xhr.responseText);
// 				console.log("xhr.responseText : " + xhr.responseText);
				alert(res.msg);
			}
		}
		// JSON 형태처럼 보이지만 string이 아니라 객체임
		var param = {
			biTitle : document.getElementById('biTitle').value,
			biContent : document.getElementById('biContent').value,
			uiNum : document.getElementById('uiNum').value
		}
		// 안에 있는 내용이 다 나옴
		console.log("param" + param); // [object Object]로 나옴 String이 아니라서
// 		alert(param);

		param = JSON.stringify(param);
		console.log("param stringify : " + param);
		console.log(typeof(param)); // string
// 		return;
		xhr.send(param);
	}
</script>
</html>