package qnaReply.service;

import java.util.List;
import java.util.Map;

import comm.dao.MyBatisDao;
import qnaReply.vo.QnAReplyVO;

//mapper namespace : brdReply , alias : BrdReplyVO
public class QnAReplyServiceImpl extends MyBatisDao implements IQnAReplyService {

	private static IQnAReplyService qDao;

	public QnAReplyServiceImpl() {
	}

	public static IQnAReplyService getInstance() {
		if (qDao == null) {
			qDao = new QnAReplyServiceImpl();
		}
		return qDao;
	}

	// 댓글 등록
	@Override
	public int registQnaReply(QnAReplyVO qrv) {
		int cnt = insert("qnaReply.insert", qrv);
		return cnt;
	}

	// 댓글 목록 조회
	@Override
	public List<QnAReplyVO> displayQnAReply(Map<String, Object> map) {
		return selectList("qnaReply.getQnAReply", map);
	}
	
	// 댓글 삭제
//	@Override
//	public int deleteQnaReply(QnAReplyVO qrv) {
//		int cnt = delete("qnaReply.delete", qrv);
//		return cnt;
//	}

}
