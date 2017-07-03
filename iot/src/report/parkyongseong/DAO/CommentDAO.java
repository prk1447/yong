package report.parkyongseong.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import report.parkyongseong.common.DBConn2;


public class CommentDAO 
{
	Connection con;
	public void setConnection() throws ClassNotFoundException, SQLException
	{
		con = DBConn2.getCon();
	}
	
	public boolean insertComment() throws SQLException
	{
		String sql = "insert into comment_info(content, ui_num, b_num, reg_date)";
		sql += " values('게시판내용3',3,3,now())";
		try
		{
			Statement st = con.createStatement();
			int result = st.executeUpdate(sql);
			if(result == 1)
			{
				con.commit();
				return true;
			}
		}
		catch(Exception e)
		{
			con.rollback();
			e.printStackTrace();
		}
		return false;
	}
	
	public List<HashMap> selectComment() throws SQLException
	{
		List<HashMap> userlist = new ArrayList<HashMap>();
		String sql = "select * from comment_info";
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			while(rs.next())
			{
				HashMap hm = new HashMap();
				int colCount = rsmd.getColumnCount();
				for(int i = 1; i <= colCount; i++)
				{
					String colName = rsmd.getColumnName(i);
					hm.put(colName, rs.getString(colName));
				}
				userlist.add(hm);
			}
			con.commit();
			return userlist;
		}
		catch(Exception e)
		{
			con.rollback();
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean updateComment() throws SQLException
	{
		String sql = "update comment_info set content='바뀐내용' where num=1";
		try
		{
			Statement st = con.createStatement();
			int result = st.executeUpdate(sql);
			if(result == 1)
			{
				st.close();
				st = null;
				con.commit();
				return true;
			}
		}
		catch(SQLException e)
		{
			con.rollback();
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteComment(int num) throws SQLException
	{
		String sql = "delete from comment_info where num=" + num;
		try
		{
			Statement st = con.createStatement();
			int result = st.executeUpdate(sql);
			if(result > 0)
			{
				con.commit();
				return true;
			}
		}
		catch(Exception e)
		{
			con.rollback();
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		CommentDAO cado = new CommentDAO();
		List<HashMap> userlist = new ArrayList<HashMap>();
		cado.setConnection();
		cado.insertComment();
		cado.updateComment();
		userlist = cado.selectComment();
		for(HashMap hm : userlist)
		{
			System.out.println(hm);
		}
	}
}
