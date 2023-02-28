<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/notice.css">
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<script src="/summernote/summernote-lite.js"></script>
	<script src="/summernote/lang/summernote-ko-KR.js"></script>
	<link rel = "stylesheet" href="/summernote/summernote-lite.css">
	
		<div class="page-content">
			<div class="notice-wrap">
				<div class="notice-header">
					<span>공지사항 작성</span>
				</div>
				<form action="/noticeWrite.do" method="post">
					<table class="notice-tbl" id="noticeWrite-tbl">
						<tr class="notice-tr">
							<th class="notice-td">제목</th>
							<td class="notice-td">
								<input type="text" name="noticeTitle" class="notice-input">
							</td>
						</tr>
						<tr class="notice-tr">
							<th class="notice-td">내용</th>
							<td class="notice-td">
								<textarea id="noticeContent" name="noticeContent" class="notice-input"></textarea>
							</td>
						</tr>
						<tr class="notice-tr">
							<td colspan="2" class="sub-btn-td">
								<button type="submit" class="notice-sub-btn">공지사항 작성</button>
							</td>
						</tr>				
					</table>
				</form>
			</div>
		</div>
		
		<script>
		$("#noticeContent").summernote({
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