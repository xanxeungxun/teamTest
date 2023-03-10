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

    /*???????????? ????????? ??????*/
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
                    <div class="page-title">????????? ??????</div>
                </div>
            </div>
            <div class="point-detail-foot">
                <div class="point-detail">
                    <div class="recharge-wrap">
                        <div class="bold">????????? ?????????</div>

                        <table class="tbl">
                        	<tr>
                                <td>
                                    <label class="border-round-start"><div><input type="radio" name="rechargePoint" id="rechargePoint0" value="100">100P</div>
                                    <div class="recharge-money">100???</div></label>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label class="border-round-start"><div><input type="radio" name="rechargePoint" id="rechargePoint1" value="5000">5,000P</div>
                                    <div class="recharge-money">5,000???</div></label>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label><div><input type="radio" name="rechargePoint" id="rechargePoint2" value="10000">10,000P</div>
                                    <div class="recharge-money">10,000???</div></label>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label><div><input type="radio" name="rechargePoint" id="rechargePoint3" value="15000">15,000P</div>
                                    <div class="recharge-money">15,000???</div></label>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label><div><input type="radio" name="rechargePoint" id="rechargePoint4" value="20000">20,000P</div>
                                    <div class="recharge-money">20,000???</div></label>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label><div><input type="radio" name="rechargePoint" id="rechargePoint5" value="25000">25,000P</div>
                                    <div class="recharge-money">25,000???</div></label>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label class="border-round-end"><div><input type="radio" name="rechargePoint" id="rechargePoint6" value="30000">30,000P</div>
                                    <div class="recharge-money">30,000???</div></label>
                                </td>
                            </tr>
                            <tr>
                                <td class="my-point-td">
                                    <div class="my-point">?????? ??? ?????? ????????? <span class="my-point-num"><%=loginUser.getUserPoint()%></span>P</div>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="payment">
                        <div class="bold">?????? ??????</div>
                        <div class="payment-money"><span class="payment-money-num">0</span>???</div>
                    </div>
                </div>
                <div class="point-foot">
                    <label><input type="checkbox" name="agreement" id="agreement" required>?????? ????????? ?????????????????? ?????? ????????? ???????????????.</label>
                    <div><button id="payBtn" class="pay-btn btn bc4">????????????</button></div>
                </div>
            </div>
        </div>
    </div>
    <%@include file="/WEB-INF/views/common/footer.jsp" %>
    <script>
        $(".tbl td>label").click(function(){
	    	//????????? ????????? ???????????? ????????? ??????
            $(".tbl td>label").removeClass("active-label");
            $(this).addClass("active-label");
            
	    	//?????? ??? ?????? ????????? radio??? ?????? ?????? ??????
	    	let clickMoney = $(this).find("[type=radio]").val();
	    	const currentUserPoint = <%=loginUser.getUserPoint()%>;
	    	
	    	const userPoint = Number(clickMoney) + currentUserPoint;
	    	$(".my-point-num").text(userPoint);
        });
    	
    	//radio??? ?????? ???????????? ?????? ??????
        $("[name=rechargePoint]").click(function(){
        	let clickMoney = $(this).val();
        	$(".payment-money-num").text(clickMoney);
        });
    	
    	/*????????????*/
    	$("#payBtn").on("click",function(){
			const price = Number($(".payment-money-num").text());
			const currentUserPoint = <%=loginUser.getUserPoint()%>;
			const myPointPlusPrice = price + currentUserPoint;
			
			const d = new Date();
			//????????? ????????? ?????? "" ??? ????????? ??????
			const date = d.getFullYear()+""+(d.getMonth()+1)+""+d.getDate()+""+d.getHours()+""+d.getMinutes()+""+d.getSeconds();
			//console.log(date);
			//console.log(price);
			
			IMP.init("imp24613087");
			
			IMP.request_pay({
				pg : "html5_inicis",
				pay_method : "card",
				merchant_uid : "????????????_"+date, //???????????? ???????????? ????????????
				name : "????????? ??????", //????????????
				amount : price, //????????????
				buyer_email : "<%=loginUser.getUserEmail()%>",
				buyer_name : "<%=loginUser.getUserName()%>",
				buyer_tel : "<%=loginUser.getUserPhone()%>",
				buyer_postcode : "12345"
				
			},function(rsp){ //?????? ?????? -> rsp??? ?????????
				if(rsp.success){
					alert("?????? ??????");
					//?????? ?????? ????????? DB insert?????? ????????? ??????
					$.ajax({
						url : "/pointRecharge.do",
						type : "post",
						data : {myPointPlusPrice:myPointPlusPrice, userNo:<%=loginUser.getUserNo()%>},
						success : function(data){
							console.log("?????? ?????? DB UPDATE ??????");
						},
						error : function(){
							console.log("?????? ?????? DB UPDATE ??????");
						}
					});
				} else{
					alert("?????? ??????");
				}
				
			});
			
		});
    </script>
</body>
</html>