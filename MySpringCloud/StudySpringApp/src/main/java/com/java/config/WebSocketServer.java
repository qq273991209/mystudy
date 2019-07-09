package com.java.config;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
/**
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 * @ServerEndpoint 可以把当前类变成websocket服务类
 * @Title: WebSocketServer.java 
 * @Package com.java.config 
 * @Description: TODO(WebSocket服务提供) 
 * @author 刘云升  
 * @date 2019年6月13日 上午9:58:08 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@ServerEndpoint("/websocket/{userno}")
@Component
@Slf4j
public class WebSocketServer {
	/**
	 * //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
	 */
	private static int onlineCount = 0;
	/**
	 * //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
	 */
	private static ConcurrentHashMap<String, WebSocketServer> webSocketSet = new ConcurrentHashMap<String, WebSocketServer>();
	/**
	 * //与某个客户端的连接会话，需要通过它来给客户端发送数据
	 */
	private Session webSocketsession;
	/**
	 * //当前发消息的人员编号
	 */
	private String userno = "";


	/**
     * 连接建立成功调用的方法
     *
     * @param session 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
	@OnOpen 
	public void onOpen(@PathParam(value = "userno") String param, Session webSocketsession, EndpointConfig config) {
		log.info(param);
	/**
	 * //接收到发送消息的人员编号
	 */
	userno = param;
	this.webSocketsession = webSocketsession;
	/**
	 * //加入map中
	 */
	webSocketSet.put(param, this);
	/**
	 * //在线数加1
	 */
	addOnlineCount();
	log.info( "有新连接加入！当前在线人数为" + getOnlineCount());

	}


	/**
     * 连接关闭调用的方法
     */
	@OnClose
	public void onClose() {
		String str = "";
		if (!str.equals(userno)) {
			/**
			 * //从set中删除
			 */
			webSocketSet.remove(userno);
			/**
			 * //在线数减1
			 */
			subOnlineCount();
			log.info("有一连接关闭！当前在线人数为" + getOnlineCount());
		}
	}


	/**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
	public void onMessage(String message, Session session) {
		
		log.info("来自客户端的消息:" + message);
		/**
		 * //群发消息
		 */
		int num = 2;
		if (num < onlineCount) {
			sendAll(message);
		} else {
			/**
			 * //给指定的人发消息
			 */
			sendToUser(message);
		}
	}


	/**
     * 给指定的人发送消息
     * @param message
     */
	@OnMessage
	public void sendToUser(String message) {
		String sendUserno = message.split("[|]")[1];
		String sendMessage = message.split("[|]")[0];
		String now = getNowTime();
		try {
			if (webSocketSet.get(sendUserno) != null) {
				webSocketSet.get(sendUserno).sendMessage(now + "通知消息："+ sendMessage);
			} else {
				log.info("当前用户不在线");
			}
		} catch (IOException e) {
				e.printStackTrace();
			}
		}

	/**
     * 给所有人发消息
     * @param message
     */
	private void sendAll(String message) {
		String now = getNowTime();
		String sendMessage = message.split("[|]")[0];
		/**
		 * //遍历HashMap
		 */
		for (String key : webSocketSet.keySet()) {
			try {
				/**
				 * //判断接收用户是否是当前发消息的用户
				 */
				if (!userno.equals(key)) {
					webSocketSet.get(key).sendMessage(now + "用户" + userno + "发来消息：" + " <br/> " + sendMessage);
					log.info("key = " + key);
				}
				} catch (IOException e) {
				e.printStackTrace();
				}
		}
}




	/**
     * 获取当前时间
     *
     * @return
     */
	private String getNowTime() {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);
		return time;
	}
	/**
     * 发生错误时调用
     *
     * @param session
     * @param error
     */
	@OnError
	public void onError(Session session, Throwable error) {
		log.info("刷新了页面发生错误");
		/**
		 * error.printStackTrace();
		 */
	}


	/**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     *
     * @param message
     * @throws IOException
     */
	public void sendMessage(String message) throws IOException {
		this.webSocketsession.getBasicRemote().sendText(message);
		/**
		 * this.session.getAsyncRemote().sendText(message);
		 */
		
	}

	/**
	 * 
	 * @return 人数
	 */
	public static synchronized int getOnlineCount() {
		return onlineCount;
		
	}

	/**
	 * 
	 * @return 人数
	 */
	public static synchronized void addOnlineCount() {
		WebSocketServer.onlineCount++;
	}

	/**
	 * 
	 * @return 人数
	 */
	public static synchronized void subOnlineCount() {
		WebSocketServer.onlineCount--;
	}

	/**
	 * 
	 * @return webSocketSet
	 */
	public static ConcurrentHashMap<String, WebSocketServer> getWebSocketSet() {
		return webSocketSet;
	}

	/**
	 * 
	 * @return webSocketsession
	 */
	public Session getWebSocketsession() {
		return webSocketsession;
	}

	/**
	 * 
	 * @return userno
	 */
	public String getUserno() {
		return userno;
	}
}