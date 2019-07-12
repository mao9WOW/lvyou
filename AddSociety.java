package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Society;
import com.bean.User;
import com.db.DAO.SocietyDAO;
import com.db.DAO.UserDAO;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Servlet implementation class AddSociety
 */
@WebServlet("/AddSociety")
public class AddSociety extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSociety() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String name = request.getParameter("new_name");
		String userName = request.getParameter("new_user");
		String phone = request.getParameter("new_phone");
		String email = request.getParameter("new_email");
		String introduce = request.getParameter("new_introduce");
		String address = request.getParameter("new_address");
		System.out.println(name+userName+phone+email+introduce+address);
		User user = UserDAO.selectByName(userName);
		if(user.equals(new User())){
			response.setCharacterEncoding("utf-8");
	        PrintWriter out = response.getWriter();
	        out.print("<script>alert('注册人不存在!');window.location.href='admin.jsp'</script>");
		}
		else{
			Society society = new Society(name, user.getUserID(), introduce, phone, email, address);
			SocietyDAO.insert(society);
			response.setCharacterEncoding("utf-8");
	        PrintWriter out = response.getWriter();
	        out.print("<script>alert('注册旅行社成功!');window.location.href='admin.jsp'</script>");
		}
		
	}

}
