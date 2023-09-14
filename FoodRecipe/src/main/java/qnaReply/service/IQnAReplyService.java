package qnaReply.service;

import java.util.List;
import java.util.Map;

import boardReply.vo.BoardReplyVO;
import qnaReply.vo.QnAReplyVO;

public interface IQnAReplyService {

	// 댓글 등록
	public int registQnaReply(QnAReplyVO qrv) throws Exception;

	// 댓글 목록 조회
	public List<QnAReplyVO> displayQnAReply(Map<String, Object> map);
	
	// 댓글 삭제
//	public int deleteQnaReply(QnAReplyVO qrv) throws Exception;
	

}
