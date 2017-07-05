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
			String sql = "insert into user_info(id, pwd, name, class_num, age)";
			sql += " values(?,?,?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, (String)hm.get("id"));
			ps.setString(2, (String)hm.get("pwd"));
			ps.setString(3, (String)hm.get("name"));
			ps.setString(4, (String)hm.get("class_num"));
			ps.setString(5, (String)hm.get("age"));
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
	
	public boolean deleteUser(HashMap hm)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con = DBConn2.getCon();
			String sql = "delete from user_info where num=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, (String)hm.get("num"));
			int result = ps.executeUpdate(sql);
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
	
	public boolean userUpdate(HashMap hm)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con = DBConn2.getCon();
			String sql = "update user_info set name=?, class_num=?, age=? where num=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, (String)hm.get("name"));
			ps.setString(2, (String)hm.get("class_num"));
			ps.setString(3, (String)hm.get("age"));
			ps.setString(4, (String)hm.get("num"));
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
	
	public List<Map> selectUser(HashMap<String, String> hm)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			String sql = "select num, id, pwd, name, age, class_num from user_info";
			if(hm.get("name") != null)
			{
				sql += " where name like ?";
			}
			con = DBConn2.getCon();
			ps = con.prepareStatement(sql);
			if(hm.get("name") != null)
			{
				ps.setString(1, hm.get("name"));
			}
			ResultSet rs = ps.executeQuery();
			List userList = new ArrayList();
			while(rs.next())
			{
				HashMap hm2 = new HashMap();
				hm2.put("num", rs.getString("num"));
				hm2.put("id", rs.getString("id"));
				hm2.put("pwd", rs.getString("pwd"));
				hm2.put("name", rs.getString("name"));
				hm2.put("age", rs.getString("age"));
				hm2.put("class_num", rs.getString("class_num"));
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
