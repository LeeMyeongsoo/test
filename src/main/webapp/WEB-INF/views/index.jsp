<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
	<html>
		<head>
		<meta charset="UTF-8">
		<title>메인페이지</title>
		
	</head>
	<body>
	  <h2>메인페이지</h2>
	  <c:if test="${session_flag != 'success' }">
		  <h3>로그인을 해주시기 바랍니다.</h3>
		  <ul>
		    <li><a href="/member/login">로그인</a></li>
		    <li><a href="memberJoin">회원가입</a></li>
		  </ul>
	  </c:if>
	  <c:if test="${session_flag == 'success' }">
		  <h3>${session_nickname }님 환영합니다.</h3>
		  <ul>
		    <li><a href="/member/logout">로그아웃</a></li>
		    <li><a href="memberList">회원리스트</a></li>
		    <li><a href="memberModify">회원정보수정</a></li>
		    <li><a href="/board/boardList">게시판</a></li>
		    <li><a href="/event/event">이벤트</a></li>
		  </ul>
	  </c:if>
	
	</body>
</html>