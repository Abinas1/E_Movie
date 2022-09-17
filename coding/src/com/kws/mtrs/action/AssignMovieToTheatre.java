package com.kws.mtrs.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kws.mtrs.bean.TheatreBean;
import com.kws.mtrs.dao.TheatreDAO;

public class AssignMovieToTheatre extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

          doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String tid=request.getParameter("tid");
		String mid=request.getParameter("mid");
		String time=request.getParameter("timings");
		String price=request.getParameter("price");
		String tarString="./AssignMovieToTheatre.jsp?status=Operation failed";
		TheatreBean tbeBean=new TheatreBean();
		tbeBean.setTheatreid(Integer.parseInt(tid));
		tbeBean.setMovieid(Integer.parseInt(mid));
		tbeBean.setTimings(time);
		tbeBean.setTicketprice(price);
		TheatreDAO tDao=new TheatreDAO();
		boolean flag=tDao.movieTheatres(tbeBean);
		if(flag){
			tarString="./AssignMovieToTheatre.jsp?status=Operation success";
		}
		
		RequestDispatcher rd=request.getRequestDispatcher(tarString);
		rd.forward(request, response);
	}

}
