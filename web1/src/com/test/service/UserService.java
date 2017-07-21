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
import com.test.dto.UserInfo;

public class UserService 
{
	public boolean insertUser(UserInfo ui)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con = DBConn2.getCon();
			String sql = "insert into user_info(userid, userpwd, username, age, address, hp1, hp2, hp3)";
			sql += " values(?,?,?,?,?,?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, ui.getuserId());
			ps.setString(2, ui.getUserPwd());
			ps.setString(3, ui.getUserName());
			ps.setInt(4, ui.getAge());
			ps.setString(5, ui.getAddress());
			ps.setString(6, ui.getHp1());
			ps.setString(7, ui.getHp2());
			ps.setString(8, ui.getHp3());
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
	
	public boolean loginUser(UserInfo ui)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con = DBConn2.getCon();
			String sql = "select * from user_info";
			sql += " where userid=? and userpwd=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ui.getuserId());
			ps.setString(2, ui.getUserPwd());
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
	
	public boolean deleteUser(UserInfo ui)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con = DBConn2.getCon();
			String sql = "delete from user_info where usernum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, ui.getUserNum());
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

	public List<UserInfo> selectUser(UserInfo ui)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			String sql = "select usernum, userid, userpwd, username, age, address, hp1, hp2, hp3 from user_info";
			if(ui.getUserName() != null)
			{
				sql += " where username like ?";
			}
			con = DBConn2.getCon();
			ps = con.prepareStatement(sql);
			if(ui.getUserName() != null)
			{
				ps.setString(1, ui.getUserName());
			}
			ResultSet rs = ps.executeQuery();
			List userList = new ArrayList();
			while(rs.next())
			{
				UserInfo ui2 = new UserInfo();
				ui2.setUserNum(rs.getInt("usernum"));
				ui2.setuserId(rs.getString("userid"));
				ui2.setUserPwd(rs.getString("userpwd"));
				ui2.setUserName(rs.getString("username"));
				ui2.setAge(rs.getInt("age"));
				ui2.setAddress(rs.getString("address"));
				ui2.setHp1(rs.getString("hp1"));
				ui2.setHp2(rs.getString("hp2"));
				ui2.setHp3(rs.getString("hp3"));
				userList.add(ui2);
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

	public boolean updateUser(UserInfo ui)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con = DBConn2.getCon();
			String sql = "update user_info where set";
			sql += " userid=?, username=?, age=? where usernum=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ui.getuserId());
			ps.setString(2, ui.getUserName());
			ps.setInt(3, ui.getAge());
			ps.setInt(4, ui.getUserNum());
			int result = ps.executeUpdate();
			if(result == 1)
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
}
