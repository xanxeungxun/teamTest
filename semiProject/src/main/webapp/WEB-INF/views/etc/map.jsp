<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/map.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<div class="page-content">
		<div class="map-wrap">
			<div class="map-header">
				<span>회사소개</span>
			</div>
			<div class="map-title">
				<h2>오시는길</h2>
				<h4>On your way to "EveryUniverse" !</h4>
			</div>
			<div class="transport-way">
				<table>
					<tr>
						<th class="addr">주소</th>
						<td>서울특별시 영등포구 선유동2로57 이레빌딩(구관)19F,20F</td>
					</tr>
					<tr colspan="2" style="width: 100px;">
						<th class="bus">버스</th>
						<td class="bus-stop">선유고등학교/(구)강서세무서
							<div class="bus-stop1"
								style="line-height: 30px; padding-bottom: 5px;">
								<img src="/img/bluebus.jpg" style="padding-right: 5px;">7612
								<img src="/img/redbus.jpg"
									style="padding-left: 10px; padding-right: 5px;">1000/1200/1300/1301/1302/1400/1500/1601/M6628/M6724
							</div> 당산역
							<div class="bus-stop2" style="line-height: 30px;">
								<img src="/img/bluebus.jpg" style="padding-right: 5px;">602/760/5620/5714/6514/6623/6631
							</div>
						</td>
					</tr>
					<tr>
						<th class="subway">지하철</th>
						<td>지하철 2,9호선 당산역 12번 출구 400ms</td>
					</tr>
				</table>
			</div>
			<div id="map" style="width: 800px; height: 400px; margin-top: 20px;"></div>
		</div>
	</div>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0fbc25150ab6b2657664309b897c83e6"></script>
	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(37.5338151, 126.8969784), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

		// 마커가 표시될 위치입니다 
		var markerPosition = new kakao.maps.LatLng(37.5338151, 126.8969784);

		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
			position : markerPosition
		});

		// 마커가 지도 위에 표시되도록 설정합니다
		marker.setMap(map);
	</script>
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>