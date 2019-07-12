package com.bean;

import java.sql.Timestamp;

/**
 * ������Ϣ�����������ң�
 * 
 * @author ����ΰ
 */
public class Chat {

	/** ������Ϣ��ID */
	private String chat_ID;
	
	/** ������Ϣ��������Ⱥ��Ӧ�ľ������� */
	private String attract_ID;
	
	/** ���͸�������Ϣ���û�ID */
	private String user_ID;
	
	/** ������Ϣ������ */
	private String message;
	
	/** ������Ϣ�ķ���ʱ�䣨���� + ʱ�䣩*/
	private Timestamp time;
	
	public Chat() {
		super();
	}
	
	/**
	 * �鹹���������ڲ���һ������Ϣ
	 * @param attract_ID �������
	 * @param user_ID �û�ID
	 * @param message ��Ϣ����
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
