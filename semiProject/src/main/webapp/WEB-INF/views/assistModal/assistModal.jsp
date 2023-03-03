<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	
		<button class="btn bc11 modal-open-btn" target="#test-modal">
          후원하기
        </button>
        
        <div id="test-modal" class="modal-bg">
	      <div class="modal-wrap">
	        <div class="modal-head">
	          <h2>후원하기</h2>
	          <span class="material-icons close-icon modal-close">close</span>
	        </div>
	        <div class="modal-content">
	          <p>모달내용</p>
	          <p>모달내용</p>
	          <p>모달내용</p>
	          <p>모달내용</p>
	        </div>
	        <div class="modal-foot">
	          <button class="btn bc6 btn-pill">확인</button>
	          <button class="btn bc33 modal-close btn-pill">취소</button>
	        </div>
	      </div>
	    </div>
        
        
			 
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>