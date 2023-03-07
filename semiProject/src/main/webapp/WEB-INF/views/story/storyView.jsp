<%@page import="com.iei.book.model.vo.Book"%>
<%@page import="com.iei.story.model.vo.Story"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    Book b = (Book)request.getAttribute("b");
    Story s = (Story)request.getAttribute("s");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<title><%=s.getStoryName() %></title>
<link rel="stylesheet" href="/css/storyView.css">

</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<div class="page-content" style="margin-top:10px;" >
        
        <div class="story-wrap">
       		
       		<div class="story-header">
       			<div class="book-and-story">
       				<div class="book-title">
       					<%=b.getBookTitle() %>
       				</div>
       				<div class="story-name">
       					<%=s.getStoryName() %>
       				</div>
       			</div>
       		</div>
       		
			<div class="story-content">
			<%
			if(loginUser!=null && loginUser.getUserId().equals(b.getBookWriterId())){
			%>
				<div class="author-zone" style="position:relative;">
					<a href="#" style="font-weight: bold; display:flex; position: absolute; right:0; line-height: 26px;">
						<span class="material-symbols-outlined">
						auto_fix
						</span>
						작품 수정하기
					</a>
				</div>
			<%
			}
			%>	
				<div class="text" style="padding: 100px 0 50px 0;">
					<%=s.getStoryContent()%>
				</div>
				
				
				<div class="story-after">
					<div class="after-title">
						작가 후기
					</div>
					<div class="after-content">
						<%=s.getStoryAfter() %>
					</div>
				</div>
				
				
			</div><!-- story-content -->
			
			
		</div><!-- story-wrap -->
		
		
		<div class="comment">
			<div class="input-comment" style="width: 80%; margin: 0 auto;">
				<span class="material-icons">account_box</span>
				<form action="" method="post" style="display: flex;">
					<div style="width: 90%;">
						<textarea name="commentCnt" class="input-form" style="min-height: 85px;"
						placeholder="친절한 코멘트는 작가에게 큰 힘이 됩니다"></textarea>
					</div>
					<div style="width: 20%;">
						<button class="btn bc4" style="width:100%; height: 100%; cursor: pointer;">등록</button>
					</div>
				</form>			
			</div>
			<div class="comment-list">
				
			</div>
		</div><!-- comment -->
		
	</div><!-- page-content -->

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>