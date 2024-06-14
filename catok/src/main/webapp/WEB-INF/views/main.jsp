<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
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
	</div>
	
	채팅화면
</body>
</html>