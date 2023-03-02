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
			<div class="page-title">문의 게시글 작성</div>
			<form action="/questionWrite.do" method="post" enctype="form-data">
				<table class="tbl" id="questionWrite">
					<tr class="tr-1">
						<th class="td-3">제목</th>
						<td colspan="3">
							<input type="text" id="questionTitle" name="questionTitle" class="input-form">						
						</td> 
					</tr>
					<tr class="tr-1">
						<th class="td-3">작성자</th>
						<td>
						<%-- --%>
						<h3>아이디1(수정할것)</h3>
						<%-- <%=m.getMemberId() %>--%>
							
							<%-- 사람 눈에 보일 것 --%>
							<input type="hidden" name="questionWriter" value="<%--<%=m.getMemberId() %>--%>">
							<%-- 데이터 전송용 --%>
							
						</td>
					</tr>
					<tr class="tr-1">
						<td colspan="4" style="text-align:left;">
							<textarea id="questionContent" name="questionContent" class="input-form"></textarea>
						</td>
					</tr>
					<tr class="tr-1">
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