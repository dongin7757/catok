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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/addFriend.js"></script>
<head>
<meta charset="UTF-8">
<title>알 수도 있는 친구</title>
</head>
<body>
	친구 추천 리스트
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>이름</th>
					<th>추가</th>
					<th>차단</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${reqList}" var="user">
					<tr>
						<td>${user.user_id}</td>
						<td><button class="addFriend" value="${user.user_id}" onclick="addFriend(event)">추가</button></td>
						<td><input type="button" onclick="blockFrd('${user.user_id}')" value="차단"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>