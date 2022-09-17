package com.kws.mtrs.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kws.mtrs.bean.TheatreBean;
import com.kws.mtrs.dao.TheatreDAO;

public class TheatreAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          TheatreBean theatreBean=new TheatreBean();
          theatreBean.setTheatrename(request.getParameter("tname"));
          theatreBean.setCity(request.getParameter("city"));
          theatreBean.setState(request.getParameter("state"));
          theatreBean.setCountry(request.getParameter("country"));
          theatreBean.setPin(request.getParameter("pin"));
          theatreBean.setPhone(request.getParameter("phoneno"));
          theatreBean.setEmail(request.getParameter("email"));
          theatreBean.setNoofshows(request.getParameter("nofshows"));
          theatreBean.setNoofseats(Integer.parseInt(request.getParameter("noofseats")));
		  TheatreDAO theatreDAO=new TheatreDAO();
		  boolean flag=theatreDAO.registerTheatres(theatreBean);
		  if(flag){
			  response.sendRedirect("Theatres.jsp?status=Registration of Theatre Success");
		  }
		  else{
			  response.sendRedirect("Thatres.jsp?status=Registration of Theatre Failure");
		  }
	}

}
