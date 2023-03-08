package com.iei.report.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.book.model.service.BookService;
import com.iei.book.model.vo.Book;
import com.iei.book.model.vo.BookListData;
import com.iei.bookListManage.controller.BookListManageListServlet;
import com.iei.bookListManage.model.service.BookListManageService;
import com.iei.bookListManage.model.vo.BookListManageVo;
import com.iei.report.model.service.ReportService;
import com.iei.report.model.vo.ReportVo;
import com.iei.reportList.model.service.ReportListService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet(name = "ReportWrite", urlPatterns = { "/reportWrite.do" })
public class ReportWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReportWriteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				//1 인코딩
				request.setCharacterEncoding("utf-8");
				
				
				//2 값 추출
				
				String root = getServletContext().getRealPath("/");
				String saveDirectory = root+"upload/report";
				int maxSize = 10*1024*1024;
				MultipartRequest mRequest
				= new MultipartRequest(request, saveDirectory, maxSize,"UTF-8",new DefaultFileRenamePolicy());
				//request -> MultipartRequest로 변환 완료
				
				
				
				// 받아와서 넣어줄 객체값 추출
				
				int bookNo = Integer.getInteger(mRequest.getParameter("bookNo"));
				//신고 게시물 번호 (소설게시판)
				
				//int reportNo = Integer.getInteger(mRequest.getParameter("reportNo"));
				//신고번호
				
				
				String reportTitle = mRequest.getParameter("reportTitle");
				//제목
				String reporterId = mRequest.getParameter("reporterId");
				//작성자 아이디 전송
				int reportType = Integer.getInteger(mRequest.getParameter("reportType"));
				
				String reportContent = mRequest.getParameter("reportContent");
				//글 전송
				
				String fileName = mRequest.getOriginalFileName("upfile");
				//실제로 첨부한 파일 이름 (중복처리 전 파일명)
				
				String filePath = mRequest.getFilesystemName("upfile");
				//실제 서버에 업로드된 파일 이름(중복처리 후 파일명)
				ReportVo r = new ReportVo();
				r.setReporterId(reporterId);
				r.setReportTitle(reportTitle);
				r.setReportContent(reportContent);
				r.setFileName(fileName);
				r.setFilePatch(filePath);
				//3 비즈니스 로직
				
				ReportListService service = new ReportListService();
				int result = service.insertReport(r);
				
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
				//보내줄 경로 위치
				request.setAttribute("loc", "/noticeList.do?reqPage=1");
				view.forward(request, response);
			}
			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doGet(request, response);
			}

}