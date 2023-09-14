package boardReply.dao;

import java.util.List;
import java.util.Map;

import board.vo.BoardVO;
import boardReply.vo.BoardReplyVO;
import comm.dao.MyBatisDao;

//mapper namespace : brdReply , alias : BrdReplyVO
public class BoardReplyDaoImpl extends MyBatisDao implements IBoardReplyDao {

	private static IBoardReplyDao brDao;

	public BoardReplyDaoImpl() {
	}

	public static IBoardReplyDao getInstance() {
		if (brDao == null) {
			brDao = new BoardReplyDaoImpl();
		}
		return brDao;
	}

	// 댓글 등록
	@Override
	public int insertBrdReply(BoardReplyVO bvr) {
		int cnt = insert("brdReply.insert", bvr);
		return cnt;
	}

	// 댓글 목록 조회
	@Override
	public List<BoardReplyVO> getBoardReply(Map<String, Object> map) {
		return selectList("brdReply.getBoardReply", map);
	}
	
	// 댓글 삭제
	@Override
	public int deleteBrdReply(BoardReplyVO bvr) {
		int cnt = delete("brdReply.delete", bvr);
		return cnt;
	}

//	@Override
//	public int updateBrdReply(BoardReplyVO bvr) {
//		int cnt = update("brdReply.update", bvr);
//		return cnt;
//	}
//

//	@Override
//	public List<BoardReplyVO> getBoardReply(int bNo) {
//		List<BoardReplyVO> brList = selectList("brdReply.getBoardReply", bNo);
//		return brList;
//	}
}
