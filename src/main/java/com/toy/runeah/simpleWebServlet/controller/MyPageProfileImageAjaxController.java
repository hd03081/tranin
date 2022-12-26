package com.toy.runeah.simpleWebServlet.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.toy.runeah.simpleWebServlet.dao.FreeBoardRegistDao;
import com.toy.runeah.simpleWebServlet.dao.MyPageDao;
import com.toy.runeah.simpleWebServlet.dao.SignDao;
import com.toy.runeah.simpleWebServlet.dto.BoardDto;
import com.toy.runeah.simpleWebServlet.dto.SignDto;
import com.toy.runeah.simpleWebServlet.misc.UploadFileUtils;

@MultipartConfig(
		// location="/tmp",
		fileSizeThreshold=1024*1024,
		maxFileSize=1024*1024*10,
		maxRequestSize=1024*1024*10*10
)
@WebServlet("/profileUploadImageAjax")
public class MyPageProfileImageAjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public MyPageProfileImageAjaxController() {
        super();
    }
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		
		//System.out.println("Post Request!!");
		//System.out.println("파일"+req.getAttribute("file").toString());
		req.setCharacterEncoding("utf-8");
		
		// 실제 서블릿이 동작하는 서버 경로 (Not 개발 서버)
		//String realPath = req.getServletContext().getRealPath("/assets/image");
		String realPath = "c:\\upload";
		// form 태그 중 name="myPageProfileAttach" 인 요청 파트
		Part filePart = req.getPart("file");
		
		// 요청된 파트의 전송된 파일 이름
		String fileName = filePart.getSubmittedFileName();
		System.out.println(fileName);
		/*
		// 입력 스트림
		InputStream fis = filePart.getInputStream();
		
		// 실제 업로드 될 경로 + 파일명
		String filePath = realPath + File.separator + fileName;
		
		// 파일 출력 스트림 (저장)
		FileOutputStream fos = new FileOutputStream(filePath);
		
		// 1024byte 씩 버퍼에 담아 읽어오는 과정
		// write(buffer, offset, length); 를 통해 읽어온 만큼만 쓰는 방법
		byte[] buf = new byte[1024];
		int size = 0;
		while((size=fis.read(buf)) != -1)
			fos.write(buf, 0, size);
		fos.close();
		fis.close();
		*/
		try {
			//외부경로에 실제 파일저장
			String savedName = UploadFileUtils.uploadFile(realPath, fileName,filePart);
			//데이터베이스에 파일이름 저장
			MyPageDao dao = new MyPageDao();
			SignDto dto = null;
			dto = (SignDto) req.getSession().getAttribute("session_member");
			dao.modifyImageURL(savedName,dto.getMemberId());
			PrintWriter out = resp.getWriter();
			String filePath = realPath + savedName;
			System.out.println(filePath);
	        out.print(filePath);
	        out.flush();   
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
