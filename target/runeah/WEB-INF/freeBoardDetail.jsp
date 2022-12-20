<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.lang.*,com.toy.runeah.simpleWebServlet.dto.BoardDto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판상세보기에오!</title>
<style>
	ul, li {
		list-style : none;
		padding : 0;
	}
	li {
		float : left;
		width : 150px;
	}
	#header {
		border : 2px solid black;
		height : 30px;
		width : 100%
	}
	.freeBoardFrame {
		height : 30px;
		width : 100%
		border-bottom : 2px solid black;
	}
</style>
</head>
<body>
		<ul id="header">
			<li>글번호</li>
			<li>회원번호</li>
			<li>별명</li>
			<li>제목</li>
			<li>등록일</li>
			<li>수정일</li>
			<li>첨부파일URL</li>
			<li>내용</li>
			<li>조회수</li>
			<li>좋아요</li>
		</ul>
		<br>
		<%
			BoardDto list = (BoardDto)request.getAttribute("list");
			out.print("<ul class='freeBoardFrame'>");
			out.print("<li class='eachFreeBoard'>");
				out.print(list.getBoardNo());
			out.print("</li>");
			out.print("<li class='eachFreeBoard'>");
				out.print(list.getMemberNo());
			out.print("</li>");
			out.print("<li class='eachFreeBoard'>");
					out.print(list.getNickName());
			out.print("</li>");
			out.print("<li class='eachFreeBoard'>");
				out.print(list.getTitle());
			out.print("</li>");
			out.print("<li class='eachFreeBoard'>");
				out.print(list.getRegDate());
			out.print("</li>");
			out.print("<li class='eachFreeBoard'>");
				out.print(list.getModDate());
			out.print("</li>");
			out.print("<li class='eachFreeBoard'>");
				out.print(list.getAttachedImageURL());
			out.print("</li>");
			out.print("<li class='eachFreeBoard'>");
				out.print(list.getContent());
			out.print("</li>");
			out.print("<li class='eachFreeBoard'>");
				out.print(list.getViewCount());
			out.print("</li>");
			out.print("<li class='eachFreeBoard'>");
				out.print(list.getThumbUpCount());
			out.print("</li>");
		out.print("</ul>");
		%>
</body>
</html>