package notice.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;
import notice.service.INoticeService;
import notice.service.NoticeServiceImpl;
import notice.vo.NoticeVO;

@WebServlet("/notice/list.do")
public class ListNoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListNoticeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 게시판 글 조회
		// 지정된 범위 내의 게시글 조회 -> 페이징 처리 정보도 같이 생성

		// 현재 페이지 지정 default 1
		int currentPage = 1;

		// 전체 글 갯수
		// 정보 조회를 위한 서비스 객체 생성하기
		INoticeService service = NoticeServiceImpl.getInstance();

		// 전체 글 갯수 조회하기
		int countList = service.countList();
		System.out.println("전체 글 갯수: " + countList);

		// 페이징 처리 및 범위 내 게시글 조회를 위한 공식 작성

		// 한 화면에 출력할 페이지 수
		int perPage = 2;

		// 한페이지에 출력할 글 갯수
		int perList = 5;

		// 전체 페이지 수 - 전체 글 갯수(countList) / 페이지 당 글 갯수(perList)
		int totalPage = (int) Math.ceil((double) countList / (double) perList);
		System.out.println("전체 페이지 수: " + totalPage);

		// 페이지에 표시할 게시글의 범위 (start ~end) 구하기
		// start = (currentPage-1)*perList+1;
		int start = (currentPage - 1) * perList + 1;

		// end = start + perList -1;

		int end = start + perList - 1;
		if (end > countList)
			end = countList; // 오버된 값을 내가 가진 최대 값으로 치환

		// 페이지 처리할 startPage~endPage 값 구하기
		// startPage = ((currentPage - 1)/perPage * perPage) + 1;
		int startPage = ((currentPage - 1) / perPage * perPage) + 1;

		// endPage = startPage + perPage -1;
		int endPage = startPage + perPage - 1;
		if (endPage > totalPage)
			endPage = totalPage;

		// 서비스객체 - board관련 service객체 땡겨쓰기
		// 범위 별 게시글 조회하기
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		List<NoticeVO> noticeList = service.noticeList(map);

		// 결과(boardList)를 request에 담아서 출력할 페이지로 전달
		request.setAttribute("list", noticeList);

		// 페이징 처리를 위한 정보도 request에 담아서 전달하기
		request.setAttribute("sPage", startPage);
		request.setAttribute("ePage", endPage);
		request.setAttribute("tPage", totalPage);
		request.setAttribute("cPage", currentPage);
		System.out.println(startPage);
		System.out.println(endPage);
		System.out.println(totalPage);

		request.getRequestDispatcher("/WEB-INF/views/notice/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
