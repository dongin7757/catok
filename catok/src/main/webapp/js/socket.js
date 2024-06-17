var webSocket = null;


	// WebSocket 서버 주소
	var url = location.href;   //현재 주소를 받아온다.
	var checkUrl = "ws:"+(url.substring(url.indexOf("//"), url.lastIndexOf("/")+1)) + "ws/catok";
	
	webSocket = new WebSocket(checkUrl);
	webSocket.onopen = function(event){
		console.log("웹소켓에 접근 됐습니다.");
	};
	