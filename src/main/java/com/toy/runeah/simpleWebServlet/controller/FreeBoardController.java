package com.toy.runeah.simpleWebServlet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toy.runeah.simpleWebServlet.dao.FreeBoardDao;
import com.toy.runeah.simpleWebServlet.dto.BoardDto;

@WebServlet("/freeBoard")
public class FreeBoardController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FreeBoardController() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		FreeBoardDao dao = new FreeBoardDao();
		List<BoardDto> list = dao.getBoards();
		System.out.println(list);
		request.setAttribute("list", list);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/freeBoard.jsp");
		requestDispatcher.forward(request, response);
		
	}
}
