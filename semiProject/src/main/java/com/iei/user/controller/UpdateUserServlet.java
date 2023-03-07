package com.iei.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iei.user.model.service.UserService;
import com.iei.user.model.vo.User;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet(name = "UpdateUser", urlPatterns = { "/updateUser.do" })
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		
		//2. 값 추출
		//프로필 이미지
		//(1-1) 파일 업로드될 경로 지정
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root+"upload/profile"; 
		
		//(1-2) 파일 업로드 최대용량 설정
		int maxSize = 10*1024*1024; //= 10MB
		
		//(1-3) multipart/form-data에서 데이터 꺼내기 위한 객체 변환
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		User u = new User();
		String userId = mRequest.getParameter("userId");
		String userPic = mRequest.getFilesystemName("profile-upfile");
		String userNick = mRequest.getParameter("userNick");
		String userPhone = mRequest.getParameter("userPhone");
		String userEmail = mRequest.getParameter("userEmail");
		String currentUserPw = mRequest.getParameter("currentUserPw");
		String userPw = mRequest.getParameter("newPw");
		
		u.setUserId(userId);
		u.setUserPic(userPic);
		u.setUserNick(userNick);
		u.setUserPhone(userPhone);
		u.setUserEmail(userEmail);
		
		if(userPw.equals("")) { //input에서 받아올때 아무것도 입력안하면 빈 문자열
			u.setUserPw(currentUserPw);
		} else {
			u.setUserPw(userPw);
		}
		
		//3. 비즈니스 로직
		UserService service = new UserService();
		int result = service.updateUser(u);
		
		//4. 결과 처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		
		if(result>0) {
			//session 정보 수정
			HttpSession session = request.getSession();
			User loginUser = (User)session.getAttribute("loginUser");
			
			loginUser.setUserPic(userPic);
			loginUser.setUserNick(userNick);
			loginUser.setUserPhone(userPhone);
			loginUser.setUserEmail(userEmail);
			loginUser.setUserPw(userPw);
			
			request.setAttribute("title", "정보 변경 성공");
			request.setAttribute("msg", "정보가 수정되었습니다.");
			request.setAttribute("icon", "success");
			
		} else {
			request.setAttribute("title", "정보 변경 실패");
			request.setAttribute("msg", "우짜냐");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/updateUserFrm.do");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
