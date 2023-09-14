package mypage.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypage.service.IMypageService;
import mypage.service.MypageServiceImpl;
import mypage.vo.MypageVO;

@WebServlet("/customer/mywirtelist.do")
public class MyPageWriteList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyPageWriteList() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// cusId parameter 값을 받아온다.
		String cusId = req.getParameter("cusId");

		// 정보조회 서비스 객체 생성하기 
		IMypageService service = MypageServiceImpl.getInstance();
		
		// 회원이 작성한 글 목록을 조회하기 위해 MypageVO 객체 생성 후 cusId를 저장한다.
		MypageVO mv = new MypageVO();
		mv.setCusId(cusId);
		
		// 회원이 작성한 글의 전체 갯수를 조회한다.
		int countList = service.countList(mv);

		// 페이징 처리를 위한 변수들을 설정한다.
		int currentPage = 1;
		currentPage = req.getParameter("page") == null ? 1 : Integer.parseInt(req.getParameter("page"));
		int perPage = 2;
		int perList = 5;
		int totalPage = (int) Math.ceil((double) countList / (double) perList);
		int start = (currentPage - 1) * perList + 1;
		int end = start + perList - 1;
		if (end > countList) end = countList;
		int startPage = ((currentPage - 1) / perPage * perPage) + 1;
		int endPage = startPage + perPage - 1;
		if (endPage > totalPage) endPage = totalPage;

		// 회원이 작성한 글 목록을 조회하기 위한 파라미터들을 설정한다.
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		map.put("cusId", cusId);

		
		System.out.println("cusId"+cusId);
		
		
		// 회원이 작성한 글 목록을 조회한다.
		List<MypageVO> mywirteList = service.myWriteList(map);
		
		System.out.println("mywirteList " + mywirteList);
		
		
		
		// 결과(boardList)를 request에 담아서 출력할 페이지로 전달
		req.setAttribute("list", mywirteList);
		
		System.out.println();
		// 페이징 처리를 위한 정보도 request에 담아서 전달하기
		req.setAttribute("sPage", startPage);
		req.setAttribute("ePage", endPage);
		req.setAttribute("tPage", totalPage);
		req.setAttribute("cPage", currentPage);
		req.setAttribute("cusId", cusId);
		
		
		req.getRequestDispatcher("/myPageWriteList.jsp").forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
