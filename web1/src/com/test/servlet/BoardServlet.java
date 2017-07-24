package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dto.BoardInfo;
import com.test.service.BoardService;

public class BoardServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resq) throws IOException, ServletException{
		req.setCharacterEncoding("UTF-8");
		BoardService bs = new BoardService();
		BoardInfo bi = new BoardInfo();
		String command = req.getParameter("command");
		if(command == null)
		{
			return;
		}
		
		if(command.equals("INSERT"))
		{
			String title = req.getParameter("bititle");
			String content = req.getParameter("bicontent");
			String biPwd = req.getParameter("bipwd");
			String creusr = req.getParameter("creusr");
			
			System.out.println(title + "," + content + "," + biPwd + "," + creusr);
			bi.setBiTitle(title);
			bi.setBiContent(content);
			bi.setBiPwd(biPwd);
			bi.setCreusr(creusr);
			
			
			if(bs.boardInsert(bi))
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
			String biNum = req.getParameter("binum");
			bi.setBiNum(Integer.parseInt(biNum));
			
			System.out.println("지울 Board_Info 번호 : " + biNum);
			
			if(bs.boardDelete(bi))
			{
				doProcess(resq, (biNum + "번호를 삭제했습니다."));
			}
			else
			{
				doProcess(resq, (biNum + "라는 번호가 존재하지 않습니다."));
			}
		}
		else if(command.equals("SELECT"))
		{
			String title = req.getParameter("title");
			if(title != null && !title.equals(""))
			{
				bi.setBiTitle("%" + title + "%");
			}
			List<BoardInfo> boardList = bs.boardSelect(bi);
			String result = "";
			result += "번호{/}TITLE{/}CONTENT{/}CREUSR{+}";
			result += "dis{/}en{/}en{/}en{+}";
			for(BoardInfo m : boardList)
			{
				result += m.getBiNum() + "{/}" + m.getBiTitle() + "{/}" + m.getBiContent()  + "{/]" + m.getCreusr() + "{+}";
			}
			result = result.substring(0, result.length()-2);
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