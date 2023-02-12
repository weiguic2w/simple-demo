package com.wcw.example.handler;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyHandler extends TextWebSocketHandler {
    // ConcurrentHashMap：避免线程不安全
    private Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    /**
     *  处理客户端数据逻辑
     */
    @Override
    protected void handleTextMessage(WebSocketSession session,
                                     TextMessage message) throws Exception {
        broadCast(new TextMessage(session.getRemoteAddress() + "：" + message.getPayload()));
    }

    /**
     *  握手成功即用户加入聊天室
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        if (!sessions.containsKey(session.getId())) {
            sessions.put(session.getId(),session);
        }
        broadCast(new TextMessage(session.getRemoteAddress() + "进入聊天室"));
    }

    /**
     * 结束握手即退出聊天室
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session.getId());
        broadCast(new TextMessage(session.getRemoteAddress() + "退出聊天室"));
    }

    /**
     * 向聊天室用户广播消息
     */
    private void broadCast(TextMessage message) {
        sessions.entrySet().parallelStream().forEach(e -> {
            try {
                e.getValue().sendMessage(message);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }
}