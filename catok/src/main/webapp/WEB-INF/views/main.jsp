<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
<%-- <%@ include file="./header.jsp"%> --%>
<jsp:include page="./header.jsp" />
</head>
<body>
	메인이에용
	<div>
		사용자명: ${username} / 권한: ${auth[1]}
	</div>
	<div>
		principal : <sec:authentication property="principal"/>		
	</div>
	<div>
		<a href="#" onclick="location.href='./admin.do'">
			관리자페이지 이동
		</a>
		<br>
		<a href="#" onclick="location.href='./user.do'">
			사용자페이지 이동
		</a>
	</div>
	<div class="container">
		<button onclick="location.href='./logout.do'"> 로그아웃 </button>
		<button onclick="location.href='./myFriendsList.do'"> 내 친구 리스트 </button>
		<button onclick="location.href='./moveFriendPg.do'"> 친구추가 </button>
		<button onclick="location.href='./myChatRoomList.do'"> 내 채팅방 리스트 </button>
		<button onclick="location.href='./getFriendsReqList.do'"> 알 수도 있는 친구 </button>
	</div>
	
	
	
	채팅화면
</body>
</html>