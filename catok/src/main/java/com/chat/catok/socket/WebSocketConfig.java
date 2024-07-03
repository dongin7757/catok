package com.chat.catok.socket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {
	
	private final WebSocketHandler webSocketHandler;
	private final NotificationWebsocketHandler notificationWebsocketHandler;
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandler, "/ws/catok/*").setAllowedOrigins("*"); //ws://127.0.0.1:포트/ws/catok, setAllowedOrigins는 허용 도메인 지정
        registry.addHandler(notificationWebsocketHandler, "/ws/notification").setAllowedOrigins("*");
        
    }
	
	
	
	
}
