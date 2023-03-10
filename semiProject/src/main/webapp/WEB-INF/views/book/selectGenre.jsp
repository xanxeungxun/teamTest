<%@page import="com.iei.book.model.vo.Book"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	ArrayList<Book> genreList = (ArrayList<Book>)request.getAttribute("genreList");
	String naviCode = (String)request.getAttribute("pageNavi");
	int start = (int)request.getAttribute("start");
	int selectGenreCode = (int)request.getAttribute("selectGenreCode");
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
    </style>
</head>

<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="page-content">
        <div class="book-wrap">

            <div class="book-list-header">
                <div>전체소설</div>
                <form name="genreFrm" action="/selectGenre.do" method="post">
                	<input type="hidden" name="reqPage" value="1">
                	<input type="hidden" name="selectGenreCode" value="<%=selectGenreCode %>">
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
            
            <%for(int i=0 ; i<genreList.size() ; i++){ %>
            <%		Book b = genreList.get(i);		  %>
            	
            	<div class="book-one">
                    <div class="book-one-cover"
                    	 style="background-image: url(/upload/cover-image/<%=b.getCoverpath() %>);
                    	 background-size: contain;
  						 background-position: center;
  						 background-repeat: no-repeat;
  						 cursor : pointer;"
  						 onclick="location.href='/storyList.do?bookNo=<%=b.getBookNo()%>';">
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
                            <span class="book-one-count">조회수</span>
                            <span class="material-symbols-outlined bookmarks">
                                bookmarks
                            </span>
                            <span class="subscriber">구독자수</span>
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
	/*const selectGenre = $("[name=genre]");
	const selectGenreVal = $("[name=genre]").val();*/

	$("[name=genre]").change(function(){
		const selectGenreCode = $("[name=selectGenreCode]");
		const options = $("[name=genre]>option");
		options.each(function(index,item){
			if($(item).val() == selectGenreCode){
				$(item).prop("selected",true);
			}
		});
		
		$("[name=genreFrm]").submit();
	});

	//[작품 설정 수정] 장르코드 기본 선택
	$(function(){
		const selectGenreCode = $("[name=selectGenreCode]").val();
		const options = $("[name=genre]>option");
		options.each(function(index,item){
			if($(item).val() == selectGenreCode){
				$(item).prop("selected",true);
			}
		});
	});
	
	
		
</script>
</body>
</html>