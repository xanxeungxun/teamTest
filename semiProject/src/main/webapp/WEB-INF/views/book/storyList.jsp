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
	<link rel="stylesheet" href="/css/assist.css">
	
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
	                            <a href="/storyView.do?storyNo=<%=s.getStoryNo()%>">
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


					 <div id="test-modal" class="modal-bg">
				      <div class="modal-wrap">
				        <div class="modal-head">
				          <h2>후원하기</h2>
				          <span class="material-icons close-icon modal-close">close</span>
				        </div>
		        	<form action="/assistPoint.do" method="post">
				        <div class="point-wrap">
					        	<table class="point-tbl">
					        		<tr class="point-tr1">
					        			<td>보유포인트</td>
					        			<td>사용할 포인트</td>
					        		</tr>
					        		<tr class="point-tr2">
					        			<td class="point-td1">
					        				<%if(loginUser != null) {%>
					        					<%=loginUser.getUserPoint() %>
					        				<%}else {%>
					        					0
					        				<%} %>
					        			</td>
					        			<td class="input-td">
					        				<input type="text" name="input-point" id="input-point">
					        			</td>
					        			
					        		</tr>
					        		<tr class="point-tr3">
					        			<td colspan="2">부족한 포인트를 충전하고 포스트를 감상해보세요.</td>
					        		</tr>
					        		<tr class="point-tr4">
					        			<td colspan="2">
					        				<a href="#" class="btn bc6">포인트 충전</a>
					        			</td>
					        		</tr>
					        		<tr>
					        			<td colspan="2" class="text-td">주식회사 에브리데이는 회원 상호 간 콘텐츠 거래를 위한 중개 시스템을 제공할 뿐, 회원을 대리하지 않습니다. 환급,취소 등 회원 간 성립된 거래에 대한 모든 책임은 회원이 직접 부담합니다. 자세한 내용은 서비스 이용 전 동의하신 이용약관을 참고해주세요.</td>
					        		</tr>
					        	</table>
					        </div>
					        <div class="modal-foot">
					          <button type="submit" class="btn bc6 btn-pill">후원</button>
					          <button type="button" class="btn bc33 modal-close btn-pill">취소</button>
					        </div>
			        	</form>
				      </div>
				    </div>
				    
				    
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
<%
if(loginUser==null || !loginUser.getUserId().equals(b.getBookWriterId())){%>
	<script>
			/*	
			<button class="btn bc66" style="margin-bottom: 10px;">첫 화 보기</button>
			<button class="btn bc6" style="margin-bottom: 10px;">후원하기</button>
			<button class="btn bc6">관심작품</button>
			*/
			const button1 = $("<button>");
			const button2 = $("<button target='#test-modal'>");
			const button3 = $("<button>");
			
			button1.text("첫 화 보기");
			button1.addClass("btn bc44");
			button1.css("margin-bottom","10px");
			
			button2.text("후원하기");
			button2.addClass("btn bc4 modal-open-btn");
			button2.css("margin-bottom","10px");
			
			
			button3.text("관심작품");
			button3.addClass("btn bc4");
			
			
			$(".book-button").append(button1);
			$(".book-button").append(button2);
			$(".book-button").append(button3);
	</script>
<% 
}else if(loginUser.getUserId().equals(b.getBookWriterId())){
	//세션 기록된 유저아이디랑 작품의 작가랑 동일할 때 -->> 작가본인일때
%>	
	<script>
	    	/*
		    	<button class="btn bc66" style="margin-bottom: 10px;">완결작품으로 전환</button>
	            <button class="btn bc6">글쓰기</button>
	    	*/
	    	const button1 = $("<button>");
	    	const button2 = $("<button>");
	    	
	    	button1.text("완결작으로 전환");
		    button1.addClass("btn bc44");
		    button1.css("margin-bottom","10px");
		    
		    button2.text("글쓰기");
		    button2.addClass("btn bc4");
		    button2.attr("onclick","location.href='/storyWriteFrm.do'");
		    
		    $(".book-button").append(button1);
		    $(".book-button").append(button2);
		    

	</script>
<%
}
%>




</body>
</html>