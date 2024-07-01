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
<title>header</title>
<script src="https://cdn.socket.io/4.0.1/socket.io.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
<script type="text/javascript" src="./js/socket.js"></script>
</head>
<body>
	<div>
        <c:set var="myId" value="${pageContext.request.userPrincipal.name}" />
        <p>현재 사용자 ID!!!: ${myId}</p>
        <input type="hidden" id="myId" value="${myId}"/>
    </div>
</body>
</html>