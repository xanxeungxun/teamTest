<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="/css/mypageDefault.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,1,0" />
</head>
<style>
    .line-content{
        display: flex;
        justify-content: space-between;
    }
    .book-box{
        display: flex;
        margin: 10px;
        width: 100%;
        border: 1px solid lightgray;
        border-radius: 4px;
        padding: 20px;
        padding-left: 30px;
    }
    .book-num{
        font-size: 20px;
        font-family: ns-bold;
        margin-top: 10px;
        margin-right: 20px;
    }
    .book-img{
        width: 120px;
        background-color: #a7a7a7;
        border-radius: 4px;
        margin-right: 20px;
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
    .book-btn{
        width: 120px;
        text-align: center;
    }
</style>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
    <div class="page-content mypage-content">
    	<%@include file="/WEB-INF/views/user/myPageMenu.jsp" %>
        <div class="mypage-detail">
            <div class="page-title">투고한 작품 확인</div>
            <div class="content-wrap">
                <div class="line-content">
                    <div class="book-box">
                        <div class="book-num">1</div>
                        <div class="book-img"></div>
                        <div class="book-info">
                            <div class="book-info-head">
                                <div class="book-title">(작품제목)</div>
                            </div>
                            <div class="genre">(장르)</div>
                            <div class="writer-wrap">
                                <span class="material-symbols-outlined">drive_file_rename_outline</span>
                                <div class="writer">(작가이름)</div>
                            </div>
                            <div class="book-date">작품 등록일 : <span class="book-date">(날짜)</span></div>
                            <div>
                                <a href="#" class="btn bc6 book-btn">수정</a>
                                <a href="#" class="btn bc33 book-btn">삭제</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>