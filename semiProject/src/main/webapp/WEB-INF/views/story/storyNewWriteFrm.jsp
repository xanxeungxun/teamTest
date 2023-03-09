<%@page import="com.iei.story.model.vo.Story"%>
<%@page import="com.iei.book.model.vo.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	int bookNo = (int)request.getAttribute("bookNo");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<link rel="stylesheet" href="/css/bookWriteFrm.css">
<link rel = "stylesheet" href="/summernote/summernote-lite.css">

</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<script src="/summernote/summernote-lite.js"></script>
<script src="/summernote/lang/summernote-ko-KR.js"></script>

<div class="page-content">
	<div class="book-wrap">
	
		<div class="book-list-header">
	          <div>작품 등록하기</div>
	    </div><!-- book-list-header -->
	    
	    
	    <div class="book-content-box">
	    
		    <form action="/storyNewWrite.do" method="post">
		    <input type="hidden" name="bookNo" value="<%=bookNo%>">
			   		<table class="board-write-frm tbl" id="boardWriteFrm2">
			   			<tr class="tr-1">
			   				<th>스토리 제목</th>
			   				<td>
			   					<input type="text" name="storyName" class="input-form" placeholder="스토리 제목을 입력하세요. 예) 에브리 유니버스">
			   				</td>
			   			</tr>
			   			<tr class="tr-1">
			   				<th colspan="2" style="text-align: left; padding-left: 27px;">내용</th>
			   			</tr>
			   			<tr class="tr-1">
			   				<td colspan="2" style="text-align: left;">
			   					<textarea name="storyContent" id="storyContent" class="input-form"></textarea>
			   				</td>
			   			</tr>
			   			<tr class="tr-1">
			   				<th>작가후기</th>
			   				<td>
			   					<textarea cols="30" rows="3" name="storyAfter" class="input-form" placeholder="작품의 전체 내용을 간단하게 소개해주세요."></textarea>
			   				</td>
			   			</tr>
			   			<tr class="tr-1">
			   				<td colspan="2">
			   					<button id="submit" class="btn bc4" style="margin-top: 30px;">글쓰기</button>
			   				</td>
			   			</tr>
			   		</table>
		   	</form>
	    
	    </div><!-- book-content-box -->
	    
	    
	</div><!-- book-wrap -->
</div><!-- page-content -->


<script>

	$("#storyContent").summernote({
	    height : 400,
	    lang : "ko-KR"
	})
	
</script>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>