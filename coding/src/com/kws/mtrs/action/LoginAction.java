package com.kws.mtrs.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kws.mtrs.bean.UserMasterBean;
import com.kws.mtrs.dao.UserMasterDAO;

public class LoginAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          UserMasterBean userMasterBean=new UserMasterBean();
          String username=request.getParameter("uname");
          userMasterBean.setUsername(username);
          userMasterBean.setPassword(request.getParameter("password"));
          UserMasterDAO userMasterDAO=new UserMasterDAO();
          String logintype=userMasterDAO.getLogintype(userMasterBean);
          System.out.println(userMasterBean.getUsername());
          System.out.println(userMasterBean.getPassword());
          int userid=userMasterDAO.getUserid(userMasterBean);
          System.out.println(userid);
          System.out.println(logintype);
          HttpSession session=request.getSession();
          if(logintype.equals("admin")){
        	 session.setAttribute("username", username);
        	 session.setAttribute("logintype", logintype);
        	 session.setAttribute("userid",userid);
        	 response.sendRedirect("AdminHome.jsp");
          }else if(logintype.equals("agent")){
        	 session.setAttribute("username", username);
        	 session.setAttribute("logintype", logintype);
        	 session.setAttribute("userid",userid);
        	 response.sendRedirect("AgentHome.jsp");
          }else if(logintype.equals("customer")){
        	 session.setAttribute("username", username);
        	 session.setAttribute("logintype", logintype);
        	 session.setAttribute("userid",userid);
        	 response.sendRedirect("CustomerHome.jsp");
          }else 
        	 response.sendRedirect("LoginForm.jsp?status=invalid user name and password, Loggin Again");
		
	}

}
