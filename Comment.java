package com.bean;

/**
 * �û��Ծ���������
 * 
 * @author ����ΰ
 */
public class Comment {

	/** ���۵�ID */
	private String comment_ID;
	
	/** ���������۵�User��ID */
	private String user_ID;
	
	/** �����۶�Ӧ�ľ�����ID */
	private String attract_ID;
	
	/** ����Ӧ���������� */
	private int score;
	
	/** ���۵����� */
	private String content;
	
	/**���۵�user��name**/
	private String userName;
	
	public Comment() {
		super();
	}

	public String getComment_ID() {
		return comment_ID;
	}

	

	public Comment(String comment_ID, String user_ID, String attract_ID, int score, String content, String userName) {
		super();
		this.comment_ID = comment_ID;
		this.user_ID = user_ID;
		this.attract_ID = attract_ID;
		this.score = score;
		this.content = content;
		this.userName = userName;
	}

	public void setComment_ID(String comment_ID) {
		this.comment_ID = comment_ID;
	}

	public String getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}

	public String getAttract_ID() {
		return attract_ID;
	}

	public void setAttract_ID(String attract_ID) {
		this.attract_ID = attract_ID;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
