<%@page import="com.iei.user.model.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	User u = (User)session.getAttribute("loginUser");
	%>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,1,1" />
 <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<style>
.mypage-menu-wrap {
	margin: 0;
	width: 170px;
	margin-right: 100px;
}

.mypage-menu-wrap>.page-title{
	font-size: 34px;
}

.cat .bold {
	font-family: ns-bold;
	font-size: 20px;
	padding-top: 5px;
	padding-left: 5px;
	color: #3a4f7a;
}

div>.icon {
	color: #3a4f7a;
	margin: 0;
	font-size: 28px;
	
}

.cat-title {
	display: flex;
	padding-bottom: 5px;
	border-bottom: 1px solid lightgray;
	margin-bottom: 7px;
	cursor: default;
}

ul {
	list-style-type: none;
}

.cat>li {
	padding-top: 40px;
}

.cat-detail>li {
	padding-left: 25px;
	margin-top: 5px;
	transition-duration: 0.3s;
}

.cat-detail>li>a:hover {
	color: #423c4d;
}

.mypage-menu-wrap a:not(.page-title) {
	font-size: 16px;
	font-family: ns-m;
	color: #6f6b7a;
}
</style>
<div class="mypage-menu-wrap">
	<a href="/myPageMain.do?userId=<%=u.getUserId()%>" class="page-title">마이페이지</a>
	<ul class="cat">
		<li>
			<div class="cat-title">
				<span class="material-symbols-outlined icon">edit_square</span>
				<div class="bold">나의 작품</div>
			</div>
			<ul class="cat-detail">
				<li><a href="/uploadBookList.do?userId=<%=u.getUserId()%>&reqPage=1">투고한 작품 확인</a></li>
			</ul>
		</li>
		<li>
			<div class="cat-title">
				<span class="material-symbols-outlined icon">auto_stories</span>
				<div class="bold">나의 책갈피</div>
			</div>
			<ul class="cat-detail">
				<li><a href="/myPageFavBookList.do?userNo=<%=u.getUserNo()%>&reqPage=1">관심작품 목록</a></li>
				<li><a href="/myPageSupBookList.do?userNo=<%=u.getUserNo()%>&reqPage=1">후원작품 목록</a></li>
			</ul>
		</li>
		<li>
			<div class="cat-title">
				<div class="material-icons icon">account_circle</div>
				<div class="bold">개인</div>
			</div>
			<ul class="cat-detail">
				<li><a href="/updateUserFrm.do">회원정보 변경</a></li>
				<li><a href="/deleteUserFrm.do">회원 탈퇴</a></li>
			</ul>
		</li>
	</ul>
</div>
