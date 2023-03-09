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
<style>
	.board-tbl tr{
		background-color: #eeeeee;
	}
	.board-input{
		border: 0.1px solid #ccc;
	}
	.note-editor.note-frame .note-editing-area .note-editable, .note-editor.note-airframe .note-editing-area .note-editable {
	    padding: 10px;
	    overflow: auto;
	    word-wrap: break-word;
	    background-color: #fff;
	}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<script src="/summernote/summernote-lite.js"></script>
	<script src="/summernote/lang/summernote-ko-KR.js"></script>
	<link rel = "stylesheet" href="/summernote/summernote-lite.css">
	
		<div class="page-content">
			<div class="board-wrap">
				<div class="board-header">
					<span>자유게시판 수정</span>
				</div>
				<form action="/boardUpdate.do" method="post" enctype="multipart/form-data">
					<table class="board-tbl" id="board-tbl">
						<tr class="board-tr">
							<th class="board-td">제목</th>
							<td class="board-td" colspan="3">
								<input type="hidden" name="status" value="stay">
								<input type="hidden" name="boardNo" value="<%=b.getBoardNo() %>">
								<input type="text" name="boardTitle" class="board-input" value="<%=b.getBoardTitle()%>" style="padding-left: 15px;">
							</td>
						</tr>
						<tr class="board-tr">
							<th class="board-td">작성자</th>
							<td class="board-td"><%=b.getBoardWriter() %></td>
							<th class="board-td">첨부파일</th>
							<td class="board-td">
								<%if(b.getFilePath()!=null){ %>
									<img src="/img/file.png" width="16px" class="delFile">
									<span class="delFile"><%=b.getFileName() %></span>
									<button type="button" class="btn bc1 delFile">삭제</button>
									<input type="file" name="upfile" style="display:none;">
									<input type="hidden" name="oldFilename" value="<%=b.getFileName()%>">
									<input type="hidden" name="oldFilepath" value="<%=b.getFilePath()%>">				
								<%}else{ %>
									<input type="file" name="upfile">
								<%} %>
							</td>
						</tr>
						<tr class="board-tr">
							<td class="board-td" colspan="4">
								<textarea id="boardContent" name="boardContent" class="board-input"><%=b.getBoardContent() %></textarea>
							</td>
						</tr>
						<tr class="board-tr">
							<td colspan="4" class="sub-btn-td">
								<button type="submit" class="board-sub-btn">자유게시판 수정</button>
							</td>
						</tr>				
					</table>
				</form>
			</div>
		</div>
		
		<script>
		$("button.delFile").on("click",function(){
			$(".delFile").hide();
			$(this).next().show();
			$("[name=status]").val("delete");
		});
		
		$("#boardContent").summernote({
			height : 500,
			lang : "ko-KR",
			callbacks : {
					onImageUpload : function(files){
					uploadImage(files[0],this);
				}
			}
		});
		
		function uploadImage(file, editor) {
			//ajax를 통해서 서버에 이미지를 업로드
			//업로드된 이미지의 경로를 받아오는 역할
			//받아온 이후 -> editor에 이미지경로를 전달해서 화면에 표현
			//<form>태그의 역할
			const form = new FormData();
			/*
			<form>
				<input type="file" name="file">
			</form>
			*/
			form.append("file",file);
			$.ajax({
				url : "/uploadImage.do",
				type : "post",
				data : form,
				processData : false,
				contentType : false,
				success : function(data){
					$(editor).summernote("insertImage",data);
				}
			});
			//processData : 전송하는 데이터를 기본적으로 문자열로 전송하게 세팅
				//-> 파일전송을 위해서 기본값인 문자열 전송을 제거
			//contentType : enctype="application/x-www-form-urlencoded;charset=UTF-8"
				//-> 파일전송을 위해서 enctype 기본값 제거
		}
	</script>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>