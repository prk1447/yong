package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.common.DBConn2;

public class UserService 
{
	public boolean insertUser(HashMap hm)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con = DBConn2.getCon();
			String sql = "insert into user_info(userid, userpwd, username, age, address, hp1, hp2, hp3)";
			sql += " values(?,?,?,?,?,?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, (String)hm.get("id"));
			ps.setString(2, (String)hm.get("pwd"));
			ps.setString(3, (String)hm.get("name"));
			ps.setString(4, (String)hm.get("age"));
			ps.setString(5, (String)hm.get("address"));
			ps.setString(6, (String)hm.get("hp1"));
			ps.setString(7, (String)hm.get("hp2"));
			ps.setString(8, (String)hm.get("hp3"));
			int result = ps.executeUpdate();
			if(result == 1)
			{
				con.commit();
				return true;
			}
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				con.rollback();
				ps.close();
				DBConn2.closeCon();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean loginUser(HashMap hm)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con = DBConn2.getCon();
			String sql = "select * from user_info";
			sql += " where userid=? and userpwd=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, (String)hm.get("userid"));
			ps.setString(2, (String)hm.get("userpwd"));
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				return true;
			}
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean deleteUser(HashMap hm)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con = DBConn2.getCon();
			String sql = "delete from user_info where usernum=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, (String)hm.get("usernum"));
			int result = ps.executeUpdate();
			if(result > 0)
			{
				con.commit();
				return true;
			}
		}
		catch(ClassNotFoundException e)
		{		
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				con.rollback();
				ps.close();
				DBConn2.closeCon();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return false;
	}

	public List<Map> selectUser(HashMap<String, String> hm)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			String sql = "select usernum, userid, userpwd, username, age, address, hp1, hp2, hp3 from user_info";
			if(hm.get("username") != null)
			{
				sql += " where username like ?";
			}
			con = DBConn2.getCon();
			ps = con.prepareStatement(sql);
			if(hm.get("username") != null)
			{
				ps.setString(1, hm.get("username"));
			}
			ResultSet rs = ps.executeQuery();
			List userList = new ArrayList();
			while(rs.next())
			{
				HashMap hm2 = new HashMap();
				hm2.put("usernum", rs.getString("usernum"));
				hm2.put("userid", rs.getString("userid"));
				hm2.put("userpwd", rs.getString("userpwd"));
				hm2.put("username", rs.getString("username"));
				hm2.put("age", rs.getString("age"));
				hm2.put("address", rs.getString("address"));
				hm2.put("hp1", rs.getString("hp1"));
				hm2.put("hp2", rs.getString("hp2"));
				hm2.put("hp3", rs.getString("hp3"));
				userList.add(hm2);
			}
			return userList;
		}
		catch(ClassNotFoundException e)
		{		
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
