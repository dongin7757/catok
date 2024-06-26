<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>친구추가</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/addFriend.js"></script>
</head>
<body>
	<span>회원 검색 : </span>
	<input type="text" id="searchUserId" name="searchUserId" placeholder="회원아이디입력">
	<input type="text" id="searchUserName" name="searchUserName" placeholder="회원이름입력">
	<button type="button" onclick="search()">검색</button>

	<div class="container">
		<h2>친구리스트</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>친구추가</th>
				</tr>
			</thead>
			<tbody class="friendsList">
				<c:forEach items="${members}" var="member">
					<tr>
						<td>${member.user_id}</td>
						<td>${member.user_name}</td>
						<td><button class="addFriend" value="${member.user_id}" onclick="addFriend(event)">추가</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>