<%@page import="com.iei.mypage.vo.UploadBook"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<UploadBook> upList = (ArrayList<UploadBook>)request.getAttribute("upList");
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
    <script src="/js/sweetalert.min.js"></script>
</head>
<style>
    .line-content{
        width: 880px;
    }
    .book-box{
        display: flex;
        height: 160px;
        margin: 10px;
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
        background-color: #fff;
        border : 1px solid #EEEEEE;
        border-radius: 4px;
        margin-right: 20px;
    }
    .book-info{
    	position: relative;
    }
    .box{
    	position: absolute;
    	bottom: 0;
    }
    .book-info>div>div{
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
    .book-btn{
        width: 120px;
        text-align: center;
    }
    
    .modal-wrap>.modal-content{
    	padding: 1.2rem 1.2rem;
    	padding-top: 30px;
    	padding-bottom: 30px;
    }
</style>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
    <div class="page-content mypage-content">
    	<%@include file="/WEB-INF/views/user/myPageMenu.jsp" %>
        <div class="mypage-detail">
            <div class="page-title">투고한 작품 확인</div>
           	<%if(upList.size() == 0) { %>
           	<div class="line"></div>
			<div class="inform-wrap">
				<span class="material-symbols-outlined book-icon">import_contacts</span>
				<div class="msg">투고한 작품이 없습니다.</div>
			</div>
			<%
			} else {
			%>
            <div class="content-wrap">
                <div class="line-content">
                	<%for(int i=0; i<upList.size(); i++) { %>
                		<%UploadBook ub = upList.get(i); %>
	                    <div class="book-box">
	                        <div class="book-num"><%=i+start %></div>
	                        <div style="background-image: url(/upload/cover-image/<%=ub.getCoverPath()%>); background-size: contain; background-position: center;  background-repeat: no-repeat; cursor : pointer;" class="book-img"></div>
	                        <div class="book-info">
	                            <div class="book-info-head">
	                                <div class="book-title"><%=ub.getBookTitle() %></div>
	                            </div>
	                            <div class="box">
		                            <div class="genre"><%=ub.getGenreName() %></div>
		                            <div class="writer-wrap">
		                                <span class="material-symbols-outlined">drive_file_rename_outline</span>
		                                <div class="writer"><%=ub.getBookWriter() %></div>
		                            </div>
		                            <div class="book-date">작품 등록일 : <span class="book-date"><%=ub.getBookDate() %></span></div>
		                            <div>
		                                <a href="/updateBookFrm.do?bookNo=<%=ub.getBookNo() %>" class="btn bc6 book-btn">수정</a>
		                                <button class="btn bc33 book-btn modal-open-btn" onclick="deleteUploadBook(<%=ub.getBookNo()%>, '<%=ub.getBookWriter()%>');">작품 삭제</button>
		                                <%--<a href="/deleteUploadBook.do?bookNo=<%=ub.getBookNo() %>&bookWriter=<%=ub.getBookWriter() %>" class="btn bc33 book-btn modal-open-btn">작품 삭제</a> --%>
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
<%--    <div id="test-modal" class="modal-bg">
      <div class="modal-wrap">
        <div class="modal-head">
          <h2>확인</h2>
          <span class="material-icons close-icon modal-close">close</span>
        </div>
        <div class="modal-content">
          <p>작성하신 작품을 정말로 삭제하시겠습니까?</p>
        </div>
        <div class="modal-foot">
          <a href="/deleteUploadBook.do" class="btn bc6 btn-pill">확인</a>
          <button class="btn bc33 modal-close btn-pill">취소</button>
        </div>
      </div> --%>
      
      <script>
	      function deleteUploadBook(bookNo, bookWriter) {
	          swal({
	              title: '작품 삭제',
	              text: "작품을 삭제하시겠습니까?",
	              icon: 'warning',
	              showCancelButton: true,
	              /*confirmButtonColor: '#AACB73',
	              cancelButtonColor: '#ccc',*/
	              confirmButtonText: '확인',
	              cancelButtonText: '취소'
	          }).then(function(result) {
	              if (result) {
	                  location.href="/deleteUploadBook.do?bookNo="+bookNo+"&bookWriter="+bookWriter;
	              }
	          })
	      }
      </script>
</body>
</html>