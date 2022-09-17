package com.kws.mtrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kws.mtrs.bean.TheatreBean;
import com.kws.mtrs.core.dao.AbstractDataAccessObject;

public class BookingDAO extends AbstractDataAccessObject{
	Connection con=null;
	PreparedStatement ps=null;
	Statement st=null;
	public boolean bookMovieTicket(TheatreBean theatreBean){
		boolean flag=false;
		try{
			con=getConnection();
			int bid=getSequenceID("booking","bookingid");
			ps=con.prepareStatement("insert into booking values(?,?,?,?,?,?)");
			ps.setInt(1,bid);
			ps.setInt(2,theatreBean.getUserid());
			ps.setString(3,theatreBean.getUsertype());
			ps.setInt(4,theatreBean.getTheatremovieid());
			ps.setInt(5,theatreBean.getNooftickets());
			ps.setString(6,"pending");
			int count=ps.executeUpdate();
			if(count>0)
				 flag=true;
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return flag;
	}
   public ArrayList<TheatreBean> viewBookingTickets(){
	   ArrayList<TheatreBean> bookingTicketsList=new ArrayList<TheatreBean>();
	   try{
		   con=getConnection();
		   st=con.createStatement();
		   ResultSet rs=st.executeQuery("select b.bookingid,b.userid,b.usertype,b.theatremoviesid,b.noofseats,b.status,u.username,m.moviename,t.name,td.timings from booking b,usermaster u,theatredetails td,theatres t,movie m where b.userid=u.userid and b.theatremoviesid=td.theatremovieid and td.theatreid=t.theatreid and td.movieid=m.movieid");
		   TheatreBean theatreBean=null;
		   while(rs.next()){
			   theatreBean=new TheatreBean();
			   theatreBean.setBookingid(rs.getInt(1));
			   theatreBean.setUserid(rs.getInt(2));
			   theatreBean.setUsertype(rs.getString(3));
			   theatreBean.setTheatremovieid(rs.getInt(4));
			   theatreBean.setNooftickets(rs.getInt(5));
			   theatreBean.setStatus(rs.getString(6));
			   theatreBean.setUsername(rs.getString(7));
			   theatreBean.setMoviename(rs.getString(8));
			   theatreBean.setTheatrename(rs.getString(9));
			   theatreBean.setTimings(rs.getString(10));
			   bookingTicketsList.add(theatreBean);
		   }
		   
	   }catch (Exception e) {
		   e.printStackTrace();
		// TODO: handle exception
	}
	   return bookingTicketsList;
   }
   public boolean acceptMovieRequest(int bid){
	   boolean flag=false;
	   try{
		   con=getConnection();
		   st=con.createStatement();
		   int count=st.executeUpdate("update booking set status='accept' where bookingid="+bid);
		   if(count>0)
			    flag=true;
	   }catch (Exception e) {
		   e.printStackTrace();
		// TODO: handle exception
	}
	   return flag;
   }
   public boolean rejectMovieRequest(int bid){
	   boolean flag=false;
	   try{
		   con=getConnection();
		   st=con.createStatement();
		   int count=st.executeUpdate("update booking set status='reject' where bookingid="+bid);
		   if(count>0)
			    flag=true;
	   }catch (Exception e) {
		   e.printStackTrace();
		// TODO: handle exception
	}
	   return flag;
   }
   public ArrayList<TheatreBean> viewBookingTicketsbyUser(int userid){
	   ArrayList<TheatreBean> bookingTicketsList=new ArrayList<TheatreBean>();
	   try{
		   con=getConnection();
		   st=con.createStatement();
		   ResultSet rs=st.executeQuery("select b.bookingid,b.userid,b.usertype,b.theatremoviesid,b.noofseats,b.status,u.username,m.moviename,t.name,td.timings from booking b,usermaster u,theatredetails td,theatres t,movie m where b.userid=u.userid and b.theatremoviesid=td.theatremovieid and td.theatreid=t.theatreid and td.movieid=m.movieid and b.userid="+userid);
		   TheatreBean theatreBean=null;
		   while(rs.next()){
			   theatreBean=new TheatreBean();
			   theatreBean.setBookingid(rs.getInt(1));
			   theatreBean.setUserid(rs.getInt(2));
			   theatreBean.setUsertype(rs.getString(3));
			   theatreBean.setTheatremovieid(rs.getInt(4));
			   theatreBean.setNooftickets(rs.getInt(5));
			   theatreBean.setStatus(rs.getString(6));
			   theatreBean.setUsername(rs.getString(7));
			   theatreBean.setMoviename(rs.getString(8));
			   theatreBean.setTheatrename(rs.getString(9));
			   theatreBean.setTimings(rs.getString(10));
			   bookingTicketsList.add(theatreBean);
		   }
		   
	   }catch (Exception e) {
		   e.printStackTrace();
		// TODO: handle exception
	}
	   return bookingTicketsList;
   }
   
   public Integer getAvailSeatInfo(int thetMovieId){
	   
	   
	   con =getConnection();
	   Integer seatsLeft = 0;
	   try {
		st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT TICKETSLEFT FROM THEATREDETAILS WHERE THEATREMOVIEID="+thetMovieId);
		if(rs.next()){
			seatsLeft = rs.getInt(1);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return seatsLeft;
	   
   }
   
}
