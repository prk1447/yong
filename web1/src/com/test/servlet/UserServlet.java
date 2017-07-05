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

import com.test.service.UserService;

public class UserServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resq) throws IOException, ServletException{
		req.setCharacterEncoding("UTF-8");
		//html화면에서 던진 값을 각각 String 변수로 받기 시작
		String command = req.getParameter("command");
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String class_num = req.getParameter("class_num");
		String age = req.getParameter("age");
		
		
		//UserService에 있는 insertUser(HashMap hm)이라는 함수를
		//호출하기 위해 UserService로 us 래퍼런스 변수를 생성
		if(command.equals("SIGNIN"))
		{
			UserService us = new UserService();
			
			//위에서 받은 String 변수를 출력해줌(Tomcat 콘솔창에)
			System.out.println(id + "," + pwd + "," + name + "," + class_num + ", " + age);
			//해쉬맵 생성
			HashMap hm = new HashMap();
			//html화면에서 던진 id값을 "id"라는 키로 해쉬맵에 저장
			hm.put("id", id);
			//html화면에서 던진 pwd값을 "pwd"라는 키로 해쉬맵에 저장
			hm.put("pwd", pwd);
			//html화면에서 던진 name값을 "name"라는 키로 해쉬맵에 저장
			hm.put("name", name);
			//html화면에서 던진 class_num값을 "class_num"라는 키로 해쉬맵에 저장
			hm.put("class_num", class_num);
			//html화면에서 던진 age값을 "age"라는 키로 해쉬맵에 저장
			hm.put("age", age); 
		
			//위에서 생성한 us래퍼런스 변수를 사용해 insertUser함수를 호출하는데 파라메터값은
			//위에서 생성하고 값을 저장한 HashMap인 hm래퍼런스 변수를 같이 던짐
			if(us.insertUser(hm))
			{
				doProcess(resq, "저장 됨");
			}
			else
			{
				doProcess(resq, "값 똑바로 입력하세요");
			}
		}
		else if(command.equals("DELETE"))
		{
			UserService us = new UserService();
			String num = req.getParameter("user_num");
			HashMap hm = new HashMap();
			hm.put("num", num);
			if(us.deleteUser(hm))
			{
				doProcess(resq, "user_info에 있는 " + num + "의값이 지워졌습니다.");
			}
			else
			{
				doProcess(resq, "user_info에는 " + num + "이 라는 값이 존재하지 않습니다.");
			}
			System.out.println("삭제할 번호 : " + num);
		}
		else if(command.equals("UPDATE"))
		{
			UserService us = new UserService();
			HashMap hm = new HashMap();
			String num = req.getParameter("user_num");
			String userName = req.getParameter("name");
			String classNum = req.getParameter("class_num");
			String userage = req.getParameter("age");
			
			hm.put("num", num);
			hm.put("name", userName);
			hm.put("class_num", classNum);
			hm.put("age", userage);
			if(us.userUpdate(hm))
			{
				doProcess(resq, "업데이트가 잘됬습니다.");
			}
			else
			{
				doProcess(resq, "업데이트에 실패했습니다.");
			}
		}
		else if(command.equals("SELECT"))
		{
			UserService us = new UserService();
			String userName = req.getParameter("name");
			HashMap hm = new HashMap();
			if(userName != null && !userName.equals(""))
			{
				hm.put("name", "%" + userName + "%");
			}
			List<Map> userList = us.selectUser(hm);
			String result = "";
			for(Map m : userList)
			{
				result += m.toString();
			}
			doProcess(resq, result);
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