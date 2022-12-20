package com.toy.runeah.simpleWebServlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.toy.runeah.simpleWebServlet.dao.LoginDao;
import com.toy.runeah.simpleWebServlet.dao.SignDao;
import com.toy.runeah.simpleWebServlet.dto.LoginDto;
import com.toy.runeah.simpleWebServlet.dto.SignDto;
import com.toy.runeah.simpleWebServlet.misc.MyUtils;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MyUtils myUtils = new MyUtils();
	
	public LoginController() {
		super();
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		int sw1 = 1;
		
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		String memberId=req.getParameter("memberId");
		if(memberId=="") {
			sw1=0;
			out.println("<script>alert('아이디가 비었습니다. 반드시 입력해주세요'); location.href='signForm';</script>");
			out.flush();
			out.close();
		}
		
		String password=req.getParameter("password");
		if(password=="") {
			sw1=0;
			out.println("<script>alert('패스워드가 비었습니다. 반드시 입력해주세요'); location.href='signForm';</script>");
			out.flush();
			out.close();
		}
		
		String autoLogin=req.getParameter("autoLogin");
		System.out.println("자동로그인 여부 : "+autoLogin); //on or null
		
		if(sw1==1) {
			LoginDto login = new LoginDto(memberId,password);
			LoginDao dao = new LoginDao();
			SignDto loginedMember = dao.login(login);
			
			if(loginedMember!=null) {
				
				try {
					if(autoLogin.equals("on")) {//자동 로그인을 체크한 경우
		                Cookie cookie1 = new Cookie("autoLoginIDCookie", memberId);
		                Cookie cookie2 = new Cookie("autoLoginPWCookie", password);
		                // 쿠키를 찾을 경로를 컨텍스트 경로로 변경해 주고...
		                cookie1.setPath("/");
		                cookie1.setMaxAge(60*60*24*7); // 단위는 (초)임으로 7일정도로 유효시간을 설정해 준다.
		                cookie2.setPath("/");
		                cookie2.setMaxAge(60*60*24*7); // 단위는 (초)임으로 7일정도로 유효시간을 설정해 준다.
		                // 쿠키를 적용해 준다.
		                resp.addCookie(cookie1);
		                resp.addCookie(cookie2); 
					}
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("오토로그인 예외발생, 자동로그인 해제안한경우");
					//쿠키들 만료시키기
					Cookie[] cookies = req.getCookies();
				    if (cookies != null)
				        for (Cookie cookie : cookies) {
				            cookie.setValue("");
				            cookie.setPath("/");
				            cookie.setMaxAge(0);
				            resp.addCookie(cookie);
				        }
				}
				
				
				System.out.println("로그인된멤버는:"+loginedMember);
				req.getSession().setAttribute("session_member",loginedMember);
				resp.sendRedirect("/runeah/");
			}else {
				out.println("<script>alert('일치하는 멤버가 없습니다,다시입력해주세요'); location.href='loginForm';</script>");
				//resp.sendRedirect("/runeah/loginForm");
			}
			
		}
		
		
	}
}
