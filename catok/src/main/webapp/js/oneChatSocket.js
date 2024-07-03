document.addEventListener("DOMContentLoaded", function() {
    let username = null; 
    let websocket = null;
    
//  동적으로 연결해줄 웹소켓의 방 넘버
    let chat_id = document.getElementById('chatId').value;

    // 페이지가 로드되면 실행될 초기화 코드
    init();

    function init() {
        // 사용자 이름 가져오기
        username = document.getElementById("myId").value;
        console.log("####myId :", username);

        // 웹소켓 연결
        websocket = new WebSocket("ws://localhost:8099/ws/catok/" + chat_id);
        websocket.onmessage = onMessage;
        websocket.onopen = onOpen;
        websocket.onclose = onClose;

        // 전송 버튼에 클릭 이벤트 추가
        document.getElementById("button-send").addEventListener("click", function(e) {
            send();
        });
    }

    function send() {
        let msg = document.getElementById("msg");
        console.log("##메시지 : " + msg.value);

        // 메시지 전송
        websocket.send(username + ":" + msg.value);

        // 채팅 메시지 저장 API 호출
        let chat_id = document.getElementById('chatId').value;
        let user_id = document.getElementById('myId').value;
        let chat_message = msg.value;
    
        fetch('./insertChatMessage.do', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json', // JSON 형식으로 요청 헤더 설정
            },
            body: JSON.stringify({ 'chat_id': chat_id, 'user_id': user_id, 'chat_message': chat_message }), // JSON 데이터 전송
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json(); // JSON 형식으로 응답 데이터 파싱
        })
        .then(data => {
            console.log('Received data:', data);
            if (data === 1) {
                console.log("채팅이 저장되었습니다.");
            } else {
                console.log("채팅이 저장되지 않았습니다.");
            }
            return data;
        })
        .catch(error => {
            console.error('에러발생:', error);
        });

        // 입력창 초기화
        msg.value = '';
    }

    function onClose(event) {
        let str = username + "님이 방을 나가셨습니다.";
        console.log(str);
//        websocket.send(str);
    }

    function onOpen(event) {
        let str = username + "님이 입장하셨습니다.";
        console.log(str);
        console.log(websocket);
//        websocket.send(str);
    }

    function onMessage(event) {
	
//		실시간 채팅  시간
		const DATE = new Date();
//		일자
		const YEAR = DATE.getFullYear();
		const MONTH = String(DATE.getMonth() + 1).padStart(2,'0');
		const DAY =  String(DATE.getDay()).padStart(2,'0');
//		시간
		const HOUR = String(DATE.getHours()).padStart(2,'0');
		const MINUTES = String(DATE.getMinutes()).padStart(2,'0');
		
		const CHATTIME = `${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTES}`;
		
        console.log("메시지 수신!");
        let data = event.data;
        console.log("##data 값: " + data);
        let arr = data.split(":");
        let sessionId = arr[0];
        let message = arr[1];

        console.log("sessionId: " + sessionId);
        console.log("cur_session: " + username);

        // 채팅 메시지 HTML 생성 및 출력
        let html = '<div class="col-6">';
        if (sessionId === username) {
            html += '<div class="alert alert-secondary">';
        } else {
            html += '<div class="alert alert-warning">';
        }
        html += '<b>' + sessionId + ' : ' + message + '</br>' + CHATTIME + '</b>';
        html += '</div></div>';

        document.getElementById("msgArea").insertAdjacentHTML('beforeend', html);
    }
});