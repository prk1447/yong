package report.parkyongseong.common;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;




public class Exam 
{
	public List<String> getUserIDList(String name)
	{
		List<String> userlist = new ArrayList<String>();
		try
		{
			Connection con = DBConn2.getCon();
			String sql = "select id,pwd,name,age from user";
			if(!name.equals(""))
			{
				sql += " where name=?";
			}
			
			PreparedStatement prestmt = con.prepareStatement(sql);
			if(!name.equals(""))
			{
				prestmt.setString(1, name);
			}
			ResultSet rs = prestmt.executeQuery();
			
			while(rs.next())
			{
				userlist.add(rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getInt(4));
			}
			DBConn2.closeCon();
			return userlist;
		}
		catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean insertUser()
	{
		try
		{
			Connection con = DBConn2.getCon();
			String sql = "insert into user(id, pwd, name, age) values('blue','blue','청길동','40')";
			PreparedStatement prestmt = con.prepareStatement(sql);
			int result = prestmt.executeUpdate();
			DBConn2.closeCon();
			if(result == 1)
			{
				return true;
			}
		}
		catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		return false;
	}
	
	public boolean deleteUser(int num)
	{
		try
		{
			Connection con = DBConn2.getCon();
			String sql = "delete from user where num='" + num + "'";
			PreparedStatement prestmt = con.prepareStatement(sql);
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
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		return false;
	}

	public boolean setUserInformation()
	{
		try
		{
			HashMap<String, Object> hm = new HashMap<String, Object>();
			Scanner scanner = new Scanner(System.in);
			Connection con = DBConn2.getCon();
			System.out.print("ID : ");
			hm.put("id", scanner.nextLine());
			System.out.print("PWD : ");
			hm.put("pwd", scanner.nextLine());
			System.out.print("NAME : ");
			hm.put("name", scanner.nextLine());
			System.out.print("AGE : ");
			hm.put("age", Integer.parseInt(scanner.nextLine()));
			
			String sql = "insert into user(id,pwd,name,age) values(?,?,?,?)";
			PreparedStatement prestmt = con.prepareStatement(sql);
			
			prestmt.setString(1, (String)hm.get("id"));
			prestmt.setString(2, (String)hm.get("pwd"));
			prestmt.setString(3, (String)hm.get("name"));
			prestmt.setInt(4, (Integer)hm.get("age"));
			prestmt.executeUpdate();
			DBConn2.closeCon();
			return true;
		}
		catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[] args)
	{
		Exam ex = new Exam();
		ex.setUserInformation();
		//List<String> list = ex.getUserIDList("홍길동");
		//for(int i = 0; i < list.size(); i++)
		//{
		//	System.out.println(list.get(i));
		//}
	}
}
