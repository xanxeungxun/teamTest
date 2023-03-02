<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/common.css">

<style>
	.page-content{
		width: calc(100%);
	}
	.page-title{
		width: calc(50%);
		margin: 0 auto;
	}
	.page-title>h3{
		font-size: 36px;
		margin: 10px;
		margin-bottom: 30px;
	
	}
	.btnList{
		width: calc(100%);
		overflow: hidden;
		display:flex;
	}
	.btnList button{
		flot: left;
		border-radius: 10px;
		width: calc(100%);
		margin-left:50px;
		height: 80px;
		margin-top: 50px;
		font-size: 26px;
		font-weight: bold;
		background-color: #3A4F7A;
		color: #fff;
	}
	.btnList button:first-child{
		margin-left:0px;
	}
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<div class="page-title">
			<h3>관리자 페이지</h3>
			<hr>
			<div class="btnList">
				<button type="button" onclick="location.href='/userListManage.do'">회원관리</button>
				<button type="button" onclick="location.href='/bookListManage.do'">작품관리</button>
				<button type="button" onclick="location.href='/question/questionList.do'">문의사항</button>
				<button type="button" onclick="location.href='/reportListManage.do'">신고접수</button>
			</div>
		</div>
	</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>