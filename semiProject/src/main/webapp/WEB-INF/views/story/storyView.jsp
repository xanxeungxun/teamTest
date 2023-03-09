<%@page import="com.iei.story.model.vo.StoryComment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.iei.book.model.vo.Book"%>
<%@page import="com.iei.story.model.vo.Story"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    Book b = (Book)request.getAttribute("b");
    Story s = (Story)request.getAttribute("s");
    ArrayList<StoryComment> cl = (ArrayList<StoryComment>)request.getAttribute("cl");
    ArrayList<StoryComment> ccl = (ArrayList<StoryComment>)request.getAttribute("ccl");
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
					<a href="/storyWriteFrm.do?bookNo=<%=s.getBookNo()%>&storyNo=<%=s.getStoryNo()%>" style="font-weight: bold; display:flex; position: absolute; right:0; line-height: 26px;">
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
		<form action="/insertStoryComment.do" method="post">
			<span class="material-icons">account_box</span>
			<div class="input-comment" style="display: flex;">
					<div style="width: 90%;">
					<input type="hidden" name="bookNo" value="<%=b.getBookNo()%>">
					<input type="hidden" name="storyNo" value="<%=s.getStoryNo()%>">
					<input type="hidden" name="userId" value="<%=loginUser.getUserId()%>">
						<textarea name="commentCnt" class="input-form" style="min-height: 85px;"
						placeholder="친절한 코멘트는 작가에게 큰 힘이 됩니다"></textarea>
					</div>
					<div style="width: 20%;">
						<button id="cmtBtn" class="btn bc4" style="width:100%; height: 100%; cursor: pointer;">등록</button>
					</div>
			</div>
		</form>
		<%}%>
			<div class="comment-list">
				<%for(StoryComment c : cl){ 
					if(c.getStoryCommentRef()==0){
				%>
					<ul class="posting-comment">
			                <li>
			                  <%if(c.getFilePath()==null){ %>
								<div class="material-icons">account_circle</div>
							  <%} else { %>
								<div style="background-image: url(/upload/profile/<%=c.getFilePath()%>); background-size: contain; background-position: center;  background-repeat: no-repeat; height: 80px; width: 80px;" id="previewImg" class="book-img"></div>
							  <%} %>
			                </li>
			                <li>
			                  <p class="comment-info">
			                    <span style="font-size:16px;"><%=c.getUserId() %></span>
			                    <span class="comment-link">
			                    <%	if(loginUser != null && loginUser.getUserId().equals(c.getUserId())){ %>
			                        <a href="javascript:void(0)" onclick="modifyComment(this,<%=c.getStoryCommentNo() %>,<%=s.getStoryNo()%>,<%=b.getBookNo()%>)">수정</a>
			                        <a type="button" href="javascript:void(0)" onclick="deleteComment(this,<%=c.getStoryCommentNo() %>,<%=s.getStoryNo()%>,<%=b.getBookNo()%>)">삭제</a>
			                     <% } %> 
			                    </span>
			                  </p>
			                  <p class="comment-date">
			                      <span><%=c.getCommentDate()%></span>
			                  </p>
			                  <p class="comment-content show-content" style="font-size:16px;"><%=c.getStoryCommentContent()%></p>
			                  <textarea name="storyCommentContent" class="input-form hide-textarea" style="min-height:96px;display:none;"><%=c.getStoryCommentContent()%></textarea>
			                  <% if(loginUser!=null) { %>
			                  	<a href="javascript:void(0)" class="recShow"><span class="material-symbols-outlined">sms</span></a>
			                  <% } %>
			                </li>
		         	</ul>
		         	
		         	<%for(StoryComment cc : ccl){ 
		         		if(cc.getStoryCommentRef()==c.getStoryCommentNo()){
		         	%>
			         	<ul class="posting-comment reply">
			                <li>
			                  <%if(cc.getFilePath()==null){ %>
								<div class="material-icons">account_circle</div>
							  <%} else { %>
								<div style="background-image: url(/upload/profile/<%=cc.getFilePath()%>); background-size: contain; background-position: center;  background-repeat: no-repeat; height: 80px; width: 80px;" id="previewImg" class="book-img"></div>
							  <%} %>
			                </li>
			                <li>
			                  <p class="comment-info">
			                      <span style="font-size:16px;"><%=cc.getUserId() %></span>
			                      <span class="comment-link" style="font-size:16px;">
			                      	  <%if(loginUser != null && loginUser.getUserId().equals(cc.getUserId())) {%>
			                          <a href="javascript:void(0)" onclick="modifyComment(this,<%=cc.getStoryCommentNo() %>,<%=s.getStoryNo()%>,<%=b.getBookNo()%>)">수정</a>
			                          <a href="javascript:void(0)" onclick="deleteComment(this,<%=cc.getStoryCommentNo() %>,<%=s.getStoryNo()%>,<%=b.getBookNo()%>)">삭제</a>
			                          <%} %>
			                      </span>
			                    </p>
			                    <p class="comment-date">
			                        <span><%=cc.getCommentDate()%></span>
			                    </p>
			                  <p class="comment-content show-content" style="font-size:16px;"><%=cc.getStoryCommentContent()%></p>
			                  <textarea name="boardCommentContent" class="input-form hide-textarea" style="min-height:96px;display:none;"><%=cc.getStoryCommentContent()%></textarea>
			                </li>
			          	</ul>
		         	<%
		         		}
		         	} %> <!-- 대댓글 출력 -->
		         	
		         	<%if(loginUser != null) {%>
					<div class="inputCommentBox inputRecommentBox">
						<form action="/insertStoryReComment.do" method="post">
							<input type="hidden" name="commentRef" value="<%=c.getStoryCommentNo()%>">
							<div class="input-comment" style="display: flex;">
									<div style="width: 90%;">
									<input type="hidden" name="bookNo" value="<%=b.getBookNo()%>">
									<input type="hidden" name="storyNo" value="<%=s.getStoryNo()%>">
									<input type="hidden" name="userId" value="<%=loginUser.getUserId()%>">
										<textarea name="commentCnt" class="input-form" style="min-height: 85px;"
										placeholder="바르고 고운말을 사용합시다 :)"></textarea>
									</div>
									<div style="width: 20%;">
										<button id="cmtBtn" class="btn bc4" style="width:100%; height: 100%; cursor: pointer;">등록</button>
									</div>
							</div>
						</form>	
					</div>			
				 	<%} %><!-- 답답글 다는 창 -->
				 	
		         <%}
				
				} %><!-- 댓글 출력 for문 끝나는 위치 -->
		         
		         
				 
				 
				
				
			</div>
		</div><!-- comment -->
		
	</div><!-- page-content -->
	
	
	<script>
	
	$(".inputRecommentBox").hide();
	
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
	
	
	function modifyComment(obj, storyCommentNo, storyNo, bookNo){
		//숨겨놓은 textarea를 화면에 보여줌
		$(obj).parents("p").siblings("textarea").show();
		//화면에 있던 댓글내용(p태그)를 숨김
		$(obj).parents("p").siblings(".comment-content").hide();
		//수정 -> 수정완료
		$(obj).text("수정완료");
		$(obj).attr("onclick","modifyComplete(this,"+storyCommentNo+","+storyNo+","+bookNo+")");
		
		//삭제 -> 수정취소
		$(obj).next().text("수정취소");
		$(obj).next().attr("onclick","modifyCancel(this,"+storyCommentNo+","+storyNo+","+bookNo+")");
		//답글달기버튼 삭제
		$(obj).parents("p").siblings("a").hide();
		
		$(obj).parent().css("width","115px");
	}
	
	function modifyCancel(obj,storyCommentNo, storyNo,bookNo){
		$(obj).parents("p").siblings("textarea").hide();
		$(obj).parents("p").siblings(".comment-content").show();
		//수정완료 -> 수정
		$(obj).prev().text("수정");
		$(obj).prev().attr("onclick","modifyComment(this,"+storyCommentNo+","+storyNo+","+bookNo+")");
		//수정취소 -> 삭제
		$(obj).text("삭제");
		$(obj).attr("onclick","deleteComment(this,"+storyCommentNo+","+storyNo+","+bookNo+")");
		//답글달기 버튼 다시 보여줌
		$(obj).parents("p").siblings("a").show();
		
		$(obj).parent().css("width","7%");
	}
	
	function modifyComplete(obj,storyCommentNo, storyNo, bookNo){
		//form태그를 생성해서 전송
		//댓글내용, 댓글번호, 공지사항번호
		
		//1. form태그 생성
		const form=$("<form style='display:none;' action='/updateStoryComment.do' method='post'></form>");
		//2. input태그 2개 숨김
		const storyCommentNoInput = $("<input type='text' name='storyCommentNo'>");
		storyCommentNoInput.val(storyCommentNo);
		const storyNoInput = $("<input type='text' name='storyNo'>");
		storyNoInput.val(storyNo);
		const bookNoInput = $("<input type='text' name='bookNo'>");
		bookNoInput.val(bookNo);
		//3. textarea
		const storyCommentContent = $(obj).parents("p").siblings("textarea").clone();
		//4. form태그에 input, textarea를 모두 포함
		form.append(storyCommentNoInput).append(storyNoInput).append(storyCommentContent).append(bookNoInput);
		//5. 생성된 form태그를 body태그에 추가
		$("body").append(form);
		//form태그를 전송
		form.submit();
	}
	
	function deleteComment(obj,storyCommentNo,storyNo,bookNo){
		if(confirm("댓글을 삭제하시겠습니까?")){
			location.href="/deleteStoryComment.do?storyCommentNo="+storyCommentNo+"&bookNo="+bookNo+"&storyNo="+storyNo;
		}
	}
	
	</script>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>