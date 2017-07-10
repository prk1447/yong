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

public class CommentService 
{
	public boolean commentInsert(HashMap hm)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con = DBConn2.getCon();
			String sql = "insert into comment_info(content, ui_num, b_num, reg_date)";
			sql += " values(?,?,?,now())";
			ps = con.prepareStatement(sql);
			ps.setString(1, (String)hm.get("content"));
			ps.setString(2, (String)hm.get("ui_num"));
			ps.setString(3, (String)hm.get("b_num"));
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
		return false;
	}
	
	public boolean commentDelete(HashMap hm)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con = DBConn2.getCon();
			String sql = "delete from comment_info where num=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, (String)hm.get("num"));
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
		return false;
	}
	
	public List<Map> commentSelect(HashMap<String, String> hm)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con = DBConn2.getCon();
			String sql = "select num, content, ui_num, b_num, reg_date from comment_info";
			if(hm.get("content") != null)
			{
				sql += " where content like ?";
			}
			ps = con.prepareStatement(sql);
			if(hm.get("content") != null)
			{
				ps.setString(1, hm.get("content"));
			}
			ResultSet rs = ps.executeQuery();
			List commentList = new ArrayList();
			while(rs.next())
			{
				HashMap hm2 = new HashMap();
				hm2.put("num", rs.getString("num"));
				hm2.put("content", rs.getString("content"));
				hm2.put("ui_num", rs.getString("ui_num"));
				hm2.put("b_num", rs.getString("b_num"));
				hm2.put("reg_date", rs.getString("reg_date"));
				commentList.add(hm2);
			}
			return commentList;
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
	
	public boolean commentUpdate(HashMap hm)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con = DBConn2.getCon();
			String sql = "update comment_info set content=? where num=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, (String)hm.get("content"));
			ps.setString(2, (String)hm.get("num"));
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
		return false;
	}
}
