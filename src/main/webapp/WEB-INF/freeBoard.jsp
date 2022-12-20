<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.lang.*,com.toy.runeah.simpleWebServlet.dto.BoardDto,com.toy.runeah.simpleWebServlet.dao.FreeBoardDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판이에오!</title>
<style>
	ul, li {
		list-style : none;
		padding : 0;
	}
	li {
		float : left;
		margin : 0px 15px 0px 15px;
		width : 150px;
	}
	#header {
		border : 2px solid black;
		height : 30px;
		width : 1080px;
	}
	.freeBoardFrame {
		height : 30px;
		width : 1080px;
		border-bottom : 2px solid black;
	}
</style>
</head>
<body>
		<ul id="header">
			<li>글번호</li>
			<li>별명</li>
			<li>제목</li>
			<li>등록일</li>
			<li>조회수</li>
			<li>좋아요</li>
		</ul>
		<br>
		<%
			List<BoardDto> list = (List<BoardDto>)request.getAttribute("list");
			for(int i=0;i<list.size();i++) {
				
				BoardDto eachBoard = (BoardDto)list.get(i);
				
				int boardNo=eachBoard.getBoardNo();
				String nickName=eachBoard.getNickName();
				String title=eachBoard.getTitle();
				Date regDate=eachBoard.getRegDate();
				int viewCount = eachBoard.getViewCount();
				int thumbUpCount = eachBoard.getThumbUpCount();
				
				String boardDetailURL="/runeah/freeBoardDetail?boardNo='"+boardNo+"'";
				out.print("<ul class='freeBoardFrame'>");
					out.print("<li class='eachFreeBoard'>");
						out.print(boardNo);
					out.print("</li>");
					out.print("<li class='eachFreeBoard'>");
						out.print(nickName);
					out.print("</li>");
					out.print("<li class='eachFreeBoard'>");
						out.print("<a href="+ boardDetailURL +">");
							out.print(title);
						out.print("</a>");
					out.print("</li>");
					out.print("<li class='eachFreeBoard'>");
						out.print(regDate);
					out.print("</li>");
					out.print("<li class='eachFreeBoard'>");
						out.print(viewCount);
					out.print("</li>");
					out.print("<li class='eachFreeBoard'>");
						out.print(thumbUpCount);
					out.print("</li>");
				out.print("</ul>");
			}
		%>
		<br>
		<a href="/runeah/freeBoardRegistForm">글쓰기</a>
</body>
</html>