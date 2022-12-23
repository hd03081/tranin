package com.toy.runeah.simpleWebServlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.toy.runeah.simpleWebServlet.dao.MyPageDao;
import com.toy.runeah.simpleWebServlet.dao.SignDao;
import com.toy.runeah.simpleWebServlet.dto.SignDto;

@WebServlet("/memberOut")
public class MeberOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public MeberOutController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		String inputPW = request.getParameter("pw");
		
		HttpSession session = request.getSession();
		SignDto member = (SignDto) session.getAttribute("session_member");
		
		if(inputPW.equals(member.getPassword())) {
			//세션에서 정보가져와서 데이터베이스에서 멤버삭제
			MyPageDao dao = new MyPageDao();
			dao.deleteMember(member.getMemberNo());
			//세션만료
			session.removeAttribute("session_member");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/index.jsp");
			requestDispatcher.forward(request, response);
		} else {
			System.out.println("패스워드 다름");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('패스워드가 틀렸습니다. 다시 확인해주세요'); location.href='myPage?myPageCategory=5';</script>");
			out.flush();
			out.close();
		}
	}
}
