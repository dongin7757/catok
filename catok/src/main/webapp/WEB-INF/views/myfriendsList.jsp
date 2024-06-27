<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 친구 리스트 창</title>
<jsp:include page="./header.jsp" />
</head>
<script type="text/javascript" src="./js/chatRoom.js"></script>
<script type="text/javascript" src="./js/myfriendsList.js"></script>
<body>
	내 친구 리스트
	<div>
		<h1>Friends List</h1>
		<table border="1">
			<thead>
				<tr>
<!-- 					<th>내 ID</th> -->
					<th>친구 ID</th>
					<th>친구 추가 일</th>
					<th>1:1채팅</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="friend" items="${friends}">
					<tr>
<%-- 						<td>${friend.user_id}</td> --%>
						<td>${friend.friend_id}</td>
						<td>${friend.add_regdate}</td>
						<td><input type="button" value="채팅" onclick="createNewChat('${friend.friend_id}')"></td>
						<td><button type="button" onclick="deleteFriend(event)" value="${friend.friend_id}">친구삭제</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>