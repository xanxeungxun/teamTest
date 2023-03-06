package com.iei.question.model.vo;

public class QuestionVo {
	private int questionNo;
	private String questionUserId;
	private String questionName;
	private String questionTitle;
	private int questionType;
	private String questionContent;
	private String enrollDate;
	private String answerYn;
	private String answerUserName;
	private String answerUserId;
	private String answerTitle;
	private String answerContent;
	private String answerDate;
	
	
	
	

	public QuestionVo(int questionNo, String questionUserId, String questionName, String questionTitle,
			int questionType, String questionContent, String enrollDate, String answerYn, String answerUserName,
			String answerUserId, String answerTitle, String answerContent, String answerDate) {
		super();
		this.questionNo = questionNo;
		this.questionUserId = questionUserId;
		this.questionName = questionName;
		this.questionTitle = questionTitle;
		this.questionType = questionType;
		this.questionContent = questionContent;
		this.enrollDate = enrollDate;
		this.answerYn = answerYn;
		this.answerUserName = answerUserName;
		this.answerUserId = answerUserId;
		this.answerTitle = answerTitle;
		this.answerContent = answerContent;
		this.answerDate = answerDate;
	}





	public QuestionVo() {
		super();
		// TODO Auto-generated constructor stub
	}





	public int getQuestionNo() {
		return questionNo;
	}





	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}





	public String getQuestionUserId() {
		return questionUserId;
	}





	public void setQuestionUserId(String questionUserId) {
		this.questionUserId = questionUserId;
	}





	public String getQuestionName() {
		return questionName;
	}





	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}





	public String getQuestionTitle() {
		return questionTitle;
	}





	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}





	public int getQuestionType() {
		return questionType;
	}





	public void setQuestionType(int questionType) {
		this.questionType = questionType;
	}





	public String getQuestionContent() {
		return questionContent;
	}





	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}





	public String getEnrollDate() {
		return enrollDate;
	}





	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}





	public String getAnswerYn() {
		return answerYn;
	}





	public void setAnswerYn(String answerYn) {
		this.answerYn = answerYn;
	}





	public String getAnswerUserName() {
		return answerUserName;
	}





	public void setAnswerUserName(String answerUserName) {
		this.answerUserName = answerUserName;
	}





	public String getAnswerUserId() {
		return answerUserId;
	}





	public void setAnswerUserId(String answerUserId) {
		this.answerUserId = answerUserId;
	}





	public String getAnswerTitle() {
		return answerTitle;
	}





	public void setAnswerTitle(String answerTitle) {
		this.answerTitle = answerTitle;
	}





	public String getAnswerContent() {
		return answerContent;
	}





	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}





	public String getAnswerDate() {
		return answerDate;
	}





	public void setAnswerDate(String answerDate) {
		this.answerDate = answerDate;
	}





	@Override
	public String toString() {
		return "QuestionVo [questionNo=" + questionNo + ", questionUserId=" + questionUserId + ", questionName="
				+ questionName + ", questionTitle=" + questionTitle + ", questionType=" + questionType
				+ ", questionContent=" + questionContent + ", enrollDate=" + enrollDate + ", answerYn=" + answerYn
				+ ", answerUserName=" + answerUserName + ", answerUserId=" + answerUserId + ", answerTitle="
				+ answerTitle + ", answerContent=" + answerContent + ", answerDate=" + answerDate + "]";
	}




	
	
}
