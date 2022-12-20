package com.toy.runeah.simpleWebServlet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toy.runeah.simpleWebServlet.dao.MainDao;

@WebServlet("/index.jsp")
public class HomeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public HomeController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		MainDao dao = new MainDao();
		String list = dao.getSomething();
		System.out.println(list);
		request.setAttribute("list", list);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/index.jsp");
		requestDispatcher.forward(request, response);
		
	}
}
