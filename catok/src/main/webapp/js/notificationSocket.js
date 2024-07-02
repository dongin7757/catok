window.onload = function(){

	let socket = null;
	
	const URL = window.location.href;
	console.log(URL);
	var checkUrl = "ws:"+(URL.substring(URL.indexOf("//"), URL.lastIndexOf("/")+1)) + "ws/notification";
	
	if(!socket){
		socket = new WebSocket(checkUrl);
		console.log(checkUrl);
	}	
	
	console.log("생성된 알람 웹소켓 객체 : " + socket);
	
	socket.onmessage = onmessage;
	socket.send = send;

}

function onmessage(){
	console.log("웹소켓 핸들러에서 받는 onmessage 함수");
}

function send(){
	console.log("웹소켓 핸들러로 보내는 send 함수 ")
}


