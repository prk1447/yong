package report.parkyongseong.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class UserDAO 
{
	public List<HashMap> doSelect(String sql)
	{
		List<HashMap> userlist = new ArrayList<HashMap>();
		try
		{
			Connection con = DBConn2.getCon();
			PreparedStatement prestmt = con.prepareStatement(sql);
			ResultSet rs = prestmt.executeQuery();
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
			DBConn2.closeCon();
			return userlist;
		}
		catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean setUserInformation()
	{
		try
		{
			HashMap<String, Object> hm = new HashMap<String, Object>();
			Scanner scanner = new Scanner(System.in);
			Connection con = DBConn2.getCon();
			System.out.println("ID : ");
			hm.put("id", scanner.nextLine());
			System.out.println("PWD : ");
			hm.put("id", scanner.nextLine());
			System.out.println("NAME : ");
			hm.put("pwd", scanner.nextLine());
			System.out.println("AGE : ");
			hm.put("age", Integer.parseInt(scanner.nextLine()));
			System.out.println("CLASS_NUM : ");
			hm.put("class_num", Integer.parseInt(scanner.nextLine()));
			
			String sql = "insert into user_info(id,pwd,name,age,class_num) values(?,?,?,?,?)";
			PreparedStatement prestmt = con.prepareStatement(sql);
			
			prestmt.setString(1, (String)hm.get("name"));
			prestmt.setString(2, (String)hm.get("id"));
			prestmt.setString(3, (String)hm.get("pwd"));
			prestmt.setInt(4, (Integer)hm.get("age"));
			prestmt.setInt(5, (Integer)hm.get("class_num"));
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
		UserDAO ud = new UserDAO();
		//ud.setUserInformation();
		
		String sql = "";
		sql = "select num,id,pwd,name,age from user";
		List<HashMap> userlist = ud.doSelect(sql);
		/*
		System.out.println("유저 리스트->");
		for(HashMap hm : userlist)
		{
			System.out.println(hm);
		}
		*/
		sql = "select ui.num, ui.id, ui.pwd, ui.name, ui.age, ci.class_name, ci.class_num from user_info as ui, class_info as ci"
				+ " where ui.class_num=ci.class_num";
		userlist = ud.doSelect(sql);
		for(HashMap hm : userlist)
		{
			System.out.println(hm);
		}
		
	}
}