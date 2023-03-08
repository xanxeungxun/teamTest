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
		
		
		<div class="comment" style="width: 80%; margin: 0 auto;">
		
		<%if(loginUser != null) {%>
			<div class="input-comment">
				<span class="material-icons">account_box</span>
				<form action="/insertStoryComment.do?bookNo=<%=b.getBookNo() %>&storyNo=<%=s.getStoryNo() %>" method="post" style="display: flex;">
					<div style="width: 90%;">
					<input type="hidden" name="userId" value="<%=loginUser.getUserId()%>">
						<textarea name="commentCnt" class="input-form" style="min-height: 85px;"
						placeholder="친절한 코멘트는 작가에게 큰 힘이 됩니다"></textarea>
					</div>
					<div style="width: 20%;">
						<button class="btn bc4" style="width:100%; height: 100%; cursor: pointer;">등록</button>
					</div>
				</form>			
			</div>
		<%}%>
			<div class="comment-list">
				
				<ul class="posting-comment">
		                <li>
		                  <span class="material-icons">account_circle</span>
		                </li>
		                <li>
		                  <p class="comment-info">
		                    <span style="font-size:16px;">작성자</span>
		                    <span class="comment-link">
		                    	<%if(loginUser != null && loginUser.getUserId().equals("댓글쓴이")){%>
		                        <a href="javascript:void(0)" onclick="modifyComment(this,코멘트번호,보드번호)">수정</a>
		                        <a type="button" href="javascript:void(0)" onclick="deleteComment(this,코멘트번호,보드번호)">삭제</a>
		                        <%} %>
		                    </span>
		                  </p>
		                  <p class="comment-date">
		                      <span>작성날짜</span>
		                  </p>
		                  <p class="comment-content show-content" style="font-size:16px;">코멘트내용</p>
		                  <textarea name="boardCommentContent" class="input-form hide-textarea" style="min-height:96px;display:none;">코멘트내용..?</textarea>
		                  <%if(loginUser!=null) {%>
		                  <a href="javascript:void(0)" class="recShow"><span class="material-symbols-outlined">sms</span></a>
		                  <%} %>
		                </li>
		         </ul>
		         
		         
		         <%if(loginUser != null) {%>
						<div class="inputCommentBox inputRecommentBox">
							<form action="/insertBoardComment.do" method="post">
								<ul style="list-style: none;">
									<li>
										<span class="material-icons">subdirectory_arrow_right</span>
									</li>
									<li>
										<input type="hidden" name="boardCommentWriter" value="로그인유저아이디"> 
										<input type="hidden" name="boardRef" value="작품번호">
										<input type="hidden" name="boardCommentRef" value="코멘트번호">
										<textarea name="boardCommentContent" class="input-form"></textarea>
									</li>
									<li>
										<button type="submit" class="btn bc4 bs4" style="font-size: 16px;">등록</button>
									</li>
								</ul>
							</form>
						</div>					
				 <%} %>
				 
				 <ul class="posting-comment reply">
		                <li>
		                  <span class="material-icons">account_circle</span>
		                </li>
		                <li>
		                  <p class="comment-info">
		                      <span style="font-size:16px;">대댓글작성자</span>
		                      <span class="comment-link" style="font-size:16px;">
		                      	  <%if(loginUser != null && loginUser.getUserId().equals("댓글작성자")) {%>
		                          <a href="javascript:void(0)" onclick="modifyComment(this,코멘트번호,작품번호)">수정</a>
		                          <a href="javascript:void(0)" onclick="deleteComment(this,코멘트번호,작품번호)">삭제</a>
		                          <%} %>
		                      </span>
		                    </p>
		                    <p class="comment-date">
		                        <span>대댓글작성일</span>
		                    </p>
		                  <p class="comment-content show-content" style="font-size:16px;">대댓글내용</p>
		                  <textarea name="boardCommentContent" class="input-form hide-textarea" style="min-height:96px;display:none;">대댓글수정창쓰</textarea>
		                </li>
		          </ul>
				
				
			</div>
		</div><!-- comment -->
		
	</div><!-- page-content -->
	
	
	<script>
	
	$(".recShow>span").on("click",function(){
		const idx = $(".recShow>span").index(this);
		if($(this).text()=="sms"){
			$(this).text("close");
		}else{
			$(this).text("sms");
		}
		$(".inputRecommentBox").eq(idx).toggle();
		$(".inputRecommentBox").eq(idx).find("textarea").focus();
	});
	
	function modifyComment(obj, boardCommentNo, boardNo){
		//숨겨놓은 textarea를 화면에 보여줌
		$(".hide-textarea").show();
		//화면에 있던 댓글내용(p태그)를 숨김
		$("show-content").hide();
		//수정 -> 수정완료
		$(obj).text("수정완료");
		$(obj).attr("onclick","modifyComplete(this,"+boardCommentNo+","+boardNo+")");
		//삭제 -> 수정취소
		$(obj).next().text("수정취소");
		$(obj).next().attr("onclick","modifyCancel(this,"+boardCommentNo+","+boardNo+")");
		//답글달기버튼 삭제
		$(obj).next().next().hide();
	}
	
	function modifyCancel(obj,boardCommentNo, boardNo){
		$(".hide-textarea").hide();
		$("show-content").show();
		//수정완료 -> 수정
		$(obj).prev().text("수정");
		$(obj).prev().attr("onclick","modifyComment(this,"+boardCommentNo+","+boardNo+")");
		//수정취소 -> 삭제
		$(obj).text("삭제");
		$(obj).attr("onclick","deleteComment(this,"+boardCommentNo+","+boardNo+")");
		//답글달기 버튼 다시 보여줌
		$(obj).next().show();
	}
	
	
	</script>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>