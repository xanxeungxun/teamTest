<%@page import="com.iei.board.model.vo.BoardComment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.iei.board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Board b = (Board)request.getAttribute("b");
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
				</div>
				<table class="board-tbl">
					<tr class="board-tr">
						<td class="board-td">
						<input type="hidden" name="boardNo" value="<%=b.getBoardNo() %>">
							<span><%=b.getBoardTitle() %></span>
							<div><%=b.getboardDate() %></div>
						</td>
					</tr>
					<%if(b.getFileName() != null) {%>
						<tr class="board-tr">
							<td class="board-td">
								<img src="/img/file.png" width="16px">
								<a href="/boardFileDown.do?boardNo=<%=b.getBoardNo()%>">
									<%=b.getFileName() %>
								</a>
							</td>
						</tr>
					<%} %>
					<tr class="board-tr">
						<td class="board-td">
							<div><%=b.getBoardContent() %></div>
						</td>					
					</tr>
				</table>
				<div>
					<a href="/boardUpdateFrm.do?boardNo=<%=b.getBoardNo() %>">수정</a>
					<button onclick="boardDelete(<%=b.getBoardNo()%>);">삭제</button>
				</div>
				
				
				<div>
        <h2>댓글출력</h2>
        <div class="comment-wrap">
            <ul class="posting-comment">
                <li>
                  <span class="material-icons">account_circle</span>
                </li>
                <li>
                  <p class="comment-info">
                    <span>user01</span>
                    <span class="comment-link">
                        <a href="#">수정</a>
                        <a href="#">삭제</a>
                    </span>
                  </p>
                  <p class="comment-date">
                      <span>2022-03-21 09:40</span>
                  </p>
                  <p class="comment-content">댓글내용댓글내용댓글내용</p>
                  <a href="#"><span class="material-symbols-outlined">sms</span></a>
                </li>
              </ul>
              <ul class="posting-comment">
                <li>
                  <span class="material-icons">account_circle</span>
                </li>
                <li>
                  <p class="comment-info">
                      <span>user01</span>
                      <span class="comment-link">
                          <a href="#">수정</a>
                          <a href="#">삭제</a>
                      </span>
                    </p>
                    <p class="comment-date">
                        <span>2022-03-21 09:40</span>
                    </p>
                  <p class="comment-content">댓글내용댓글내용댓글내용</p>
                  <a href="#"><span class="material-symbols-outlined">sms</span></a>
                </li>
              </ul>
              <ul class="posting-comment reply">
                <li>
                  <span class="material-icons">account_circle</span>
                </li>
                <li>
                  <p class="comment-info">
                      <span>user01</span>
                      <span class="comment-link">
                          <a href="#">수정</a>
                          <a href="#">삭제</a>
                      </span>
                    </p>
                    <p class="comment-date">
                        <span>2022-03-21 09:40</span>
                    </p>
                  <p class="comment-content">댓글내용댓글내용댓글내용</p>
                  <a href="#"><span class="material-symbols-outlined">sms</span></a>
                </li>
              </ul>
        </div>
      </div>
			</div>
		</div>
		
		<script>
		function boardDelete(boardNo) {
			if(confirm("게시글을 삭제하시겠습니까?")){
				location.href="/deleteBoard.do?boardNo="+boardNo;
			}
		}
		</script>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>