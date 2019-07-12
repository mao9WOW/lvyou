package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Attraction;
import com.bean.DayPlan;
import com.db.DAO.AttractionDAO;

/**
 * @author 陈卓明  李子奇
 * Servlet implementation class AutoPlanDo
 */
@WebServlet("/AutoPlanDo")
public class AutoPlanDo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoPlanDo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String cityName = request.getParameter("cityName");
		cityName = new String(cityName.getBytes("ISO-8859-1"), "utf-8");
		String dayStr = request.getParameter("dayStr");
		//String cityName = "陕西";
		//String dayStr = "3";
		int dayNum = Integer.parseInt(dayStr);
		
		AttractionDAO placesDAO = new AttractionDAO();
		ArrayList<Attraction> places = placesDAO.selectByAddress(cityName);
		ArrayList<DayPlan> dayPlan = new ArrayList<DayPlan>();
		int n=0;
		
		for(int i = 0;i<places.size();i++){
			for(int j= i;j<places.size();j++){
				//大的放前面
				if(places.get(i).getPlay_time()<places.get(j).getPlay_time()){
					Attraction a= places.get(i);
					places.set(i, places.get(j));
					places.set(j, a);
				}
			}
		}
		
		
		for(int i=0;i < dayNum ; i++){
			int playHour = 0;
			ArrayList<Attraction> oneDay = new ArrayList<Attraction>();			
			for(int m=n ; m < places.size() ; m++){
				System.out.println("n:" + n);
				if(playHour + places.get(m).getPlay_time() < 12){
					oneDay.add(places.get(m));
					playHour = playHour + places.get(m).getPlay_time();
					//System.out.println(places.get(i).getAttract_name()+places.get(m).getPlay_time());
					//System.out.println(playHour+places.get(m).getPlay_time() );
				}
				if(m == places.size()-1 || (playHour + places.get(m).getPlay_time() >= 12)){
					n=m+1;
					DayPlan oneDayPlan = new DayPlan();
					oneDayPlan.setAttractions(oneDay);
					dayPlan.add(oneDayPlan);
					break;
				}
			}
			if(n == places.size()-1){
				break;
			}
		}
		request.setAttribute("days", dayPlan);
		for(int i=0; i<dayPlan.size();i++){
			System.out.println("Day "+i+":");
			for(int j=0;j<dayPlan.get(i).getAttractions().size();j++){
				System.out.print(dayPlan.get(i).getAttractions().get(j).getAttract_name());
				System.out.print("--");
				
			}
			System.out.println("--------------------------");
		}
		request.setCharacterEncoding("utf-8");	
	    response.setContentType("text/html; charset=utf-8");
		request.setAttribute("day", dayPlan);	
		request.getRequestDispatcher("autoPlan.jsp").forward(request, response);
		
	}

}
