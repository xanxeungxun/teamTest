<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	padding: 20px;
	border: 1px solid lightgray;
	box-shadow: 0 0 0 0.1rem #eee;
	border-radius: 10px;
	display: flex;
}

.mypage-box>.material-icons {
	font-size: 140px;
	color: #ccc;
}

.mypage-info {
	padding: 20px;
	width: 65%;
}

.line {
	width: 100%;
	border-bottom: 1px solid lightgray;
}

.icon {
	font-size: 20px;
	color: #59516e;
	cursor: default;
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
	padding: 2px 0px 0px 3px;
}

.link>div>a:hover {
	color: #fea1bf;
}

.logout-btn {
	height: 55px;
	margin-top: 100px;
}

.myPoint {
	display: block;
	height: 50px;
	text-align: center;
	line-height: 50px;
	margin: 10px 0px 10px 0px;
	border-radius: 4px;
	box-shadow: 0 0 0 0.1rem #eee;
}

.myPoint-num {
	color: #ffc6d3;
}
</style>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<div class="page-content mypage-content">
		<%@include file="/WEB-INF/views/common/myPageMenu.jsp"%>
		<div class="mypage-main-wrap mypage-detail">
			<div class="mypage-box">
				<div class="material-icons">account_circle</div>
				<div class="mypage-info">
					<div class="user-info">
						<div class="nick">(닉네임나오는곳)</div>
						<div class="email">(이메일나오는곳)</div>
					</div>
					<div class="line"></div>
					<div class="link">
						<div>
							<div class="material-symbols-outlined icon">mail</div>
							<a href="#" class="message">쪽지함</a>
						</div>
						<div>
							<div class="material-symbols-outlined icon">savings</div>
							<a href="#" class="point">포인트 충전</a>
						</div>
					</div>
				</div>
				<a href="/logout.do" class="btn bc33 logout-btn">로그아웃</a>
			</div>
			<div>
				<div class="myPoint bc4">
					나의 포인트 : <span class="myPoint-num">0</span> P</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>