package com.kws.mtrs.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kws.mtrs.bean.NewsBean;
import com.kws.mtrs.dao.NewsDAO;

public class NewsAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            NewsBean newsBean=new NewsBean();
            newsBean.setNewsheading(request.getParameter("nheading"));
            newsBean.setNewsdetails(request.getParameter("ndetails"));
            NewsDAO newsDAO=new NewsDAO();
            boolean flag=newsDAO.registerNews(newsBean);
            if(flag)
            	response.sendRedirect("News.jsp?status=Posting News Success");
            else
            	response.sendRedirect("News.jsp?status=Posting News Failure");
		
	}

}
