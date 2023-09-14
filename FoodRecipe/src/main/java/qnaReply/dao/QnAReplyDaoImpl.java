package qnaReply.dao;

import java.util.List;
import java.util.Map;

import comm.dao.MyBatisDao;
import qnaReply.vo.QnAReplyVO;

//mapper namespace : brdReply , alias : BrdReplyVO
public class QnAReplyDaoImpl extends MyBatisDao implements IQnAReplyDao {

	private static IQnAReplyDao qDao;

	public QnAReplyDaoImpl() {
	}

	public static IQnAReplyDao getInstance() {
		if (qDao == null) {
			qDao = new QnAReplyDaoImpl();
		}
		return qDao;
	}

	// 댓글 등록
	@Override
	public int insertQnaReply(QnAReplyVO qrv) {
		int cnt = insert("qnaReply.insert", qrv);
		return cnt;
	}

	// 댓글 목록 조회
	@Override
	public List<QnAReplyVO> getQnAReply(Map<String, Object> map) {
		return selectList("qnaReply.getQnAReply", map);
	}
	
	// 댓글 삭제
//	@Override
//	public int deleteQnaReply(QnAReplyVO qrv) {
//		int cnt = delete("qnaReply.delete", qrv);
//		return cnt;
//	}

}
