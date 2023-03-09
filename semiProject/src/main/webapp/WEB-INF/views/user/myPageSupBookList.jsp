<%@page import="com.iei.mypage.vo.SupportBook"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<SupportBook> supList = (ArrayList<SupportBook>)request.getAttribute("supList");
    String pageNavi = (String)request.getAttribute("pageNavi");
    int start = (int)request.getAttribute("start");
    %>
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

        overflow: hidden;
    }
    .book-box{
    	width: 420px;
    	height: 190px;
        display: flex;
        float: left;
        margin: 10px;
        padding: 10px;
        justify-content: space-between;
        border : 1px solid #EEEEEE;
        border-radius: 4px;
        box-sizing: border-box;
    }
    .book-img{
        width: 130px;
        height: 100%;
        background-color: #fff;
        border-radius: 4px;
        margin-right: 10px;
        border : 1px solid #EEEEEE;
    }
    .book-info>div, .book-info>div>div{
        padding-top: 3px;
        padding-bottom: 3px;
    }
    .book-info{
    	width: 250px;
    	position: relative;
    }
    .book-info-head{
        display: flex;
        justify-content: space-between;
    }
    .close-btn{
        cursor: pointer;
    }

    .genre{
        font-size: 12px;
    }
    .book-date{
        font-size: 12px;
        color: #a7a7a7;
    }
    .writer-wrap{
        display: flex;
    }
    .writer-wrap>.material-symbols-outlined{
    	margin: 0;
        font-size: 18px;
        margin-right: 3px;
    }
    .writer{
        font-size: 15px;
    }
	.box{
        position: absolute;
        bottom: 0;
    }
    .box>div>.sup-btn{
    	padding: 0;
		width: 250px;
	    height: 50px;
	    text-align: center;
	    font-size: 15px;
	    line-height: 50px;
	    cursor: default;
    }
    .sup-money{
        color: #ffc6d3;
        font-size: 15px;

    }
</style>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
    <div class="page-content mypage-content">
    	<%@include file="/WEB-INF/views/user/myPageMenu.jsp" %>
        <div class="mypage-detail">
            <div class="page-title">후원작품 목록</div>
            <%if(supList.size() == 0) { %>
           	<div class="line"></div>
			<div class="inform-wrap">
				<span class="material-symbols-outlined book-icon">import_contacts</span>
				<div class="msg">후원한 작품이 없습니다.</div>
			</div>
			<%
			} else {
			%>
            <div class="content-wrap">
                <div class="line-content">
                	<%for(int i=0; i<supList.size(); i++) { %>
                		<%SupportBook sb = supList.get(i); %>
	                    <div class="book-box">
	                        <a href="/storyList.do?bookNo=<%=sb.getBookNo() %>"><img src="/upload/cover-image/<%=sb.getCoverPath()%>" class="book-img"></a>
	                        <div class="book-info">
	                            <div class="book-info-head">
	                                <a href="/storyList.do?bookNo=<%=sb.getBookNo() %>" class="book-title"><%=sb.getBookTitle() %></a>
	                            </div>
	                            <div class=box>
		                            <div class="genre"><%=sb.getGenreName() %></div>
		                            <div class="writer-wrap">
		                                <span class="material-symbols-outlined">drive_file_rename_outline</span>
		                                <a href="/uploadBookList.do?userId=<%=sb.getBookWriter()%>&reqPage=1" class="writer"><%=sb.getRecvUserNick() %></a>
		                            </div>
		                            <div class="book-date">작품 등록일 : <span class="book-date"><%=sb.getBookDate() %></span></div>
		                            <div>
		                                <div class="btn bc4 sup-btn">후원금액 : <span class="sup-money"><%=sb.getTotalSupportMoney() %></span> P</div>
		                            </div>
	                            </div>
	                        </div>
	                    </div>
                	<%} %>
            	</div>
       		</div>
       		<div id="pageNavi"><%=pageNavi %></div>
       		<%} %>
       	</div>
    </div>
    <%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>