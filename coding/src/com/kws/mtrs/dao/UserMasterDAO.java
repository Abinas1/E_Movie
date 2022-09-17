// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UserMasterDAO.java

package com.kws.mtrs.dao;

import com.kws.mtrs.bean.UserMasterBean;
import com.kws.mtrs.core.dao.AbstractDataAccessObject;
import com.kws.mtrs.core.util.DateWrapper;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class UserMasterDAO extends AbstractDataAccessObject
{

    public UserMasterDAO()
    {
        con = null;
        ps = null;
        st = null;
    }

    public boolean registerUser(UserMasterBean userMasterBean)
    {
        boolean flag = false;
        try
        {
            con = getConnection();
            int uid = getSequenceID("usermaster", "userid");
            ps = con.prepareStatement("insert into usermaster values(?,?,?,?,?,?,?,?,?,sysdate,sysdate,?,?,?,?)");
            ps.setInt(1, uid);
            ps.setString(2, userMasterBean.getUsername());
            ps.setString(3, userMasterBean.getPassword());
            ps.setString(4, userMasterBean.getLogintype());
            ps.setString(5, userMasterBean.getAddress());
            ps.setString(6, userMasterBean.getCity());
            ps.setString(7, userMasterBean.getState());
            ps.setString(8, userMasterBean.getCountry());
            ps.setString(9, userMasterBean.getPhoneno());
           // ps.setString(10, DateWrapper.parseDate(userMasterBean.getDob()));
            File f = new File(userMasterBean.getPhoto());
            FileInputStream fis = new FileInputStream(f);
            ps.setBinaryStream(10, fis, (int)f.length());
            ps.setString(11, userMasterBean.getSquestion());
            ps.setString(12, userMasterBean.getSanswer());
            ps.setString(13, userMasterBean.getStatus());
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

    public String getLogintype(UserMasterBean userMasterBean)
    {
        String lt = "";
        try
        {
            con = getConnection();
            ps = con.prepareStatement("select logintype from usermaster where username=? and password=?");
            ps.setString(1, userMasterBean.getUsername());
            ps.setString(2, userMasterBean.getPassword());
            for(ResultSet rs = ps.executeQuery(); rs.next();)
                lt = rs.getString(1);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return lt;
    }

    public int getUserid(UserMasterBean userMasterBean)
    {
        int id = 0;
        try
        {
            con = getConnection();
            ps = con.prepareStatement("select userid from usermaster where username=? and password=?");
            ps.setString(1, userMasterBean.getUsername());
            ps.setString(2, userMasterBean.getPassword());
            for(ResultSet rs = ps.executeQuery(); rs.next();)
                id = rs.getInt(1);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return id;
    }

    public boolean acceptRequest(int userid)
    {
        boolean flag = false;
        try
        {
            con = getConnection();
            st = con.createStatement();
            int count = st.executeUpdate((new StringBuilder("update usermaster set status='accepted' where userid=")).append(userid).toString());
            if(count > 0)
                flag = true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean changePassword(UserMasterBean userMasterBean)
    {
        boolean flag = false;
        try
        {
            con = getConnection();
            ps = con.prepareStatement("update usermaster set password=? where username=? and password=?");
            ps.setString(1, userMasterBean.getNewpassword());
            ps.setString(2, userMasterBean.getUsername());
            ps.setString(3, userMasterBean.getPassword());
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

    public ArrayList getCustomers()
    {
        ArrayList customerList = new ArrayList();
        try
        {
            con = getConnection();
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select userid,username from usermaster where logintype='customer'");
            UserMasterBean userMasterBean = null;
            for(; rs.next(); customerList.add(userMasterBean))
            {
                userMasterBean = new UserMasterBean();
                userMasterBean.setUserid(rs.getInt(1));
                userMasterBean.setUsername(rs.getString(2));
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return customerList;
    }

    public ArrayList getAgents()
    {
        ArrayList agentsList = new ArrayList();
        try
        {
            con = getConnection();
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select userid,username from usermaster where logintype='agent'");
            UserMasterBean userMasterBean = null;
            for(; rs.next(); agentsList.add(userMasterBean))
            {
                userMasterBean = new UserMasterBean();
                userMasterBean.setUserid(rs.getInt(1));
                userMasterBean.setUsername(rs.getString(2));
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return agentsList;
    }

    public ArrayList getUsers()
    {
        ArrayList agentsList = new ArrayList();
        try
        {
            con = getConnection();
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select userid,username from usermaster ");
            UserMasterBean userMasterBean = null;
            for(; rs.next(); agentsList.add(userMasterBean))
            {
                userMasterBean = new UserMasterBean();
                userMasterBean.setUserid(rs.getInt(1));
                userMasterBean.setUsername(rs.getString(2));
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return agentsList;
    }

    public UserMasterBean getPersonalProfile(int id, String storepath)
    {
        UserMasterBean userMasterBean = null;
        try
        {
            con = getConnection();
            st = con.createStatement();
            for(ResultSet rs = st.executeQuery((new StringBuilder("select userid,username,dob,dor,address,city,state,country,phoneno,photo,squestion,sanswer from usermaster where userid=")).append(id).toString()); rs.next(); userMasterBean.setSanswer(rs.getString(12)))
            {
                userMasterBean = new UserMasterBean();
                userMasterBean.setUserid(rs.getInt(1));
                userMasterBean.setUsername(rs.getString(2));
                userMasterBean.setDob(DateWrapper.parseDate(rs.getDate(3)));
                userMasterBean.setDor(DateWrapper.parseDate(rs.getDate(4)));
                userMasterBean.setAddress(rs.getString(5));
                userMasterBean.setCity(rs.getString(6));
                userMasterBean.setState(rs.getString(7));
                userMasterBean.setCountry(rs.getString(8));
                userMasterBean.setPhoneno(rs.getString(9));
                Blob b = rs.getBlob(10);
                byte b1[] = b.getBytes(1L, (int)b.length());
                OutputStream fout = new FileOutputStream((new StringBuilder(String.valueOf(storepath))).append("/").append(id).append(".gif").toString());
                fout.write(b1);
                userMasterBean.setPhoto((new StringBuilder(String.valueOf(id))).append(".gif").toString());
                userMasterBean.setSquestion(rs.getString(11));
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return userMasterBean;
    }

    public ArrayList getAgents(String storepath)
    {
        ArrayList userList = new ArrayList();
        try
        {
            con = getConnection();
            st = con.createStatement();
            UserMasterBean userMasterBean = null;
            for(ResultSet rs = st.executeQuery("select userid,username,dob,dor,address,city,state,country,phoneno,photo,squestion,sanswer from usermaster where logintype='agent'"); rs.next();)
            {
                int id = 1;
                userMasterBean = new UserMasterBean();
                userMasterBean.setUserid(rs.getInt(1));
                userMasterBean.setUsername(rs.getString(2));
                userMasterBean.setDob(DateWrapper.parseDate(rs.getDate(3)));
                userMasterBean.setDor(DateWrapper.parseDate(rs.getDate(4)));
                userMasterBean.setAddress(rs.getString(5));
                userMasterBean.setCity(rs.getString(6));
                userMasterBean.setState(rs.getString(7));
                userMasterBean.setCountry(rs.getString(8));
                userMasterBean.setPhoneno(rs.getString(9));
                Blob b = rs.getBlob(10);
                byte b1[] = b.getBytes(1L, (int)b.length());
                OutputStream fout = new FileOutputStream((new StringBuilder(String.valueOf(storepath))).append("/").append(id).append(".gif").toString());
                fout.write(b1);
                userMasterBean.setPhoto((new StringBuilder(String.valueOf(id))).append(".gif").toString());
                userMasterBean.setSquestion(rs.getString(11));
                userMasterBean.setSanswer(rs.getString(12));
                userList.add(userMasterBean);
                id++;
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return userList;
    }

    public ArrayList getCustomers(String storepath)
    {
        ArrayList userList = new ArrayList();
        try
        {
            con = getConnection();
            st = con.createStatement();
            UserMasterBean userMasterBean = null;
            for(ResultSet rs = st.executeQuery("select userid,username,dob,dor,address,city,state,country,phoneno,photo,squestion,sanswer from usermaster where logintype='customer'"); rs.next();)
            {
                int id = 1;
                userMasterBean = new UserMasterBean();
                userMasterBean.setUserid(rs.getInt(1));
                userMasterBean.setUsername(rs.getString(2));
                userMasterBean.setDob(DateWrapper.parseDate(rs.getDate(3)));
                userMasterBean.setDor(DateWrapper.parseDate(rs.getDate(4)));
                userMasterBean.setAddress(rs.getString(5));
                userMasterBean.setCity(rs.getString(6));
                userMasterBean.setState(rs.getString(7));
                userMasterBean.setCountry(rs.getString(8));
                userMasterBean.setPhoneno(rs.getString(9));
                Blob b = rs.getBlob(10);
                byte b1[] = b.getBytes(1L, (int)b.length());
                OutputStream fout = new FileOutputStream((new StringBuilder(String.valueOf(storepath))).append("/").append(id).append(".gif").toString());
                fout.write(b1);
                userMasterBean.setPhoto((new StringBuilder(String.valueOf(id))).append(".gif").toString());
                userMasterBean.setSquestion(rs.getString(11));
                userMasterBean.setSanswer(rs.getString(12));
                userList.add(userMasterBean);
                id++;
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return userList;
    }

    public ArrayList viewCustomerRequests(String storepath)
    {
        ArrayList customerList = new ArrayList();
        try
        {
            con = getConnection();
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select userid,username,address,city,photo,phoneno,status from usermaster where status='pending'");
            UserMasterBean userMasterBean = null;
            for(; rs.next(); customerList.add(userMasterBean))
            {
                int id = rs.getInt(1);
                userMasterBean = new UserMasterBean();
                userMasterBean.setUserid(id);
                userMasterBean.setUsername(rs.getString(2));
                userMasterBean.setAddress(rs.getString(3));
                userMasterBean.setCity(rs.getString(4));
                Blob b = rs.getBlob(5);
                byte b1[] = b.getBytes(1L, (int)b.length());
                OutputStream fout = new FileOutputStream((new StringBuilder(String.valueOf(storepath))).append("/").append(id).append(".gif").toString());
                fout.write(b1);
                userMasterBean.setPhoto((new StringBuilder(String.valueOf(id))).append(".gif").toString());
                userMasterBean.setPhoneno(rs.getString(6));
                userMasterBean.setStatus(rs.getString(7));
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return customerList;
    }

    public String retrievePassword(UserMasterBean userMasterBean)
    {
        String password = "";
        try
        {
            con = getConnection();
            ps = con.prepareStatement("select password from usermaster where username=? and squestion=? and sanswer=?");
            ps.setString(1, userMasterBean.getUsername());
            ps.setString(2, userMasterBean.getSquestion());
            ps.setString(3, userMasterBean.getSanswer());
            for(ResultSet rs = ps.executeQuery(); rs.next();)
                password = rs.getString(1);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return password;
    }

    Connection con;
    PreparedStatement ps;
    Statement st;
}
