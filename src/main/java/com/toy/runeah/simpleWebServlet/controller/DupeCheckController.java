package com.toy.runeah.simpleWebServlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toy.runeah.simpleWebServlet.dao.SignDao;

@WebServlet("/dupeCheck")
public class DupeCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SignDao dao = new SignDao();
	
	public DupeCheckController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		
		response.getWriter().write(dao.dupeCheck(id));
	}

}
