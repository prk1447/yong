package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.test.common.DBConn2;
import com.test.dto.BoardInfo;

public class BoardService 
{
	public boolean boardInsert(BoardInfo bi)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con = DBConn2.getCon();
			String sql = "insert into board_info(bititle, bicontent, bipwd, creusr, credat)";
			sql += " values(?,?,?,?,now())";
			ps = con.prepareStatement(sql);
			ps.setString(1, bi.getBiTitle());
			ps.setString(2, bi.getBiContent());
			ps.setString(3, bi.getBiPwd());
			ps.setString(4, bi.getCreusr());
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
	
	public boolean boardDelete(BoardInfo bi)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con = DBConn2.getCon();
			String sql = "delete from board_info where binum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, bi.getBiNum());
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

	public List<BoardInfo> boardSelect(BoardInfo bi)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con = DBConn2.getCon();
			String sql = "select  from board_info";
			if(bi.getBiTitle() != null)
			{
				sql += " where bititle like ?";
			}
			ps = con.prepareStatement(sql);
			if(bi.getBiTitle() != null)
			{
				ps.setString(1, bi.getBiTitle());
			}
			ResultSet rs = ps.executeQuery();
			List boardList = new ArrayList();
			while(rs.next())
			{
				BoardInfo bi2 = new BoardInfo();
				bi2.setBiNum(rs.getInt("binum"));
				bi2.setBiTitle(rs.getString("bititle"));
				bi2.setBiContent(rs.getString("bicontent"));
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
			String sql = "update board_info set bititle=?, bicontent=? where num=?";
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
