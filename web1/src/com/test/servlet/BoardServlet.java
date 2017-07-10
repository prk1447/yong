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

import com.test.service.BoardService;

public class BoardServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resq) throws IOException, ServletException{
		req.setCharacterEncoding("UTF-8");
		BoardService bs = new BoardService();
		
		String command = req.getParameter("command");
		if(command == null)
		{
			return;
		}
		
		if(command.equals("INSERT"))
		{
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String userNum = req.getParameter("user_num");
			
			System.out.println(title + "," + content + "," + userNum);
			
			HashMap hm = new HashMap();
			hm.put("title", title);
			hm.put("content", content);
			hm.put("user_num", userNum);
			
			if(bs.boardInsert(hm))
			{
				doProcess(resq, "저장됨");
			}
			else
			{
				doProcess(resq, "값을 똑바로 입력해주세요");
			}
		}
		else if(command.equals("DELETE"))
		{
			String boardNum = req.getParameter("board_num");
			HashMap hm = new HashMap();
			hm.put("board_num", boardNum);
			
			if(bs.boardDelete(hm))
			{
				doProcess(resq, (boardNum + "번호를 삭제했습니다."));
			}
			else
			{
				doProcess(resq, (boardNum + "라는 번호가 존재하지 않습니다."));
			}
		}
		else if(command.equals("SELECT"))
		{
			String title = req.getParameter("title");
			HashMap hm = new HashMap();
			if(title != null && !title.equals(""))
			{
				hm.put("title", "%" + title + "%");
			}
			List<Map> boardList = bs.boardSelect(hm);
			String result = "";
			for(Map m : boardList)
			{
				result += m.toString();
			}
			doProcess(resq, result);
		}
		else if(command.equals("UPDATE"))
		{
			String boardNum = req.getParameter("board_num");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			HashMap hm = new HashMap();
			hm.put("board_num", boardNum);
			hm.put("title", title);
			hm.put("content", content);
			if(bs.boardUpdate(hm))
			{
				doProcess(resq, "업데이트 완료");
			}
			else
			{
				doProcess(resq, "업데이트 실패");
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