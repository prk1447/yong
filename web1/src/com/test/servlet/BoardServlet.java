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
			String boardNum = req.getParameter("num");
			HashMap hm = new HashMap();
			hm.put("num", boardNum);
			
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
			String result = "<script>";
			result += "function deleteBoard(num){";
			result += "location.href='delete.board?command=DELETE&num=' + num;";
			result += "}";
			result += "</script>";
			result += "<form action='*.board'>";
			result += "이름 : <input type='text' name='name' id='name'/> <input type='submit' value='검색'/>";
			result += "<input type='hidden' name='command' value='SELECT'/>";
			result += "</form>";
			result += "<table border='1'>";
			result += "<tr>";
			result += "<td>" + "보드번호" + "</td>";
			result += "<td>" + "보드제목" + "</td>";
			result += "<td>" + "보드내용" + "</td>";
			result += "<td>" + "writer" + "</td>";
			result += "<td>" + "날짜" + "</td>";
			result += "<td>" + "삭제 버튼" + "</td>";
			result += "</tr>";
			for(Map m : boardList)
			{
				result += "<tr>";
				result += "<td>" + m.get("num") + "</td>";
				result += "<td>" + m.get("title") + "</td>";
				result += "<td>" + m.get("content") + "</td>";
				result += "<td>" + m.get("writer") + "</td>";
				result += "<td>" + m.get("reg_date") + "</td>";
				result += "<td><input type='button' value='삭제' onclick='deleteBoard(" + m.get("num") + ")'/></td>";
				result += "</tr>";
			}
			result += "</table>";
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