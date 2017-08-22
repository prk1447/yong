package com.test.common;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ExamDBConn 
{
	public static void main(String[] args)
	{
		Connection con;
		try
		{
			Properties pro = DBConn2.getPro();
			System.out.println(pro.getProperty("db.driver"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

