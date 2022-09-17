package com.kws.mtrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.kws.mtrs.bean.EventsBean;
import com.kws.mtrs.core.dao.AbstractDataAccessObject;

public class EventDAO extends AbstractDataAccessObject{
	Connection con=null;
	PreparedStatement ps=null;
	Statement st=null;
	public boolean postEvents(EventsBean eventsBean){
		boolean flag=false;
		try{
			con=getConnection();
			int eid=getSequenceID("events", "eventid");
			ps=con.prepareStatement("insert into events values(?,?,?)");
			ps.setInt(1,eid);
			ps.setString(2,eventsBean.getEventname());
			ps.setString(3,eventsBean.getEventdesc());
			int count=ps.executeUpdate();
			if(count>0)
				flag=true;
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return flag;
	}
	public ArrayList<EventsBean> getEvents(){
		ArrayList<EventsBean> eventsList=new ArrayList<EventsBean>();
		try{
			con=getConnection();
			st=con.createStatement();
			EventsBean eventsBean=null;
			ResultSet rs=st.executeQuery("select * from events");
			while(rs.next()){
				eventsBean=new EventsBean();
				eventsBean.setEventid(rs.getInt(1));
				eventsBean.setEventname(rs.getString(2));
				eventsBean.setEventdesc(rs.getString(3));
				eventsList.add(eventsBean);
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return eventsList;
	}
	

}
