<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.lang.*,com.toy.runeah.simpleWebServlet.dto.BResult,com.toy.runeah.simpleWebServlet.dao.MainDao"%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link rel="stylesheet" href="/css/style.css"/>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.js"></script>
<script src="/js/home.js"></script>
<body>
	<h2>Start!</h2>
	<div id="todopart">
		<%
		String list = (String)request.getAttribute("list");
		out.print(
				"<article class='object'>"+
				list
				);
		out.print("</article>");
		%>
		</div>
</body>
</html>