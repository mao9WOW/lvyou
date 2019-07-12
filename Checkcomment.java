package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Comment;
import com.db.DAO.CommentDAO;
import com.db.DAO.UserDAO;

/**
 * Servlet implementation class Checkcomment
 */
@WebServlet("/Checkcomment")
public class Checkcomment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checkcomment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String uid=(String)request.getParameter("uid");
		System.out.println("uid"+uid);
		String aid=(String)request.getParameter("aid");
		System.out.println("aid"+aid);
		String comment=(String)request.getParameter("new_comment");
		System.out.println("comment"+comment);
		String scores = (String)request.getParameter("new_rating");
		System.out.println("scores"+scores);
		String uname = UserDAO.selectByID(uid).getUserName();
		int score = Integer.parseInt(scores);
		String newCID=CommentDAO.newID();
		Comment newcomment = new Comment(newCID,uid,aid,score,comment,uname);
		CommentDAO.insert(newcomment);
		response.sendRedirect("AttractionInfo.jsp?id="+aid);
		}

}
