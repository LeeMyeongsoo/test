<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>뷰페이지</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/read.css">
  <style type="text/css">
     .list{cursor: pointer; }
  </style>
  <script type="text/javascript">
    function boardDelete(){
    	if(confirm("삭제하시겠습니까?")){
    		location.href="boardDelete?bid="+${boardVo.bid}+"&page="+${page};
    	}
    }
  </script>
</head>
<body>
<section>
    <h1>NOTICE</h1>

    <table>
      <colgroup>
        <col width="80%">
        <col width="10%">
        <col width="10%">
        
      </colgroup>
      <tr>
        <th colspan="3">제목</th>
      </tr>
      <tr>
        <td colspan="3"><strong>${boardVo.btitle }</strong></td>
      </tr>
      <tr>
        <td>${boardVo.bname }</td>
        <td>조회수</td>
        <td>${boardVo.bhit }</td>
      </tr>
      <tr>
        <td colspan="3" class="article">${boardVo.bcontent }</td>
      </tr>
      <tr>
        <td colspan="3" class="article"><img src="/upload/${boardVo.bupload}"></td>
      </tr>
      <tr>
        <td colspan="3" class="article"><strong>다운로드 | </strong><a href="/upload/${boardVo.bupload}">이미지다운로드</a></td>
      </tr>
      <tr>
        <td colspan="3"><strong>다음글</strong> <span class="separator">|</span><a href="boardView?bid=${boardVoPre.bid}">${boardVoNext.btitle}</a></td>
      </tr>
      <tr>
        <td colspan="3"><strong>이전글</strong> <span class="separator">|</span><a href="boardView?bid=${boardVoNext.bid}"> ${boardVoNext.btitle}</a></td>
      </tr>
    </table>

    <a href="boardList?page=${page}"><div class="list">목록</div></a>
    <div class="list" onclick="boardDelete()">삭제</div>
    <a href="boardModify?bid=${boardVo.bid}&page=${page}"><div class="list">수정</div></a>
    <a href="boardReply?bid=${boardVo.bid}&page=${page}"><div class="list">답변달기</div></a>
  </section>
</body>
</html>