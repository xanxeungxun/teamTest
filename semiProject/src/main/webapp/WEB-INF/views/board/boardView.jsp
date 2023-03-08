<%@page import="com.iei.board.model.vo.BoardComment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.iei.board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Board b = (Board)request.getAttribute("b");
    	ArrayList<BoardComment> commentList = (ArrayList<BoardComment>)request.getAttribute("commentList");
    	ArrayList<BoardComment> reCommentList = (ArrayList<BoardComment>)request.getAttribute("reCommentList");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/board.css">
<style>
	.inputRecommentBox{
		margin: 30px 0px;
		display: none;
	}
	.board-td{
		height: 80px;
	}
	.file-td{
	width: 10%;
	height: 30px;
	}
	.file2-td{
		width: 90%;
		height: 30px;
	}
	.boardContentDiv{
		min-height: 400px;
	}
	.report-a{
		float: right;
		margin-right: 50px;
	}
	.textarea .input-from{
		resize: none;
	}
	.input-form{
	    width: 100%;
	    height: 50px;
	    display: block;
	    padding: 0.8rem;
	    background-color: #fff;
	    outline: none;
	    border: 1px solid #ccc;
	    border-radius: 4px;
	    box-sizing: border-box;
	}
	.book-img{
        width: 80px;
        height: 80px;
        background-color: #fff;
        border : 1px solid #EEEEEE;
        border-radius: 60px;
    }
    .comment-ul{
    	display: flex;
   		list-style-type: none;
    	margin-top: 50px;
    	margin-bottom: 50px;
    }
    textarea.input-form {
	    resize: none;
	    min-height: 100px;
	    width: 1000px;
	}
	.btn{
		width: 100px;
		height: 100px;
	}
	
	
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
		<div class="page-content">
			<div class="board-wrap">
				<div class="board-header">
				<span>자유게시판</span>
				<%if(loginUser!=null && loginUser.getUserId().equals(b.getBoardWriter())) {%>
				<button class="news-btn btn1" onclick="boardDelete(<%=b.getBoardNo()%>);">삭제</button>
				<a class="news-btn btn1" href="/boardUpdateFrm.do?boardNo=<%=b.getBoardNo() %>">수정</a>
				<%} %>
				</div>
				<table class="board-tbl">
					<tr class="board-tr">
						<td class="board-td" colspan="2">
						<input type="hidden" name="boardNo" value="<%=b.getBoardNo() %>">
							<span class="title-span"><%=b.getBoardTitle() %></span>
							<div>
								<span class="date-span"><%=b.getboardDate() %></span>
								<%-- 신고 버튼 --%>
								<a href="/report/reportWriteFrm.do?boardNo=<%=b.getBoardNo() %>" class="report-a">
									<span class="report material-symbols-outlined" style="font-size:24px;">e911_emergency</span>
								</a>
							</div>
						</td>
					</tr>
					<%if(b.getFileName() != null) {%>
						<tr class="board-tr">
							<th class="board-td file-td">첨부파일</th>
							<td class="board-td file2-td">
								<img src="/img/file.png" width="16px">
								<a href="/boardFileDown.do?boardNo=<%=b.getBoardNo()%>">
									<%=b.getFileName() %>
								</a>
							</td>
						</tr>
					<%} %>
					<tr class="board-tr">
						<td class="board-td" colspan="2">
							<div class="boardContentDiv"><%=b.getBoardContent() %></div>
						</td>					
						<a class="news-btn btn1" id="list-btn" href="/boardList.do?reqPage=1">목록보기</a>
					</tr>
				</table>
				
				
				
				
				<%--로그인 되어있는 경우에만 댓글 작성 화면을 띄움--%>
				<%if(loginUser != null) {%>
				<div class="inputCommentBox">
					<form action="/insertBoardComment.do" method="post">
						<ul class="comment-ul">
							<li>
								<span class="material-icons" style="font-size:100px;">account_box</span>
							</li>
							<li>
								<input type="hidden" name="boardCommentWriter" value="<%=loginUser.getUserId() %>">
								<input type="hidden" name="boardRef" value="<%=b.getBoardNo() %>">
								<input type="hidden" name="boardCommentRef" value="0">
								<textarea name="boardCommentContent" class="input-form" placeholder="댓글을 입력해주세요"></textarea>
							</li>
							<li>
								<button type="submit" class="btn bc1 bs2">등록</button>
							</li>
						</ul>
					</form>
				</div>
				<%} %>
				
				<div>
				<%for(BoardComment bc : commentList) {%>
		            <ul class="posting-comment">
		                <li>
		                  	<%if(bc.getFilePath()==null){ %>
								<div class="material-icons">account_circle</div>
							<%} else { %>
								<div style="background-image: url(/upload/profile/<%=bc.getFilePath()%>); background-size: contain; background-position: center;  background-repeat: no-repeat;" id="previewImg" class="book-img"></div>
							<%} %>
		                </li>
		                <li>
		                  <p class="comment-info">
		                    <span><%=bc.getBoardCommnetWriter() %></span>
		                    <span class="comment-link">
		                    	<%if(loginUser != null && loginUser.getUserId().equals(bc.getBoardCommnetWriter())) {%>
		                        <a href="javascript:void(0)" onclick="modifyComment(this,<%=bc.getBoardCommentNo()%>,<%=b.getBoardNo()%>)">수정</a>
		                        <a type="button" href="javascript:void(0)" onclick="deleteComment(this,<%=bc.getBoardCommentNo()%>,<%=b.getBoardNo()%>)">삭제</a>
		                        <%} %>
		                    </span>
		                  </p>
		                  <p class="comment-date">
		                      <span><%=bc.getBoardCommentDate() %></span>
		                  </p>
		                  <p class="comment-content show-content"><%=bc.getBoardCommentContent() %></p>
		                  <%if(loginUser!=null) {%>
		                  <a href="javascript:void(0)" class="recShow"><span class="material-symbols-outlined">sms</span></a>
		                  <%} %>
		                  <textarea name="boardCommentContent" class="input-form hide-textarea" style="min-height:96px;display:none;"><%=bc.getBoardCommentContent() %></textarea>
		                </li>
		              </ul>
		              
		             <%for(BoardComment bcc : reCommentList) {%>
		             	<%if(bcc.getBoardCommentRef()==bc.getBoardCommentNo()) {%>
		              <ul class="posting-comment reply">
		                <li>
		                  	<%if(bcc.getFilePath()==null){ %>
								<div class="material-icons">account_circle</div>
							<%} else { %>
								<div style="background-image: url(/upload/profile/<%=bcc.getFilePath()%>); background-size: contain; background-position: center;  background-repeat: no-repeat;" id="previewImg" class="book-img"></div>
							<%} %>
		                </li>
		                <li>
		                  	<p class="comment-info">
		                      <span><%=bcc.getBoardCommnetWriter() %></span>
		                      <span class="comment-link">
		                      	  <%if(loginUser != null && loginUser.getUserId().equals(bcc.getBoardCommnetWriter())) {%>
		                          <a href="javascript:void(0)" onclick="modifyComment(this,<%=bcc.getBoardCommentNo()%>,<%=b.getBoardNo()%>)">수정</a>
		                          <a href="javascript:void(0)" onclick="deleteComment(this,<%=bcc.getBoardCommentNo()%>,<%=b.getBoardNo()%>)">삭제</a>
		                          <%} %>
		                      </span>
		                    </p>
		                    <p class="comment-date">
		                        <span><%=bcc.getBoardCommentDate() %></span>
		                    </p>
		                  <p class="comment-content show-content"><%=bcc.getBoardCommentContent() %></p>
		                  <textarea name="boardCommentContent" class="input-form hide-textarea" style="min-height:96px;display:none;"><%=bcc.getBoardCommentContent() %></textarea>
		                </li>
		              </ul>
		              <%} %>
	              <%} %>
        		
				 
				
					
					
					<%if(loginUser != null) {%>
						<div class="inputCommentBox inputRecommentBox">
							<form action="/insertBoardComment.do" method="post">
								<ul class="comment-ul">
									<li>
										<span class="material-icons" style="font-size:100px;">subdirectory_arrow_right</span>
									</li>
									<li>
										<input type="hidden" name="boardCommentWriter" value="<%=loginUser.getUserId() %>"> 
										<input type="hidden" name="boardRef" value="<%=b.getBoardNo() %>">
										<input type="hidden" name="boardCommentRef" value="<%=bc.getBoardCommentNo() %>">
										<textarea name="boardCommentContent" class="input-form" style="min-height: 100px;" placeholder="댓글을 입력해주세요"></textarea>
									</li>
									<li>
										<button type="submit" class="btn bc1 bs2">등록</button>
									</li>
								</ul>
							</form>
						</div>					
				 	<%} %>
				<%}//댓글 출력 for문 끝나는 위치 %>
				</div>
			</div>
      			
		</div>
		
		<script>
		function boardDelete(boardNo) {
			if(confirm("게시글을 삭제하시겠습니까?")){
				location.href="/deleteBoard.do?boardNo="+boardNo;
			}
		}
		
		
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
			$(obj).parents("li").eq(0).find("textarea").show();
			//화면에 있던 댓글내용(p태그)를 숨김
			$(obj).parent().next().next().hide();
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
		function modifyComplete(obj,boardCommentNo, boardNo){
			//form태그를 생성해서 전송
			//댓글내용, 댓글번호, 공지사항번호
			//1. form태그 생성
			const form=$("<form style='display:none;' action='/updateBoardComment.do' method='post'></form>");
			//2. input태그 2개 숨김
			const boardCommentNoInput = $("<input type='text' name='boardCommentNo'>");
			boardCommentNoInput.val(boardCommentNo);
			const boardNoInput = $("<input type='text' name='boardNo'>");
			boardNoInput.val(boardNo);
			//3. textarea
			const boardCommentContent = $(obj).parents("li").eq(0).find("textarea").clone();
			//4. form태그에 input, textarea를 모두 포함
			form.append(boardCommentNoInput).append(boardNoInput).append(boardCommentContent);
			//5. 생성된 form태그를 body태그에 추가
			$("body").append(form);
			//form태그를 전송
			form.submit();
		}
		function deleteComment(obj,boardCommentNo,boardNo){
			if(confirm("댓글을 삭제하시겠습니까?")){
				location.href="/deleteBoardComment.do?boardCommentNo="+boardCommentNo+"&boardNo="+boardNo;
			}
		}
		</script>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>