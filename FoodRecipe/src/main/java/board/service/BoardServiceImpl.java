package board.service;

import java.util.List;
import java.util.Map;

import board.dao.BoardDaoImpl;
import board.dao.IBoardDao;
import board.vo.BoardVO;

public class BoardServiceImpl implements IBoardService {

	private IBoardDao bDao;

	private static IBoardService BoardService;

	private BoardServiceImpl() {
		bDao = BoardDaoImpl.getInstance();
	}

	public static IBoardService getInstance() {
		if (BoardService == null) {
			BoardService = new BoardServiceImpl();
		}
		return BoardService;
	}

	@Override
	public int registBoard(BoardVO bv) {
		int cnt = bDao.insertBoard(bv);
		return cnt;
	}

	@Override
	public int modifyBoard(BoardVO bv) {
		return bDao.updateBoard(bv);
	}

	@Override
	public int removeBoard(int bNo) {
		return bDao.deleteBoard(bNo);
	}

	@Override
	public BoardVO bnoBoard(String bNo) {
		return bDao.bnoList(bNo);
	}

	@Override
	public int countList(BoardVO bv) {

		int countList = 0;

		countList = bDao.countList(bv);

		return countList;

	}

	@Override
	public List<BoardVO> boardList(Map<String, Object> map) {

		List<BoardVO> boardList = null;

		boardList = bDao.boardList(map);

		return boardList;
	}
	
	@Override
	public int removeBoardReply(BoardVO bv) {
		
		return bDao.deleteBoardreply(bv);
	}

	@Override
	public boolean hasReply(int bNo) {

		return bDao.hasReply(bNo);
	}

	@Override
	public int removeBoardLike(BoardVO bv) {
		
		return bDao.deleteBoardlike(bv);
	}

	@Override
	public boolean hasLike(int bNo) {
		
		return bDao.hasLike(bNo);
	}

	

}
