package qnaReply.dao;

import java.util.List;
import java.util.Map;

import boardReply.vo.BoardReplyVO;
import qnaReply.vo.QnAReplyVO;

public interface IQnAReplyDao {

	// 댓글 등록
	public int insertQnaReply(QnAReplyVO qrv) throws Exception;

	// 댓글 목록 조회
	public List<QnAReplyVO> getQnAReply(Map<String, Object> map);
	
	// 댓글 삭제
//	public int deleteQnaReply(QnAReplyVO qrv) throws Exception;
	

}
