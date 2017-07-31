<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
boolean login = Boolean.parseBoolean(request.getParameter("login"));
String loginStr = "로그인";
if(login)
{
	loginStr = "로그아웃";
}
%>
<body background="http://st.gde-fon.com/wallpapers_original/415423_skajp_oblaka_raduga_prostoj-fon_1680x1050_www.Gde-Fon.com.jpg"></body>
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/main.jsp">Home</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="/board/board_select.jsp">게시판가기</a></li>
            <li><a href="/user/user_info.jsp">유저정보가기</a></li>
            <li><a href="/user/logout_ok.jsp"><%=loginStr%></a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
</nav>

