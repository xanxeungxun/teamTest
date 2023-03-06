<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">



<title>새로운 작품 등록</title>
<link rel="stylesheet" href="/css/bookWriteFrm.css">


</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp"%>

<div class="page-content">
	<div class="book-wrap">
	
		<div class="book-list-header">
	          <div>작품 등록하기</div>
	    </div><!-- book-list-header -->
	
	    <div class="book-content-box">
	    	
	    	
	   		<form action="" method="post" enctype="multipart/form-data">
	   		<!-- ★★★ 첨부파일이 있으면 method는 무조건 post , enctype="multipart/form-data" 를 꼭 써줘야함-->
		   		<table class="board-write-frm tbl" id="boardWriteFrm">
		   			<tr class="tr-1">
		   				<th>작품명</th>
		   				<td>
		   					<input type="text" name="bookTitle" class="input-form">
		   				</td>
		   			</tr>
		   		</table>
	   		</form>
	    	
	    
	    </div><!-- book-content-box -->
        
	</div><!-- book-wrap -->
</div><!-- page-content -->

<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>