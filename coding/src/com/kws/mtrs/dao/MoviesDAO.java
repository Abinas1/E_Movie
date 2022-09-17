// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MoviesDAO.java

package com.kws.mtrs.dao;

import com.kws.mtrs.bean.MovieBean;
import com.kws.mtrs.core.dao.AbstractDataAccessObject;
import com.kws.mtrs.core.util.DateWrapper;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class MoviesDAO extends AbstractDataAccessObject
{

    public MoviesDAO()
    {
        con = null;
        ps = null;
        st = null;
    }

    public boolean registerMovies(MovieBean movieBean)
    {
        boolean flag = false;
        try
        {
            con = getConnection();
            int mid = getSequenceID("movie", "movieid");
            ps = con.prepareStatement("insert into MOVIE values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            System.out.println("insert into MOVIE values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, mid);
            ps.setString(2, movieBean.getMoviename());
            File f = new File(movieBean.getImage());
            FileInputStream fis = new FileInputStream(f);
            ps.setBinaryStream(3, fis, (int)f.length());
            ps.setString(4, movieBean.getSynopsis());
            ps.setString(5, DateWrapper.parseDate(movieBean.getReleasedate()));
            ps.setString(6, movieBean.getLanguage());
            ps.setString(7, movieBean.getGenre());
            ps.setString(8, movieBean.getHero());
            ps.setString(9, movieBean.getHeroin());
            ps.setString(10, movieBean.getVilan());
            ps.setString(11, movieBean.getLength());
            ps.setString(12, movieBean.getDirector());
            ps.setString(13, movieBean.getMusic());
            System.out.println(movieBean.getMusic());
            ps.setInt(14, 0);
            int count = ps.executeUpdate();
            if(count > 0)
                flag = true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public ArrayList getMoviesInfo(String storepath)
    {
        ArrayList movieList = new ArrayList();
        try
        {
            con = getConnection();
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from movie");
            MovieBean movieBean = null;
            for(; rs.next(); movieList.add(movieBean))
            {
                movieBean = new MovieBean();
                int mid = rs.getInt(1);
                movieBean.setMovieid(mid);
                movieBean.setMoviename(rs.getString(2));
                Blob b = rs.getBlob(3);
                byte b1[] = b.getBytes(1L, (int)b.length());
                OutputStream fout = new FileOutputStream((new StringBuilder(String.valueOf(storepath))).append("/").append(mid).append("m.gif").toString());
                fout.write(b1);
                movieBean.setImage((new StringBuilder(String.valueOf(mid))).append("m.gif").toString());
                movieBean.setSynopsis(rs.getString(4));
                movieBean.setReleasedate(DateWrapper.parseDate(rs.getDate(5)));
                movieBean.setLanguage(rs.getString(6));
                movieBean.setGenre(rs.getString(7));
                movieBean.setHero(rs.getString(8));
                movieBean.setHeroin(rs.getString(9));
                movieBean.setVilan(rs.getString(10));
                movieBean.setLength(rs.getString(11));
                movieBean.setDirector(rs.getString(12));
                movieBean.setMusic(rs.getString(13));
                movieBean.setRating(rs.getInt(14));
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return movieList;
    }

    public ArrayList<MovieBean> getMovies()
    {
        ArrayList<MovieBean> movieList = new ArrayList<MovieBean>();
        try
        {
            con = getConnection();
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select movieid,moviename from movie");
            MovieBean movieBean = null;
            while(rs.next())
            {
                movieBean = new MovieBean();
                int mid = rs.getInt(1);
                System.out.println(mid);
                movieBean.setMovieid(mid);
                movieBean.setMoviename(rs.getString(2));
                movieList.add(movieBean);
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return movieList;
    }

    public boolean geveRating(int mid)
    {
        boolean flag = false;
        try
        {
            con = getConnection();
            st = con.createStatement();
            int count = st.executeUpdate((new StringBuilder("update movie set rating=(select nvl(max(rating),0)+1 from movie where movieid=")).append(mid).append(") where movieid=").append(mid).toString());
            if(count > 0)
                flag = true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public ArrayList moviesByTheatres(int tid, String storepath)
    {
        ArrayList moviesList = new ArrayList();
        try
        {
            con = getConnection();
            st = con.createStatement();
            ResultSet rs = st.executeQuery((new StringBuilder("select m.moviename,m.image,m.releasedate,m.hero,m.heroin,td.timings,td.ticketprice,td.theatreid,td.movieid,td.theatremovieid,t.name from movie m,theatredetails td,theatres t where td.movieid=m.movieid and td.theatreid=t.theatreid and td.theatreid=")).append(tid).toString());
            MovieBean movieBean = null;
            for(int id = 1; rs.next(); id++)
            {
                movieBean = new MovieBean();
                movieBean.setMoviename(rs.getString(1));
                Blob b = rs.getBlob(2);
                byte b1[] = b.getBytes(1L, (int)b.length());
                OutputStream fout = new FileOutputStream((new StringBuilder(String.valueOf(storepath))).append("/").append(id).append("mt.gif").toString());
                fout.write(b1);
                movieBean.setImage((new StringBuilder(String.valueOf(id))).append("mt.gif").toString());
                movieBean.setReleasedate(DateWrapper.parseDate(rs.getDate(3)));
                movieBean.setHero(rs.getString(4));
                movieBean.setHeroin(rs.getString(5));
                movieBean.setTimings(rs.getString(6));
                movieBean.setTicketprice(rs.getString(7));
                movieBean.setTheatreid(rs.getInt(8));
                movieBean.setMovieid(rs.getInt(9));
                movieBean.setTheatremovieid(rs.getInt(10));
                movieBean.setTheatrename(rs.getString(11));
                moviesList.add(movieBean);
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return moviesList;
    }

    Connection con;
    PreparedStatement ps;
    Statement st;
}
