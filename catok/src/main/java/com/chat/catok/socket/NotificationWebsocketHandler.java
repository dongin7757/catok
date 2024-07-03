package com.chat.catok.socket;

import java.util.ArrayList;
import java.util.List;import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Websocket;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class NotificationWebsocketHandler extends TextWebSocketHandler {
	
	private static List<WebSocketSession> list = new ArrayList<WebSocketSession>();

	//알람보내기용 웹소켓이 연결됐을 시 실행 될 메서드
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		list.add(session);
		log.info("알람 웹소켓에 접속된 유저 : {} ", list);
		log.info("알람용 웹소켓에 접속 완료됐습니다.");
	}

	//알람보내기용 웹소켓이 연결종료됐을 시 실행 될 메서드
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		
		list.remove(session);
		log.info("{} 세션이 알람웹소켓에서 연결 해제되었습니다. \n 연결 상태 {} ", session, status);
		log.info("알람 웹소켓의 연결이 종료되었습니다.");
	}
	
	//웹소켓에서 메세지를 보냈을 시 실행 될 메서드
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub
	}
	
	
	
	
}
