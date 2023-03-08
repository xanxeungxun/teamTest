<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="/css/mypageDefault.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,1,0" />
</head>
<style>
    /*head*/
    .point-head{
        width: 100%;
        height: 70px;
        border-bottom: 2px solid lightgray;
        padding: 15px;
        position: relative;
        box-sizing: border-box;
    }
    .back{
        padding: 0;
        position: absolute;
        bottom: 0;
        left: 45px;
        padding-bottom: 12px;
        font-weight: 600;
    }
    .page-title{
        padding: 0;
        position: absolute;
        bottom: 0;
        left: 80px;
        padding-bottom: 15px;
    }
    
    .point-detail-foot{
        padding: 50px 60px 50px 60px;
    }

    /*detail*/

    .point-detail{
        margin: 0 auto;
    }
    .point-detail>.recharge-wrap{
        display: flex;
    }
    .recharge-wrap>table{
        width: 60%;
        border-spacing: 0;

    }
    .recharge-wrap>table td{
        padding: 0;
    }
    .bold{
        font-family: ns-bold;
        width: 15%;
        text-align: right;
        margin-right: 60px;
    }
    .recharge-wrap>table td>label{
        height: 60px;
        line-height: 60px;
        padding: 0 20px 0 20px;
        border: 1px solid lightgray;
        border-bottom: none;
        font-size: 14px;
        display: flex;
        justify-content: space-between;
    }
    .recharge-wrap>table .my-point-td{
        border: none;
    }
    .recharge-wrap>table td>.my-point{
        text-align: center;
        height: 80px;
        line-height: 80px;
        color: #3a4f7a;
    }
    .my-point-num{
        font-family: ns-m;
        margin-left: 5px;
        color: #fea1bf;
    }
    .border-round-start{
        border-top-left-radius: 4px;
        border-top-right-radius: 4px;
    }
    .recharge-wrap>table .border-round-end{
        border-bottom-left-radius: 4px;
        border-bottom-right-radius: 4px;
        border-bottom: 1px solid lightgray;
    }
    [type="radio"],[type="checkbox"]{
        margin-right: 10px;
    }
    .payment{
        display: flex;
        height: 100px;
        line-height: 100px;
        border-top: 1px solid lightgray;
        border-bottom: 1px solid lightgray;
        box-sizing: border-box;
    }
    .point-foot{
        text-align: center;
        padding: 30px;
        padding-right: 0;
    }
    .point-foot>div{
        text-align: right;
        padding-top: 50px;
        padding-bottom: 50px;
        padding-right: 0;
    }
    .point-foot>.pay-btn{
        width: 110px;
        height: 50px;
        padding: 0;
        text-align: center;
    }

    /*클릭하면 배경색 바뀜*/
    .active-label{
        background-color: #f8f8f8ee;
    }
</style>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
		<!-- iamport.payment.js -->
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
    <div class="page-content">
        <div class="mypage-wrap">
            <div class="point-head">
                <div class="page-title-wrap">
                    <a href="/myPageMain.do?userId=<%=loginUser.getUserId()%>" class="material-symbols-outlined back">arrow_back_ios</a>
                    <div class="page-title">포인트 충전</div>
                </div>
            </div>
            <div class="point-detail-foot">
                <div class="point-detail">
                    <div class="recharge-wrap">
                        <div class="bold">충전할 포인트</div>

                        <table class="tbl">
                        	<tr>
                                <td>
                                    <label class="border-round-start"><div><input type="radio" name="rechargePoint" id="rechargePoint0" value="100">100P</div>
                                    <div class="recharge-money">100원</div></label>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label class="border-round-start"><div><input type="radio" name="rechargePoint" id="rechargePoint1" value="5000">5,000P</div>
                                    <div class="recharge-money">5,000원</div></label>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label><div><input type="radio" name="rechargePoint" id="rechargePoint2" value="10000">10,000P</div>
                                    <div class="recharge-money">10,000원</div></label>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label><div><input type="radio" name="rechargePoint" id="rechargePoint3" value="15000">15,000P</div>
                                    <div class="recharge-money">15,000원</div></label>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label><div><input type="radio" name="rechargePoint" id="rechargePoint4" value="20000">20,000P</div>
                                    <div class="recharge-money">20,000원</div></label>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label><div><input type="radio" name="rechargePoint" id="rechargePoint5" value="25000">25,000P</div>
                                    <div class="recharge-money">25,000원</div></label>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label class="border-round-end"><div><input type="radio" name="rechargePoint" id="rechargePoint6" value="30000">30,000P</div>
                                    <div class="recharge-money">30,000원</div></label>
                                </td>
                            </tr>
                            <tr>
                                <td class="my-point-td">
                                    <div class="my-point">충전 후 보유 포인트 <span class="my-point-num"><%=loginUser.getUserPoint()%></span>P</div>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="payment">
                        <div class="bold">결제 금액</div>
                        <div class="payment-money"><span class="payment-money-num">0</span>원</div>
                    </div>
                </div>
                <div class="point-foot">
                    <label><input type="checkbox" name="agreement" id="agreement" required>주문 내용을 확인하였으며 결제 진행에 동의합니다.</label>
                    <div><button id="payBtn" class="pay-btn btn bc4">결제하기</button></div>
                </div>
            </div>
        </div>
    </div>
    <%@include file="/WEB-INF/views/common/footer.jsp" %>
    <script>
        $(".tbl td>label").click(function(){
	    	//충전할 포인트 클릭하면 배경색 변환
            $(".tbl td>label").removeClass("active-label");
            $(this).addClass("active-label");
            
	    	//충전 후 보유 포인트 radio에 따라 숫자 변경
	    	let clickMoney = $(this).find("[type=radio]").val();
	    	const currentUserPoint = <%=loginUser.getUserPoint()%>;
	    	
	    	const userPoint = Number(clickMoney) + currentUserPoint;
	    	$(".my-point-num").text(userPoint);
        });
    	
    	//radio에 따라 결제금액 숫자 변경
        $("[name=rechargePoint]").click(function(){
        	let clickMoney = $(this).val();
        	$(".payment-money-num").text(clickMoney);
        });
    	
    	/*결제하기*/
    	$("#payBtn").on("click",function(){
			const price = Number($(".payment-money-num").text());
			const currentUserPoint = <%=loginUser.getUserPoint()%>;
			const myPointPlusPrice = price + currentUserPoint;
			
			const d = new Date();
			//문자열 덧셈을 위해 "" 빈 문자열 추가
			const date = d.getFullYear()+""+(d.getMonth()+1)+""+d.getDate()+""+d.getHours()+""+d.getMinutes()+""+d.getSeconds();
			//console.log(date);
			//console.log(price);
			
			IMP.init("imp24613087");
			
			IMP.request_pay({
				pg : "html5_inicis",
				pay_method : "card",
				merchant_uid : "상품번호_"+date, //상점에서 관리하는 주문번호
				name : "포인트 충전", //결제이름
				amount : price, //결제금액
				buyer_email : "<%=loginUser.getUserEmail()%>",
				buyer_name : "<%=loginUser.getUserName()%>",
				buyer_tel : "<%=loginUser.getUserPhone()%>",
				buyer_postcode : "12345"
				
			},function(rsp){ //결제 결과 -> rsp로 들어옴
				if(rsp.success){
					alert("결제 성공");
					//결제 관련 정보를 DB insert하는 작업이 필요
					$.ajax({
						url : "/pointRecharge.do",
						type : "post",
						data : {myPointPlusPrice:myPointPlusPrice, userNo:<%=loginUser.getUserNo()%>},
						success : function(data){
							console.log("결재 정보 DB UPDATE 성공");
						},
						error : function(){
							console.log("결재 정보 DB UPDATE 실패");
						}
					});
				} else{
					alert("결제 실패");
				}
				
			});
			
		});
    </script>
</body>
</html>