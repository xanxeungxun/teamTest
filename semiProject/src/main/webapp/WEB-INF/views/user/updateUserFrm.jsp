<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/css/mypageDefault.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<style>
   div>.user-bold{
        font-family: ns-m;
    }
    .update-input-wrap>div{
        padding: 15px 0px 15px 0px;
    }
    .content-wrap>div:first-child{
        padding-top: 20px;
    }


    .profile>.material-icons{
        font-size: 80px;
        color: #ccc
    }
    .profile{
        margin-top: 10px;
        display: flex;
    }

    .profile-file{
        overflow: hidden;
        padding-top: 20px;
        padding-bottom: 20px;
    }
    .profile>div>*{
        float: left;
    }
    .page-content .upfile-name{
        height: 44px;
        margin: 0;
        width: 480px;
        margin-left: 20px;
        font-size: 14px;
    }
    .profile-file>.upfile{
        width: 100px;
        height: 44px;
        padding: 0;
        text-align: center;
        line-height: 44px;
    }

    .input-form{
        margin: 10px 0px 10px 0px;
    }
    .pw-change-notice{
        padding: 10px 0px 10px 0px;
        font-size: 14px;
    }
    .pw-change-notice>ul{
        padding: 5px;
        list-style-position: inside;
    }
    .pw-change-notice li{
        padding: 3px 0px 3px 0px;
    }
    .pw-change-notice>.bold{
    	font-family: ns-m;
    }

    /*check-circle*/
    .update-input-wrap>div>div{
        position: relative;
    }
    div>.check-circle{
        color: #ffc6d3;
        position: absolute;
        z-index: 1;
        right: 10px;
        top: 12px;
        display: none;
    }

    div>.active-check-circle{
        display: block;
    }

    div>.active-reg-msg{
        color: #f86697;
        font-size: 12px;
    }
    div>.active-reg-input{
        margin-bottom: 2px;
        outline: 2px solid #f86697;
    }
</style>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content mypage-content">
		<%@include file="/WEB-INF/views/user/myPageMenu.jsp" %>
		<div class="mypage-detail">
			<div class="mypage-title page-title">회원정보 변경</div>
	        <form action="/updateUser.do" method="post" enctype="multipart/form-data">
	            <div class="content-wrap">
	                <div>
	                    <label for="profilePic" class="bold user-bold">프로필 사진</label>
	                    <div class="profile">
                            <img id="previewImg" style="width:80px; height:80px; display:none">
	                        <div class="material-icons no-profilePic">account_circle</div>
	                        <%=loginUser.getUserPic() %>
	                        <div class="profile-file">
	                            <div class="upfile-name input-form">파일을 선택해주세요</div>
	                            <label for="profile-upfile" class="btn bc6 upfile">파일 선택</label>
	                            <input type="file" name="profile-upfile" id="profile-upfile" class="upload-hidden" accept="image/*" style="display:none">
	                        </div>
	                    </div>
	                </div> 
	            	<div class="update-input-wrap">
                        <div>
                            <label for="userNick" class="bold user-bold">닉네임</label>
                            <div>
                                <span class="material-symbols-outlined check-circle">check_circle</span>
                                <input type="text" name="userNick" id="userNick" class="input-form input-update" value="<%=loginUser.getUserNick()%>">
                                <span class="reg-msg"></span>
                            </div>
                        </div>
                        <div>
                            <label for="userId" class="bold user-bold">아이디</label>
                            <div>
                                <input type="text" name="userId" id="userId" class="input-form" value="<%=loginUser.getUserId()%>" readonly>
                            </div>
                        </div>
                        <div>
                            <label for="userPhone" class="bold user-bold">전화번호</label>
                            <div>
                                <span class="material-symbols-outlined check-circle">check_circle</span>
                                <input type="text" name="userPhone" id="userPhone" class="input-form input-update" value="<%=loginUser.getUserPhone()%>">
                                <span class="reg-msg"></span>
                            </div>
                        </div>
                        <div>
                            <label for="userEmail" class="user-bold">이메일</label>
                            <div>
                                <span class="material-symbols-outlined check-circle">check_circle</span>
                                <input type="email" name="userEmail" id="userEmail" class="input-form input-update" value="<%=loginUser.getUserEmail()%>">
                                <span class="reg-msg"></span>
                            </div>
                        </div>
                        <div>
                            <label for="userPw" class="bold user-bold">비밀번호</label>
                            <div>
                                <span class="material-symbols-outlined check-circle">check_circle</span>
                                <input type="password" name="userPw" id="userPw" placeholder="현재 비밀번호" class="input-form input-update">
                                <span class="reg-msg"></span>
                            </div>
                            <div>
                                <span class="material-symbols-outlined check-circle">check_circle</span>
                                <input type="password" name="newPw" id="newPw" placeholder="새 비밀번호" class="input-form input-update">
                                <span class="reg-msg"></span>
                            </div>
                            <div>
                                <span class="material-symbols-outlined check-circle">check_circle</span>
                                <input type="password" name="newPwCh" id="newPwCh" placeholder="새 비밀번호 확인" class="input-form input-update">
                                <span class="reg-msg"></span>
                            </div>
                            <div class="pw-change-notice">
                                <div class="bold">비밀번호 변경 시 유의사항</div>
                                <ul>
                                    <li>· 8자 이상, 영문/숫자만 입력해주세요.</li>
                                    <li>· ID와 같은 비밀번호는 사용할 수 없습니다.</li>
                                </ul>
                            </div>
                        </div>
                    </div>
	            </div>
	            <div class="foot-btn">
	                <a href="#" class="btn bc33">취소</a>
	                <button type="submit" class="btn bc4">정보 수정</button>
	            </div>
	        </form>
		</div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<script>
		/*1. 프로필 이미지 업로드*/
		$(document).ready(function(){
		    //파일첨부 이벤트
		    $('.profile-file .upload-hidden').on('change', function(){  	
		        
		        if(!validFileSize($(this)[0].files[0])){
		            alert("파일 사이즈가 10MB를 초과합니다.");
		            return false;
		        } else {
		            var filename = $(this).val().split('/').pop().split('\\').pop();
		            $(this).prev().val(filename); //input upload-name 에 파일명 설정해주기
	
		            readImage($(this)[0]); //미리보기
	
		            //기본이미지 삭제 / 업로드 이미지 보이기
		            $('.no-profilePic').css("display","none");
		            $('#previewImg').css("display","inline-block");
	
		            //파일 이름 표시
		            $('.upfile-name').text(filename);
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
		            const previewImage = document.getElementById("previewImg");
		            previewImage.src = e.target.result;
		        }
		        // reader가 이미지 읽도록 하기
		        reader.readAsDataURL(input.files[0]);
		    }
		}
	
		/*2. 닉네임, 전화번호, 이메일 정규표현식*/
		//true일 때 CSS
		function trueDesign(i){
		    $(".check-circle").eq(i).addClass("active-check-circle");
		    $(".reg-msg").eq(i).text("");
		    $(".reg-msg").eq(i).removeClass("active-reg-msg");
		    $(".input-update").eq(i).removeClass("active-reg-input");
		}
		//false일 때 CSS
		function falseDesign(i){
		    $(".check-circle").eq(i).removeClass("active-check-circle");
		    $(".reg-msg").eq(i).addClass("active-reg-msg");
		    $(".input-update").eq(i).addClass("active-reg-input");
		}
	
		//(1) 닉네임
		$("[name=userNick]").on("change",function(){
		    const nickReg = /^[a-zA-Z가-힣]{1,10}$/;
		    const check = nickReg.test($(this).val());
	
		    if(check) {
		        //true
		        trueDesign(0);
	
		    } else {
		        //false
		        $(".reg-msg").eq(0).text("10글자 이내로 영문 대소문자/한글로만 입력해주세요.");
		        falseDesign(0);
		    }
		});
	
		//(2) 전화번호
		$("[name=userPhone]").on("change",function(){
		    const phoneReg = /^010-[0-9]{3,4}-[0-9]{4}$/;
		    const check = phoneReg.test($(this).val());
	
		    if(check) {
		        //true
		        trueDesign(1);
	
		    } else {
		        //false
		        $(".reg-msg").eq(1).text("전화번호를 올바르게 입력했는지 확인해주세요.");
		        falseDesign(1);
		    }
		});
	
		//(3) 이메일주소
		$("[name=userEmail]").on("change",function(){
		    const emailReg = /^[a-zA-Z0-9]{5,25}@/;
		    const check = emailReg.test($(this).val());
	
		    if(check) {
		        //true
		        trueDesign(2);
	
		    } else {
		        //false
		        $(".reg-msg").eq(2).text("5~25자의 영문 대소문자/숫자로만 입력해주세요.");
		        falseDesign(2);
		    }
		});
	
		/*3. 비밀번호 정규표현식*/
		//(1) 현재 비밀번호 맞는지 확인 -> loginUser.getUserPw()와 동일한지 체크
		$("[name=userPw]").on("change",function(){
		    const pwInputValue = $(this).val();
		
		    if($("[name=userId]").val() == $("[name=userPw]").val()) {
		        idDifferPw(3);
		        return;
		    } else {
		        if(<%=loginUser.getUserPw() %> == pwInputValue) {
		            trueDesign(3);
		    
		        } else{
		            $(".reg-msg").eq(3).text("비밀번호가 일치하지 않습니다.");
		            falseDesign(3);
		    
		        }
		    }
		
		});
		
		//아이디, 비번 같으면 안됨
		function idDifferPw(i){
		    $(".reg-msg").eq(i).text("아이디와 같은 비밀번호는 사용할 수 없습니다.");
		    falseDesign(i);
		}
		
		//(2) 새 비밀번호 정규표현식
		$("[name=newPw]").on("change",function(){
		    const newPwReg = /^[a-zA-Z0-9]{8,25}$/;
		    const check = newPwReg.test($(this).val());

		    //로그인된 아이디와 비교
		    if($("[name=userId]").val() == $("[name=newPw]").val()) {
		        idDifferPw(4);
		        return;
		    } else {
		        if(check) {
		            //true
		            trueDesign(4);
		    
		        } else {
		            //false
		            $(".reg-msg").eq(4).text("8~25자의 영문 대소문자/숫자로만 입력해주세요.");
		            falseDesign(4);
		        }
		    }
		});

		//(3) 새 비밀번호 확인 ... 동일한지 확인
		$("[name=newPwCh]").on("change",function(){
		    const newPwValue = $("[name=newPw]").val();
		    const newPwReValue = $(this).val();
		    if(newPwValue == newPwReValue) {
		        trueDesign(5);

		    } else{
		        $(".reg-msg").eq(5).text("비밀번호가 일치하지 않습니다.");
		        falseDesign(5);

		    }
		});
	</script>
</body>
</html>