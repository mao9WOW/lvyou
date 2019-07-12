package com.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.bean.Attraction;
import com.bean.Chat;
import com.bean.User;
import com.db.DAO.*;

import net.sf.json.JSONObject;

@ServerEndpoint("/websocket")
public class ChatServer extends HttpServlet{
	
	private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static Vector<Session> room = new Vector<Session>();
	
	/* 当前用户 */
	private User user = new User();
	
	/**
	 * 用户接入
	 * @param session 可选
	 */
	@OnOpen
	public void onOpen(Session session){
	    room.addElement(session);
	}
	/**
	 * 接收到来自用户的消息
	 * @param message
	 * @param session
	 */
	@OnMessage
	public void onMessage(String message,Session session){
		
	    //把用户发来的消息解析为JSON对象
	    JSONObject obj = JSONObject.fromObject(message);
	    //向JSON对象中添加发送时间
	    obj.put("date", df.format(new Date()));
	    //遍历聊天室中的所有会话
	    for(Session se : room){
	        //设置消息是否为自己的
	        obj.put("isSelf", se.equals(session));
	        //发送消息给远程用户
	        se.getAsyncRemote().sendText(obj.toString());
	    }
	    
	    String str = obj.getString("attract_ID");
	    String attract_ID = "";
	    for(int i = 0 ; i<8-str.length() ; i++) {
	    	attract_ID += "0";
	    }
	    attract_ID += str;
	    String user_ID = "";
	    str = obj.getString("user_ID");
	    for(int i = 0 ; i<8-str.length() ; i++) {
	    	user_ID += "0";
	    }
	    user_ID += str;
	    Chat chat = new Chat(attract_ID, user_ID, obj.getString("content"));
	    System.err.println(chat.toString());
	    ChatDAO.insert(chat);
	}
	/**
	 * 用户断开
	 * @param session
	 */
	@OnClose
	public void onClose(Session session){
	    room.remove(session);
	}
	/**
	 * 用户连接异常
	 * @param t
	 */
	@OnError
	public void onError(Throwable t){
	}
	

}
