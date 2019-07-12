package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.TravelGroup;
import com.db.DAO.TravelGroupDAO;

/**
 * Servlet implementation class AddTravelGroup
 */
@WebServlet("/AddTravelGroup")
public class AddTravelGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTravelGroup() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String societyID = (String) session.getAttribute("societyID");
		session.removeAttribute("societyID");
		//String societyID = request.getParameter("societyID");
		String topic = request.getParameter("reset-topic");
		String introduce = request.getParameter("reset-intro");
		String begin = request.getParameter("reset-begin");
		begin=begin.replaceAll("T"," ")+":00";
		Timestamp beginStamp = Timestamp.valueOf(begin);
		String end = request.getParameter("reset-end");
		end=end.replaceAll("T"," ")+":00";
		Timestamp endStamp = Timestamp.valueOf(end);
		String maximum = request.getParameter("reset-maximum");
		int max = Integer.valueOf(maximum).intValue();
		TravelGroup newGroup = new TravelGroup(societyID, topic, introduce, beginStamp, endStamp, max);
		System.out.println(societyID+" "+topic+" "+introduce+" "+begin+" "+end+" "+maximum);
		TravelGroupDAO.insert(newGroup);
		PrintWriter out = response.getWriter();
	    out.print("<script>alert('创建新旅游团成功');window.location.href='checkGroup.jsp?id="+societyID+"'</script>");
	}

}
