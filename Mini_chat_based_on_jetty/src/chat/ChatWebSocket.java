package chat;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

@WebSocket
public class ChatWebSocket {
    ChatWebSocket socket;
    private Session session;

    public ChatWebSocket() {
    }

    @OnWebSocketConnect
    public void onOpen(Session session) {
        this.socket = this;
        this.session = session;
    }

    @OnWebSocketMessage
    public void onMessage(String data) {
        socket.sendString(data);
    }

    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        this.socket = null;
    }

    public void sendString(String data) {
        try {
            session.getRemote().sendString(data);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}