<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">



<title>새로운 작품 등록</title>
<link rel="stylesheet" href="/css/bookWriteFrm.css">
<link rel = "stylesheet" href="/summernote/summernote-lite.css">

</head>


<body>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<script src="/summernote/summernote-lite.js"></script>
<script src="/summernote/lang/summernote-ko-KR.js"></script>


<div class="page-content">
	<div class="book-wrap">
	
		<div class="book-list-header">
	          <div>작품 등록하기</div>
	    </div><!-- book-list-header -->
	
	    <div class="book-content-box">
	    	
	    	
	   		<form action="/bookWrite.do" method="post" enctype="multipart/form-data">
	   		<input type="hidden" name="bookWriter" value="<%=loginUser.getUserId()%>">
	   		<!-- ★★★ 첨부파일이 있으면 method는 무조건 post , enctype="multipart/form-data" 를 꼭 써줘야함-->
		   		<table class="board-write-frm tbl" id="boardWriteFrm1">
		   			<tr class="tr-1">
		   				<th>작품명</th>
		   				<td style="text-align: left; height: 98px;">
		   					<input type="text" name="bookTitle" id="bookTitle" class="input-form" placeholder="작품의 제목을 입력하세요.(최대 300Byte)">
		   					<span id="titleChk" style="font-size:14px; color:red; display:none;">*작품명이 300Byte를 초과해 등록할 수 없습니다.</span>
		   				</td>
		   			</tr>
		   			<tr class="tr-1">
		   				<th>카테고리</th>
		   				<td style="text-align: left; line-height: 46px;">
		   					<input type="radio" name="genre" value="1" id="test1">
		   					<label for="test1">판타지</label>
		   					<input type="radio" name="genre" value="2" id="test2">
		   					<label for="test2">로맨스</label>
		   					<input type="radio" name="genre" value="3" id="test3">
		   					<label for="test3">로맨스판타지</label>
		   					<input type="radio" name="genre" value="4" id="test4">
		   					<label for="test4">무협</label>
		   					<input type="radio" name="genre" value="5" id="test5">
		   					<label for="test5">퓨전</label>
		   					<input type="radio" name="genre" value="6" id="test6">
		   					<label for="test6">게임</label>
		   					<input type="radio" name="genre" value="7" id="test7">
		   					<label for="test7">역사</label>
		   					<input type="radio" name="genre" value="8" id="test8">
		   					<label for="test8">스포츠</label>
		   					<input type="radio" name="genre" value="9" id="test9">
		   					<label for="test9">라이트노벨</label>
		   					<input type="radio" name="genre" value="10" id="test10">
		   					<label for="test10">BL</label>
		   					<input type="radio" name="genre" value="11" id="test11">
		   					<label for="test11">GL</label>
		   					<br>
		   					
		   					<input type="radio" name="genre" value="12" id="test12">
		   					<label for="test12">패러디</label>
		   					<input type="radio" name="genre" value="13" id="test13">
		   					<label for="test13">팬픽</label>
		   					<input type="radio" name="genre" value="14" id="test14">
		   					<label for="test14">SF</label>
		   					<input type="radio" name="genre" value="15" id="test15">
		   					<label for="test15">밀리터리</label>
		   					<input type="radio" name="genre" value="16" id="test16">
		   					<label for="test16">시</label>
		   					<input type="radio" name="genre" value="17" id="test17">
		   					<label for="test17">소설</label>
		   					<input type="radio" name="genre" value="18" id="test18">
		   					<label for="test18">수필</label>
		   					<input type="radio" name="genre" value="19" id="test19">
		   					<label for="test19">공포</label>
		   					<input type="radio" name="genre" value="20" id="test20">
		   					<label for="test20">추리</label>
		   					<input type="radio" name="genre" value="21" id="test21">
		   					<label for="test21">아동</label>
		   					<input type="radio" name="genre" value="22" id="test22">
		   					<label for="test22">시나리오/희곡</label>
		   					<input type="radio" name="genre" value="23" id="test23">
		   					<label for="test23">비평</label>
		   				</td>
		   			</tr>
		   			<tr class="tr-1">
		   				<th>작품소개</th>
		   				<td style="text-align: left; height: 135px;">
		   					<textarea cols="30" rows="3" name="bookExp" class="input-form" placeholder="작품의 전체 내용을 간단하게 소개해주세요.(최대 2000Byte)"></textarea>
		   					<span id="expChk" style="font-size:14px; color:red; display:none;">*작품소개가 2000Byte를 초과해 등록할 수 없습니다.</span>
		   				</td>
		   			</tr>
		   			<tr class="tr-1">
		   				<th>작품 표지</th>
		   				<td>
		   					<input type="file" name="coverpath">
		   					<span style="font-size: 14px; color:red;width: 500px;">*작품 표지는 180x240에 최적화되어 있습니다. 등록하지 않을시 기본 표지로 설정됩니다. 최대 10MB</span>
		   				</td>
		   			</tr>
		   			<tr class="tr-1">
		   				<td colspan="2" style="text-align: right;" >
		   					<button type="button" id="nextFrmBtn" onclick="nextFrm()" class="btn bc4" style="margin-top: 30px;">다음</button>
		   				</td>
		   			</tr>
		   		</table>
		   		<!-- =========================================================================================================== -->
		   		<table class="board-write-frm tbl" id="boardWriteFrm2">
		   			<tr class="tr-1">
		   				<th>스토리 제목</th>
		   				<td style="text-align: left; height: 135px;">
		   					<input type="text" name="storyName" class="input-form" placeholder="스토리 제목을 입력하세요. 예) 에브리 유니버스 (최대 300Byte)">
		   					<span id="storyTitleChk" style="font-size:14px; color:red; display:none;">*스토리 제목이 300Byte를 초과해 등록할 수 없습니다.</span>
		   				</td>
		   			</tr>
		   			<tr class="tr-1">
		   				<th colspan="2" style="text-align: left; padding-left: 27px;">내용</th>
		   			</tr>
		   			<tr class="tr-1">
		   				<td colspan="2" style="text-align: left;">
		   					<textarea name="storyContent" id="storyContent" class="input-form"></textarea>
		   				</td>
		   			</tr>
		   			<tr class="tr-1">
		   				<th>작가후기</th>
		   				<td>
		   					<textarea cols="30" rows="3" name="storyAfter" class="input-form"></textarea>
		   				</td>
		   			</tr>
		   			<tr class="tr-1">
		   				<td style="text-align: left;">
		   					<button type="button" id="backFrmBtn" onclick="backFrm()" class="btn" style="cursor: pointer;margin-top: 30px;">이전</button>
		   				</td>
		   				<td style="text-align: right;">
		   					<button id="submit" class="btn bc4" style="margin-top: 30px;">첫 작품 등록하기</button>
		   				</td>
		   			</tr>
		   		</table>
	   		</form>
	    	
	    
	    </div><!-- book-content-box -->
        
	</div><!-- book-wrap -->
</div><!-- page-content -->



<script type="text/javascript">
	
	$("#boardWriteFrm2").hide();
	
	function nextFrm(){
		$("#boardWriteFrm1").hide();
		$("#boardWriteFrm2").show();
	}
	
	function backFrm(){
		$("#boardWriteFrm2").hide();
		$("#boardWriteFrm1").show();
	}
	
	
	
	$("#storyContent").summernote({
	      height : 400,
	      lang : "ko-KR"
	})
	
	
	$("[name=bookTitle]").on("keyup",function(){
		let titleByte =byteCheck($(this));
		if(titleByte>300){
			$(this).css("border","1px solid red")
			$("#titleChk").css("display","block");
		}else{
			$(this).css("border","1px solid #ccc")
			$("#titleChk").css("display","none");
		}
	})
	
	$("[name=storyName]").on("keyup",function(){
		let storyTitleByte = byteCheck($(this));
		if(storyTitleByte>300){
			$(this).css("border","1px solid red")
			$("#storyTitleChk").css("display","block");
		}else{
			$(this).css("border","1px solid #ccc")
			$("#storyTitleChk").css("display","none");
		}
	})
	
	
	$("[name=bookExp]").on("keyup",function(){
		let expByte =byteCheck($(this));
		if(expByte>2000){
			$(this).css("border","1px solid red")
			$("#expChk").css("display","block");
		}else{
			$(this).css("border","1px solid #ccc")
			$("#expChk").css("display","none");
		}
	})
	
	
	
	

	function byteCheck(el){
	    var codeByte = 0;
	    for (var idx = 0; idx < el.val().length; idx++) {
	        var oneChar = escape(el.val().charAt(idx));
	        if ( oneChar.length == 1 ) {
	            codeByte ++;
	        } else if (oneChar.indexOf("%u") != -1) {
	            codeByte += 3;
	        } else if (oneChar.indexOf("%") != -1) {
	            codeByte ++;
	        }
	    }
	    return codeByte;
	}


</script>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>