package com.kws.mtrs.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kws.mtrs.bean.EmailBean;
import com.kws.mtrs.dao.EmailsDAO;

public class EmailAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		doPost(request,response);
		
	}

	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		String target = "";
		EmailBean email=new EmailBean();
		int userid=Integer.parseInt(request.getParameter("receiverid"));
		String sub=request.getParameter("subject");
		String desc=request.getParameter("maildesc");
		
		email.setReceiverid(userid);
		email.setSubject(sub);
		email.setMaildesc(desc);
		email.setSendername(username);
		EmailsDAO edao=new EmailsDAO();
		
		boolean flag=edao.sendEmail(email);
		
		if(flag)
       	 response.sendRedirect("Emails.jsp?status=Mail sended Success");
        else
       	response.sendRedirect("Emails.jsp?status=Mail send Failure");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
