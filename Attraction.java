package com.bean;

import java.sql.Time;
import java.util.ArrayList;

import org.apache.naming.java.javaURLContextFactory;

import com.db.DAO.ChatDAO;
import com.db.DAO.CommentDAO;
import com.db.DAO.ForumDAO;
import com.db.DAO.ImageDAO;
import com.db.DAO.LabelDAO;
import com.db.DAO.StrategyDAO;

public class Attraction {

	/** �����ı��루Ψһ�� */
	private String attract_ID;
	
	/** ���������֣�Ψһ�� */
	private String attract_name;
	
	/** ������ַ��ʡ���С��ء��硢�壩 */
	private String address;
	
	/** ������ϵ�绰 */
	private String tel;
	
	/** �������� */
	private String email;
	
	/** �����ȼ���1~5�� */
	private int level;
	
	/** ������� */
	private String introduce;
	
	/** ������Ʊ�۸� */
	private float price;
	
	/** ������õĵĵ����� */
	private int like_num;
	
	/**����ҳ��� ����� */
	private int views;
	
	/** ��������ʱ�䣨��λ��Сʱ�� */
	private int play_time;
	
	/** ��������ʱ�� */
	private Time start;
	
	/** �����ر�ʱ�� */
	private Time end;
	
	/** �����ķ����Ӧ��ͼƬID  */
	private String image_ID;
	
	
	public Attraction() {
		super();
	}
	
	public Attraction(String attract_name, String address, 
			String tel, String email, int level, String introduce, float price,
			int play_time, Time start, Time end, String image_ID) {
		super();
		this.attract_name = attract_name;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.level = level;
		this.introduce = introduce;
		this.price = price;
		this.play_time = play_time;
		this.start = start;
		this.end = end;
		this.image_ID = image_ID;
	}


	/**
	 * ��ȡ��ǰ��Ϣ�ı�ǩ
	 * @return ��ȡ�ı�ǩ
	 */
	public ArrayList<Label> getLabelList() {
		return LabelDAO.selectLabelList(attract_ID);
	}
	
	/**
	 * ��ȡ�����ķ����Ӧ��ͼƬbean����
	 * @return ��ȡ����ͼƬ
	 */
	public Image getCover() {
		return ImageDAO.selectByID(image_ID);
	}
	
	/**
	 * ��ȡ��ǰ����������ͼƬ
	 * @return ���ҵ���Image bean����
	 */
	public ArrayList<Image> getImageList() {
		return ImageDAO.selectByAttractID(attract_ID);
	}
	
	/**
	 * ��ȡ��ǰ��������������
	 * @return ���ҵ��������б�
	 */
	public ArrayList<Comment> getCommentList() {
		return CommentDAO.selectByAttractID(attract_ID);
	}
	
	/**
	 * ��ȡ��ǰ��������Ⱥ��ǰnum�������¼
	 * @param num �����¼������
	 * @return  ���ҵ���������Ϣ�б�
	 */
	public ArrayList<Chat> getChatList(int num) {
		return ChatDAO.selectByAttractID(attract_ID, num);
	}
	
	/**
	 * ��ȡ�͵�ǰ�����йص�������̳����
	 * @return ���ҵ�����������
	 */
	public ArrayList<Forum> getForumList() {
		return ForumDAO.selectByAttractID(attract_ID);
	}
	
	/**
	 * �鿴��ǰ���������й���
	 * @return �鵽�Ĺ����б�
	 */
	public ArrayList<Strategy> getStrategyList() {
		return StrategyDAO.selectByAttractID(attract_ID);
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
	 * @return the attract_name
	 */
	public String getAttract_name() {
		return attract_name;
	}

	/**
	 * @param attract_name the attract_name to set
	 */
	public void setAttract_name(String attract_name) {
		this.attract_name = attract_name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return the introduce
	 */
	public String getIntroduce() {
		return introduce;
	}

	/**
	 * @param introduce the introduce to set
	 */
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @return the like_num
	 */
	public int getLike_num() {
		return like_num;
	}

	/**
	 * @param like_num the like_num to set
	 */
	public void setLike_num(int like_num) {
		this.like_num = like_num;
	}

	/**
	 * @return the views
	 */
	public int getViews() {
		return views;
	}

	/**
	 * @param views the views to set
	 */
	public void setViews(int views) {
		this.views = views;
	}

	/**
	 * @return the play_time
	 */
	public int getPlay_time() {
		return play_time;
	}

	/**
	 * @param play_time the play_time to set
	 */
	public void setPlay_time(int play_time) {
		this.play_time = play_time;
	}

	/**
	 * @return the start
	 */
	public Time getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(Time start) {
		this.start = start;
	}

	/**
	 * @return the end
	 */
	public Time getEnd() {
		return end;
	}

	/**
	 * @param end the end to set
	 */
	public void setEnd(Time end) {
		this.end = end;
	}

	/**
	 * @return the image_ID
	 */
	public String getImage_ID() {
		return image_ID;
	}

	/**
	 * @param image_ID the image_ID to set
	 */
	public void setImage_ID(String image_ID) {
		this.image_ID = image_ID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attraction other = (Attraction) obj;
		if (attract_ID == null) {
			if (other.attract_ID != null)
				return false;
		} else if (!attract_ID.equals(other.attract_ID))
			return false;
		if (attract_name == null) {
			if (other.attract_name != null)
				return false;
		} else if (!attract_name.equals(other.attract_name))
			return false;
		return true;
	}
	
	public static String formalTime(Time time){
		int hours = time.getHours();
		int minutes = time.getMinutes();
		if(hours+10>=24)
			hours=hours+10-24;
		else {
			hours = hours+10;
		}
		String hour = ""+hours,minute =""+minutes;
		if(hours<10)
			hour="0"+hour;
		if(minutes<10)
			minute = "0"+minute;
		return hour+":"+minute;
	}

	@Override
	public String toString() {
		return "Attraction [attract_ID=" + attract_ID + ", attract_name=" + attract_name + ", address=" + address
				+ ", tel=" + tel + ", email=" + email + ", level=" + level + ", introduce=" + introduce + ", price="
				+ price + ", like_num=" + like_num + ", views=" + views + ", play_time=" + play_time + ", start="
				+ start + ", end=" + end + ", image_ID=" + image_ID + "]";
	}

}
