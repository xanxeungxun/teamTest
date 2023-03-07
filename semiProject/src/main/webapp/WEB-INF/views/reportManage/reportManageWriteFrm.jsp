<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>문의 게시글 작성</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<style>
	#reportManageWrite td, #reportManageWrite th{
		border : 1px solid #ccc;
	}
	.input-form{
		padding-left: 10px;
		
	
	}
	
</style>
<link rel="stylesheet" href="/css/reportManage.css">
</head>

<body>
<script>
$(document).ready(function(){ 
	$("#submitBtn").click(function(){
			if($("#reportManageTitle").val().length==0){ alert("제목을 입력하세요."); $("#reportManageTitle").focus(); return false; }
			if($("#reportManageContent").val().length==0){ alert("내용을 입력하세요."); $("#reportManageContent").focus(); return false; }
		});		
});
</script>
<%@include file="/WEB-INF/views/common/header.jsp"%>
<script src="/summernote/summernote-lite.js"></script>
	<script src="/summernote/lang/summernote-ko-KR.js"></script>
	<link rel="stylesheet" href="/summernote/summernote-lite.css">
		<div class="page-content">
			<div class="page-title">신고 사항 작성</div>
			<form action="/reportManageWrite.do" method="post">
				<table class="tbl" id="reportManageWrite">
					<tr class="tr-1">
						<th class="td-3" style="height:50px;">신고 게시물</th>
						<td colspan="3">
							가져온게시물제목				
						</td> 
					</tr>
					<tr class="tr-1">
						<th class="td-3">제목</th>
						<td colspan="3">
							<input type="text" id="reportManageTitle" name="reportManageTitle" class="input-form">						
						</td> 
					</tr>
					<tr class="tr-1">
						<th class="td-3">종류</th>
						<td colsan="2">
					<select class="input-form" id="reportManageType" name="reportManageType">
    					<option value="0" selected>-- 문의내용선택 --</option>
    					<option value="1">유저</option>
    					<option value="2">게시판</option>
    					<option value="3">소설</option>
    					<option value="4">기타</option>
    				</select></td>
						<th class="td-3">작성자</td>
						<td style="width:200px;text-align:right;padding-right:50px;">
							<span>아이디</span>
							<input type="hidden" name="reportManageId" 
							value="<%=loginUser.getUserId()%>">
							<%=loginUser.getUserId()%>
							<br><span>닉네임</span>
							<input type="hidden" name="reportManageName" value="<%=loginUser.getUserName()%>">
							<%=loginUser.getUserName()%>
						</td>
					</tr>
					<tr class="tr-1"style="position:relative;line-height:50px;">
						<th class="td-3">첨부파일</th>
						<td colspan="1">
						<input type="file" name="upfile" style="position: absolute;font-size:20px;top:25px;left:290px;"></td>
						<th class="td-3">피신고자</td>
						<td style="width:200px;text-align:right;padding-right:50px;position: relative;">
						<span style="position: absolute;top:20px;left:50px;">아이디</span>
						<input type="text" id="criminal-user-id" name="criminal-user-id" class="input-form"
						style="width:100px;height:30px;position: absolute;right:50px;top:30px;">
						</td>
					</tr>
					<tr class="tr-1">
						<td colspan="4" style="text-align:left;">
							<textarea id="reportManageContent" name="reportManageContent" class="input-form" style="height:500px;"></textarea>
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
			<script>
			$("#reportManageContent").summernote({
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