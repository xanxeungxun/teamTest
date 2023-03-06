<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    .book-img-file{
        width: 200px;
        height: 260px;
        background-color: rgb(218, 218, 218);
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
            <form action="/updateBook.do" method="post">
                <div class="content-wrap">
                    <div class="book-img">
                        <div class="book-img-file"></div>
                        <div class="notice-msg">600*800 픽셀 이상</div>
                        <div class="upfile">
                            <label for="book-img-upfile" class="btn bc4">파일 선택</label>
                            <input type="file" name="book-img-upfile" id="book-img-upfile" style="display:none">
                        </div>
                    </div>
                    <div class="book-info">
                        <div>
                            <div class="bold">상태 <span class="star">*</span></div>
                            <label><input type="radio" name="status" value="ing">연재</label>
                            <label><input type="radio" name="status" value="fin">완결</label>
                        </div>
                        <div>
                            <label class="bold">제목 <span class="star">*</span></label><input type="text" name="bookTitle" id="bookTitle" class="input-form" placeholder="작품 제목">
                            <div class="notice-msg">최대 30자까지 입력할 수 있습니다.</div>
                        </div>
                        <div>
                            <label class="bold">설명 <span class="star">*</span></label>
                            <textarea cols="50" rows="10" class="input-form" placeholder="작품 설명"></textarea>
                            <div class="notice-msg">최대 100자까지 입력할 수 있습니다. 작품의 개요, 연재 정보, 독자를 위한 인삿말 등 작품을 매력적으로 소개해보세요.</div>
                        </div>
                        <div>
                            <div class="bold">장르 설정 <span class="star">*</span></div>
                            <select name="genre" class="input-form">
                                <option value="판타지">판타지</option>
                                <option value="판타지">로맨스</option>
                                <option value="판타지">로맨스판타지</option>
                                <option value="판타지">무협</option>
                                <option value="판타지">퓨전</option>
                                <option value="판타지">게임</option>
                                <option value="판타지">역사</option>
                                <option value="판타지">스포츠</option>
                                <option value="판타지">라이트노벨</option>
                                <option value="판타지">BL</option>
                                <option value="판타지">GL</option>
                                <option value="판타지">패러디</option>
                                <option value="판타지">팬픽</option>
                                <option value="판타지">SF</option>
                                <option value="판타지">밀리터리</option>
                                <option value="판타지">시</option>
                                <option value="판타지">소설</option>
                                <option value="판타지">수필</option>
                                <option value="판타지">공포</option>
                                <option value="판타지">추리</option>
                                <option value="판타지">아동</option>
                                <option value="판타지">시나리오/희곡</option>
                                <option value="판타지">비평</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="foot-btn">
                    <a href="#" class="btn bc33">취소</a>
                    <button type="submit" class="btn bc6">수정 완료</button>
                </div>
            </form>
        </div>
    </div>
    <%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>