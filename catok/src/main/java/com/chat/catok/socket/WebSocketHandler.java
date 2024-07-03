package com.chat.catok.socket;

import java.io.IOException;
import java.net.http.WebSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

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
//	private static List<WebSocketSession> list = new ArrayList<>();
	
	private static Map<String, List<WebSocketSession>> sessions = new ConcurrentHashMap<>();
	
	// 사용자가 웹소켓 서버에 접속하면 동작하는 메소드
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//		list.add(session);
		String url = session.getUri().getPath();
		String roomId = url.substring(url.lastIndexOf('/') + 1);
		
		sessions.computeIfAbsent(roomId, k -> new CopyOnWriteArrayList<>()).add(session);
		//map List 형태의 세션안에 Map<스트링, 리스트(생성)> 만든 후 생성된 리스트에 세션을 더한다...?
		
		log.info("{} 방에 접속되있는 사용자 {}", roomId, sessions.get(roomId));
	}
	
	// 웹소켓 서버 접속이 해제되면 동작하는 메소드
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//		log.info(session + " !!! 클라이언트 접속이 해제되었어용");
//		list.remove(session);
		String url = session.getUri().getPath();
		String roomId = url.substring(url.lastIndexOf('/') + 1);
		
		List<WebSocketSession> connectedSessions = sessions.get(roomId);
		
		if (connectedSessions != null) {
            connectedSessions.remove(session);
            if (connectedSessions.isEmpty()) {
                sessions.remove(roomId);
            }
        }
		
		log.info("{} 사용자가 웹소켓연결을 해제하였습니다 현재접속 세션 : {}",session , sessions);
		
	}
	
	
	// 사용자의 메시지를 받게되면 동작하는 메소드
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		String url = session.getUri().getPath();
		String roomId = url.substring(url.lastIndexOf('/') + 1);
		String payload = message.getPayload();
		
		List<WebSocketSession> connectedSessions = sessions.get(roomId);
		
		if(connectedSessions != null) {
			for(WebSocketSession sess : connectedSessions) {
				if(sess.isOpen()) {
					sess.sendMessage(message);
				}
			}
		}
		
		
//		String id = session.getId(); // 메시지를 발송한 아이디
//		log.info("####_id : " + id);
//		String payload = message.getPayload();
//		log.info("####_payload : " + payload);
//		for(WebSocketSession sess : list) {
//			sess.sendMessage(message);
//		}
	}
}
