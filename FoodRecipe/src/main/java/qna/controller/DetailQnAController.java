package qna.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qna.service.IQnAService;
import qna.service.QnAServiceImpl;
import qna.vo.QnAVO;
import qnaReply.service.IQnAReplyService;
import qnaReply.service.QnAReplyServiceImpl;
import qnaReply.vo.QnAReplyVO;

@WebServlet("/qna/detail.do")
public class DetailQnAController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String qNo = request.getParameter("qNo");

		IQnAService qService = QnAServiceImpl.getInstance();

		QnAVO qv = qService.qnoQnA(qNo);

		request.setAttribute("qv", qv);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("qNo", qNo);

	// Q&A 답변 목록 관련 추가 시작
		// 정보 조회를 위한 서비스 객체 생성하기
		IQnAReplyService service = QnAReplyServiceImpl.getInstance();
		
		// 내용 저장
		List<QnAReplyVO> qnaReplyList = service.displayQnAReply(map);
				  
		// 결과 qnaReplyList를 request에 담아서 출력할 페이지로 전달
		request.setAttribute("Replylist", qnaReplyList);
	// Q&A 답변 목록 관련 끝
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/qna/detail.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
