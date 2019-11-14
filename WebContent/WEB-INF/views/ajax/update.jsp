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
	<div class="container">
		<h3 align="center"><b>게시물 수정</b></h3>
		<table class="table table-bordered">
		<tr>
			<th>게시물 번호</th>
			<td>${param.biNum}</td>
		</tr>
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
<!-- ㅇ
예전에 onclick="click()" 이라고 했을 때
onclick = function(){
	click();
}
이거임!
 -->
<button type="button" class="btn btn-outline-primary" onclick="goPage('/ajax/list')">목록</button>
<script>
	function update(){
		// [] : 속성
		var inputs = document.querySelectorAll('[id]');
		var param = {};
		
		// param['biTitle'] = document.getElementById('biTitle').value;
// 		for(var input of inputs){
// 			param[input.id] = input.value;
// 		}
		for(var input in inputs){
			var input = inputs[idx];
			if(input.id) param[input.id] = input.value;
		}
		console.log("param : " + param);
	}

	function ajax(conf){
		// new 안 붙이면 function 호출 
		// new 붙이면 function안에 있는 것들의 메모리를 생성해서 대입
		var xhr = new XMLHttpRequest();
		xhr.open(conf.method, conf.url);
		// 수정 후 post를 해야하므로
		if(conf.method != 'GET'){
			xhr.setRequestHeader('Content-Type', 'application/json');
		}
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				conf.callback(xhr.responseText);
			}
		}
		var param = (conf.param) ? conf.param : '';
		xhr.send(param);
	}

	var data = {
		method : 'GET',
		url : '/ajax/board/view?cmd=view&biNum=${param.biNum}',
		callback: function(res){
			var board = JSON.parse(res);
			// board : 이젠 string이 아님
			var inputs = document.querySelectorAll('[id]');
			for(var idx in inputs){
				var input = inputs[idx];
		 		console.log(input.id);
		 		
				if(input.id){
					 input.value = board[input.id];
				}
			}
		}
	}
	ajax(data);
</script>
</body>
</html>

<!--  
// 	function update(){
// 		var xhr = new XMLHttpRequest();
// 		xhr.open('GET', '/ajax/board/update');
// 		xhr.setRequestHeader('Content-Type', 'application/json');
		
// 		xhr.onreadystatechange = function(){
// 			if(xhr.readyState == 4 && xhr.status == 200){
// 				var res = JSON.parse(xhr.responseText);
// 				alert(res.msg);
// 			}
// 		}
// 		var param = {
// 			biTitle : document.getElementById('biTitle').value,
// 			biContent : document.getElementById('biContent').value,
// 			uiNum : document.getElementById('uiNum').value
// 		}
// 		param = JSON.stringify(param);
// 		xhr.send(param);
// 	}
-->