<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리-메인</title>
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
		margin-left:5px;
		height: 60px;
		line-height:5px;
		margin-top: 50px;
		font-size: 26px;
		font-weight: bold;
		background-color: #2F343D;
		color: #fff;
	}
	.btnList button:hover{
	background-color: #fff;
	color:#2F343D;
	}
	.btnList button:first-child{
		margin-left:0px;
	}
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%if(loginUser!=null&&loginUser.getUserLevel() == 1){ %>
<%} %>
	<div class="page-content">
		<div class="page-title">
		<br><br><br>
			<h3>관리자 페이지</h3>
			<hr>
			<div class="btnList">
				<button class="btn bc1 bs3" style="font-size:20px;" type="button" onclick="location.href='/userManage/userManageList.do?reqPage=1'">회원관리</button>
				<button class="btn bc1 bs3" style="font-size:20px;" type="button" onclick="location.href='/bookListManage/bookListManageList.do?reqPage=1'">작품관리</button>
				<button class="btn bc1 bs3" style="font-size:20px;" type="button" onclick="location.href='/question/questionList.do?reqPage=1'">문의사항</button>
				<button class="btn bc1 bs3" style="font-size:20px;" type="button" onclick="location.href='/report/reportList.do?reqPage=1'">신고현황</button>
			
			</div>
		</div>
	</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>