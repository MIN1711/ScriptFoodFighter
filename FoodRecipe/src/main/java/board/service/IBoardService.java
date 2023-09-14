package board.service;

import java.util.List;
import java.util.Map;

import board.vo.BoardVO;

public interface IBoardService {

	public int registBoard(BoardVO bv);

	public int modifyBoard(BoardVO bv);

	public int removeBoard(int bNo);

	public BoardVO bnoBoard(String bNo);

	public int countList(BoardVO bv);

	public List<BoardVO> boardList(Map<String, Object> map);
	
	public int removeBoardReply(BoardVO bv);
	
	public boolean hasReply(int bNo);
	
	public int removeBoardLike(BoardVO bv);
	
	public boolean hasLike(int bNo);
	
}
