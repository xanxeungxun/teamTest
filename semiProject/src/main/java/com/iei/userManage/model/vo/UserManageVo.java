package com.iei.userManage.model.vo;

public class UserManageVo {
	
	private int userNo;  
	private String userId;
	private String userPw;
	private String userName;
	private String userNick;
	private String userPhone;
	private int userLevel;
	private String userPic;
	private int userPoint;
	private String userEnroll;
	private String userEmail;
	
	
	public UserManageVo() {
		super();
	}


	public UserManageVo(int userNo, String userId, String userPw, String userName, String userNick, String userPhone,
			int userLevel, String userPic, int userPoint, String userEnroll, String userEmail) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userNick = userNick;
		this.userPhone = userPhone;
		this.userLevel = userLevel;
		this.userPic = userPic;
		this.userPoint = userPoint;
		this.userEnroll = userEnroll;
		this.userEmail = userEmail;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPw() {
		return userPw;
	}


	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserNick() {
		return userNick;
	}


	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}


	public String getUserPhone() {
		return userPhone;
	}


	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}


	public int getUserLevel() {
		return userLevel;
	}


	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}


	public String getUserPic() {
		return userPic;
	}


	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}


	public int getUserPoint() {
		return userPoint;
	}


	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}


	public String getUserEnroll() {
		return userEnroll;
	}


	public void setUserEnroll(String userEnroll) {
		this.userEnroll = userEnroll;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	@Override
	public String toString() {
		return "UserManageVo [userNo=" + userNo + ", userId=" + userId + ", userPw=" + userPw + ", userName=" + userName
				+ ", userNick=" + userNick + ", userPhone=" + userPhone + ", userLevel=" + userLevel + ", userPic="
				+ userPic + ", userPoint=" + userPoint + ", userEnroll=" + userEnroll + ", userEmail=" + userEmail
				+ "]";
	}
	
	
}
