package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.service.CommentService;

public class CommentServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resq) throws IOException, ServletException{
		req.setCharacterEncoding("UTF-8");
		
		CommentService cs = new CommentService();
		String command = req.getParameter("command");
		if(command == null)
		{
			return;
		}
		
		if(command.equals("INSERT"))
		{
			String content = req.getParameter("content");
			String uNum = req.getParameter("ui_num");
			String bNum = req.getParameter("b_num");
			
			HashMap hm = new HashMap();
			hm.put("content", content);
			hm.put("ui_num", uNum);
			hm.put("b_num", bNum);
			if(cs.commentInsert(hm))
			{
				doProcess(resq, "insert 잘됨");
			}
			else
			{
				doProcess(resq, "값을 제대로 넣어주세요");
			}
		}
		else if(command.equals("DELETE"))
		{
			String cNum = req.getParameter("ci_num");
			HashMap hm = new HashMap();
			hm.put("num", cNum);
			
			if(cs.commentDelete(hm))
			{
				doProcess(resq, "delete 성공!");
			}
			else
			{
				doProcess(resq, "delete 실패!");
			}
		}
		else if(command.equals("SELECT"))
		{
			String content = req.getParameter("content");
			HashMap hm = new HashMap();
			if(content != null && !content.equals(""))
			{
				hm.put("content", "%" + content + "%");
			}
			List<Map> commentList = cs.commentSelect(hm);
			String result = "";
			for(Map m : commentList)
			{
				result += m.toString();
			}
			doProcess(resq, result);
		}
		else if(command.equals("UPDATE"))
		{
			String cNum = req.getParameter("ci_num");
			String content = req.getParameter("ci_content");
			
			HashMap hm = new HashMap();
			hm.put("num", cNum);
			hm.put("content", content);
			if(cs.commentUpdate(hm))
			{
				doProcess(resq, "update 성공");
			}
			else
			{
				doProcess(resq, "update 실패");
			}
		}
	}
	
	public void dePost(HttpServletRequest req, HttpServletResponse reqs) throws IOException{
		
	}

	
	public void doProcess(HttpServletResponse resq, String writeStr) throws IOException {
		resq.setContentType("text/html; charset = UTF-8");
		PrintWriter out = resq.getWriter();
		out.print(writeStr);
		
	}
}