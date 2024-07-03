<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
<title>나의 채팅방 목록</title>
<jsp:include page="../header.jsp" />
</head>
<body>

	내가 포함된 채팅방 리스트
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>채팅방</th>
					<th>마지막 채팅</th>
					<th>시간</th>
				</tr>
			</thead>
			<tbody id="friendList">
				<c:forEach items="${rooms}" var="room">
					<tr>
						<input type="hidden" value="${room.user_id}">
						<td>${room.user_id}님과의 채팅</td>
						<td>${room.chat_message}</td>
						<td>${room.chat_regdate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
<script type="text/javascript" src="./js/chatRoom.js"></script>
</html>