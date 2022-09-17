package com.kws.mtrs.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kws.mtrs.bean.EventsBean;
import com.kws.mtrs.dao.EventDAO;

public class EventsAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         EventsBean eventsBean=new EventsBean();
         eventsBean.setEventname(request.getParameter("eventname"));
         eventsBean.setEventdesc(request.getParameter("eventDesc"));
         EventDAO eventDAO=new EventDAO();
         boolean flag=eventDAO.postEvents(eventsBean);
         if(flag)
        	 response.sendRedirect("Events.jsp?status=Posting Event Success");
         else
        	response.sendRedirect("Events.jsp?status=Posting Event Failure");
		
	}

}
