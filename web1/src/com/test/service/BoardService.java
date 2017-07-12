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

public class BoardService 
{
	public boolean boardInsert(HashMap hm)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con = DBConn2.getCon();
			String sql = "insert into board(title, content, writer, reg_date)";
			sql += " values(?,?,?,now())";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, (String)hm.get("title"));
			ps.setString(2, (String)hm.get("content"));
			ps.setString(3, (String)hm.get("user_num"));
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
	
	public boolean boardDelete(HashMap hm)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con = DBConn2.getCon();
			String sql = "delete from board where num=?";
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

	public List<Map> boardSelect(HashMap<String, String> hm)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con = DBConn2.getCon();
			String sql = "select num, title, content, writer, reg_date from board";
			if(hm.get("title") != null)
			{
				sql += " where title like ?";
			}
			ps = con.prepareStatement(sql);
			if(hm.get("title") != null)
			{
				ps.setString(1, (String)hm.get("title"));
			}
			ResultSet rs = ps.executeQuery();
			List boardList = new ArrayList();
			while(rs.next())
			{
				HashMap hm2 = new HashMap();
				hm2.put("num", rs.getString("num"));
				hm2.put("title", rs.getString("title"));
				hm2.put("content", rs.getString("content"));
				hm2.put("writer", rs.getString("writer"));
				hm2.put("reg_date", rs.getString("reg_date"));
				boardList.add(hm2);
			}
			return boardList;
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
	
	public boolean boardUpdate(HashMap hm)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con = DBConn2.getCon();
			String sql = "update board set title=?, content=? where num=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, (String)hm.get("title"));
			ps.setString(2, (String)hm.get("content"));
			ps.setString(3, (String)hm.get("board_num"));
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
