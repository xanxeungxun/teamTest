<%@page import="com.iei.book.model.vo.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Book b = (Book)request.getAttribute("b");
    %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=b.getBookTitle() %></title>
	
	<link rel="stylesheet" href="/css/storyList.css">
	
	
	<style>
        .material-symbols-outlined {
            font-variation-settings:
            'FILL' 0,
            'wght' 300,
            'GRAD' 0,
            'opsz' 48;
            font-size: 24px;
        }
        .bookmarks{
            font-variation-settings:
            'FILL' 1,
            'wght' 300
        }
    </style>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

	<div class="page-content">
        <div class="book-wrap">
            
            <div class="book-list-header">
                <div>작품상세</div>
            </div>

            <div class="book-content-box">

                <div class="book-content">
                    <div class="book-cover"
                    	 style="background-image: url(/upload/cover-image/<%=b.getCoverpath() %>);
                    	 background-size: contain;
  						 background-position: center;
  						 background-repeat: no-repeat;">
                    </div>
                    <div class="book-exp">
                        <div class="book-title">
                            <%=b.getBookTitle() %>
                        </div>
                        <div class="book-genre">
                            <span><%=b.getGenreName() %></span>
                            <span class="gray-bar">|</span>
                            <span class="material-symbols-outlined">
                                visibility
                            </span>
                            <span>총 조회수</span>
                            <span class="gray-bar">|</span>
                            <span class="material-symbols-outlined bookmarks">
                                bookmarks
                            </span>
                            <span>총 구독자수</span>
                            <span class="gray-bar">|</span>
                            <span>
                            <%=b.getBookStatus() %>
                            </span>
                            <a href="#">
                                <span class="report material-symbols-outlined" style="font-size:22px;">e911_emergency</span>
                            </a>
                        </div>
                        <div class="book-writer">
                            <%=b.getBookWriterNick() %>
                        </div>
                        <div class="book-synop">
                            <%=b.getBookExp() %>
                        </div>
                    </div>
                    <div class="book-botton">
                        <button class="btn bc66" style="margin-bottom: 10px;">첫 화 보기</button>
                        <button class="btn bc6" style="margin-bottom: 10px;">후원하기</button>
                        <button class="btn bc6">관심작품</button>
                    </div>
                </div><!--book-content-->

                <div class="switch-zone">
                    <div class="author-menu">
                        <button class="all-check btn bc3">전체선택</button>
                        <button class="btn bc3">삭제하기</button>
                    </div><!--author-menu-->
                </div>

                <div class="book-story">
                    <div class="one-story">
                        <div class="icon-or-box">
                            <span id="none">
                            	new
                            </span>
                            <input type="checkbox" id="check" name="check">
                        </div>
                        <div class="story-scene">
                            0000화
                        </div>
                        <div class="story-title">
                            <a href="#">
                            100바이트 다 채운 소설제목?? 공백포함 100바이트 몇글자정도 cERA di CUPra
                            </a>
                        </div>
                        <div class="story-coment">
                            <span class="material-symbols-outlined">
                                forum
                            </span>
                            <span>000</span>
                        </div>
                        <div class="story-date">
                            2023-03-14
                        </div>
                    </div><!--스토리 하나-->
                    
                </div><!--book-story-->

            </div><!--book-content-box-->

        </div><!--book-wrap-->
    </div><!--page-content-->

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>