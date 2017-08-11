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
import com.test.dto.Goods;
import com.test.dto.Page;

public class GoodsService 
{
	public List<Goods> selectGoods(Goods pGoods)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			String sql = "select gi.ginum, gi.giname, gi.gidesc, vi.vinum, vi.viname";
			sql += " from goods_info as gi, vendor_info as vi";
			sql += " where gi.vinum=vi.vinum";
			sql += " order by gi.ginum";
			sql += " limit ?,?";
			Page page = pGoods.getPage();
			con = DBConn2.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, page.getStartRow());
			ps.setInt(2, page.getRowCnt());
			ResultSet rs = ps.executeQuery();
			List<Goods> goodsList = new ArrayList<Goods>();
			while(rs.next())
			{
				Goods goods = new Goods();
				goods.setGiNum(rs.getInt("gi.ginum"));
				goods.setGiName(rs.getString("gi.giname"));
				goods.setGiDesc(rs.getString("gi.gidesc"));
				goods.setViNum(rs.getInt("vi.vinum"));
				goods.setViName(rs.getString("vi.viname"));
				goodsList.add(goods);
			}
			return goodsList;
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
				ps.close();
				DBConn2.closeCon();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public int getTotalCount(Goods pGoods)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try 
		{
			String sql = "select count(1) ";
			sql += " from goods_info as gi, vendor_info as vi ";
			sql += " where gi.vinum=vi.vinum";
			con = DBConn2.getCon();
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Goods> goodsList = new ArrayList<Goods>();
			while(rs.next())
			{
				return rs.getInt(1);
			}
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				ps.close();
				DBConn2.closeCon();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public List selectVendor(Goods pGoods)
	{
		Connection con = null;
		PreparedStatement ps = null;
		ArrayList<Map<String, String>> vendorList = new ArrayList<Map<String, String>>();
		try
		{
			con = DBConn2.getCon();
			String sql = "select vinum, viname from vendor_info";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Map<String, String> vhm = new HashMap<String, String>();
				vhm.put("vinum", rs.getString("vinum"));
				vhm.put("viname", rs.getString("viname"));
				vendorList.add(vhm);
			}
		return vendorList;
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
				ps.close();
				DBConn2.closeCon();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return null;
	}
}
