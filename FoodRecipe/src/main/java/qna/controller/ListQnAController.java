package qna.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.vo.BoardVO;
import qna.service.IQnAService;
import qna.service.QnAServiceImpl;
import qna.vo.QnAVO;

@WebServlet("/qna/list.do")
public class ListQnAController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListQnAController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cusId = request.getParameter("cusId");
		String qTitle = request.getParameter("qTitle");

		QnAVO qv = new QnAVO();
		qv.setCusId(cusId);
		qv.setqTitle(qTitle);

		// 정보 조회를 위한 서비스 객체 생성하기
		IQnAService service = QnAServiceImpl.getInstance();

		// 전체 글 개수 조회하기
		int countList = service.countList();
		System.out.println("전체 글 개수: " + countList);

		// 현재 페이지 지정 default 1
		int currentPage = 1;

		currentPage = request.getParameter("page") == null ? 1 : 
			Integer.parseInt(request.getParameter("page"));

		// 페이징 처리 및 범위 내 게시글 조회를 위한 공식 작성
		// 한 화면에 출력할 페이지 수
		int perPage = 2;

		// 한페이지에 출력할 글 개수
		int perList = 5;

		// 전체 페이지 수 - 전체 글 개수(countList) / 페이지 당 글 개수(perList)
		int totalPage = (int) Math.ceil((double) countList / (double) perList);

		// 페이지에 표시할 게시글의 범위 (start ~end) 구하기
		int start = (currentPage - 1) * perList + 1;
		int end = start + perList - 1;
			if (end > countList)
				end = countList; // 오버된 값을 내가 가진 최대 값으로 치환

		// 페이지 처리할 startPage~endPage 값 구하기
		int startPage = ((currentPage - 1) / perPage * perPage) + 1;
		int endPage = startPage + perPage - 1;
			if (endPage > totalPage)
				endPage = totalPage;

		// 서비스객체 - qna관련 service객체 쓰기
		// 범위 별 게시글 조회하기
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		List<QnAVO> qnaList = service.qnaList(map);

		// 결과(qnaList)를 request에 담아서 출력할 페이지로 전달
		request.setAttribute("list", qnaList);

		// 페이징 처리를 위한 정보도 request에 담아서 전달하기
		request.setAttribute("sPage", startPage);
		request.setAttribute("ePage", endPage);
		request.setAttribute("tPage", totalPage);
		request.setAttribute("cPage", currentPage);
		request.setAttribute("cusId", qv.getCusId());
		request.setAttribute("qTitle", qv.getqTitle());

		request.getRequestDispatcher("/WEB-INF/views/qna/list.jsp").forward(request, response);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
