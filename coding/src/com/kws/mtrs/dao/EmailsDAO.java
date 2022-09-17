package com.kws.mtrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.kws.mtrs.bean.EmailBean;
import com.kws.mtrs.core.dao.AbstractDataAccessObject;
import com.kws.mtrs.core.util.DateWrapper;

public class EmailsDAO extends AbstractDataAccessObject{
	Connection con=null;
	PreparedStatement ps=null;
	PreparedStatement ps1=null;
	Statement st=null;
	ResultSet rs1=null;
	public boolean sendEmail(EmailBean emailBean){
		
		String sendername=emailBean.getSendername();
		int senderid=0;
		
		
		boolean flag=false;
		try{
			con=getConnection();
			
			ps1=con.prepareStatement("select USERID from USERMASTER where USERNAME=?");
			ps1.setString(1,sendername);
			rs1=ps1.executeQuery();
			while(rs1.next())
			{
				senderid=rs1.getInt(1);
			}
			
			int eid=getSequenceID("emails", "emailid");
			ps=con.prepareStatement("insert into emails values(?,?,?,sysdate,?,?)");
			ps.setInt(1,eid);
			ps.setInt(2,senderid);
			ps.setInt(3,emailBean.getReceiverid());
			//ps.setString(4,DateWrapper.parseDate(emailBean.getSenddate()));
			ps.setString(4,emailBean.getSubject());
			ps.setString(5,emailBean.getMaildesc());
			int count=ps.executeUpdate();
			if(count>0)
				 flag=true;
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return flag;
	}
	public ArrayList<EmailBean> viewEmails(int rid){
		ArrayList<EmailBean> mailsList=new ArrayList<EmailBean>();
		try{
			con=getConnection();
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select e.emailid,e.senderid,e.receiverid,e.senddate,e.subject,e.maildesc,u.username from emails e,usermaster u where e.senderid=u.userid and e.receiverid="+rid);
			EmailBean emailBean=null;
			while(rs.next()){
				emailBean=new EmailBean();
				emailBean.setEmailid(rs.getInt(1));
				emailBean.setSenderid(rs.getInt(2));
				emailBean.setReceiverid(rs.getInt(3));
				emailBean.setSenddate(DateWrapper.parseDate(rs.getDate(4)));
				emailBean.setSubject(rs.getString(5));
				emailBean.setMaildesc(rs.getString(6));
				emailBean.setSendername(rs.getString(7));
				mailsList.add(emailBean);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return mailsList;
	}

}
