<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.kws.mtrs.dao.MoviesDAO"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Rating.jsp' starting page</title>
    
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
       int mid=Integer.parseInt(request.getParameter("mid"));
       MoviesDAO moviesDAO=new MoviesDAO();
       boolean flag=moviesDAO.geveRating(mid);
       if(flag)
          response.sendRedirect("ViewAllMovies.jsp?status=Giving Rating Success");
       else
         response.sendRedirect("ViewAllMovies.jsp?status=Giving Rating Failure");
           
     %>
  </body>
</html>
