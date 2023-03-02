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
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
		<div class="page-content">
			<div class="board-wrap">
				<div class="board-header">
				<span>자유게시판</span>
				<button class="news-btn btn1" onclick="boardDelete(<%=b.getBoardNo()%>);">삭제</button>
				<a class="news-btn btn1" href="/boardUpdateFrm.do?boardNo=<%=b.getBoardNo() %>">수정</a>
				</div>
				<table class="board-tbl">
					<tr class="board-tr">
						<td class="board-td" colspan="2">
						<input type="hidden" name="boardNo" value="<%=b.getBoardNo() %>">
							<span class="title-span"><%=b.getBoardTitle() %></span>
							<div><span class="date-span"><%=b.getboardDate() %></span></div>
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
							<div><%=b.getBoardContent() %></div>
						</td>					
					</tr>
				</table>
				
				
				<div class="commentBox">
				<%for(BoardComment bc : commentList) {%>
					<ul class="posting-comment">
						<li>
							<span class="material-icons">account_box</span>
						</li>
						<li>
							<p class="comment-info">
								<span><%=bc.getBoardCommnetWriter() %></span>
								<span><%=bc.getBoardCommentDate() %></span>
							</p>
							<p class="comment-content"><%=bc.getBoardCommentContent() %></p>
							<textarea name="boardCommentContent" class="input-form" style="min-height:96px;display:none;"><%=bc.getBoardCommentContent() %></textarea>
							<p class="comment-link">
							<%-- 	<%if(m != null) {%> --%>
								<%-- <%if(m.getMemberId().equals(nc.getNcWriter())) {%> --%>
										<a href="javascript:void(0)" onclick="modifyComment(this,<%=bc.getBoardCommentNo()%>,<%=b.getBoardNo()%>);">수정</a>
										<a href="javascript:void(0)" onclick="deleteComment(this,<%=bc.getBoardCommentNo()%>,<%=b.getBoardNo()%>);">삭제</a>
								<%-- 	<%}//해당 댓글 수정 조건(댓글작성자가 로그인한 회원인지 확인) %> --%>
									<a href="javascript:void(0)" class="recShow">답글달기</a>
							<%-- 	<%}//대댓글 달기 조건문(로그인체크) %> --%>
							</p>
						</li>
					</ul>
					<%for(BoardComment bcc : reCommentList) {%>
						<%if(bcc.getBoardCommentRef()==bc.getBoardCommentNo()) {%>
							<ul class="posting-comment reply">
								<li>
									<span class="material-icons">subdirectory_arrow_right</span>
									<span class="material-icons">account_box</span>
								</li>
								<li>
									<p class="comment-info">
										<span><%=bcc.getBoardCommnetWriter() %></span>
										<span><%=bcc.getBoardCommentDate() %></span>
									</p>
									<p class="comment-content"><%=bcc.getBoardCommentContent() %></p>
									<textarea name="boardCommentContent" class="input-form" style="min-height:96px;display:none;"><%=bcc.getBoardCommentContent() %></textarea>
									<p class="comment-link">
									<%-- 	<%if(m!=null && m.getMemberId().equals(ncc.getNcWriter())) {%> --%>
											<a href="javascript:void(0)" onclick="modifyComment(this,<%=bcc.getBoardCommentNo()%>,<%=b.getBoardNo()%>);">수정</a>
											<a href="javascript:void(0)" onclick="deleteComment(this,<%=bcc.getBoardCommentNo()%>,<%=b.getBoardNo()%>);">삭제</a>
									<%-- 	<%} %> --%>
									</p>
								</li>
							</ul>	
						<%}//댓글번호 체크 if문 종료 %>				
					<%}// %>
					
					
					<%-- 댓글에 대한 대댓글 입력양식 --%>
				<%-- 	<%if(m!=null) {%> --%>
						<div class="inputCommentBox inputRecommentBox">
							<form action="/insertBoardComment.do" method="post">
								<ul>
									<li>
										<span class="material-icons">subdirectory_arrow_right</span>
									</li>
									<li>
									<%-- 	<input type="hidden" name="ncWriter" value="<%=m.getMemberId() %>"> --%>
										<input type="hidden" name="boardRef" value="<%=b.getBoardNo() %>">
										<input type="hidden" name="boardCommentRef" value="<%=bc.getBoardCommentNo() %>">
										<textarea name="boardCommentContent" class="input-form"></textarea>
									</li>
									<li>
										<button type="submit" class="btn bc1 bs4">등록</button>
									</li>
								</ul>
							</form>
						</div>					
				<%-- 	<%} %> --%>
				<%}//댓글 출력 for문 끝나는 위치 %>
			</div>
			
			
			
				
			
			
			<%--로그인 되어있는 경우에만 댓글 작성 화면을 띄움--%>
				<div class="inputCommentBox">
					<form action="/insertBoardComment.do" method="post">
						<ul>
							<li>
								<span class="material-icons">account_box</span>
							</li>
							<li>
								<input type="hidden" name="boardRef" value="<%=b.getBoardNo() %>">
								<input type="hidden" name="boardCommentRef" value="0">
								<textarea name="boardCommentContent" class="input-form"></textarea>
							</li>
							<li>
								<button type="submit" class="btn bc1 bs4">등록</button>
							</li>
						</ul>
					</form>
				</div>
				
      			
      			
			</div>
		</div>
		
		<script>
		function boardDelete(boardNo) {
			if(confirm("게시글을 삭제하시겠습니까?")){
				location.href="/deleteBoard.do?boardNo="+boardNo;
			}
		}
		
		$(".recShow").on("click",function(){
			//몇번째 답글달기 버튼을 클릭한지
			const idx = $(".recShow").index(this);
			if($(this).text()=="답글달기"){
				$(this).text("취소");
			}else{
				$(this).text("답글달기");
			}
			$(".inputRecommentBox").eq(idx).toggle();
			$(".inputRecommentBox").eq(idx).find("textarea").focus();
		});
		
		function modifyComment(obj, boardCommentNo, boardNo){
			//숨겨놓은 textarea를 화면에 보여줌
			$(obj).parent().prev().show();
			//화면에 있던 댓글내용(p태그)를 숨김
			$(obj).parent().prev().prev().hide();
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
			$(obj).parent().prev().hide();//textarea숨김
			$(obj).parent().prev().prev().show();//기존댓글 다시 보여줌
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
			const ncContent = $(obj).parent().prev().clone();
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