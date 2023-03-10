<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 게시글 작성</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<style>
	#questionWrite td, #questionWrite th{
		border : 1px solid #ccc;
	}
	.input-form{
		padding-left: 10px;
		
	
	}
	
</style>
<link rel="stylesheet" href="/css/question.css">
</head>
<body>
<script>



$(document).ready(function(){ 
	$("#submitBtn").click(function(){
			if($("#questionTitle").val().length==0){ alert("제목을 입력하세요."); $("#questionTitle").focus(); return false; }
			if($("#questionContent").val().length==0){ alert("내용을 입력하세요."); $("#questionContent").focus(); return false; }
		});		
});

</script>
<%@include file="/WEB-INF/views/common/header.jsp"%>
		<div class="page-content">
		<br><br>
			<div class="page-title"style="padding-left:10px;">문의 게시글 작성</div>
			<br>
			<hr>
			<br><br>
			<form action="/questionWrite.do" method="post">
				<table class="tbl" id="questionWrite">
					<tr class="tr-1" style="background:#F0F0F0;">
						<th class="td-3" style="background:#F0F0F0;">제목</th>
						<td colspan="3">
							<input type="text" id="questionTitle" name="questionTitle" class="input-form">						
						</td> 
					</tr>
					<tr class="tr-1" style="background:#F0F0F0;">
						<th class="td-3" style="background:#F0F0F0;">종류</th>
						<td colsan="2">
					<select class="input-form" id="questionType" name="questionType">
    					<option value="0" selected>-- 문의사항선택 --</option>
    					<option value="1">이용안내</option>
    					<option value="2">시스템오류</option>
    					<option value="3">결제</option>
    					<option value="4">건의사항</option>
    					<option value="5">기타</option>
    					<option value="6">신고</option>
    				</select></td>
						<td class="td-3" style="background:#F0F0F0;">작성자</td>
						<td>
						<%-- 로그인 제작 완료시 해당 주석 풀고 적용 할 것 --%>
						<%--<%=loginUser.getUserId()%>--%>
							<input type="hidden" name="questionId" 
							value="<%=loginUser.getUserId()%>">
							<%=loginUser.getUserId()%>
							<input type="hidden" name="questionName" value="<%=loginUser.getUserName()%>">
							<%=loginUser.getUserName()%>
						</td>
					</tr>
					<tr class="tr-1" style="background:#F0F0F0;">
						<td colspan="4" style="text-align:left;">
							<textarea id="questionContent" name="questionContent" class="input-form" style="height:600px;"></textarea>
						</td>
					</tr>
					<tr class="tr-1" style="background:#F0F0F0;">
						<td colspan="4">
							<button type="submit" id="submitBtn" class="btn bc1 bs4">문의 게시글 작성</button>
						</td>
					</tr>
				</table>
				
			</form>
		</div>


<%@include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>