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
					<td class="report-td-2" colspan="5">신고 사항</td>
					<td style="float:right;" >
					<%if(report.getReportYn()==1){ %>
					<span id="btn" class="btn bc1 bs2" style="line-height:5px;height:20px;margin:10px;cursor:default;background:#2F343D;color:#EFEFEF;">
					처리완료
					</span>
					<%}else{ %>
					<span id="btn" class="btn bc1 bs2" style="line-height:5px;height:20px;margin:10px;cursor:default;background:#EFEFEF;color:#2F343D;">
					처리중
					</span>
					<%}%>
				</tr>
				<%-- ============================================================ --%>
				<tr class="report-tr" style="text-align:center;">
					<td class="report-td" style="background:#F0F0F0;">제목</td> 
					<%-- 게시글 제목 --%>
					<td class="report-td" colspan="5" ><span><%=report.getReportTitle()%></span>
					</td>
				</tr>
				<tr class="report-tr" style="text-align:center;">
					<td class="report-td" style="background:#F0F0F0;">작성자</td> 
					<%-- 신고자 --%>
					<td class="report-td" style="text-align:right;padding-right:50px;">
						<div>
							<%=report.getReporterId()%></div>
					</td>
					<%-- 게시 날짜 --%>
					<td class="report-td" style="background:#F0F0F0;">작성일</td> 
					<td class="report-td"style="text-align:right;padding-right:50px;">
						<div><%=report.getReportDate()%></div>
					</td>
					<td class="report-td" style="background:#F0F0F0;">사유</td> 
					<td class="report-td"style="text-align:right;padding-right:50px;">
					<% if(report.getReportType() == 1 ){%>욕설
						<%}else if(report.getReportType() == 2 ){%>폭언
						<%}else if(report.getReportType() == 3 ){%>성적수치심
						<%}else if(report.getReportType() == 4 ){%>기타
						<%} %>
					
					</td> 
				</tr>
				<tr class="report-tr">
				<%-- 작성자 게시물 --%>
					<td class="report-td" colspan="6" style="padding-left: 30px; padding-top:100px;padding-bottom:100px;">
						<%=report.getReportContent().replace("\r\n", "<br>")%> 
					</td>
				</tr>
			</table>
			<br><br><br>
			<%if(loginUser!=null&&loginUser.getUserLevel()==1&&report.getReportYn()==2){ %>
				<button onclick="btnClick();" value="테스트" id="btn" class="btn bc1 bs4">신고 처리 하기</button>
				<%}else if(loginUser!=null&&loginUser.getUserLevel()==1&&report.getReportYn()==1){ %>
				<button value="테스트" id="btn" class="btn bc1 bs4">신고 처리가 완료되었습니다</button>
				<%} %>
				
		</div>
		<input type="hidden" id="reportNo" name="reportNo" value="<%=report.getReportNo()%>">
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
	<script>
	function btnClick(){
		if(window.confirm("신고완료를 진행하시겠습니까?")){
			const reportNo = $("#reportNo").val();
			location.href="/changeReportNo.do?reportNo="+reportNo;
			console.log(reportNo);
		}
	}
	</script>
</body>
</html>