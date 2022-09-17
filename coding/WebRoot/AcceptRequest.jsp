<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.kws.mtrs.dao.UserMasterDAO"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AcceptRequest.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <%
       String status=request.getParameter("status");
       if(status.equals("pending")){
          int id=Integer.parseInt(request.getParameter("userid"));
          UserMasterDAO userMasterDAO=new UserMasterDAO();
          boolean flag=userMasterDAO.acceptRequest(id);
          if(flag)
             response.sendRedirect("ViewCustomerRequests.jsp?status=Proceessing Customer request Success");
          else
             response.sendRedirect("ViewCustomerRequests.jsp?status=Processing Customer Request Failure");
       }
        else
          response.sendRedirect("ViewCustomerRequests.jsp?status=Processing request Completed");
    %>
  </body>
</html>
