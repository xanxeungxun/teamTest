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
					<td class="report-td-2" colspan="4">신고 사항</td>
				</tr>
				<tr class="report-tr">
					<%-- 게시글 제목 --%>
					<td class="report-td" style="width: 30%"><span><%=report.getReportTitle()%></span>
					</td>
					<%-- 게시 날짜 --%>
					<td class="report-td" style="width: 10%">
						<div><%=report.getReportDate()%></div>
					</td>
					<%-- 신고자 --%>
					<td class="report-td" style="width: 10%">
						<div>
							아이디
							<%=report.getReporterId()%></div>
					</td>
				</tr>
				<tr class="report-tr">
				<%-- 작성자 게시물 --%>
					<td class="report-td" colspan="3" style="padding-left: 30px;">
						<%=report.getReportContent().replace("\r\n", "<br>")%> 
					</td>
				</tr>
			</table>
		</div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>