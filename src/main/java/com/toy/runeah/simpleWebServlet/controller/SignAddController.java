package com.toy.runeah.simpleWebServlet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toy.runeah.simpleWebServlet.dao.SignDao;
import com.toy.runeah.simpleWebServlet.dto.MemberDto;

@WebServlet("/signAdd")
public class SignAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	SignDao dao = new SignDao();
	
    public SignAddController() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		
		String memberId = request.getParameter("memberId");
		String password = request.getParameter("password");
		String nickName = request.getParameter("nickName");
		String address = request.getParameter("address1")+" "+request.getParameter("address2");
		String zipCode = request.getParameter("zipCode");
		
		MemberDto memberDto = new MemberDto(memberId,password,nickName,address,zipCode);
		dao.addMember(memberDto);
		
		response.sendRedirect("/runeah/");
		//RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/index.jsp");
		//requestDispatcher.forward(request, response);
	}

}
