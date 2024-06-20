<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
		<ul>
		    <c:forEach items="${chattings}" var="chatting">
		        <li>${chatting.user_id} : ${chatting.chat_message} - ${chatting.chat_regdate}</li>
		        <!-- chatting 객체의 필드에 접근하여 출력 -->
		    </c:forEach>
		</ul>
		---
		<br>
		<textarea rows="5" cols="30"></textarea>
		<button type="submit">전송</button>
	</form>
</body>
</html>