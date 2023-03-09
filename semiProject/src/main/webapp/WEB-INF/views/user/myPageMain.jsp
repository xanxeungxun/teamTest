<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	User user = (User)request.getAttribute("u");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/default.css">
<link rel="stylesheet" href="/css/mypageDefault.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,1,0" />
</head>
<style>
.mypage-box {
	padding: 40px 40px;
	border: 1px solid lightgray;
	box-shadow: 0 0 0 0.1rem #eee;
	border-radius: 10px;
	display: flex;
	
	position: relative;
}

.mypage-box>.profile>.material-icons {
	font-size: 140px;
	color: #ccc;
}

.mypage-info {
	padding: 15px;
	width: 68%;
}

.line {
	width: 100%;
	border-bottom: 1px solid lightgray;
}

.link>div>.icon {
	font-size: 24px;
}

.nick {
	font-size: 20px;
	font-family: ns-bold;
}

.email {
	font-size: 14px;
	color: #59516e;
	padding: 5px 0px 10px 0px;
}

.link {
	padding-top: 10px;
}

.link>div {
	display: flex;
	margin: 5px 0px 5px 0px;
}

.link>div>a {
	display: block;
	padding: 5px 0px 0px 3px;
}

.link>div>a:hover {
	color: #fea1bf;
}

.logout-btn {
	height: 55px;
	position: absolute;
	right: 40px;
	bottom: 40px;
}

.mypage-main-wrap>div>.myPoint {
	display: block;
	height: 50px;
	text-align: center;
	line-height: 50px;
	margin: 10px 0px 10px 0px;
	border-radius: 4px;
	box-shadow: 0 0 0 0.1rem #eee;
	cursor: default;
}

.myPoint-num {
	color: #ffc6d3;
}

    .book-img{
        width: 120px;
        height: 120px;
        background-color: #fff;
        border : 1px solid #EEEEEE;
        border-radius: 60px;
    }
</style>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<div class="page-content mypage-content">
		<%@include file="/WEB-INF/views/user/myPageMenu.jsp"%>
		<div class="mypage-main-wrap mypage-detail">
			<div class="mypage-box">
				<div class="profile">
					<%if(loginUser.getUserPic()==null){ %>
						<div class="material-icons">account_circle</div>
					<%} else { %>
						<div style="background-image: url(/upload/profile/<%=loginUser.getUserPic()%>); background-size: contain; background-position: center;  background-repeat: no-repeat;" id="previewImg" class="book-img"></div>
					<%} %>
				</div>
				<div class="mypage-info">
					<div class="user-info">
						<div class="nick"><%=user.getUserNick() %></div>
						<div class="email"><%=user.getUserEmail() %></div>
					</div>
					<div class="line"></div>
					<div class="link">
						<div>
							<div class="material-symbols-outlined icon">calendar_month</div>
							<a href="/cal.do" class="cal">출석체크</a>
						</div>
						<div>
							<div class="material-symbols-outlined icon">savings</div>
							<a href="/pointRechargeFrm.do" class="point">포인트 충전</a>
						</div>
					</div>
				</div>
				<a href="/logout.do" class="btn bc33 logout-btn">로그아웃</a>
			</div>
			<div>
				<div class="myPoint bc4">
					나의 포인트 : <span class="myPoint-num"><%=user.getUserPoint() %></span> P
				</div>
				<%if(loginUser!=null&&loginUser.getUserLevel()==1){ %>
				<div class="myPoint bc4" onclick="location.href='/adminMain.do?userLevel=1';" style="cursor: pointer;">
					관리자 페이지
				</div>
				<%} %>
				<%if(loginUser!=null&&loginUser.getUserLevel()!=1){ %>
					<div class="myPoint bc4" 
					onclick="location.href='/report/searchReportList.do?searchType=1&searchValue=<%=loginUser.getUserId() %>';" style="cursor: pointer;">
					내가 신고한 게시글
					
					</div>
				<%} %>
			</div>
		</div>
	</div>
</body>
</html>