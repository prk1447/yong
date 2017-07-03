package report.parkyongseong.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import report.parkyongseong.common.DBConn2;

public class TestDAO 
{
	private Connection con;
	private PreparedStatement prestmt;
	public boolean insertTest(int writer)
	{
		try
		{
			con = DBConn2.getCon();
			String sql = "select * from user_info where num=?";
			prestmt = con.prepareStatement(sql);
			prestmt.setInt(1, writer);
			ResultSet rs = prestmt.executeQuery();
			if(rs.next())
			{
				sql = "insert into test(title, content, writer, reg_date)";
				sql += " values(?,?,?,?)";
				prestmt = con.prepareStatement(sql);
				prestmt.setString(1, "게시물4");
				prestmt.setString(2, "내용4");
				prestmt.setInt(3, 4);
				Date d = new Date();
				SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				prestmt.setString(4, sdt.format(d));
				int result = prestmt.executeUpdate();
				if(result == 1)
				{
					return true;
				}
				DBConn2.closeCon();
			}
			else
			{
				System.out.println(writer + "번호를 가진 사람이 USER_INFO테이블에 없어요");
			}
		}
		catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Map> selectTest()
	{
		List<Map> userTest = new ArrayList<Map>();
		try
		{
			con = DBConn2.getCon();
			String sql = "select te. *, ui.id, ui.name from test as te, user_info as ui";
			sql += " where te.writer=ui.num";
			prestmt = con.prepareStatement(sql);
			ResultSet rs = prestmt.executeQuery();
			while(rs.next())
			{
				Map hm = new HashMap();
				hm.put("num", rs.getString("num"));
				hm.put("title", rs.getString("title"));
				hm.put("content", rs.getString("content"));
				hm.put("writer", rs.getString("writer"));
				hm.put("reg_date", rs.getString("reg_date"));
				hm.put("id", rs.getString("id"));
				hm.put("name", rs.getString("name"));
				userTest.add(hm);
			}
			DBConn2.closeCon();
			return userTest;
		}
		catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean updateTest()
	{
		try
		{
			con = DBConn2.getCon();
		}
		catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteTest(int num)
	{
		try
		{
			con = DBConn2.getCon();
			String sql = "delete from test where num=" + num;
			prestmt = con.prepareStatement(sql);
			int result = prestmt.executeUpdate();
			DBConn2.closeCon();
			if(result > 0)
			{
				return true;
			}
		}
		catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[] args)
	{
		TestDAO tado = new TestDAO();
		List<Map> list = tado.selectTest();
		tado.insertTest(6);
		//tado.deleteTest(2);
	}
}
