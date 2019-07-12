package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.*;
import com.db.DAO.AttractionDAO;

/**
 * @author 陈卓明 李子奇
 * Servlet implementation class CompareDo
 */
@WebServlet("/CompareDo")
public class CompareDo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//私有静态存记录的attraction的数据，单例模式
	private static ArrayList<Attraction> attractions = new ArrayList<Attraction>();
    public CompareDo() {super();}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
        doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//String cityName = request.getParameter("cityName");
		//PrintWriter output = response.getWriter();
		String command = request.getParameter("command");
		command = new String(command.getBytes("ISO-8859-1"), "utf-8");
		String info = request.getParameter("attract_name");
		info = new String(info.getBytes("ISO-8859-1"), "utf-8");
		AttractionDAO allPlacesDAO = new AttractionDAO();
		ArrayList<Attraction> allPlaces = allPlacesDAO.selectByName("");
		request.setAttribute("allInfo", allPlaces);
		System.out.println(command);
		System.out.println(info);
		//command = new String(command.getBytes("ISO-8859-1"),"utf-8");
		//info = new String(info.getBytes("ISO-8859-1"),"utf-8");
		if (command.equals("add")) {
			System.out.println("进入添加分支");
			AttractionDAO placesDAO = new AttractionDAO();
			ArrayList<Attraction> placesByName = placesDAO.selectByName(info);
			if (attractions != null) {
				System.out.println("不是空的表");
			} else {
				System.out.println("空的表");
			}
			attractions.add(placesByName.get(0));
			System.out.println(attractions.get(attractions.size() - 1).getAttract_name());
			ArrayList<String> openTime = new ArrayList<String>();
			for(int i=0;i<attractions.size();i++){
				openTime.add(attractions.get(i).formalTime(attractions.get(i).getStart()) + " - " +attractions.get(i).formalTime(attractions.get(i).getEnd()));
			}
			if (placesByName != null && !placesByName.isEmpty()) {
				request.setAttribute("info", attractions);
				request.setAttribute("openTime", openTime);
				request.setAttribute("number", attractions.size());
				request.getRequestDispatcher("compare.jsp").forward(request, response);
			} else {
				//System.out.println("未能查到相应数据，请确认输入的相关信息");
				response.setCharacterEncoding("utf-8");
		        PrintWriter out = response.getWriter();
		        out.print("<script>alert('未能查到相应数据，请确认输入的相关信息');window.location.href='places.jsp'</script>");
			}
		} else if (command.equals("del")) {
			System.out.println("--------------");
			System.out.println("进入删除分支");
			int i = 0;
			for (i = 0; i < attractions.size(); i++) {
				if (attractions.get(i).getAttract_name().equals(info)) {
					System.out.println(i);
					break;
				}
				if (i == attractions.size() - 1) {
					System.out.println("没找到删除对象");
				}
			}
			System.out.println(i);
			    attractions.remove(i);		
				request.setAttribute("info", attractions);
				request.setAttribute("number", attractions.size());
				request.getRequestDispatcher("compare.jsp").forward(request, response);
		}
		//output.close();
	}

}
