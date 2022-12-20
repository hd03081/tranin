package com.toy.runeah.simpleWebServlet.controller;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.toy.runeah.simpleWebServlet.dao.FreeBoardDetailDao;
import com.toy.runeah.simpleWebServlet.dao.FreeBoardRegistDao;
import com.toy.runeah.simpleWebServlet.dao.SignDao;
import com.toy.runeah.simpleWebServlet.dto.BoardDto;
import com.toy.runeah.simpleWebServlet.dto.SignDto;
import com.toy.runeah.simpleWebServlet.misc.MyUtils;

@WebServlet("/freeBoardRegist")
public class FreeBoardRegistController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MyUtils myUtils = new MyUtils();
	public FreeBoardRegistController() {
		super();
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int sw1 = 1;
		
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		//json parsing
		JSONObject jObj = new JSONObject(myUtils.getBody(req));
	    Iterator<String> it = jObj.keys();
	    while(it.hasNext())
	    {
	      String key = it.next(); // get key
	      Object o = jObj.get(key); // get value
	      System.out.println(key + " : " +  o); // print the key and value
	    }
		String memberNo = (String) jObj.get("memberNo");
		String nickName = (String) jObj.get("nickName");
		String title = (String) jObj.get("title");
		String attachedImageURL = (String) jObj.get("attachedImageURL");
		String content = (String) jObj.get("content");
		
		if(sw1==1) {
			BoardDto board = new BoardDto(Integer.parseInt(memberNo),nickName,title,attachedImageURL,content);
			FreeBoardRegistDao dao = new FreeBoardRegistDao();
			int insertCount = dao.addBoard(board);
			System.out.println(insertCount);
			//resp.sendRedirect("/runeah/");
		}
		
		
	}
}
