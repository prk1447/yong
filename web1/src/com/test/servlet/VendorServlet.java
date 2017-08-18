package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.test.dto.Goods;
import com.test.dto.Page;
import com.test.dto.Vendor;
import com.test.service.VendorService;

public class VendorServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	private VendorService vs = new VendorService();
	Gson g = new Gson();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		request.setCharacterEncoding("UTF-8");
		
		String params = request.getParameter("param");
	    Vendor vendor = g.fromJson(params, Vendor.class);
	    String command = vendor.getCommand();
		if(command.equals("view"))
		{
	    	Vendor resultVendor = vs.selectVendor(vendor);
	    	request.setAttribute("vendor", resultVendor);
	    	request.setAttribute("url", "/goods/goods_view.jsp");
	    	RequestDispatcher rd=request.getRequestDispatcher("/goods/goods_view2.jsp");
	    	try 
	    	{
				rd.forward(request, response);
			} 
	    	catch (ServletException e)
	    	{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		Vendor vendor = g.fromJson(request.getReader(), Vendor.class);
		String command = vendor.getCommand();
		if(command.equals("list"))
		{
			List<Vendor> vendorList = vs.selectVendorsList(vendor);
			HashMap hm = new HashMap();
			hm.put("vendor", vendorList);
			String result = g.toJson(hm);
			doProcess(response, result);
		}
		else if(command.equals("view"))
		{   	
			Vendor resultVendor = vs.selectVendor(vendor);
			HashMap hm = new HashMap();
			hm.put("vendor", resultVendor);
			hm.put("url", "/vendor/vendor_view.jsp");
			String jsonStr = g.toJson(hm);
			doProcess(response, jsonStr);
	    }
		else if(command.equals("delete"))
		{
			int result = vs.deleteVendor(vendor);
			HashMap hm = new HashMap();
			hm.put("msg", "삭제 성공");
			hm.put("url", "/vendor/vendor_list.jsp");
			if(result != 1)
			{
				hm.put("msg", "삭제 실패");
				hm.put("url", "");
			}
			String jsonStr = g.toJson(hm);
			doProcess(response, jsonStr);
		}
		else if(command.equals("insert"))
		{
			int result = vs.insertVendor(vendor);
			HashMap hm = new HashMap();
			hm.put("msg", "저장 성공");
			hm.put("url", "/vendor/vendor_list.jsp");
			if(result != 1)
			{
				hm.put("msg", "저장 실패");
				hm.put("url", "");
			}
			String jsonStr = g.toJson(hm);
			doProcess(response, jsonStr);
		}
		else if(command.equals("update"))
		{
			int result = vs.updateVendor(vendor);
			HashMap hm = new HashMap();
			hm.put("msg", "수정 완료");
			hm.put("url", "/vendor/vendor_list.jsp");
			if(result != 1)
			{
				hm.put("msg", "수정 실패");
				hm.put("url", "");
			}
			String jsonStr = g.toJson(hm);
			doProcess(response, jsonStr);
		}
		else if(command.equals("vendor"))
		{
			Vendor vendorList = vs.selectVendor(vendor);
			HashMap hm = new HashMap();
			hm.put("vendor", vendorList);
			String jsonStr = g.toJson(hm);
			doProcess(response, jsonStr);
		}
	}

	
	public void doProcess(HttpServletResponse resq, String writeStr) throws IOException {
		resq.setContentType("text/html; charset = UTF-8");
		PrintWriter out = resq.getWriter();
		out.print(writeStr);
		
	}
}