package com.kws.mtrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.kws.mtrs.bean.NewsBean;
import com.kws.mtrs.core.dao.AbstractDataAccessObject;
import com.kws.mtrs.core.util.DateWrapper;

public class NewsDAO extends AbstractDataAccessObject{ 
	Connection con=null;
	PreparedStatement ps=null;
	Statement st=null;
	public boolean registerNews(NewsBean newsBean){
		boolean flag=false;
		try{
			con=getConnection();
			int id=getSequenceID("news","newsid");
			ps=con.prepareStatement("insert into news values(?,?,?,sysdate)");
			ps.setInt(1,id);
			ps.setString(2,newsBean.getNewsheading());
			ps.setString(3,newsBean.getNewsdetails());
			int count=ps.executeUpdate();
			if(count>0)
				 flag=true;
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return flag;
	}
   public ArrayList<NewsBean> getNews(){
	   ArrayList<NewsBean> newsList=new ArrayList<NewsBean>();
	   try{
		   con=getConnection();
		   st=con.createStatement();
		   NewsBean newsBean=null;
		   ResultSet rs=st.executeQuery("select * from news");
		   while(rs.next()){
			    newsBean=new NewsBean();
			    newsBean.setNewsid(rs.getInt(1));
			    newsBean.setNewsheading(rs.getString(2));
			    newsBean.setNewsdetails(rs.getString(3));
			    newsBean.setNewsPostedDate(DateWrapper.parseDate(rs.getDate(4)));
			    newsList.add(newsBean);
		   }
	   }catch (Exception e) {
		   e.printStackTrace();
		// TODO: handle exception
	}
	   return newsList;
   }
}
