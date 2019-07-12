package com.bean;

import java.sql.Timestamp;

/**
 * 聊天信息（用于聊天室）
 * 
 * @author 解智伟
 */
public class Chat {

	/** 聊天信息的ID */
	private String chat_ID;
	
	/** 聊天信息所在聊天群对应的景区编码 */
	private String attract_ID;
	
	/** 发送该聊天信息的用户ID */
	private String user_ID;
	
	/** 聊天信息的内容 */
	private String message;
	
	/** 聊天信息的发送时间（日期 + 时间）*/
	private Timestamp time;
	
	public Chat() {
		super();
	}
	
	/**
	 * 虚构函数，用于插入一条新消息
	 * @param attract_ID 景区编号
	 * @param user_ID 用户ID
	 * @param message 消息内容
	 */
	public Chat(String attract_ID , String user_ID , String message) {
		super();
		this.attract_ID = attract_ID;
		this.user_ID = user_ID;
		this.message = message;
	}

	/**
	 * @return the chat_ID
	 */
	public String getChat_ID() {
		return chat_ID;
	}

	/**
	 * @param chat_ID the chat_ID to set
	 */
	public void setChat_ID(String chat_ID) {
		this.chat_ID = chat_ID;
	}

	/**
	 * @return the attract_ID
	 */
	public String getAttract_ID() {
		return attract_ID;
	}

	/**
	 * @param attract_ID the attract_ID to set
	 */
	public void setAttract_ID(String attract_ID) {
		this.attract_ID = attract_ID;
	}

	/**
	 * @return the user_ID
	 */
	public String getUser_ID() {
		return user_ID;
	}

	/**
	 * @param user_ID the user_ID to set
	 */
	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the time
	 */
	public Timestamp getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chat other = (Chat) obj;
		if (attract_ID == null) {
			if (other.attract_ID != null)
				return false;
		} else if (!attract_ID.equals(other.attract_ID))
			return false;
		if (chat_ID == null) {
			if (other.chat_ID != null)
				return false;
		} else if (!chat_ID.equals(other.chat_ID))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (user_ID == null) {
			if (other.user_ID != null)
				return false;
		} else if (!user_ID.equals(other.user_ID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Chat [chat_ID=" + chat_ID + ", attract_ID=" + attract_ID + ", user_ID=" + user_ID + ", message="
				+ message + ", time=" + time + "]";
	}
}
