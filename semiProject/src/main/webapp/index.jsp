<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	let topbutton = document.getElementById("gototop");
	// 버튼을 누르면 맨 위로 즉시 스크롤
	function gotoTop() {
		document.body.scrollTop = 0;
		document.documentElement.scrollTop = 0;
	}
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<button onclick="gotoTop()" id="gototop" title="맨 위로">＾</button>
	<div class="content-wrap">
		<div class="content-title">

			<div class="autoplay">
				<div>
					<img src="/slideimg/slideimg1.png">
				</div>
				<div>
					<img src="/slideimg/slideimg2.jpg">
				</div>
				<div>
					<img src="/slideimg/slideimg3.jpg">
				</div>
				<div>
					<img src="/slideimg/slideimg4.jpg">
				</div>
				<div>
					<img src="/slideimg/slideimg5.jfif">
				</div>
				<div>
					<img src="/slideimg/slideimg6.jpg">
				</div>
			</div>



		</div>


		<div class="content-mid">
			<div class="mid-container">
				<div class="mid-content-title">
					<div class="content-category">
						<a href="#">인기콘텐츠 ></a>
					</div>
				</div>
				<div class="content-box">
					<div class="img-box">
						<a href="#"> <img src="/img/click.jfif">
							<div class="inner-wrap">
								<h3 class="title">
									<a href="#">클릭</a>
								</h3>
								<div class="inner-text">
									<div class="author">가현</div>
									<div class="inner-sub1">
										<span class="status">완결 <span class="episode"> <span
												class="slash">/</span> 46화
										</span>
										</span> <i class="material-symbols-outlined read-count-icon">
											visibility </i> <span class="rc">1만</span> <i
											class="material-symbols-outlined favorite-icon"> favorite
										</i> <span class="fv">4.5천</span> <i
											class="material-symbols-outlined comment"> sms </i> <span
											class="cm">501</span>
									</div>
									<p class="inner-sub2">
										<a href="#">최고의 선택을 대신 내려주는 서비스, 클릭! 클릭은 모든 경우의 수를 고려하여, 고객에게 가장 합리적인 선택을 대신 내려준다.
										고객에게 가장 어울리는 옷의 선택에서부터, 음식, 집, 직업…… 심지어 사랑까지도…… AI가 선택한 최고의 남자 vs 해원이 사랑하는 남자.
										과연, 해원의 선택은 무엇일까?</a>
									</p>
								</div>
								<div class="tags-box">
									<a href="#" class="tag">웹소설</a> <a href="#" class="tag">로맨스</a>
									<a href="#" class="tag">전체이용가</a> <a href="#" class="tag"></a>
								</div>
							</div>
						</a>
					</div>

					<div class="img-box">
						<a href="#"> <img src="/img/contract.jfif">
							<div class="inner-wrap">
								<h3 class="title">
									<a href="#">그와 나의 계약관계</a>
								</h3>
								<div class="inner-text">
									<div class="author">주예화</div>
									<div class="inner-sub1">
										<span class="status">완결 <span class="episode"> <span
												class="slash">/</span> 104화
										</span>
										</span> <i class="material-symbols-outlined read-count-icon">
											visibility </i> <span class="rc">7만</span> <i
											class="material-symbols-outlined favorite-icon"> favorite
										</i> <span class="fv">5천</span> <i
											class="material-symbols-outlined comment"> sms </i> <span
											class="cm">522</span>
									</div>
									<p class="inner-sub2">
										<a href="#">대한민국 취준생 ‘한서윤’. 대한민국 톱스타 ‘유민혁’의 애인이 되다. 청년 실업률이 10%에 육박하는 오늘날의 대한민국을 살아가는 3년차 취업준비생 한서윤.
										한 줄기 빛조차 스며들지 않는 취업이라는 터널 속을 오늘도 묵묵히 걸으며 인내하는 중에 대한민국 톱배우! 유민혁을 만나게 된다...</a>
									</p>
								</div>
								<div class="tags-box">
									<a href="#" class="tag">웹소설</a> <a href="#" class="tag">로맨스</a>
									<a href="#" class="tag">15세 이용가</a> <a href="#" class="tag"></a>
								</div>
							</div>
						</a>
					</div>
					<div class="img-box">
						<a href="#"> <img src="/img/dogsujack.jfif">
							<div class="inner-wrap">
								<h3 class="title">
									<a href="#">개수작</a>
								</h3>
								<div class="inner-text">
									<div class="author">한봄이</div>
									<div class="inner-sub1">
										<span class="status">완결 <span class="episode"> <span
												class="slash">/</span> 79화
										</span>
										</span> <i class="material-symbols-outlined read-count-icon">
											visibility </i> <span class="rc">2.5만</span> <i
											class="material-symbols-outlined favorite-icon"> favorite
										</i> <span class="fv">4천</span> <i
											class="material-symbols-outlined comment"> sms </i> <span
											class="cm">252</span>
									</div>
									<p class="inner-sub2">
										<a href="#">“나한테 잡힌 거야, 당신.
										”자유로운 삶을 살아가던 최혜아.어느 날 불순한 사건으로 도정혁과 엮이며 그와 계약 결혼을 할 위기에 처한다.
										계속해서 옭아매는 정혁의 집착으로 그녀는 자유를 박탈당하고, 결국 해서는 안 될 선택을 하게 되는데..........
										위험하고 위태로운 그의 개수작에 과연 혜아는 넘어가지 않을 수 있을까.</a>
									</p>
								</div>
								<div class="tags-box">
									<a href="#" class="tag">웹소설</a> <a href="#" class="tag">로맨스</a>
									<a href="#" class="tag">15세 이용가</a> <a href="#" class="tag"></a>
								</div>
							</div>
						</a>
					</div>
					<div class="img-box">
						<a href="#"> <img src="/img/namsachin.jfif">
							<div class="inner-wrap">
								<h3 class="title">
									<a href="#">남사친과 실수는 추천하지 않습니다</a>
								</h3>
								<div class="inner-text">
									<div class="author">권찌</div>
									<div class="inner-sub1">
										<span class="status">완결 <span class="episode"> <span
												class="slash">/</span> 97화
										</span>
										</span> <i class="material-symbols-outlined read-count-icon">
											visibility </i> <span class="rc">5만</span> <i
											class="material-symbols-outlined favorite-icon"> favorite
										</i> <span class="fv">5.1천</span> <i
											class="material-symbols-outlined comment"> sms </i> <span
											class="cm">744</span>
									</div>
									<p class="inner-sub2">
										<a href="#">모든것이 완벽해 보이는 내 친구. 같은 산부인과 출신, 같은 유치원, 초등학교, 중학교, 고등학교까지 함께 보낸 그놈. 
										그놈과 실수로 하룻밤을 보냈다. “너…. 네가 왜 여기 있어?” 그날 이후, 29년 우정이 크게 흔들렸다. "진지하게 생각해봐." 한발짝 내딛는 지서준과 혼란스러운 문다율. 
											이 사랑, 순탄치만은 않다.</a>
									</p>
								</div>
								<div class="tags-box">
									<a href="#" class="tag">웹소설</a> <a href="#" class="tag">로맨스</a>
									<a href="#" class="tag">전체이용가</a> <a href="#" class="tag"></a>
								</div>
							</div>
						</a>
					</div>
				</div>


				<div class="btm-link1">
					<div class="link-main1">
						<a href="/category/웹소설/recent" class="btn btn-secondary">전체 보기</a>
					</div>
				</div>


				<div class="mid-content-title">
					<div class="content-category">
						<a href="#">최신콘텐츠 ></a>
					</div>
				</div>
				<div class="content-box">
					<div class="img-box">
						<a href="#"> <img src="/img/earthzzang.jpg">
							<div class="inner-wrap">
								<h3 class="title">
									<a href="#">악인의 능력만 흡수해서 지구최강</a>
								</h3>
								<div class="inner-text">
									<div class="author">셀레포</div>
									<div class="inner-sub1">
										<span class="status">연재<span class="episode"> <span
												class="slash">/</span> 125화
										</span>
										</span> <i class="material-symbols-outlined read-count-icon">
											visibility </i> <span class="rc">8만</span> <i
											class="material-symbols-outlined favorite-icon"> favorite
										</i> <span class="fv">4만</span> <i
											class="material-symbols-outlined comment"> sms </i> <span
											class="cm">866</span>
									</div>
									<p class="inner-sub2">
										<a href="#">각성하지 못했다는 이유로 괴롭힘을 받던 김진성.
										자신도 모르게 휘두른 유리 조각에 일진을 죽이게 된다.ㅤㅤㅤㅤㅤ
										▶ 악인을 처치하셨습니다.ㅤㅤㅤㅤㅤ
										▶ 상대방의 특성을 획득했습니다.ㅤ
										▶ 상대방의 스킬을 획득했습니다.ㅤ
										‘내가 각성을 했다고…?’</a>
									</p>
								</div>
								<div class="tags-box">
									<a href="#" class="tag">웹소설</a> <a href="#" class="tag">판타지</a>
									<a href="#" class="tag"></a> <a href="#" class="tag"></a>
								</div>
							</div>
						</a>
					</div>

					<div class="img-box">
						<a href="#"> <img src="/img/manggame.jpg">
							<div class="inner-wrap">
								<h3 class="title">
									<a href="#">망겜에 갇힌 고인물</a>
								</h3>
								<div class="inner-text">
									<div class="author">체엔</div>
									<div class="inner-sub1">
										<span class="status">연재 <span class="episode"> <span
												class="slash">/</span> 493화
										</span>
										</span> <i class="material-symbols-outlined read-count-icon">
											visibility </i> <span class="rc">9만</span> <i
											class="material-symbols-outlined favorite-icon"> favorite
										</i> <span class="fv">9만</span> <i
											class="material-symbols-outlined comment"> sms </i> <span
											class="cm">995</span>
									</div>
									<p class="inner-sub2">
										<a href="#">
										-겜이 컨텐츠가 부족하네요. 님들은 사지 마세요.
										저런 평가를 남겼는데 게임에 갇혔다. 나쁜 놈들.
										저놈들도 나쁘지만 나는 왜 하필 로그라이크 게임을 열심히 했을까?
										갇힐 거라면 이것보다 나은 게임도 많았을 건데.
										죽을 때마다 처음의 순간으로 돌아가는 것도 지겹다.
										이름모를 미궁에 유배된 지 어언 97년.
										남은 시간은 이제 3년뿐. 이번은 마지막이었으면..</a>
									</p>
								</div>
								<div class="tags-box">
									<a href="#" class="tag">웹소설</a> <a href="#" class="tag">판타지</a>
									<a href="#" class="tag">전체이용가</a> <a href="#" class="tag"></a>
								</div>
							</div>
						</a>
					</div>
					<div class="img-box">
						<a href="#"> <img src="/img/godofsoccer.jpg">
							<div class="inner-wrap">
								<h3 class="title">
									<a href="#">축구의 신이 된 저니맨</a>
								</h3>
								<div class="inner-text">
									<div class="author">치순</div>
									<div class="inner-sub1">
										<span class="status">연재 <span class="episode"> <span
												class="slash">/</span> 141화
										</span>
										</span> <i class="material-symbols-outlined read-count-icon">
											visibility </i> <span class="rc">2만</span> <i
											class="material-symbols-outlined favorite-icon"> favorite
										</i> <span class="fv">4.2천</span> <i
											class="material-symbols-outlined comment"> sms </i> <span
											class="cm">101</span>
									</div>
									<p class="inner-sub2">
										<a href="#">밀월에서만 20년을 뛴 원클럽맨 다니엘
										1부 리그 승격을 결정짓는 골을 넣었으나 그에게 찾아온 것은 방출이라는 배신이었다
										"이럴 줄 알았으면 나를 위해서 살걸" 은퇴 당일 트럭에 치여 죽음을 맞이한 그는 대한민국 고등학생 전상욱의 몸에 빙의하게 되는데
										"원클럽맨은 개뿔, 이번 생은 저니맨으로 산다!" 두 번째 기회는 오직 나를 위해서만 쓰겠다.
										전상욱의 활약을 주목하라!</a>
									</p>
								</div>
								<div class="tags-box">
									<a href="#" class="tag">웹소설</a> <a href="#" class="tag">현대판타지</a>
									<a href="#" class="tag">전체이용가</a> <a href="#" class="tag"></a>
								</div>
							</div>
						</a>
					</div>
					<div class="img-box">
						<a href="#"> <img src="/img/commingsummer.jpg">
							<div class="inner-wrap">
								<h3 class="title">
									<a href="#">태양이 멀어지면 여름이 온다</a>
								</h3>
								<div class="inner-text">
									<div class="author">홍지흔</div>
									<div class="inner-sub1">
										<span class="status">연재 <span class="episode"> <span
												class="slash">/</span> 74화
										</span>
										</span> <i class="material-symbols-outlined read-count-icon">
											visibility </i> <span class="rc">6만</span> <i
											class="material-symbols-outlined favorite-icon"> favorite
										</i> <span class="fv">5.1천</span> <i
											class="material-symbols-outlined comment"> sms </i> <span
											class="cm">579</span>
									</div>
									<p class="inner-sub2">
										<a href="#">
										맞선 장소에 난입한 남자의 독설.  
										“지금 뭐 하자는 거죠”
										“가벼운 관계답게 실컷 즐기기나 하려고.”
										“동의하지 않는 관계는 없다가 룰입니다만.”
										“동의하게 될 텐데?”
										“전혀요.”
										“새빨간 거짓말.”
										“차준교 상무님.”
										“귀 빨개졌어. 너.”
										당황한 서정에게 바짝 다가선 그가 속삭였다.
										사랑이 두려운 여자와 사랑에 미친 남자의 격정 멜로.</a>
									</p>
								</div>
								<div class="tags-box">
									<a href="#" class="tag">웹소설</a> <a href="#" class="tag">로맨스</a>
									<a href="#" class="tag">15세 이용가</a> <a href="#" class="tag"></a>
								</div>
							</div>
						</a>
					</div>
				</div>



			</div>



		</div>

		<div class="btm-link2">
			<div class="link-main2">
				<a href="/category/웹소설/recent" class="btn btn-secondary">전체 보기</a>
			</div>
		</div>
	</div>


	<a href="/adminMain.do">관리자 페이지 바로가기</a>
	<script src="/js/slick.js"></script>
	<script>
        $(function () {
            $('.autoplay').slick({
                slidesToShow: 3,
                slidesToScroll: 1,
                autoplay: true,
                autoplaySpeed: 3000,
                dotsClass: "slick-dots"
            });
        });
        $(".slick-arrow").attr("display", "none");

    </script>
    <link rel="stylesheet" href="/css/slick.css">
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>