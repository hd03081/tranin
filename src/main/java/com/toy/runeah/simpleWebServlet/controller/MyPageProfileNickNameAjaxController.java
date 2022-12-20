package com.toy.runeah.simpleWebServlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toy.runeah.simpleWebServlet.dao.MyPageDao;
import com.toy.runeah.simpleWebServlet.dto.SignDto;

@WebServlet("/profileNickNameAjax")
public class MyPageProfileNickNameAjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public MyPageProfileNickNameAjaxController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		String newNickName = request.getParameter("value");
		
		MyPageDao dao = new MyPageDao();
		SignDto dto = null;
		dto = (SignDto) request.getSession().getAttribute("session_member");
		dao.modifyProfileNickName(newNickName,dto.getMemberId());
		
		PrintWriter out = response.getWriter();
        out.print(newNickName);
        out.flush();   
	}
}
