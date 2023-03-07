<%@page import="com.iei.user.model.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
		User loginUser = (User)session.getAttribute("loginUser");
	%>
	
<script src="js/jquery-3.6.3.min.js"></script>

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

<%-- 로그인 후 바뀐 버튼 --%>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,1,0" />

<link rel="stylesheet" href="/css/common.css">
<!-- 공용 css -->

<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<!-- 구글 아이콘 -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<script src="/js/jquery-3.6.0.js"></script>
<!-- jquery -->
<link rel="stylesheet" href="/css/default.css">
<!-- 은아님이 만든 예쁜 스타일 -->
<script src="/js/default.js"></script>


<div class="header-wrap">


	<div class="header-wrap">

		<div class="header-top">
			<div class="left-top-wrap">
				<a href="/" class="logo-text"><h4>Every Universe</h4></a>
                
                <div class="please">
	                <form action="/search.do" method="get">
	                <input type="hidden" value="1" name="reqPage">
	                <input id="integrated-search" class="search-bar" type="text" name="searchKeyword" value=""
	                    placeholder="포스트, 시리즈, 채널 검색" maxlength="50">
	                    <button type="submit" id="search-icon" class="material-symbols-outlined search-icon">search</button>
	                </form>
	                
	                <div class="sign">
					<%if(loginUser == null) { %>
						<%-- 로그인 안된 경우 --%>
						<a href="/loginFrm.do">로그인</a> <i>ㅤ|ㅤ</i> <a href="/joinFrm.do">회원가입</a>
					<%} else { %>
						<%-- 로그인된 경우 --%>
						<a href="/myPageMain.do?userId=<%=loginUser.getUserId()%>" class="material-symbols-outlined person-icon" style="font-size: 50px; margin-left : 0; flex-shrink: 0;">person</a>
					<%} %>
					</div>
                </div>
				
			</div>
			<div class="header-bottom">
				<div class="menu-wrap">
					<div class="top-menu">
						<ul>
							<li class="top-menu-button">
								<a href="/bookWriteFrm.do">
									<span class="material-symbols-outlined write-icon">drive_file_rename_outline</span>
									작품등록
								</a>
							</li>
							<li class="top-menu-button"><a href="/noticeList.do?reqPage=1">공지사항</a></li>
							<li class="top-menu-button"><a href="/boardList.do?reqPage=1">자유게시판</a></li>
							<li class="top-menu-button"><a href="/bookList.do?reqPage=1">소설게시판</a></li>
							<li class="top-menu-button"><a href="/question/questionList.do?reqPage=1">문의게시판</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

	</div>
	<div class="header-blocked"></div>


</div>
<div class="header-blocked"></div>

<script src="/js/common.js"></script>



