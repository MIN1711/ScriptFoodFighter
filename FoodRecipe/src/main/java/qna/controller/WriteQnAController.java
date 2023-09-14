package qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qna.service.IQnAService;
import qna.service.QnAServiceImpl;
import qna.vo.QnAVO;

@WebServlet("/qna/insert.do")
public class WriteQnAController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/qna/insert.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 받아와야할 파라미터
		String qTitle = request.getParameter("qTitle");
		String qCon = request.getParameter("qCon");
		String cusId = request.getParameter("cusId");

		// 서비스 객체 생성
		IQnAService qnaService = QnAServiceImpl.getInstance();

		// 파라미터 vo에 저장
		QnAVO qnaVo = new QnAVO();
		qnaVo.setqTitle(qTitle);
		qnaVo.setqCon(qCon);
		qnaVo.setCusId(cusId);

		// 글 등록하기
		int cnt = qnaService.registQnA(qnaVo);

		// 이동할 url
		response.sendRedirect(request.getContextPath() + "/qna/list.do");
	}
	
	
	
	
}
