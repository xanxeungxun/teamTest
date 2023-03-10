<%@page import="com.iei.book.model.vo.Book"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	ArrayList<Book> searchList = (ArrayList<Book>)request.getAttribute("searchList");
	String naviCode = (String)request.getAttribute("naviCode");
	int begin = (int)request.getAttribute("begin");
	String result="";
%>    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>소설게시판</title>
    
    <link rel="stylesheet" href="/css/bookList.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

    <style>
        .material-symbols-outlined {
            font-variation-settings:
            'FILL' 0,
            'wght' 300,
            'GRAD' 0,
            'opsz' 48;
        }
        .bookmarks{
            font-variation-settings:
            'FILL' 1,
            'wght' 300
        }
        .book-img{
        width: 180px;
        height: 240px;
        background-color: #fff;
        border-radius: 4px;
        margin-right: 10px;
        border : 1px solid #EEEEEE;
    }
    </style>
</head>

<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="page-content">
        <div class="book-wrap">

            <div class="book-list-header">
                <div>전체소설</div>
            </div>

            <div class="book-list">
                
           <!--     
                <div class="book-one">
                    <div class="book-one-cover">
                        소설표지
                    </div>
                    <div class="book-one-etc">
                        <div class="book-one-title"><a href="#">소설 글자수는 이정도 이정도 이정도 소설제목 소설제목 소설...</a></div>
                        <div class="book-one-subTitle">
                            <span class="genre"><a href="#">장르이름</a></span>
                            <span class=""><a href="#">올라온 화 수</a></span>
                        </div>
                        <div class="book-one-writer"><a href="#">글쓴이</a></div>
                        <div class="book-one-syn">
                            미안해, 솔직하지 못 한 내가
                            지금 이 순간이 꿈이라면
                            살며시 너에게로 다가가
                            모든 걸 고백 할텐데
                            전화도 할 수 없는 밤이 오면
                        </div>
                        <div class="book-one-exp">
                            <span class="material-symbols-outlined">
                                visibility
                            </span>
                            <span class="book-one-count">조회수</span>
                            <span class="material-symbols-outlined bookmarks">
                                bookmarks
                            </span>
                            <span class="subscriber">구독자수</span>
                        </div>
                    </div>
                </div><!--작품하나..-->
            
            <%if(!searchList.isEmpty()){ %>
            	
            
            <%for(int i=0 ; i<searchList.size() ; i++){ %>
            <%		Book b = searchList.get(i);		  %>
            	
            	<div class="book-one">
                    <div class="book-one-cover" onclick="location.href='/storyList.do?bookNo=<%=b.getBookNo()%>';">
  						 <img class="book-img" src="/upload/cover-image/<%=b.getCoverpath() %>" style="cursor:pointer;">
                    </div>
                    <div class="book-one-etc">	
                        <div class="book-one-title">
	                        <a href="/storyList.do?bookNo=<%=b.getBookNo()%>">
		                        <%=b.getBookTitle() %>
	                        </a>
                        </div>
                        <div class="book-one-subTitle">
                            <span class="genre"><a href="#"><%=b.getGenreName() %></a></span>
                            <span class="gray-bar">|</span>
                            <span>총 <%=b.getStoryCount()%>화</span>
                        </div>
                        <div class="book-one-writer"><a href="#"><%=b.getBookWriterNick() %></a></div>
                        <div class="book-one-syn">
	                        <a href="/storyList.do?bookNo=<%=b.getBookNo()%>">
		                        <%=b.getBookExp() %>
	                        </a>
                        </div>
                        <div class="book-one-exp">
                            <span class="material-symbols-outlined">
                                visibility
                            </span>
                            <span class="book-one-count"><%=b.getAllViewer() %></span>
                            <span class="material-symbols-outlined bookmarks">
                                bookmarks
                            </span>
                            <span class="subscriber"><%=b.getAllScore() %></span>
                        </div>
                    </div>
                </div><!--작품하나..-->
            	
            <%} %>
            
            </div><!--book-list-->
            
			<div id="pageNavi" style="margin-bottom: 50px;">
			<%=naviCode %>
			</div>
			
			<%}else{ %>
				<div style="text-align:center; color:#cccccc;">검색 결과가 없습니다.</div>
            <%}%>
			
      </div><!-- book-wrap -->
</div><!-- page-content -->

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>