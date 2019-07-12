package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javafx.scene.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.GroupMember;
import com.bean.TravelGroup;
import com.bean.User;
import com.db.DAO.GroupMemberDAO;
import com.db.DAO.TravelGroupDAO;

/**
 * Servlet implementation class addGroupMember
 */
@WebServlet("/addGroupMember")
public class addGroupMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addGroupMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String groupID = request.getParameter("groupid");
		String societyID = request.getParameter("societyid");
		//System.out.println(groupID+" "+societyID);
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("User");
		String userID = user.getUserID();
		int currentNumber = GroupMemberDAO.selectByGroupID(groupID).size();
		if(currentNumber<TravelGroupDAO.selectByID(groupID).getMaximum())
		{
			GroupMember member = new GroupMember(groupID, userID);
			GroupMemberDAO.insert(member);
			PrintWriter out = response.getWriter();
	        out.print("<script>alert('加入旅游团成功!');window.location.href='Takepart.jsp?id="+societyID+"'</script>");
		}
		else{
			PrintWriter out = response.getWriter();
			out.print("<script>alert('加入旅游团失败，旅游团人数以满');window.location.href='Takepart.jsp?id="+societyID+"'</script>");
		}
	}

}
