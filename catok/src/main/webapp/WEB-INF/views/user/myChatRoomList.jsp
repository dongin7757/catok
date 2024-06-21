<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 채팅방 목록</title>
</head>
<body>
	
	내가 포함된 채팅방 리스트
	<div>
		<table>
			<tr>
				<th>채팅방</th>
				<th>채팅</th>
				<th>시간</th>
			</tr>
				<c:forEach items="${rooms}" var="room">
					<td>${room.user_id}님 과의 채팅</td>
					<td>${room.chat_message}</td>
					<td>${room.chat_regdate}</td>
				</c:forEach>
		</table>
	</div>
</body>
</html>