package com.chat.catok.socket;

import java.io.IOException;
import java.net.http.WebSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WebSocketHandler extends TextWebSocketHandler{
	private static List<WebSocketSession> list = new ArrayList<>();
	
	// 사용자가 웹소켓 서버에 접속하면 동작하는 메소드
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		list.add(session);
		log.info(session + " !!! 클라이언트가 접속했어용");
	}
	
	// 웹소켓 서버 접속이 해제되면 동작하는 메소드
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log.info(session + " !!! 클라이언트 접속이 해제되었어용");
		list.remove(session);
	}
	
	
	// 사용자의 메시지를 받게되면 동작하는 메소드
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String id = session.getId(); // 메시지를 발송한 아이디
		log.info("####_id : " + id);
		String payload = message.getPayload();
		log.info("####_payload : " + payload);
		for(WebSocketSession sess : list) {
			sess.sendMessage(message);
		}
	}
}
