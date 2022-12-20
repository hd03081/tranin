package com.toy.runeah.simpleWebServlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.toy.runeah.simpleWebServlet.dao.SignDao;
import com.toy.runeah.simpleWebServlet.dto.SignDto;
import com.toy.runeah.simpleWebServlet.misc.MyUtils;

@WebServlet("/signAdd")
public class SignAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MyUtils myUtils = new MyUtils();
	
	public SignAddController() {
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
		
		String name=req.getParameter("name");
		if(name=="") {
			sw1=0;
			out.println("<script>alert('이름이 비었습니다. 반드시 입력해주세요'); location.href='signForm';</script>");
			out.flush();
			out.close();
		}
		
		String nickName=req.getParameter("nickName");
		if(nickName=="") {
			sw1=0;
			out.println("<script>alert('별명이 비었습니다. 반드시 입력해주세요'); location.href='signForm';</script>");
			out.flush();
			out.close();
		}
		
		String sex=req.getParameter("sex");
		if(sex=="") {
			sw1=0;
			out.println("<script>alert('성별이 비었습니다. 반드시 입력해주세요'); location.href='signForm';</script>");
			out.flush();
			out.close();
		}
		
		String birthYear=req.getParameter("birthYear");
		if(birthYear=="") {
			sw1=0;
			out.println("<script>alert('나이가 비었습니다. 반드시 입력해주세요'); location.href='signForm';</script>");
			out.flush();
			out.close();
		}
		
		String birthMonth=req.getParameter("birthMonth");
		if(birthMonth=="") {
			sw1=0;
			out.println("<script>alert('나이가 비었습니다. 반드시 입력해주세요'); location.href='signForm';</script>");
			out.flush();
			out.close();
		}
		
		String birthDay=req.getParameter("birthDay");
		if(birthDay=="") {
			sw1=0;
			out.println("<script>alert('나이가 비었습니다. 반드시 입력해주세요'); location.href='signForm';</script>");
			out.flush();
			out.close();
		}
		
		String phone1=req.getParameter("phone1");
		if(phone1=="") {
			sw1=0;
			out.println("<script>alert('휴대전화번호가 비었습니다. 반드시 입력해주세요'); location.href='signForm';</script>");
			out.flush();
			out.close();
		}
		
		String phone2=req.getParameter("phone2");
		if(phone2=="") {
			sw1=0;
			out.println("<script>alert('집전화가 비었습니다. 반드시 입력해주세요'); location.href='signForm';</script>");
			out.flush();
			out.close();
		}
		
		String phone3=req.getParameter("phone3");
		if(phone3=="") {
			sw1=0;
			out.println("<script>alert('집전화가 비었습니다. 반드시 입력해주세요'); location.href='signForm';</script>");
			out.flush();
			out.close();
		}
		
		String phone4=req.getParameter("phone4");
		if(phone4=="") {
			sw1=0;
			out.println("<script>alert('집전화가 비었습니다. 반드시 입력해주세요'); location.href='signForm';</script>");
			out.flush();
			out.close();
		}
		
		String phone5=req.getParameter("phone5");
		if(phone5=="") {
			sw1=0;
			out.println("<script>alert('집전화가 비었습니다. 반드시 입력해주세요'); location.href='signForm';</script>");
			out.flush();
			out.close();
		}
		
		String phone6=req.getParameter("phone6");
		if(phone6=="") {
			sw1=0;
			out.println("<script>alert('집전화가 비었습니다. 반드시 입력해주세요'); location.href='signForm';</script>");
			out.flush();
			out.close();
		}
		
		String zipCode=req.getParameter("zipCode");
		if(zipCode=="") {
			sw1=0;
			out.println("<script>alert('집전화가 비었습니다. 반드시 입력해주세요'); location.href='signForm';</script>");
			out.flush();
			out.close();
		}
		
		String address1=req.getParameter("address1");
		if(address1=="") {
			sw1=0;
			out.println("<script>alert('주소가 비었습니다. 반드시 입력해주세요'); location.href='signForm';</script>");
			out.flush();
			out.close();
		}
		
		String address2=req.getParameter("address2");
		if(address2=="") {
			sw1=0;
			out.println("<script>alert('주소가 비었습니다. 반드시 입력해주세요'); location.href='signForm';</script>");
			out.flush();
			out.close();
		}
		
		
		if(sw1==1) {
			SignDto sign = new SignDto(0,memberId,password,name,nickName,sex,birthYear,birthMonth,birthDay,phone1,phone2,phone3,phone4,phone5,phone6,zipCode,address1,address2,null,"상태메시지입니다");
			SignDao dao = new SignDao();
			int insertCount = dao.addMember(sign);
			System.out.println(insertCount);
			resp.sendRedirect("/runeah/");
		}
		
		
	}
}
