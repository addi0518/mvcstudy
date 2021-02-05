package com.mvcstudy.testmvc.controller;
	
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvcstudy.testmvc.service.UserService;
import com.mvcstudy.testmvc.vo.Pagination;
import com.mvcstudy.testmvc.vo.User;

@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//UID값으로 통신한 것이 정상인지 판단 -> 미리 선언(직렬화 관련)
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charse=utf-8");
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		String view = null;
		
		int page = 1;
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String id = null;
		String pw = null;
		HttpSession session = null;
		
		command = checkSession(request, response, command);
		
		switch (command) {
			case "/user-list.do":
				String reqPage = request.getParameter("page");
				if (reqPage != null) {
					page = Integer.parseInt(reqPage);
				}
				UserService userService = UserService.getInstance();
				//생성자를 private로 선언하여 다른클래스에서 해당 클래스의 인스턴스를 
				//new로 생성하지 못하게 하고, getInstance()함수를 통해서 인스턴스를 갖도록 한다.
				ArrayList<User> list = userService.getUsers(page);
				request.setAttribute("list", list);
				//이름이 list인 속성의 값을 list로 지정한다.
				Pagination pagination = new Pagination(page);
				request.setAttribute("list", list);
				request.setAttribute("pagination", pagination);
				view = "user/list";
				break;
				
			case "/user-insert.do":
				view = "user/insert";
				break;
				
			case "/user-insert-process.do":
				User user = new User();
				user.setU_id(request.getParameter("u_id"));
				user.setU_pw(request.getParameter("u_pw"));
				user.setU_name(request.getParameter("u_name"));
				user.setU_tel(request.getParameter("tel1") + "-" + request.getParameter("tel2") + request.getParameter("tel3"));
				user.setU_age(request.getParameter("u_age"));
				
				userService = UserService.getInstance();
				userService.insertUser(user);
				
				view = "user/insert-result";
				break;
				
			case "/user-login.do":
				view = "user/login";
				break;
				
			case "/user-login-process.do":
				id = request.getParameter("login_id");
				pw = request.getParameter("login_password");
				
				userService = UserService.getInstance();
				user = userService.loginUser(id, pw);
				
				if(user != null) {
					session = request.getSession();
					session.setAttribute("user", user);
					
					view = "user/login-result";
				} else {
					view = "user/login-fail";
				}
				break;
				
			case "/logout.do":
				session = request.getSession();
				session.invalidate();
				view = "user/login";
				break;
			
			case "/acess-denied.do":
				view = "user/access-denied";
				break;
		}
		
		//RequestDispatcher는 클라이언트로부터 최초에 들어온 요청을 
		//JSP/Servlet 내에서 원하는 자원으로 요청을 넘기는(보내는) 역할을 수행하거나, 
		//특정 자원에 처리를 요청하고 처리 결과를 얻어오는 기능을 수행하는 클래스입니다
		RequestDispatcher rd = request.getRequestDispatcher(view+".jsp");
		rd.forward(request, response);
	}
	
	String checkSession(HttpServletRequest request, HttpServletResponse response, String command) {
		HttpSession session = request.getSession();
		
		String[] authList = {
				"/user-list.do"
				,"/user-insert.do"
				,"/user-insert-process.do"
				,"/user-detail.do"
				,"/user-edit.do"
				,"/user-edit-process.do"
				,"/logout.do"
		};
		
		for(String item : authList) {
			if(item.equals(command)) {
				if(session.getAttribute("user") == null) {
					command = "/access-denied.do";
				}
			}
		}
		return command;
	}
}
