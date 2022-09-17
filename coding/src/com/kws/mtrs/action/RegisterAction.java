package com.kws.mtrs.action;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kws.mtrs.bean.UserMasterBean;
import com.kws.mtrs.dao.UserMasterDAO;


public class RegisterAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 UserMasterBean userMasterBean=new UserMasterBean();
		 userMasterBean.setUsername(request.getParameter("uname"));
		 userMasterBean.setPassword(request.getParameter("upass"));
		 userMasterBean.setLogintype(request.getParameter("logintype"));
		 userMasterBean.setAddress(request.getParameter("address"));
		 userMasterBean.setCity(request.getParameter("city"));
		 userMasterBean.setState(request.getParameter("state"));
		 userMasterBean.setCountry(request.getParameter("country"));
		 userMasterBean.setPhoneno(request.getParameter("phno"));
		 userMasterBean.setDob(request.getParameter("dob"));
		 userMasterBean.setPhoto(request.getParameter("photo"));
		 userMasterBean.setSquestion(request.getParameter("squestion"));
		 userMasterBean.setSanswer(request.getParameter("sanswer"));
		 userMasterBean.setStatus(request.getParameter("status"));
		 UserMasterDAO userMasterDAO=new UserMasterDAO();
		 boolean flag=userMasterDAO.registerUser(userMasterBean);
		 if(flag)
			 response.sendRedirect("Register.jsp?status=Registration Success");
		 else
			 response.sendRedirect("Register.jsp?status=Registration Failure");
		 
	}

	

}
