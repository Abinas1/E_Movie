// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MoviesAction.java

package com.kws.mtrs.action;

import com.kws.mtrs.bean.MovieBean;
import com.kws.mtrs.dao.MoviesDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class MoviesAction extends HttpServlet
{

    public MoviesAction()
    {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        MovieBean movieBean = new MovieBean();
        movieBean.setMoviename(request.getParameter("mname"));
        movieBean.setImage(request.getParameter("image"));
        movieBean.setSynopsis(request.getParameter("synopsis"));
        movieBean.setReleasedate(request.getParameter("rdate"));
        movieBean.setLanguage(request.getParameter("lang"));
        movieBean.setGenre(request.getParameter("genre"));
        movieBean.setHero(request.getParameter("hero"));
        movieBean.setHeroin(request.getParameter("heroin"));
        movieBean.setVilan(request.getParameter("vilan"));
        movieBean.setLength(request.getParameter("length"));
        movieBean.setDirector(request.getParameter("director"));
        movieBean.setMusic(request.getParameter("music"));
        MoviesDAO moviesDAO = new MoviesDAO();
        boolean flag = moviesDAO.registerMovies(movieBean);
        if(flag)
            response.sendRedirect("Movies.jsp?status=Movie Registration Success");
        else
            response.sendRedirect("Movies.jsp?status=Movie Registration Failure");
    }
}
