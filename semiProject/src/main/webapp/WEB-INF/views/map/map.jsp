<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=nelw5vcohs&submodules=geocoder"></script>
<style>
	
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
		<div class="page-content">
			<div class="header-wrap">
				<div class="notice-header">
					<span>회사소개</span>
				</div>
		<div class="map" style="width:100%; height:500px;"></div>
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>