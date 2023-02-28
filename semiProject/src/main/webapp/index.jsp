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
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
 	<button onclick="gotoTop()" id="gototop" title="맨 위로">＾</button>
	<div class="content-wrap">
        <div class="content-title">

            <div class="autoplay">
                <div><img src="slideimg/bg-1.jpg"></div>
                <div><img src="slideimg/bg-2.jpg"></div>
                <div><img src="slideimg/bg-3.jpg"></div>
                <div><img src="slideimg/bg-1.jpg"></div>
                <div><img src="slideimg/bg-2.jpg"></div>
                <div><img src="slideimg/bg-3.jpg"></div>
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
                        <a href="#">
                            <img src="img/dora.png">
                            <div class="inner-wrap">
                                <h3 class="title">
                                    <a href="#">도라에몽</a>
                                </h3>
                                <div class="inner-text">
                                    <div class="author">진구</div>
                                        <div class="inner-sub1">
                                            <span class="status">연재
                                                <span class="episode">
                                                    <span class="slash">/</span>
                                                    50화
                                                </span>
                                            </span>
                                            <i class="material-symbols-outlined read-count-icon">
                                                visibility
                                            </i>
                                            <span class="rc">5만</span>
                                            <i class="material-symbols-outlined favorite-icon">
                                                favorite
                                            </i>
                                            <span class="fv">4.5천</span>
                                            <i class="material-symbols-outlined comment">
                                                sms
                                            </i>
                                            <span class="cm">501</span>
                                        </div>
                                        <p class="inner-sub2">
                                            <a href="#">대충 간략한 내용 대충 간략한 내용 대충 간략한 내용 대충 간략한 내용 대충 간략한 내용</a>
                                        </p>
                                </div>
                                <div class="tags-box">
                                    <a href="#" class="tag">웹소설</a>
                                    <a href="#" class="tag">bl</a>
                                    <a href="#" class="tag">치정</a>
                                    <a href="#" class="tag">성장</a>
                                </div>
                            </div>
                        </a>
                    </div>
                    
                    <div class="img-box">
                        <a href="#">
                            <img src="img/dora.png">
                            <div class="inner-wrap">
                                <h3 class="title">
                                    <a href="#">도라에몽</a>
                                </h3>
                                <div class="inner-text">
                                    <div class="author">진구</div>
                                        <div class="inner-sub1">
                                            <span class="status">연재
                                                <span class="episode">
                                                    <span class="slash">/</span>
                                                    50화
                                                </span>
                                            </span>
                                            <i class="material-symbols-outlined read-count-icon">
                                                visibility
                                            </i>
                                            <span class="rc">5만</span>
                                            <i class="material-symbols-outlined favorite-icon">
                                                favorite
                                            </i>
                                            <span class="fv">4.5천</span>
                                            <i class="material-symbols-outlined comment">
                                                sms
                                            </i>
                                            <span class="cm">501</span>
                                        </div>
                                        <p class="inner-sub2">
                                            <a href="#">대충 간략한 내용 대충 간략한 내용 대충 간략한 내용 대충 간략한 내용 대충 간략한 내용</a>
                                        </p>
                                </div>
                                <div class="tags-box">
                                    <a href="#" class="tag">웹소설</a>
                                    <a href="#" class="tag">bl</a>
                                    <a href="#" class="tag">치정</a>
                                    <a href="#" class="tag">성장</a>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="img-box">
                        <a href="#">
                            <img src="img/dora.png">
                            <div class="inner-wrap">
                                <h3 class="title">
                                    <a href="#">도라에몽</a>
                                </h3>
                                <div class="inner-text">
                                    <div class="author">진구</div>
                                        <div class="inner-sub1">
                                            <span class="status">연재
                                                <span class="episode">
                                                    <span class="slash">/</span>
                                                    50화
                                                </span>
                                            </span>
                                            <i class="material-symbols-outlined read-count-icon">
                                                visibility
                                            </i>
                                            <span class="rc">5만</span>
                                            <i class="material-symbols-outlined favorite-icon">
                                                favorite
                                            </i>
                                            <span class="fv">4.5천</span>
                                            <i class="material-symbols-outlined comment">
                                                sms
                                            </i>
                                            <span class="cm">501</span>
                                        </div>
                                        <p class="inner-sub2">
                                            <a href="#">대충 간략한 내용 대충 간략한 내용 대충 간략한 내용 대충 간략한 내용 대충 간략한 내용</a>
                                        </p>
                                </div>
                                <div class="tags-box">
                                    <a href="#" class="tag">웹소설</a>
                                    <a href="#" class="tag">bl</a>
                                    <a href="#" class="tag">치정</a>
                                    <a href="#" class="tag">성장</a>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="img-box">
                        <a href="#">
                            <img src="img/dora.png">
                            <div class="inner-wrap">
                                <h3 class="title">
                                    <a href="#">도라에몽</a>
                                </h3>
                                <div class="inner-text">
                                    <div class="author">진구</div>
                                        <div class="inner-sub1">
                                            <span class="status">연재
                                                <span class="episode">
                                                    <span class="slash">/</span>
                                                    50화
                                                </span>
                                            </span>
                                            <i class="material-symbols-outlined read-count-icon">
                                                visibility
                                            </i>
                                            <span class="rc">5만</span>
                                            <i class="material-symbols-outlined favorite-icon">
                                                favorite
                                            </i>
                                            <span class="fv">4.5천</span>
                                            <i class="material-symbols-outlined comment">
                                                sms
                                            </i>
                                            <span class="cm">501</span>
                                        </div>
                                        <p class="inner-sub2">
                                            <a href="#">대충 간략한 내용 대충 간략한 내용 대충 간략한 내용 대충 간략한 내용 대충 간략한 내용</a>
                                        </p>
                                </div>
                                <div class="tags-box">
                                    <a href="#" class="tag">웹소설</a>
                                    <a href="#" class="tag">bl</a>
                                    <a href="#" class="tag">치정</a>
                                    <a href="#" class="tag">성장</a>
                                </div>
                            </div>
                        </a>
                    </div>
                </div>



                

                <div class="mid-content-title">
                    <div class="content-category">
                        <a href="#">최신콘텐츠 ></a>
                    </div>
                </div>
                <div class="content-box">
                    <div class="img-box">
                        <a href="#">
                            <img src="img/dora.png">
                            <div class="inner-wrap">
                                <h3 class="title">
                                    <a href="#">도라에몽</a>
                                </h3>
                                <div class="inner-text">
                                    <div class="author">진구</div>
                                        <div class="inner-sub1">
                                            <span class="status">연재
                                                <span class="episode">
                                                    <span class="slash">/</span>
                                                    50화
                                                </span>
                                            </span>
                                            <i class="material-symbols-outlined read-count-icon">
                                                visibility
                                            </i>
                                            <span class="rc">5만</span>
                                            <i class="material-symbols-outlined favorite-icon">
                                                favorite
                                            </i>
                                            <span class="fv">4.5천</span>
                                            <i class="material-symbols-outlined comment">
                                                sms
                                            </i>
                                            <span class="cm">501</span>
                                        </div>
                                        <p class="inner-sub2">
                                            <a href="#">대충 간략한 내용 대충 간략한 내용 대충 간략한 내용 대충 간략한 내용 대충 간략한 내용</a>
                                        </p>
                                </div>
                                <div class="tags-box">
                                    <a href="#" class="tag">웹소설</a>
                                    <a href="#" class="tag">bl</a>
                                    <a href="#" class="tag">치정</a>
                                    <a href="#" class="tag">성장</a>
                                </div>
                            </div>
                        </a>
                    </div>
                    
                    <div class="img-box">
                        <a href="#">
                            <img src="img/dora.png">
                            <div class="inner-wrap">
                                <h3 class="title">
                                    <a href="#">도라에몽</a>
                                </h3>
                                <div class="inner-text">
                                    <div class="author">진구</div>
                                        <div class="inner-sub1">
                                            <span class="status">연재
                                                <span class="episode">
                                                    <span class="slash">/</span>
                                                    50화
                                                </span>
                                            </span>
                                            <i class="material-symbols-outlined read-count-icon">
                                                visibility
                                            </i>
                                            <span class="rc">5만</span>
                                            <i class="material-symbols-outlined favorite-icon">
                                                favorite
                                            </i>
                                            <span class="fv">4.5천</span>
                                            <i class="material-symbols-outlined comment">
                                                sms
                                            </i>
                                            <span class="cm">501</span>
                                        </div>
                                        <p class="inner-sub2">
                                            <a href="#">대충 간략한 내용 대충 간략한 내용 대충 간략한 내용 대충 간략한 내용 대충 간략한 내용</a>
                                        </p>
                                </div>
                                <div class="tags-box">
                                    <a href="#" class="tag">웹소설</a>
                                    <a href="#" class="tag">bl</a>
                                    <a href="#" class="tag">치정</a>
                                    <a href="#" class="tag">성장</a>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="img-box">
                        <a href="#">
                            <img src="img/dora.png">
                            <div class="inner-wrap">
                                <h3 class="title">
                                    <a href="#">도라에몽</a>
                                </h3>
                                <div class="inner-text">
                                    <div class="author">진구</div>
                                        <div class="inner-sub1">
                                            <span class="status">연재
                                                <span class="episode">
                                                    <span class="slash">/</span>
                                                    50화
                                                </span>
                                            </span>
                                            <i class="material-symbols-outlined read-count-icon">
                                                visibility
                                            </i>
                                            <span class="rc">5만</span>
                                            <i class="material-symbols-outlined favorite-icon">
                                                favorite
                                            </i>
                                            <span class="fv">4.5천</span>
                                            <i class="material-symbols-outlined comment">
                                                sms
                                            </i>
                                            <span class="cm">501</span>
                                        </div>
                                        <p class="inner-sub2">
                                            <a href="#">대충 간략한 내용 대충 간략한 내용 대충 간략한 내용 대충 간략한 내용 대충 간략한 내용</a>
                                        </p>
                                </div>
                                <div class="tags-box">
                                    <a href="#" class="tag">웹소설</a>
                                    <a href="#" class="tag">bl</a>
                                    <a href="#" class="tag">치정</a>
                                    <a href="#" class="tag">성장</a>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="img-box">
                        <a href="#">
                            <img src="img/dora.png">
                            <div class="inner-wrap">
                                <h3 class="title">
                                    <a href="#">도라에몽</a>
                                </h3>
                                <div class="inner-text">
                                    <div class="author">진구</div>
                                        <div class="inner-sub1">
                                            <span class="status">연재
                                                <span class="episode">
                                                    <span class="slash">/</span>
                                                    50화
                                                </span>
                                            </span>
                                            <i class="material-symbols-outlined read-count-icon">
                                                visibility
                                            </i>
                                            <span class="rc">5만</span>
                                            <i class="material-symbols-outlined favorite-icon">
                                                favorite
                                            </i>
                                            <span class="fv">4.5천</span>
                                            <i class="material-symbols-outlined comment">
                                                sms
                                            </i>
                                            <span class="cm">501</span>
                                        </div>
                                        <p class="inner-sub2">
                                            <a href="#">대충 간략한 내용 대충 간략한 내용 대충 간략한 내용 대충 간략한 내용 대충 간략한 내용</a>
                                        </p>
                                </div>
                                <div class="tags-box">
                                    <a href="#" class="tag">웹소설</a>
                                    <a href="#" class="tag">bl</a>
                                    <a href="#" class="tag">치정</a>
                                    <a href="#" class="tag">성장</a>
                                </div>
                            </div>
                        </a>
                    </div>
                </div>



            </div>



        </div>
        <div class="mid-mid">
            <ul>


            </ul>
        </div>
    </div>
    <div class="content-bottom">
        <div class="bottom-title">

        </div>
        <div class="bottom-top">
            <ul>

            </ul>
        </div><!--bottom-top-->
        <div class="bottom-top">
            <ul>

            </ul>
        </div>
        <div class="bottom-top">
            <ul>

            </ul>
        </div><!--bottom-top-->
    </div><!--content-bottom-->
    <div class="btm-link">
        <div class="link-main">
            <a href="/category/웹소설/recent" class="btn btn-secondary">전체 보기</a>
        </div>
    </div>
    </div>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>