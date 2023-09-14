package board.dao;

import java.util.List;
import java.util.Map;
import board.vo.BoardVO;

public interface IBoardDao {

	// board 게시글 작성
	public int insertBoard(BoardVO bv);

	// board 게시글 수정
	public int updateBoard(BoardVO bv);

	// board 게시글 삭제
	public int deleteBoard(int bNo);

	// board 페이지 리스트(최신순)
	public BoardVO bnoList(String bNo);

	// board 게시글 수 체크
	public int countList(BoardVO bv);

	// board 페이지 받기(최신순)
	public List<BoardVO> boardList(Map<String, Object> map);
	
	// board 댓글 삭제(댓글 존재하는 게시글 삭제를 위함)
	public int deleteBoardreply(BoardVO bv);
			
	// board 댓글 존재 여부 확인
	public boolean hasReply(int bNo); 
	
	// board 추천 삭제(추천 존재하는 게시글 삭제를 위함)
	public int deleteBoardlike(BoardVO bv);
			
	// board 추천 존재 여부 확인
	public boolean hasLike(int bNo); 

}
