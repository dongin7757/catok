<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캐톡 회원가입</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h2>캐톡 회원가입</h2>
		<form action="/">
			<div class="form-group">
				<label for="user_id">ID:</label> 
				<input type="text" class="form-control" id="user_id" placeholder="아이디를 입력하세요." name="user_id">
			</div>
			<div class="form-group">
				<label for="user_password">Password:</label> 
				<input type="password" class="form-control" id="user_password" placeholder="비밀번호를 입력하세요." name="user_password">
			</div>
			<div class="form-group">
				<label for="user_passChk">Password 확인:</label> 
				<input type="password" class="form-control" id="user_passChk" placeholder="비밀번호를 입력하세요." name="user_passChk">
			</div>
			<div class="form-group">
				<label for="user_name">이름:</label> 
				<input type="text" class="form-control" id="user_name" placeholder="이름을 입력하세요." name="user_name">
			</div>
			<div class="form-group">
				<label for="user_email">Email:</label> 
				<input type="email" class="form-control" id="user_email" placeholder="이메일을 입력하세요." name="user_email">
			</div>
			
			<button type="submit" class="btn btn-default">회원가입</button>
			<button type="button" class="btn btn-warning" onclick="history.back()">뒤로가기</button>
		</form>
	</div>

</body>
</html>