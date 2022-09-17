package com.kws.mtrs.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kws.mtrs.bean.TheatreBean;
import com.kws.mtrs.dao.BookingDAO;

public class BookingTicketAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TheatreBean theatreBean=new TheatreBean();
		theatreBean.setUserid(Integer.parseInt(request.getParameter("userid")));
		theatreBean.setUsertype(request.getParameter("logintype"));
		theatreBean.setTheatremovieid(Integer.parseInt(request.getParameter("mtid")));
		theatreBean.setNooftickets(Integer.parseInt(request.getParameter("notickets")));
		BookingDAO bookingDAO=new BookingDAO();
		boolean flag=bookingDAO.bookMovieTicket(theatreBean);
		if(flag)
			response.sendRedirect("ViewMoviesByTheatres.jsp?status=Booking ticket request Success");
		else
			response.sendRedirect("ViewMoviesByTheatres.jsp?status=Booking ticket request Failure");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
