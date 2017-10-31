package com.techelevator.controller.websockets;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;


@Component
public class StompEventHandler {
	private List<String> connectedUsers = new ArrayList<String>();
	@Autowired
	private SimpMessagingTemplate template;
	
	@EventListener
	public void onConnectEvent(SessionSubscribeEvent event) {
		StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
		if("/topic/chat".equals(accessor.getDestination())) {
			connectedUsers.add((String)accessor.getSessionAttributes().get("email"));
        	this.template.convertAndSend("/topic/members", connectedUsers);
		}
    }
	
	@EventListener
	public void onDisconnectEvent(SessionDisconnectEvent event) {
		StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
		
        connectedUsers.remove((String)accessor.getSessionAttributes().get("email"));
        this.template.convertAndSend("/topic/members", connectedUsers);
	}
}