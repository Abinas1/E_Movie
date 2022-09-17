package com.kws.mtrs.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kws.mtrs.bean.UserMasterBean;
import com.kws.mtrs.dao.UserMasterDAO;

public class ForgotPasswordAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         UserMasterBean userMasterBean=new UserMasterBean();
         userMasterBean.setUsername(request.getParameter("uname"));
         userMasterBean.setSquestion(request.getParameter("squestion"));
         userMasterBean.setSanswer(request.getParameter("sanswer"));
         UserMasterDAO userMasterDAO=new UserMasterDAO();
         String password=userMasterDAO.retrievePassword(userMasterBean);
         if(password.length()!=0){
        	 response.sendRedirect("ForgotPassword.jsp?status=ur password is "+password);
         }else
        	 response.sendRedirect("ForgotPassword.jsp?status=sorry! ur password not found, try again");
		
	}

}
