package com.toy.runeah.simpleWebServlet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toy.runeah.simpleWebServlet.dao.FreeBoardDetailDao;
import com.toy.runeah.simpleWebServlet.dao.FreeBoardDao;
import com.toy.runeah.simpleWebServlet.dto.BoardDto;

@WebServlet("/freeBoardDetail")
public class FreeBoardDetailController extends HttpServlet  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FreeBoardDetailController() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String boardNo=request.getParameter("boardNo");
		FreeBoardDetailDao dao = new FreeBoardDetailDao();
		BoardDto list = dao.getOneBoard(boardNo);
		System.out.println(list);
		request.setAttribute("list", list);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/freeBoardDetail.jsp");
		requestDispatcher.forward(request, response);
		
	}
}
