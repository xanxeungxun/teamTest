<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="/css/default.css">
</head>
<style>
    .agree-content{
        max-width: 760px;
        margin: 0 auto;
        padding: 50px 30px 10px;
        background: #fff;
        box-sizing: border-box;
    }
    .agree-content>h1{
        padding-bottom: 30px;
        border-bottom: 1px solid #dfdfdf;
        margin-bottom: 35px;
    }
    .agree-content>table th{
        text-align: center;
        border: 1px solid #D1D5D9;
        background-color: #D1D5D9;
    }
    .agree-content>table th:first-child{
        width: 12%;
    }
    .agree-content> table td{
        border: 1px solid #D1D5D9;
        vertical-align: top;
        padding: 10px;
        line-height: 1.7em;
    }
    .agree-content>p{
        padding: 20px 0 0 0;
    }
</style>
<body>
<%@include file = "/WEB-INF/views/user/agreeContentHeader.jsp" %>
    <div class="agree-content">

        <h1>개인정보 수집 및 이용 동의 (필수)</h1>
        <table>
            <tr>
                <th>수집 단계</th>
                <th>수집/이용 목적</th>
                <th>수집 항목</th>
                <th>보유 및 이용기간</th>
            </tr>
            <tr>
                <td>회원가입</td>
                <td>1. 회원 가입 시 의사 확인, 본인 확인, 서비스 제공 시 이용자 식별 등 회원 관리, 통계학적 분석을 통한 마케팅에 이용 2. 광고성 정보 수신에 대하여 별도의 동의를 한 회원에 한하여 "회사"의 새로운 서비스, 이벤트, 최신 정보 등 회원의 취향에 맞는 정보를 최적화하여 제공</td>
                <td>[14세 이상 국내/해외 거주자] (필수) 이름, 아이디, 비밀번호, 이메일주소 (선택) 출생년도, 성별 단, 14세미만의 경우 법정대리인의 본인인증값을 별도로 수집합니다.</td>
                <td>회원 탈퇴시까지 보유 및 이용합니다. 단, 관련 법령 규정에 의하여 보존할 필요가 있는 경우 해당 법령에서 정한 기간동안 개인정보를 보유합니다.</td>
            </tr>
            <tr>
                <td>서비스 이용과정에서 생성 및 수집되는 정보</td>
                <td>결제 및 서비스 이용 기록 확인</td>
                <td>(필수) IP주소, 쿠키, 방문일시, OS종류, 브라우저 종류, 결제기록, 서비스이용기록, 불량 이용기록 모바일 앱 사용시, 단말기정보(단말기 모델, 하드웨어ID, 운영체제 버전 정보)</td>
                <td>상동</td>
            </tr>
        </table>
			
		<p>※ 이용자는 개인정보의 수집 및 이용 동의를 거부할 권리가 있습니다. 단, 회원가입 시 수집하는 최소한의 개인정보, 즉, 필수 항목에 대한 수집 및 이용 동의를 거부하실 경우, 회원가입이 제한됩니다.</p>
			
    </div>
</body>
</html>