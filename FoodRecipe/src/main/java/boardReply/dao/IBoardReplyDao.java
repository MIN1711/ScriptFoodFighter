package boardReply.dao;

import java.util.List;
import java.util.Map;

import boardReply.vo.BoardReplyVO;

public interface IBoardReplyDao {

	// 댓글 등록
	public int insertBrdReply(BoardReplyVO bvr) throws Exception;

	// 댓글 목록 조회
	public List<BoardReplyVO> getBoardReply(Map<String, Object> map);
	
	// 댓글 삭제
	public int deleteBrdReply(BoardReplyVO bvr) throws Exception;
	
//	// 댓글 수정
//	public int updateBrdReply(BoardReplyVO bvr) throws Exception;
	
	
//	public int insertBrdReply(BrdReplyVO bvr);
//	public int updateBrdReply(BrdReplyVO bvr);
//	public int deleteBrdReply(String bNo);
//	public List<BrdReplyVO> getAllBrdReply();
//	public List<BrdReplyVO> searchBrdReply(BrdReplyVO bvr);
//	public BrdReplyVO getBrdReply(String bNo);
//	public boolean checkBrdReply(String cusId);
//	public List<BrdReplyVO> BrdReplyList(Map<String, Object> map);
}
