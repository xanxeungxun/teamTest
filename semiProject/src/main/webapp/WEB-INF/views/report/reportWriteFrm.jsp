<%@page import="com.iei.bookListManage.model.vo.*"%>
<%@page import="com.iei.board.model.vo.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    <%
    BookListManageVo list = (BookListManageVo)request.getAttribute("list");
    %>
    <%
    Board list2 = (Board)request.getAttribute("list2");
    %>
    

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>신고 게시글 작성</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<style>
	#reportWrite td, #reportWrite th{
		border : 1px solid #ccc;
	}
	.input-form{
		padding-left: 10px;
		
	
	}
</style>
<link rel="stylesheet" href="/css/report.css">
</head>

<body>
<script>
$(document).ready(function(){ 
	$("#submitBtn").click(function(){
			if($("#reportTitle").val().length==0){ alert("제목을 입력해주세요."); $("#reportTitle").focus(); return false; }
			if($("#reportContent").val().length==0){ alert("내용을 작성해주세요."); $("#reportContent").focus(); return false; }
			if($("#reportType").val()==0){ alert("신고 종류를 선택해주세요."); $("#reportContent").focus(); return false; }
			
		});		
});



</script>
<%@include file="/WEB-INF/views/common/header.jsp"%>
<script src="/summernote/summernote-lite.js"></script>
	<script src="/summernote/lang/summernote-ko-KR.js"></script>
	<link rel="stylesheet" href="/summernote/summernote-lite.css">
		<div class="page-content">
			<div class="page-title">신고 사항 작성</div>
			<form action="/reportWrite.do" method="post" enctype="multipart/form-data">
				<table class="tbl" id="reportWrite">
					<tr class="tr-1">
						<th class="td-3" style="height:50px;">신고 게시물</th>
						<td colspan="3">
					
					<%-- 제목 (소설) --%>
					<% if(list !=null){%>
							<input type="hidden" id="noGo1" name="bobType" value="(소설게시판)">
							<input type="hidden" id="noGo2" name="bobNo" value="<%=list.getBookNo() %>">
							<input type="hidden" id="noGo3" name="bobTitle" value="<%=list.getBookTitle() %>">
							<%=list.getBookTitle() %>
							<%}else if(list2 != null){%>
							
					<%-- 제목 (자유) --%>
							<input type="hidden" id="noGo1" name="bobType" value="(자유게시판)">
							<input type="hidden" id="noGo2" name="bobNo" value="<%=list2.getBoardNo() %>">
							<input type="hidden" id="noGo3" name="bobTitle" value="<%=list2.getBoardTitle() %>">
							<%=list2.getBoardTitle() %>
							<%} %>
							
						</td> 
					</tr>
					<tr class="tr-1">
						<th class="td-3">제목</th>
						<td colspan="3">
							<input type="text" id="reportTitle" name="reportTitle" class="input-form">						
						</td> 
					</tr>
					<tr class="tr-1">
						<th class="td-3">종류</th>
						<td colsan="2">
					<select class="input-form" id="reportType" name="reportType">
    					<option value="0" selected>-- 신고내용선택 --</option>
    					<option value="1">욕설</option>
    					<option value="2">폭언</option>
    					<option value="3">성적수치심</option>
    					<option value="4">기타</option>
    				</select></td>
						<th class="td-3" class="ttt">작성자</td>
						<td style="width:200px;text-align:right;padding-right:50px;">
							<span>아이디</span>
							<input type="hidden" name="reporterId" id="reporterId"
							value="<%=loginUser.getUserId()%>">
							<%=loginUser.getUserId()%>
							<br><span>닉네임</span>
							<input type="hidden" name="reporterName" value="<%=loginUser.getUserName()%>">
							<%=loginUser.getUserName()%>
						</td>
					</tr>
					<tr class="tr-1"style="position:relative;line-height:50px;">
						
						
					</tr>
					<tr class="tr-1">
						<td colspan="4" style="text-align:left;">
							<textarea id="reportContent" name="reportContent" class="input-form" style="height:500px;"></textarea>
						</td>
					</tr>
					<tr class="tr-1">
						<td colspan="4">
							<button type="submit" id="submitBtn" class="btn bc1 bs4">신고 사항 전송</button>
						</td>
					</tr>
				</table>
				
			</form>
		</div>
			<script>
			
			$(document).ready(function(){
			    $("#submitBtn").submit(function(){
			        var rv = true;
			        // 유효성 검사
			        $.each($("reportTitle, reportContent, reportType"), function(){
			            if($(this).val() === null || $(this).val() === ' ' || $(this).val().length === 0){
			                alert('입력이 유효하지 않습니다...');
			                return rv = false;
			            }else{
			            	const reporterId = $("#reporterId").val();
							const bobType = $("#noGo1").val();
							const bobNo = $("#noGo2").val();
							const bobTitle = $("#noGo3").val();
							const reportType = $("#reportType").val();
							const reportTitle = $("#reportTitle").val();
							
							let url = "/report/reportWrite.do?reporterId="+reporterId+
										"?reportType="+reportType+
										"?bobType="+bobType+
										"?bobTitle="+bobTitle+
										"?reportTitle="+reportTitle+
										"?bobNo="+bobNo
										;
							location.href = url;
			            }
			        })
			        return rv;
				    });
			});
			
			$("#reportContent").summernote({
					height: 400,
					lang: "ko-KR",
					callbacks : {
						onImageUpload: function(files){
							uploadImage(files[0],this);
						}
					}
			});
			
			function uploadImage(file, editor){
				//ajax를 통해서 서버에 이미지를 업로드
				//업로드된 이미지의 경로를 받아오는 역할
				//받아온 이후 -> editor에 이미지 경로를 전달해서 화면에 표현
				//<form> 태그의 역할
				const form = new FormData();
				/*
				<form>
					<inpit type="file" name="file">
				</form>
				*/
				form.append("file",file);
				$.ajax({
					url : "/uploadImage.do",
					type : "post",//파일 업로드시 반드시 타입을 post로 줘야 함
					data : form,
					processData : false,
					contentType : false,
					success: function(data){
					$(editor).summernote("insertImage",data);
					}
				});
				//processData : 전송하는 데이터를 기본적으로 문자열로 전송하게 세팅이 되어 있다.
				//-> 파일 전송을 위해서 기본값인 문자열 전송을 제거
				//contentType : enctype="application/x-www-form-urlencoded;charset=UTF-8"
				//-> 파일 전송을 위해서 enctype 기본값을 제거
			}
		</script>
<%@include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>