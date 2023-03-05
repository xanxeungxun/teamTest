<%@page import="com.iei.user.model.vo.FavoriteBook"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<FavoriteBook> favList = (ArrayList<FavoriteBook>)request.getAttribute("favList");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="/css/default.css">
    <link rel="stylesheet" href="/css/mypageDefault.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,1,0" />
</head>
<style>
    .mypage-detail>.content-wrap{
        padding: 10px 30px 10px 30px;
    }
    .line-content{
        display: flex;
        justify-content: space-between;
    }
    .book-box{
        display: flex;
        margin: 20px;
    }
    .book-img{
        width: 120px;
        background-color: #a7a7a7;
        border-radius: 4px;
        margin-right: 10px;
    }
    .book-info>div{
        padding: 3px 0px 3px 0px;
    }
    .book-info-head{
        display: flex;
        justify-content: space-between;
    }
    .close-btn{
        cursor: pointer;
    }
    .book-title{
        font-size: 18px;
        font-family: ns-m;
    }
    .genre{
        font-size: 14px;
    }
    .book-date{
        font-size: 12px;
        color: #a7a7a7;
    }
    .writer-wrap{
        display: flex;
    }
    .material-symbols-outlined{
        font-size: 18px;
        margin-right: 3px;
    }
    .writer{
        font-size: 15px;
    }
    .read-btn{
        width: 100px;
        text-align: center;
    }
</style>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content mypage-content">
		<%@include file="/WEB-INF/views/user/myPageMenu.jsp" %>
        <div class="mypage-detail">
            <div class="page-title">관심작품 목록</div>
            <div class="content-wrap">
            	<%for(int i=0; i<2; i++) { %>
	                <div class="line-content">
	                	<%for(FavoriteBook fb : favList) {  %>
		                    <div class="book-box">
		                        <div class="book-img"></div>
		                        <div class="book-info">
		                            <div class="book-info-head">
		                                <div class="book-title"><%=fb.getBookTitle() %></div>
		                                <a href="#" class="material-symbols-outlined close-btn">close</a>
		                            </div>
		                            <div class="genre"><%=fb.getGenreName() %></div>
		                            <div class="writer-wrap">
		                                <span class="material-symbols-outlined">drive_file_rename_outline</span>
		                                <div class="writer"><%=fb.getBookWriter() %></div>
		                            </div>
		                            <div class="book-date">작품 등록일 : <span class="book-date"><%=fb.getBookDate() %></span></div>
		                            <div>
		                                <a href="#" class="btn bc6 read-btn">보기</a>
		                                <a href="#" class="btn bc000 bc444 sup-btn">후원하기</a>
		                            </div>
		                        </div>
		                    </div>
	                	<%} %>
	                </div>
            	<%} %>
            </div>
        </div>
    </div>
    <%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>