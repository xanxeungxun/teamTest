<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.iei.question.model.vo.QuestionVo"%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page trimDirectiveWhitespaces="true" %>
<%
			Date date = new Date();
			SimpleDateFormat sd = new SimpleDateFormat
			("yy-MM-dd");	
			
			String time = sd.format(date);
		%>
    <%
    	QuestionVo question = (QuestionVo)request.getAttribute("questionResult");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- question 용 css --%>
<link rel="stylesheet" href="/css/question.css">
<%-- question 용 css --%>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<div class="question-wrap">
			<div class="question-header">
				<span>문의사항 답변 등록/수정</span>
			</div>
			<table class="question-tbl">
				<tr class="question-tr">
					<td class="question-td-2" colspan="4">문의사항</td>
				</tr>
				<tr class="question-tr">
					<td class="question-td"style="width:30%">
						<span><%=question.getQuestionTitle()%></span>
					</td>
					<td class="question-td"style="width:10%">
						<div><%=question.getEnrollDate() %></div>
					</td>
					<td class="question-td"style="width:10%">
						<div>아이디<%=question.getQuestionUserId() %><br>
						닉네임<%=question.getQuestionName() %></div>
					</td>
				</tr>
				<tr class="question-tr">
					<td class="question-td" colspan="3">
						<%=question.getQuestionContent().replace("\r\n","<br>") %>
					</td>
				</tr>
				
				<tr class="question-tr">
					<td class="question-td-2" colspan="4">답변 입력/수정</td>
				</tr>
				
				
				<%if(question.getAnswerUserId()==loginUser.getUserId()){ %>
				
				<tr class="question-tr">
					<td class="question-td">
						<input class="input-form" style="font-size:18px;"
						 type="text" id="answerTitle" 
						 value="<%=question.getAnswerTitle()%>"></input>
					</td>
					<td class="question-td">
						<div><%=question.getAnswerDate() %></div>
					</td>
					<td class="question-td">
						<div>관리자 아이디
						<%=question.getAnswerUserId() %>
						<br>관리자 닉네임
						<%=question.getAnswerUserName() %></div>
					</td>
				</tr>
				<tr class="question-tr">
					<td class="question-td" colspan="3">
						<textarea class="input-form" 
						id="answerContent"style="font-size:18px;">
						<%=question.getAnswerContent().replace("\r\n","<br>") %>
						</textarea>
				<%}else {%>
					<tr class="question-tr">
						<td class="question-td">
							<input class="input-form" style="font-size:18px;"
							 type="text" id="answerTitle" 
							 value="<%=question.getAnswerTitle()%>"></input>
						</td>
						<td class="question-td">
						
							<div><%= time %>
							</div>
						</td>
						<td class="question-td">
						<input class="input-form" 
						type="hidden"
						id="answerUserId" value="<%=loginUser.getUserId() %>">
						</input>
							<div>관리자 아이디
							<%=loginUser.getUserId() %>
						<input class="input-form" 
						type="hidden"
						id="answerUserName" value="<%=loginUser.getUserName() %>">
						</input>
							<br>관리자 닉네임
							<%=loginUser.getUserName() %></div>
						</td>
					</tr>
					<tr class="question-tr">
						<td class="question-td" colspan="3">
						<textarea class="input-form" 
						id="answerContent"style="font-size:18px;">
						<%=question.getAnswerContent().replace("\r\n","<br>") %>
						</textarea>
				<%} %>
				
				<br>
			<div class="btn-position">
				<button class="btn bc1 bs1" id="editBtn" onclick="writeAnswer()">작성 완료</button>
			</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>

<script>
	
	function writeAnswer(){
		
		//ajax 통신에 사용 될 객체를 만듬
		let inputData = {
			questionNo : "<%=question.getQuestionNo()%>", 
			answerTitle : document.querySelector("#answerTitle").value,
			answerContent : document.querySelector("#answerContent").value,
			answerUserId : document.querySelector("#answerUserId").value,
			answerUserName : document.querySelector("#answerUserName").value
		};
		
		
		$.ajax({
		    url:"/question/editAnswer.do",
		    type:"GET",
		    dataType:"",
		    data:inputData,
		    success: function(result) {
		    	alert("답변이 작성되었습니다.");
				location.href = '/question/viewQuestion.do?questionNo=<%=question.getQuestionNo()%>'
		    },
		    error: function(result){
		    	alert("오류가 발생했습니다.");
		    }
		});		
	}
</script>
</html>