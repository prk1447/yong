package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.common.DBConn2;
import com.test.dto.Vendor;

public class VendorService {

	public List<Vendor> selectVendorsList(Vendor vendor)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try 
		{
			String sql = "select vinum, viname, videsc, viaddress, viphone from vendor_info where 1=1";
			if(vendor.getViName() != null)
			{
				sql += " and viname like ?";
			}
			con = DBConn2.getCon();
			ps = con.prepareStatement(sql);
			if(vendor.getViName() != null)
			{
				ps.setString(1, "%" + vendor.getViName() + "%");
			}
			ResultSet rs = ps.executeQuery();
			List<Vendor> vendorList = new ArrayList<Vendor>();
			while(rs.next())
			{
				Vendor rVendor = new Vendor();
				rVendor.setViNum(rs.getInt("vinum"));
				rVendor.setViName(rs.getString("viname"));
				rVendor.setViDesc(rs.getString("videsc"));
				rVendor.setViAddress(rs.getString("viaddress"));
				rVendor.setViPhone(rs.getString("viphone"));
				vendorList.add(rVendor);
			}
			return vendorList;
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
		return null;
	}

	public int insertVendor(Vendor vendor)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			String sql = "insert into vendor_info(viname, videsc, viaddress, viphone, vicredat, vicretim)";
			sql += " values(?,?,?,?,DATE_FORMAT(NOW(), '%Y%m%d'), DATE_FORMAT(NOW(), '%H%i%s'))";
			con = DBConn2.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vendor.getViName());
			ps.setString(2, vendor.getViDesc());
			ps.setString(3, vendor.getViAddress());
			ps.setString(4, vendor.getViPhone());
			int result = ps.executeUpdate();
			con.commit();
			return result;
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
		return 0;
	}

	public Vendor selectVendor(Vendor vendor)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			String sql = "select vinum, viname, videsc, viaddress, viphone from vendor_info where 1=1";
			sql += " and vinum=?";
			con = DBConn2.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vendor.getViNum());
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Vendor rVendor = new Vendor();
				rVendor.setViNum(rs.getInt("viNum"));
				rVendor.setViName(rs.getString("viName"));
				rVendor.setViDesc(rs.getString("viDesc"));
				rVendor.setViAddress(rs.getString("viAddress"));
				rVendor.setViPhone(rs.getString("viPhone"));
				return rVendor;
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

	public int deleteVendor(Vendor vendor)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			String sql = "delete from vendor_info where vinum=?";
			con = DBConn2.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vendor.getViNum());
			int result = ps.executeUpdate();
			con.commit();
			return result;
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
		return 0;
	}

	public int updateVendor(Vendor vendor)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			String sql = "update vendor_info set viname=?,";
			sql += "videsc=?,viaddress=?,viphone=? where vinum=?";
			con = DBConn2.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vendor.getViName());
			ps.setString(2, vendor.getViDesc());
			ps.setString(3, vendor.getViAddress());
			ps.setString(4, vendor.getViPhone());
			ps.setInt(5, vendor.getViNum());
			int result = ps.executeUpdate();
			con.commit();
			return result;
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
		return 0;
	}
}
