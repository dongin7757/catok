<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
<title>나의 채팅방 목록</title>
<jsp:include page="../header.jsp" />
</head>
<body>

	<div class="container">
	<p>내가 포함된 채팅방 리스트 <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" style="float: right;" onclick="getMyFriList()">단체방 생성</button></p>
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">그룹채팅 생성</h4>
					</div>
					<div class="modal-body">
						<h3>방 제목을 작성하세요.</h3>
						<input id="chat_title" class="form-control" type="text" maxlength="10" placeholder="10글자 제한입니다.">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>이름</th>
									<th><input type="checkbox" id="selectAll" onclick="allChk()"></th>
								</tr>
							</thead>
							<tbody id="friList">

							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-success" onclick="createGroupChat()">채팅방 생성</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					</div>
				</div>
			</div>
		</div>

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
						<input type="hidden" class="roomType" value="${room.room_type}">
						<input type="hidden" class="friendId" value="${room.user_id}">
						<input type="hidden" class="chatId" value="${room.chat_id}">
						<c:if test="${room.room_type eq '1'}">
							<td>${room.user_id}님과의 채팅</td>
						</c:if>
						<c:if test="${room.room_type eq 'N'}">
							<td>${room.chat_title}</td>
						</c:if>
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