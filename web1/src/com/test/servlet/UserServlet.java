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
		
		//String op = req.getParameter("op");
		//System.out.println("연산자의 결과는 = " + op);
		/*
		String name1 = req.getParameter("name");
		String pwd1 = req.getParameter("pass");
		System.out.println("input html에서 던진 값은 : " + name1 + pwd1);
		*/
		String command = req.getParameter("command");
		if(command == null)
		{
			return;
		}
		
		
		//UserService에 있는 insertUser(HashMap hm)이라는 함수를
		//호출하기 위해 UserService로 us 래퍼런스 변수를 생성
		if(command.equals("SIGNIN"))
		{
			UserService us = new UserService();
			
			//html화면에서 던진 값을 각각 String 변수로 받기 시작
			String id = req.getParameter("userid");
			String pwd = req.getParameter("userpwd");
			String name = req.getParameter("username");
			String age = req.getParameter("age");
			String address = req.getParameter("address");
			String hp1 = req.getParameter("hp1");
			String hp2 = req.getParameter("hp2");
			String hp3 = req.getParameter("hp3");
			
			
			//위에서 받은 String 변수를 출력해줌(Tomcat 콘솔창에)
			System.out.println(id + "," + pwd + "," + name + "," + age + ", " + address + "," + hp1 + "-" + hp2 + "-" + hp3);
			//해쉬맵 생성
			HashMap hm = new HashMap();
			//html화면에서 던진 id값을 "id"라는 키로 해쉬맵에 저장
			hm.put("id", id);
			//html화면에서 던진 pwd값을 "pwd"라는 키로 해쉬맵에 저장
			hm.put("pwd", pwd);
			//html화면에서 던진 name값을 "name"라는 키로 해쉬맵에 저장
			hm.put("name", name);
			//html화면에서 던진 class_num값을 "class_num"라는 키로 해쉬맵에 저장
			hm.put("age", age);
			//html화면에서 던진 age값을 "age"라는 키로 해쉬맵에 저장
			hm.put("address", address); 
			hm.put("hp1", hp1);
			hm.put("hp2", hp2);
			hm.put("hp3", hp3);
			//위에서 생성한 us래퍼런스 변수를 사용해 insertUser함수를 호출하는데 파라메터값은
			//위에서 생성하고 값을 저장한 HashMap인 hm래퍼런스 변수를 같이 던짐
			if(us.insertUser(hm))
			{
				doProcess(resq, "회원가입 성공");
			}
			else
			{
				doProcess(resq, "회원가입 실패");
			}
		}
		else if(command.equals("LOGIN"))
		{
			UserService us = new UserService();
			String userId = req.getParameter("userid");
			String userPwd = req.getParameter("userpwd");
			
			HashMap hm = new HashMap();
			hm.put("userid", userId);
			hm.put("userpwd", userPwd);
			
			if(us.loginUser(hm))
			{
				doProcess(resq, "로그인에 성공");
			}
			else
			{
				doProcess(resq, "아이디와 비밀번호를 제대로 입력해주세요");
			}
		}
		else if(command.equals("DELETE"))
		{
			UserService us = new UserService();
			String num = req.getParameter("usernum");
			HashMap hm = new HashMap();
			hm.put("usernum", num);
			boolean isDelete = us.deleteUser(hm);
			if(isDelete)
			{
				doProcess(resq, "user_info에 있는 " + num + "의값이 지워졌습니다.");
			}
			else
			{
				doProcess(resq, "user_info에는 " + num + "이 라는 값이 존재하지 않습니다.");
			}
			System.out.println("삭제할 번호 : " + num);
		}
		
		else if(command.equals("SELECT"))
		{
			UserService us = new UserService();
			String userName = req.getParameter("username");
			HashMap hm = new HashMap();
			if(userName != null && !userName.equals(""))
			{
				hm.put("username", "%" + userName + "%");
			}
			List<Map> userList = us.selectUser(hm);
			String result = "";
			result += "번호{/}이름{/}아이디{/}나이{+}";
			result += "dis{/}en{/}en{/}en{+}";
			for(Map m : userList)
			{
				result += m.get("usernum") + "{/}" + m.get("username") + "{/}" + m.get("userid") + "{/}" + m.get("age") + "{+}";
			}
			result = result.substring(0, result.length()-3);
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