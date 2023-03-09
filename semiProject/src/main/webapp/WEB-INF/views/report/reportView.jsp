<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.iei.report.model.vo.ReportVo"%>
<%
ReportVo report = (ReportVo) request.getAttribute("questionResult");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/report.css">
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<div class="page-content">
		<div class="report-wrap">
			<div class="report-header">
				<span>신고 상세보기</span>
			</div>
			<table class="report-tbl">
				<tr class="report-tr">
					<td class="report-td-2" colspan="3">신고 사항</td>
					<td style="float:right;" >
					<button type="text" id="btn" class="btn bc1 bs2" style="line-height:5px;height:20px;margin:10px;">
					처리중</button>
					</td>
				</tr>
				<%-- ============================================================ --%>
				<tr class="report-tr">
					<td class="report-td">제목</td> 
					<%-- 게시글 제목 --%>
					<td class="report-td" colspan="3" ><span><%=report.getReportTitle()%></span>
					</td>
				</tr>
				<tr class="report-tr">
					<td class="report-td">작성자</td> 
					<%-- 신고자 --%>
					<td class="report-td" style="text-align:right;padding-right:50px;">
						<div>
							<%=report.getReporterId()%></div>
					</td>
					<%-- 게시 날짜 --%>
					<td class="report-td">작성일</td> 
					<td class="report-td"style="text-align:right;padding-right:50px;">
						<div><%=report.getReportDate()%></div>
					</td>
				</tr>
				<tr class="report-tr">
				<%-- 작성자 게시물 --%>
					<td class="report-td" colspan="4" style="padding-left: 30px; padding-top:100px;padding-bottom:100px;">
						<%=report.getReportContent().replace("\r\n", "<br>")%> 
					</td>
				</tr>
			</table>
			<%if(loginUser!=null&&loginUser.getUserLevel()==1){ %>
				<button onclick="btnClick();" value="테스트" id="btn" class="btn bc1 bs4">신고 처리 완료</button>
				<%} %>
		</div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
	<script>
	function btnClick(){
		if(window.confirm("테스트")){
			$("#btn").text("처리완료");
		}
	}
	</script>
</body>
</html>