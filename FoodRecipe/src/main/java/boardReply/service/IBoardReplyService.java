package boardReply.service;

import java.util.List;
import java.util.Map;

import boardReply.vo.BoardReplyVO;

public interface IBoardReplyService {

	// 댓글 등록
	public int registBrdReply(BoardReplyVO bvr) throws Exception;

	// 댓글 목록 조회
	public List<BoardReplyVO> displayBoardReply(Map<String, Object> map);

	// 댓글 삭제
	public int removeBrdReply(BoardReplyVO bvr) throws Exception;

//	// 댓글 수정
//	public int modifyBrdReply(BoardReplyVO bvr) throws Exception;
	
//	public List<BoardReplyVO> displayBoardReply(int bNo) throws Exception;
//	public int registBrdReply(BrdReplyVO bvr);
//	public int modifyBrdReply(BrdReplyVO bvr);
//	public int removeBrdReply(String bNo);
//	public List<BrdReplyVO> displayAllBrdReply();
//	public List<BrdReplyVO> searchBrdReply(BrdReplyVO bvr);
//	public BrdReplyVO getBrdReply(String bNo);
//	public boolean checkBrdReply(String cusId);

}
