<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1대1 채팅</title>
<script src="https://cdn.socket.io/4.0.1/socket.io.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
<script type="text/javascript" src="./js/socket.js"></script>
</head>
<body>
	<form action="" type="post">
		${friendId}님과의 채팅방입니다.
		<br>
		---
		<br>
		<textarea rows="5" cols="30"></textarea>
		<button type="submit">전송</button>
	</form>
</body>
</html>