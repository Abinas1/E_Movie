package com.kws.mtrs.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kws.mtrs.bean.TheatreBean;
import com.kws.mtrs.dao.TheatreDAO;

public class MovieTheatresAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          TheatreBean theatreBean=new TheatreBean();
          theatreBean.setTheatreid(Integer.parseInt(request.getParameter("tid")));
          theatreBean.setMovieid(Integer.parseInt(request.getParameter("movieid")));
          theatreBean.setTimings(request.getParameter("timings"));
          theatreBean.setTicketprice(request.getParameter("ticketPrice"));
          TheatreDAO theatreDAO=new TheatreDAO();
          boolean flag=theatreDAO.movieTheatres(theatreBean);
          if(flag)
        	  response.sendRedirect("ViewTheatres.jsp?status=adding movietheatre success");
          else
        	  response.sendRedirect("ViewTheatres.jsp?status=adding movietheatre Failure");
		 
	}

}
