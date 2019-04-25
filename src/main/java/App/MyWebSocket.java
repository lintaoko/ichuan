package App;

import App.Domain.UserLogin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/websocket/{nickname}")
@Component
@Slf4j
public class MyWebSocket {
    private Session session;
    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<MyWebSocket>();
    private String nickname;
    @OnOpen
    public void onOpen(Session session,@PathParam("nickname") String nickname) throws IOException {
        this.session = session;
        this.nickname=nickname;
        webSocketSet.add(this);
        System.out.println(nickname+"加入！当前在线人数为" + webSocketSet.size());
        this.session.getAsyncRemote().sendText("恭喜您成功连接上ichuan狗粉丝在线口嗨聊天室-->当前在线人数为：" + webSocketSet.size());
    }
    @OnClose
    public void onClose() {
        webSocketSet.remove(this); //从set中删除
        broadcast(nickname+"离开了");
        System.out.println("有一连接关闭！当前在线人数为" + webSocketSet.size());
    }
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("来自客户端的消息:"+nickname+ message);
        broadcast(nickname+":"+message);
    }
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }
    private synchronized void broadcast(String message) {
        for (MyWebSocket item : webSocketSet) {
            item.session.getAsyncRemote().sendText(message);//异步发送消息.
        }
    }
}
