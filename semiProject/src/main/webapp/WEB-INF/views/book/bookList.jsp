<%@page import="com.iei.book.model.vo.Book"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	ArrayList<Book> list = (ArrayList<Book>)request.getAttribute("bookList");
	String naviCode = (String)request.getAttribute("naviCode");
	int start = (int)request.getAttribute("start");
	String result1="";
	String result2="";
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
                <div>
                   <ul>
                        <li><a href="/bookList.do?reqPage=1">최신순</a><span class="gray-bar">|</span></li>
                        <li><a href="/bookListViews.do?reqPage=1">인기순</a><span class="gray-bar">|</span></li>
                        <li><a href="/bookListComplete.do?reqPage=1">완결</a></li>
                    </ul>
                </div>
                <form name="genreFrm" action="/selectGenre.do" method="get">
                	<input type="hidden" name="reqPage" value="1">
	                <div class="book-selectBox">
		               	<select name="genre" class="input-form">
		                    <option value="1">판타지</option>
		                    <option value="2">로맨스</option>
		                    <option value="3">로맨스판타지</option>
		                    <option value="4">무협</option>
		                    <option value="5">퓨전</option>
		                    <option value="6">게임</option>
		                    <option value="7">역사</option>
		                    <option value="8">스포츠</option>
		                    <option value="9">라이트노벨</option>
		                    <option value="10">BL</option>
		                    <option value="11">GL</option>
		                    <option value="12">패러디</option>
		                    <option value="13">팬픽</option>
		                    <option value="14">SF</option>
		                    <option value="15">밀리터리</option>
		                    <option value="16">시</option>
		                    <option value="17">소설</option>
		                    <option value="18">수필</option>
		                    <option value="19">공포</option>
		                    <option value="20">추리</option>
		                    <option value="21">아동</option>
		                    <option value="22">시나리오/희곡</option>
		                    <option value="23">비평</option>
		            	</select>
	                </div>
                </form>
            </div>

            <div class="book-list">
                
          
            <%for(int i=0 ; i<list.size() ; i++){ %>
            <%		Book b = list.get(i);		  %>
            	
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
			
      </div><!-- book-wrap -->
</div><!-- page-content -->

<%@ include file="/WEB-INF/views/common/footer.jsp" %>

<script>
	const selectGenre = $("[name=genre]");
	const selectGenreVal = $("[name=genre]").val();
	const options = $("[name=genre]>option");
	$(selectGenre).change(function(){
		$("[name=genreFrm]").submit();
	});
</script>
</body>
</html>