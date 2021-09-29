<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	  <h1>관리자 글쓰기</h1>
    <hr>

    <form action="testUpload" name="testUpload" method="post" enctype="multipart/form-data">
      <table>
        <colgroup>
          <col width="15%">
          <col width="85%">
        </colgroup>
        <tr>
          <th>작성자</th>
          <td>
            <input type="text" name="bname">
          </td>
        </tr>
       
        <tr>
          <th>이미지 등록1</th>
          <td>
            <input type="file" name="files" id="files">
          </td>
        </tr>
        <tr>
          <th>이미지 등록2</th>
          <td>
            <input type="file" name="files" id="files">
          </td>
        </tr>
        <tr>
          <th>이미지 등록3</th>
          <td>
            <input multiple="multiple" type="file" name="file" />

          </td>
        </tr>
      </table>
      <hr>
      <div class="button-wrapper">
        <button type="submit" class="write">작성완료</button>
        <button type="button" class="cancel" onclick="javascript:location.href='boardList?page=${param.page}'">취소</button>
      </div>
    </form>
	
	</body>
</html>