<%@page import="com.iei.story.model.vo.Story"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.iei.book.model.vo.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Book b = (Book)request.getAttribute("b");
    	ArrayList<Story> storyList = (ArrayList<Story>)request.getAttribute("storyList");
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
                    
                    
                    
                    <div class="book-button">
                    
                    <!-- 만약 b.get작가아이디가 세션에 있는 작가 아이디랑 같다면 
                    <if(loginUser.getUserId().equals(b.getBookWriterId())){%>
                    	<button class="btn bc66" style="margin-bottom: 10px;">완결작품으로 전환</button>
                        <button class="btn bc6">글쓰기</button>
                    <} %> --> 
                
                    	
                    </div>
                    
                    
                    
                </div><!--book-content-->

                <div class="switch-zone">
                    <div class="author-menu">
                        <button class="all-check btn bc3">전체선택</button>
                        <button class="btn bc3">삭제하기</button>
                    </div><!--author-menu-->
                </div>


			<!-- 여기서부턴 스토리리스트 ================================================= -->

                <div class="book-story">
                
                <%for(int i=0 ; i < storyList.size() ; i++){ 
                		Story s = storyList.get(i);
                %>
                
	                    <div class="one-story">
	                        <div class="icon-or-box">
	                            <span id="none">
	                            	new
	                            </span>
	                            <input type="checkbox" id="check" name="check">
	                        </div>
	                        <div class="story-scene">
	                            <%=s.getRownum() %>화
	                        </div>
	                        <div class="story-title">
	                            <a href="#">
	                            <%=s.getStoryName() %>
	                            </a>
	                        </div>
	                        <div class="story-coment">
	                            <span class="material-symbols-outlined">
	                                forum
	                            </span>
	                            <span>
	                            <%=s.getReadCount() %>
	                            </span>
	                        </div>
	                        <div class="story-date">
	                            <%=s.getStoryTime() %>
	                        </div>
	                    </div><!--스토리 하나-->
                    
                <%} %>    
                    
                </div><!--book-story-->

            </div><!--book-content-box-->

        </div><!--book-wrap-->
    </div><!--page-content-->

<%@ include file="/WEB-INF/views/common/footer.jsp" %>


	<script>
	/*
	
	<button class="btn bc66" style="margin-bottom: 10px;">첫 화 보기</button>
    <button class="btn bc6" style="margin-bottom: 10px;">후원하기</button>
    <button class="btn bc6">관심작품</button> */
    
    const a = $("<a>");
    a.text("이건되나");
    $(".book-button").append(a);
	
	</script>
</body>
</html>