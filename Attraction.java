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

	/** 景区的编码（唯一） */
	private String attract_ID;
	
	/** 景区的名字（唯一） */
	private String attract_name;
	
	/** 景区地址（省、市、县、乡、村） */
	private String address;
	
	/** 景区联系电话 */
	private String tel;
	
	/** 景区邮箱 */
	private String email;
	
	/** 景区等级（1~5） */
	private int level;
	
	/** 景点介绍 */
	private String introduce;
	
	/** 景区门票价格 */
	private float price;
	
	/** 景区获得的的点赞数 */
	private int like_num;
	
	/**景区页面的 浏览量 */
	private int views;
	
	/** 建议游玩时间（单位：小时） */
	private int play_time;
	
	/** 景区开放时间 */
	private Time start;
	
	/** 景区关闭时间 */
	private Time end;
	
	/** 景区的封面对应的图片ID  */
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
	 * 获取当前信息的标签
	 * @return 获取的标签
	 */
	public ArrayList<Label> getLabelList() {
		return LabelDAO.selectLabelList(attract_ID);
	}
	
	/**
	 * 获取景区的封面对应的图片bean对象
	 * @return 获取到的图片
	 */
	public Image getCover() {
		return ImageDAO.selectByID(image_ID);
	}
	
	/**
	 * 获取当前景区的所有图片
	 * @return 查找到的Image bean对象
	 */
	public ArrayList<Image> getImageList() {
		return ImageDAO.selectByAttractID(attract_ID);
	}
	
	/**
	 * 获取当前景区的所有评论
	 * @return 查找到的评论列表
	 */
	public ArrayList<Comment> getCommentList() {
		return CommentDAO.selectByAttractID(attract_ID);
	}
	
	/**
	 * 获取当前景区聊天群的前num个聊天记录
	 * @param num 聊天记录的条数
	 * @return  查找到的聊天消息列表
	 */
	public ArrayList<Chat> getChatList(int num) {
		return ChatDAO.selectByAttractID(attract_ID, num);
	}
	
	/**
	 * 获取和当前景区有关的所有论坛帖子
	 * @return 查找到的所有帖子
	 */
	public ArrayList<Forum> getForumList() {
		return ForumDAO.selectByAttractID(attract_ID);
	}
	
	/**
	 * 查看当前景区的所有攻略
	 * @return 查到的攻略列表
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
