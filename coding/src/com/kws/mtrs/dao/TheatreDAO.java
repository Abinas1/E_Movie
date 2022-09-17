package com.kws.mtrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.kws.mtrs.bean.TheatreBean;
import com.kws.mtrs.core.dao.AbstractDataAccessObject;

public class TheatreDAO extends AbstractDataAccessObject{
	Connection con=null;
	PreparedStatement ps=null;
	Statement st=null;
	public boolean registerTheatres(TheatreBean theatreBean){
		boolean flag=false;
		try{
			con=getConnection();
			int tid=getSequenceID("theatres", "theatreid");
			ps=con.prepareStatement("insert into theatres values(?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1,tid);
			ps.setString(2,theatreBean.getTheatrename());
			ps.setString(3,theatreBean.getCity());
			ps.setString(4,theatreBean.getState());
			ps.setString(5,theatreBean.getCountry());
			ps.setString(6,theatreBean.getPin());
			ps.setString(7,theatreBean.getPhone());
			ps.setString(8,theatreBean.getEmail());
			ps.setString(9,theatreBean.getNoofshows());
			ps.setInt(10,theatreBean.getNoofseats());
			int count=ps.executeUpdate();
			if(count>0)
				  flag=true;
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return flag;
	}
	public ArrayList<TheatreBean> theatresList(){
		ArrayList<TheatreBean> theatresList=new ArrayList<TheatreBean>();
		try{
			con=getConnection();
			st=con.createStatement();
			TheatreBean theatreBean=null;
			ResultSet rs=st.executeQuery("select * from theatres");
			while(rs.next()){
				theatreBean=new TheatreBean();
				theatreBean.setTheatreid(rs.getInt(1));
				theatreBean.setTheatrename(rs.getString(2));
				theatreBean.setCity(rs.getString(3));
				theatreBean.setState(rs.getString(4));
				theatreBean.setCountry(rs.getString(5));
				theatreBean.setPin(rs.getString(6));
				theatreBean.setPhone(rs.getString(7));
				theatreBean.setEmail(rs.getString(8));
				theatreBean.setNoofshows(rs.getString(9));
				theatreBean.setNoofseats(rs.getInt(10));
				theatresList.add(theatreBean);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return theatresList;
	}
	public boolean movieTheatres(TheatreBean theatreBean){
		boolean flag=false;
		try{
			con=getConnection();
			int mtid=getSequenceID("theatredetails", "theatremovieid");
			ps=con.prepareStatement("insert into theatredetails values(?,?,?,?,?,(SELECT NOOFSEATS FROM THEATRES WHERE THEATREID=?))");
			ps.setInt(1,theatreBean.getTheatreid());
			ps.setInt(2,theatreBean.getMovieid());
			ps.setString(3,theatreBean.getTimings());
			ps.setString(4,theatreBean.getTicketprice());
			ps.setInt(5,mtid);
			ps.setInt(6,theatreBean.getTheatreid());
			int count=ps.executeUpdate();
			if(count>0)
				 flag=true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
   public int getnoShows(int tid){
	   int showscount=0;
	   try{
		   con=getConnection();
		   st=con.createStatement();
		   ResultSet rs=st.executeQuery("select count(THEATREMOVIEID) from theatredetails where theatreid="+tid);
		   while(rs.next()){
			   showscount=rs.getInt(1);
		   }
	   }catch (Exception e) {
		   e.printStackTrace();
		// TODO: handle exception
	}
	   return showscount;
   }
   
   public ArrayList<TheatreBean> getTheatres(){
	   ArrayList<TheatreBean> tlist=new ArrayList<TheatreBean>();
	   try{
		   con=getConnection();
		   st=con.createStatement();
		   ResultSet rs=st.executeQuery("select THEATREID,NAME from THEATRES");
		   
		   while (rs.next()){
			TheatreBean tbeBean=new TheatreBean();
			tbeBean.setTheatreid(rs.getInt(1));
			tbeBean.setTheatrename(rs.getString(2));
			tlist.add(tbeBean);
		   }
	   }catch (Exception e) {
		e.printStackTrace();
	}
	   return tlist;
   }
   
   public String getTheatreName(String tid){
	   String tname=null;
	   try{
		   con=getConnection();
		   PreparedStatement pst=con.prepareStatement("select NAME from THEATRES where THEATREID=?");
           pst.setInt(1, Integer.parseInt(tid));
           ResultSet rs=pst.executeQuery();
           if(rs.next()){
        	   tname=rs.getString(1);
           }
	   }catch (Exception e) {
		e.printStackTrace();
	}
	   return tname;
   }
   
}
