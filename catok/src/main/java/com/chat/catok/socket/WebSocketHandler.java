package com.chat.catok.socket;

import java.io.IOException;
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
	// CLIENTS 라는 변수에 세션을 담아두기위한 맵형식의 공간
	private static final ConcurrentHashMap<String, WebSocketSession> CLIENTS = new ConcurrentHashMap<String, WebSocketSession>();
	
	
	// 사용자가 웹소켓 서버에 접속하면 동작하는 메소드
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		CLIENTS.put(session.getId(), session);
		log.info("접근한 session의 정보 : {}",session);
	}
	
	// 웹소켓 서버접속이 끝났을 때 동작하는 메소드 CLIENTS 변수에 있는 해당 세션을 제거
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		CLIENTS.remove(session.getId());
		log.info("사용자의 세션이 끊어졌습니다. : {}", session);
	}
	
	
	
	// 사용자의 메시지를 받게되면 동작하는 메소드
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String id = session.getId(); // 메시지를 발송한 아이디
		CLIENTS.entrySet().forEach( arg->{
			if(!arg.getKey().equals(id)) { // 같은 아이디가 아닐경우 메시지 전달
				try {
					arg.getValue().sendMessage(message);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
