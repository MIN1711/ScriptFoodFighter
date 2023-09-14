package boardReply.service;

import java.util.List;
import java.util.Map;

import board.vo.BoardVO;
import boardReply.dao.BoardReplyDaoImpl;
import boardReply.dao.IBoardReplyDao;
import boardReply.vo.BoardReplyVO;

public class BoardReplyServiceImpl implements IBoardReplyService {

	private IBoardReplyDao brDao;

	private static IBoardReplyService brService;

	private BoardReplyServiceImpl() {
		brDao = BoardReplyDaoImpl.getInstance();
	}

	public static IBoardReplyService getInstance() {
		if (brService == null) {
			brService = new BoardReplyServiceImpl();
		}
		return brService;
	}

	// 댓글 등록
	@Override
	public int registBrdReply(BoardReplyVO bvr) throws Exception {
		int cnt = brDao.insertBrdReply(bvr);
		return cnt;
	}

	// 댓글 목록 조회
	@Override
	public List<BoardReplyVO> displayBoardReply(Map<String, Object> map) {
		List<BoardReplyVO> boardReplyList = null;

		boardReplyList = brDao.getBoardReply(map);

		return boardReplyList;
	}
	
	// 댓글 삭제
	@Override
	public int removeBrdReply(BoardReplyVO bvr) throws Exception {
		int cnt = brDao.deleteBrdReply(bvr);
		return cnt;
	}

//	@Override
//	public int modifyBrdReply(BoardReplyVO bvr) throws Exception {
//		int cnt = brDao.updateBrdReply(bvr);
//		return cnt;
//	}
//

}
