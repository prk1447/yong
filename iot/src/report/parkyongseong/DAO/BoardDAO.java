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

//board테이블에 update, insert, delete, select 하는 함수를 각각 4개 생성해주세요
// 모두 단일 작업임으로 한개의 함수마다 commit이 이러우져야 하며
// 만약 에러날경우rollback이 되면 됩니다.
public class BoardDAO
{
	Connection con;
	public void setConnection() throws ClassNotFoundException, SQLException
	{
		con = DBConn2.getCon();
	}
	
	public boolean insertBoard()
	{
		try
		{
			String sql = "insert into board(title, content, writer, reg_date) values('게시판제목6','게시판내용6',3,now())";
			Statement st = con.createStatement();
			int result = st.executeUpdate(sql);
			if(result == 1)
			{
				con.commit();
				return true;
			}
		}
		catch(SQLException e)
		{
			System.out.println("insert 에서 오류가 나서 롤백 시켯습니다.");
			e.printStackTrace();
		}
		return false;
	}
	
	public List<HashMap> selectBoard() throws SQLException
	{
		List<HashMap> userlist = new ArrayList<HashMap>();
		try
		{
			String sql = "select * from board";
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
			System.out.println("select 에서 나서 롤백 시켯습니다.");
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean updateBoard() throws SQLException
	{
		try
		{
			String sql = "update board set title='뀨' where num=1";
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
		catch(Exception e)
		{
			con.rollback();
			System.out.println("update 에서 오류가 나서 롤백 시켯습니다.");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteBoard(int num) throws SQLException
	{
		try
		{
			String sql = "delete from board where num=" + num;
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
			System.out.println("delete 에서 오류가 나서 롤백 시켯습니다.");
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		BoardDAO bdao = new BoardDAO();
		List<HashMap> userlist = new ArrayList<HashMap>();
	
		bdao.setConnection();
		bdao.insertBoard();
		bdao.updateBoard();
		bdao.deleteBoard(4);
		userlist = bdao.selectBoard();
		for(HashMap hm : userlist)
		{
			System.out.println(hm);
		}
	
		
	}
}
