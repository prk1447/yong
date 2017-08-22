package com.test.servlet.test;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FormServlet extends CommonServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		String result = "ID : " + id + "\nPWD : " + pwd; 
		doProcess(response, result);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		HashMap hm = g.fromJson(request.getReader(), HashMap.class);
		String id = (String)hm.get("id");
		String pwd = (String)hm.get("pwd");
		
		hm.put("id", id);
		hm.put("pwd", pwd);
		String jsonStr = g.toJson(hm);
		doProcess(response, jsonStr);
	}
}
