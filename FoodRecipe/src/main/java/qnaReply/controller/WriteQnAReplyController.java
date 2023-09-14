package qnaReply.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qnaReply.service.IQnAReplyService;
import qnaReply.service.QnAReplyServiceImpl;
import qnaReply.vo.QnAReplyVO;

@WebServlet("/qna/reply.do")
public class WriteQnAReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/qna/detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 받아와야할 파라미터
		int qNo = Integer.parseInt(request.getParameter("qNo"));
		String qRCon = request.getParameter("qRCon");
		String manCod = request.getParameter("manCod");

		// 서비스 객체 생성
		IQnAReplyService qrService = QnAReplyServiceImpl.getInstance();

		// 받아온 파라미터를 vo에 저장
		QnAReplyVO qrVo = new QnAReplyVO();
		qrVo.setqNo(qNo);
		qrVo.setqRCon(qRCon);
		qrVo.setManCod(manCod);

		try {
			// 답변 등록하기
			int cnt = qrService.registQnaReply(qrVo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// bNo받아와 redirect --> ajax에서 reload() 사용
		//response.sendRedirect(request.getContextPath() + "/board/detail.do?bNo=" + bNo);

	}
}
