package com.toy.runeah.simpleWebServlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toy.runeah.simpleWebServlet.dao.MyPageDao;
import com.toy.runeah.simpleWebServlet.dto.SignDto;

@WebServlet("/myPageMyInfoModify")
public class MyPageInfoModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public MyPageInfoModifyController() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		SignDto dto = null;
		dto = (SignDto) request.getSession().getAttribute("session_member");
		int myPageMyInfoNo = dto.getMemberNo();
		String myPageMyInfoId = request.getParameter("myPageMyInfoId");
		String myPageMyInfoPassword = request.getParameter("myPageMyInfoPassword");
		String myPageMyInfoName = request.getParameter("myPageMyInfoName");
		String myPageMyInfoNickName = request.getParameter("myPageMyInfoNickName");
		String myPageMyInfoSex = request.getParameter("myPageMyInfoSex");
		String myPageMyInfoBirth = request.getParameter("myPageMyInfoBirth");
		String myPageMyInfoPhone = request.getParameter("myPageMyInfoPhone");
		String myPageMyInfoTel = request.getParameter("myPageMyInfoTel");
		String myPageMyAddress = request.getParameter("myPageMyAddress");
		String myPageMyInfoAccountNo = request.getParameter("myPageMyInfoAccountNo");
		System.out.println("NO:"+myPageMyInfoNo);
		System.out.println("이름:"+myPageMyInfoName);
		System.out.println("별명:"+myPageMyInfoNickName);
		System.out.println("비번:"+myPageMyInfoPassword);
		System.out.println("비번확인:"+request.getParameter("myPageMyInfoPasswordConfirm"));
		//패스워드확인 일치안하면 튕구기
		if(myPageMyInfoPassword.equals(request.getParameter("myPageMyInfoPasswordConfirm"))) {
			//데이터베이스에 정보 수정하기
			MyPageDao dao = new MyPageDao();
			dao.modifyMyPageInfo(myPageMyInfoNo,myPageMyInfoId,myPageMyInfoPassword,myPageMyInfoName,myPageMyInfoNickName,myPageMyInfoSex,myPageMyInfoBirth,myPageMyInfoPhone,myPageMyInfoTel,myPageMyAddress,myPageMyInfoAccountNo);
			response.sendRedirect("/runeah/myPage?myPageCategory=0");
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('패스워드가 다릅니다. 다시 입력해주세요'); location.href='myPage?myPageCategory=0';</script>");
			out.flush();
			out.close();
		}
	}
}
