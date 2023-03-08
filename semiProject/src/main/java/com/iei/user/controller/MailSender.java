package com.iei.user.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.iei.user.model.service.UserService;

public class MailSender {
	
	public String sendMail(String id, String email) {
		boolean result = false;
		
		//이메일 통신 설정
		Properties prop = System.getProperties();
		
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", 587);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", true); //tls : 암호화 통신
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		//인증정보설정(로그인)
		Session session = Session.getDefaultInstance(prop,
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						PasswordAuthentication pa = new PasswordAuthentication("eunahchung0417","lqpq urpr jwcg jsem");
						
						return pa;
					}
				}
		);
		
		//이메일 작성해서 전송하는 객체
		MimeMessage msg = new MimeMessage(session);
		
		//회원 비밀번호 찾기
		UserService service = new UserService();
		String searchPw = service.selectUserPw(id, email);
		
		if(searchPw != null) {
			try {
				//이메일 작성
				msg.setSentDate(new Date());
				
				//보내는 사람 정보 설정
				msg.setFrom(new InternetAddress("eunahchung0417@gmail.com","Every Universe"));
				
				//받는 사람 정보
				InternetAddress to = new InternetAddress(email);
				msg.setRecipient(Message.RecipientType.TO, to);
				
				//이메일 제목 설정
				msg.setSubject("[Every Universe]회원님의 비밀번호를 안내해드립니다.");
				
				//이메일 내용(본문 설정)
				msg.setContent("    <div class=\"searchPwMailContent-wrap\">\r\n"
						+ "        <div class=\"mail-box\" style=\"margin:0; padding:15px;\">\r\n"
						+ "            <table cellspacing=\"0\" cellpadding=\"0\" style=\"max-width:660px; width:100%; margin:0 auto; border-collapse:collapse\">\r\n"
						+ "                <tr>\r\n"
						+ "                    <td colspan=\"2\" style=\"padding:40px 10px; background-color:white; border:1px solid #e5e8eb\">\r\n"
						+ "                        <div style=\"max-width:490px; width:100%; margin:0 auto; font-size:13px; color:#2f343d; line-height:1.8em\">\r\n"
						+ "                            <h1 style=\"padding:10px 0 35px 0; margin:0 auto; font-size:28px; font-weight:600; color:#2f343d; text-align:center; line-height:1.4em; border-bottom:1px solid #e5e8eb\">비밀번호를 잊으셨나요?</h1>\r\n"
						+ "                            <br><p style=\"font-size:14px; color:#2f343d; line-height:1.8em; margin:10px 0 0 0; padding:0; text-align:center;\">\r\n"
						+ "                                <strong style=\"font-size:16px\">회원님 안녕하세요!</strong>\r\n"
						+ "                                <br>나만의 창작 이야기를 모두와 나누는 소설 플랫폼\r\n"
						+ "                                <br><span style=\"color:#952eee; font-weight:600\">Every Universe</span>입니다.\r\n"
						+ "                                <br><br>회원님의 비밀번호를 안내해드립니다.\r\n"
						+ "                            </p>\r\n"
						+ "                            <div style=\"background-color:#fea1bf; color:#fff; padding:15px 45px; margin:15px 0 30px 0; font-size:18px; font-weight:600; text-align:center\">"+searchPw+"</div>\r\n"
						+ "                            <p style=\"font-weight: 600; font-size:14px; color:#2f343d; line-height:1.8em; margin:10px 0 0 0; padding:0; text-align:center\">\r\n"
						+ "                                항상 Every Universe를 사랑해주시는 회원님께 감사드리며,\r\n"
						+ "                                <br>보다 나은 Every Universe가 되기 위해 최선을 다하겠습니다.\r\n"
						+ "                            </p>\r\n"
						+ "                        </div>\r\n"
						+ "                    </td>\r\n"
						+ "                </tr>\r\n"
						+ "            </table>\r\n"
						+ "        </div>\r\n"
						+ "    </div>", "text/html;charset=utf-8");
				
				//이메일 전송
				Transport.send(msg);
				result = true; //위 과정이 잘 이뤄짐
				
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		if(result) {
			return searchPw; //뭘 리턴해줘야하지?
		} else {
			return null;
		}
		
	}
	
	
	public String sendEmailCheck(String inputEmail) {
		boolean result = false;
		
		//이메일 통신 설정
		Properties prop = System.getProperties();
		
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", 587);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", true); //tls : 암호화 통신
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		//인증정보설정(로그인)
		Session session = Session.getDefaultInstance(prop,
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						PasswordAuthentication pa = new PasswordAuthentication("khsp1989","ictvttehzrduhwbf");
						
						return pa;
					}
				}
		);
		
		//이메일 작성해서 전송하는 객체
		MimeMessage msg = new MimeMessage(session);
		
		/*인증을 위한 랜덤코드 생성
		영어 소문자, 영어 대문자, 숫자 8자리*/
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<8; i++) {
			//0 ~ 9 : r.nextInt(10); //0부터 매개변수 개수 중 랜덤 수 1개
			//A ~ Z : (char)(r.nextInt(26)+65); //아스키코드 시작번호 65
			//a ~ z : (char)(r.nextInt(26)+97); //시작번호 97
			
			//0, 1, 2
			int flag = r.nextInt(3);
			if(flag == 0) {
				//0~9
				int randomNumber = r.nextInt(10);
				sb.append(randomNumber);
				
			} else if(flag == 1) {
				//A~Z
				char randomChar = (char)(r.nextInt(26)+65);
				sb.append(randomChar);
				
			} else if(flag == 2) {
				//a~z
				char randomChar = (char)(r.nextInt(26)+97);
				sb.append(randomChar);
			}
			
			
		}
		
		//이메일 중복체크
		UserService service = new UserService();
		String sameEmail = service.selectEmail(inputEmail);
		
		if(sameEmail == null) {
			try {
				//이메일 작성
				msg.setSentDate(new Date());
				
				//보내는 사람 정보 설정
				msg.setFrom(new InternetAddress("khsp1989@gmail.com","Every Universe"));
				
				//받는 사람 정보
				InternetAddress to = new InternetAddress(inputEmail);
				msg.setRecipient(Message.RecipientType.TO, to);
				
				//이메일 제목 설정
				msg.setSubject("[Every Universe]인증번호를 안내해드립니다.");
				
				//이메일 내용(본문 설정)
				msg.setContent("    <div class=\"searchPwMailContent-wrap\">\r\n"
						+ "        <div class=\"mail-box\" style=\"margin:0; padding:15px;\">\r\n"
						+ "            <table cellspacing=\"0\" cellpadding=\"0\" style=\"max-width:660px; width:100%; margin:0 auto; border-collapse:collapse\">\r\n"
						+ "                <tr>\r\n"
						+ "                    <td colspan=\"2\" style=\"padding:40px 10px; background-color:white; border:1px solid #e5e8eb\">\r\n"
						+ "                        <div style=\"max-width:490px; width:100%; margin:0 auto; font-size:13px; color:#2f343d; line-height:1.8em\">\r\n"
						+ "                            <h1 style=\"padding:10px 0 35px 0; margin:0 auto; font-size:28px; font-weight:600; color:#2f343d; text-align:center; line-height:1.4em; border-bottom:1px solid #e5e8eb\">이메일 인증 메일</h1>\r\n"
						+ "                            <br><p style=\"font-size:14px; color:#2f343d; line-height:1.8em; margin:10px 0 0 0; padding:0; text-align:center;\">\r\n"
						+ "                                <strong style=\"font-size:16px\">회원님 안녕하세요!</strong>\r\n"
						+ "                                <br>나만의 창작 이야기를 모두와 나누는 소설 플랫폼\r\n"
						+ "                                <br><span style=\"color:#952eee; font-weight:600\">Every Universe</span>입니다.\r\n"
						+ "                                <br><br>회원님의 인증번호를 안내해드립니다.\r\n"
						+ "                            </p>\r\n"
						+ "                            <div style=\"background-color:#fea1bf; color:#fff; padding:15px 45px; margin:15px 0 30px 0; font-size:18px; font-weight:600; text-align:center\">"+sb+"</div>\r\n"
						+ "                            <p style=\"font-weight: 600; font-size:14px; color:#2f343d; line-height:1.8em; margin:10px 0 0 0; padding:0; text-align:center\">\r\n"
						+ "                                항상 Every Universe를 사랑해주시는 회원님께 감사드리며,\r\n"
						+ "                                <br>보다 나은 Every Universe가 되기 위해 최선을 다하겠습니다.\r\n"
						+ "                            </p>\r\n"
						+ "                        </div>\r\n"
						+ "                    </td>\r\n"
						+ "                </tr>\r\n"
						+ "            </table>\r\n"
						+ "        </div>\r\n"
						+ "    </div>", "text/html;charset=utf-8");
				
				//이메일 전송
				Transport.send(msg);
				result = true; //위 과정이 잘 이뤄짐
				
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		if(result) {
			return sb.toString(); //뭘 리턴해줘야하지?
		} else {
			return null;
		}
		
	}

}
