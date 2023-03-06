<%@page import="com.iei.book.model.vo.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    Book book = (Book)request.getAttribute("book");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="/css/default.css">
    <link rel="stylesheet" href="/css/mypageDefault.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<style>
	.no-cover{
		width: 200px;
        height: 260px;
        background-color: #EEEEEE;
        border-radius: 4px;
	}
    .book-img-file{
        width: 200px;
        height: 260px;
        background-color: #fff;
        border : 1px solid #EEEEEE;
        border-radius: 4px;
    }
    .bold{
        font-family: ns-m;
        margin-bottom: 10px;
    }
    .notice-msg{
        text-align: center;
        padding: 5px 0px 5px 0px;
    }
    .upfile{
        text-align: right;
    }
    .upfile>.bc4{
        font-size: 14px;
        padding: 12px 15px;
    }
    .input-form{
        margin: 10px 0px 5px 0px;
    }
    .book-info>div{
        margin-top: 10px;
    }
    .book-info>div:not(:first-child){
        margin-top: 40px;
    }
    .content-wrap{
        padding: 35px 45px 35px 45px;
        display: flex;
    }
    .book-info{
        margin-left: 70px;
        width: 50%;
    }
    [type="radio"]{
        margin-right: 5px;
    }
    .book-info>div:first-child>label:last-child{
        margin-right: 5px;
    }
    .notice-msg{
        font-size: 12px;
        color: #a7a7a7;
        text-align: left;
    }
    .book-info select{
        width: 140px;
    }
    .star{
        color: #fea1bf;
    }
    .content-wrap>.book-info textarea {
    width: 100%;
    height: 4.25em;
    resize: none;
  }
  .book-info>div:first-child>label{
    margin-right: 10px;
  }
</style>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
    <div class="page-content mypage-content">
    	<%@include file="/WEB-INF/views/user/myPageMenu.jsp" %>
        <div class="mypage-detail">
            <div class="page-title">작품 정보 수정</div>
            <form action="/updateBook.do" method="post" enctype="multipart/form-data">
            	<input type="text" name="bookNo" value="<%=book.getBookNo() %>" style="display:none">
                <div class="content-wrap">
                    <div class="book-img">
                    	<%if(book.getCoverpath()==null){ %>
	                    	<div class="no-cover"></div>
                    	<%} else { %>
	                        <img src="/upload/cover-image/<%=book.getCoverpath()%>" id="cover-img" class="book-img-file">
                    	<%} %>
                        <div class="notice-msg">600*800 픽셀 이상</div>
                        <div class="upfile">
                            <label for="book-img-upfile" class="btn bc4">파일 선택</label>
                            <input type="file" name="book-img-upfile" id="book-img-upfile" class="upload-hidden" accept="image/*" style="display:none">
                        </div>
                    </div>
                    <div class="book-info">
                        <div>
                            <div class="bold">상태 <span class="star">*</span></div>
                            <%if(book.getBookStatus().equals("1")) { %>
                            <label><input type="radio" name="status" value="1" checked>연재</label>
                            <label><input type="radio" name="status" value="2">완결</label>
                            <%} else if(book.getBookStatus().equals("2")) { %>
                            <label><input type="radio" name="status" value="1">연재</label>
                            <label><input type="radio" name="status" value="2" checked>완결</label>
                            <%} %>
                        </div>
                        <div>
                            <label class="bold">제목 <span class="star">*</span></label><input type="text" name="bookTitle" id="bookTitle" class="input-form" placeholder="작품 제목" value="<%=book.getBookTitle()%>">
                            <div class="notice-msg">최대 30자까지 입력할 수 있습니다.</div>
                        </div>
                        <div>
                            <label class="bold">설명 <span class="star">*</span></label>
                            <textarea cols="50" rows="10" name="bookExp" class="input-form" placeholder="작품 설명"><%=book.getBookExp()%></textarea>
                            <div class="notice-msg">최대 100자까지 입력할 수 있습니다. 작품의 개요, 연재 정보, 독자를 위한 인삿말 등 작품을 매력적으로 소개해보세요.</div>
                        </div>
                        <div>
                            <div class="bold">장르 설정 <span class="star">*</span></div>
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
                    </div>
                </div>
                <div class="foot-btn">
                    <a href="/uploadBookList.do?userId=<%=loginUser.getUserId()%>&reqPage=1" class="btn bc33">취소</a>
                    <button type="submit" class="btn bc6">수정 완료</button>
                </div>
            </form>
        </div>
    </div>
    <%@include file="/WEB-INF/views/common/footer.jsp" %>
    <script>
	/*1. 프로필 이미지 업로드*/
	$(document).ready(function(){
	    //파일첨부 이벤트
	    $('.upfile>.upload-hidden').on('change', function(){  	
	        
	        if(!validFileSize($(this)[0].files[0])){
	            alert("파일 사이즈가 10MB를 초과합니다.");
	            return false;
	        } else {
	            var filename = $(this).val().split('/').pop().split('\\').pop();
	            $("#cover-img").css({"background-image":"url(/upload/cover-image/"+filename+")"}); //input upload-name 에 파일명 설정해주기

	            readImage($(this)[0]); //미리보기

	            //기본이미지 삭제 / 업로드 이미지 보이기10
	            /*$('.no-cover').css("display","none");
	            $('#cover-img').css("display","inline-block");*/
	        }
	    });
	});

	//파일 용량 10MB 제한
	function validFileSize(file){
	    if(file.size > 10000000){ //10MB
	        return false;
	    }else{
	        return true;
	    }
	}

	//이미지 띄우기
	function readImage(input) {
	    if(input.files && input.files[0]) {
	        const reader = new FileReader();
	        reader.onload = function(e){
	            const previewImage = document.getElementById("cover-img");
	            previewImage.src = e.target.result;
	        }
	        // reader가 이미지 읽도록 하기
	        reader.readAsDataURL(input.files[0]);
	    }
	}
    </script>
</body>
</html>