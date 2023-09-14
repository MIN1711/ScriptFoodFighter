package board.dao;

import java.util.List;
import java.util.Map;
import board.vo.BoardVO;
import comm.dao.MyBatisDao;

public class BoardDaoImpl extends MyBatisDao implements IBoardDao {

	private static IBoardDao boardDao;

	public BoardDaoImpl() {
	}

	public static IBoardDao getInstance() {
		if (boardDao == null) {
			boardDao = new BoardDaoImpl();
		}
		return boardDao;
	}

	@Override
	public int insertBoard(BoardVO bv) {
		int cnt = insert("brd.insert", bv);
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO bv) {
		int cnt = update("brd.update", bv);
		return cnt;
	}

	@Override
	public int deleteBoard(int bNo) {
		int cnt = delete("brd.delete", bNo);
		return cnt;
	}

	@Override
	public BoardVO bnoList(String bNo) {
		BoardVO bv = selectOne("brd.getBno", bNo);

		return bv;
	}

	@Override
	public int countList(BoardVO bv) {
		return selectOne("brd.countList", bv);
	}

	@Override
	public List<BoardVO> boardList(Map<String, Object> map) {
		return selectList("brd.boardList", map);
	}

	@Override
	public int deleteBoardreply(BoardVO bv) {
		int cnt= delete("brd.deleteReply",bv);
		return cnt;
	}
	@Override
	public boolean hasReply(int bNo) {
		int result = selectOne("brd.chkReply", bNo);
		boolean cnt = result == 1 ? true : false; // null 체크 후 값이 true인 경우에만 true로 설정
		return cnt;
	}

	@Override
	public int deleteBoardlike(BoardVO bv) {
		int cnt= delete("brd.deleteLike",bv);
		return cnt;
	}

	@Override
	public boolean hasLike(int bNo) {
		int result = selectOne("brd.chkLike",bNo);
		boolean cnt = result == 1 ? true : false; // null 체크 후 값이 true인 경우에만 true로 설정
		return cnt;
	}



}
