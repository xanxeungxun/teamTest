//인서트로 처리 할 객체

package com.iei.question.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import com.iei.question.model.service.NoticeService;
import com.iei.question.model.vo.Notice;

@WebServlet(name = "NoticeWrite", urlPatterns = { "/noticeWritee.do" })
public class NoticeWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public NoticeWriteServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 인코딩
		request.setCharacterEncoding("utf-8");
		//2 값 추출
		//multipart/form-date(파일업로드)형식이면 데이터를 변환후 출력
		//->cos.jar 라이브러리를 이용(/WEB-INF/lib/폴더에 해당 라이브러리가 있어야 함)
		//2-1. 파일이 업로드 될 경로를 지정
		// webapp폴더의 절대경로를 구하는 방법(절대경로 c드라이브 부터 경로)
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root+"upload/notice";
		//2-2. 파일 업로드 최대용량 설정(일반적으로 웹은 10MB)
		int maxSize = 10*1024*1024;
		//2-3. multipart/form-data에서 데이터를 꺼내기 위한 객체 변환 작업
		//request - > MultipartRequest객체로 변환 (cos.jar)
		//매개변수 5개를 전달하면 변환
		// 1)request,2)파일저장경로,3)파일최대크기,4)인코딩타입,5)파일중복처리객체
		MultipartRequest mRequest
		= new MultipartRequest(request, saveDirectory, maxSize,"UTF-8",new DefaultFileRenamePolicy());
		//request -> MultipartRequest로 변환 완료
		//- > 파일업로드가 완료되는 시점
		// 입력 정보를 추출 (MultipartRequest에서 추출)
		String noticeTitle = mRequest.getParameter("noticeTitle");
		String noticeWriter = mRequest.getParameter("noticeWriter");
		String noticeContent = mRequest.getParameter("noticeContent");
		//실제로 첨부한 파일 이름 (중복처리 전 파일명)
		String filename = mRequest.getOriginalFileName("upfile");
		//실제 서버에 업로드된 파일 이름(중복처리 후 파일명)
		String filepath = mRequest.getFilesystemName("upfile");
		Notice n = new Notice();
		n.setNoticeTitle(noticeTitle);
		n.setNoticeWriter(noticeWriter);
		n.setNoticeContent(noticeContent);
		n.setFilename(filename);
		n.setFilepach(filepath);
		//3 비즈니스 로직
		NoticeService service = new NoticeService();
		int result = service.insertNotice(n);
		//4 결과 처리
		RequestDispatcher view =
				request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("title", "게시글 작성 성공");
			request.setAttribute("msg", "게시글이 작성되었씁니다.");
			request.setAttribute("icon", "success");
		}else {
			request.setAttribute("title", "게시글 작성 실패");
			request.setAttribute("msg", "오류가 발생하였습니다.");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/noticeList.do?reqPage=1");
		view.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
