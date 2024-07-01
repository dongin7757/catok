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

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<script type="text/javascript" src="./js/socket.js"></script>
</head>
<body>
<div>
    <div class="container">
    	<input type="hidden" id="myId" value="${myId}"/>
    	<input type="hidden" id="chatId" value="${chatId}"/>
        <div class="col-6">
            <label><b>${friendId}님과의 채팅방</b></label>
        </div>
        <div>
            <div id="msgArea" class="col"></div>
            <div class="col-6">
                <div class="input-group mb-3">
                    <input type="text" id="msg" class="form-control" aria-label="Recipient's username" aria-describedby="button-addon2">
                    <div class="input-group-append">
                        <button class="btn btn-outline-secondary" type="button" onclick="sendMessage()" id="button-send">전송</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>