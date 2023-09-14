package qna.dao;

import java.util.List;
import java.util.Map;

import comm.dao.MyBatisDao;
import qna.vo.QnAVO;

public class QnADaoImpl extends MyBatisDao implements IQnADao{
	
	private static IQnADao qnaDao;
	
	private QnADaoImpl() {
	}
	
	public static IQnADao getInstance() {
		if(qnaDao == null) {
			qnaDao = new QnADaoImpl();
		}
		return qnaDao;
	}
	// Q&A 목록
	@Override
	public List<QnAVO> qnaList(Map<String, Object> map) {
		return selectList("qna.qnaList", map);
	}
	
	// Q&A 개수_페이징
	@Override
	public int countList() {
		return selectOne("qna.countList");
	}
	
	// Q&A 글 작성
	@Override
	public int insertQnA(QnAVO qv) {
		int cnt = insert("qna.insert", qv);
		return cnt;
	}

	// Q&A 상세 페이지
	@Override
	public QnAVO qnaList(String qNo) {
		QnAVO qv = selectOne("qna.getQno", qNo);
		return qv;
	}
	
	// Q&A 글 삭제
	@Override
	public int deleteQnA(int qNo) {
		int cnt = delete("qna.delete", qNo);
		return cnt;
	}
	
	// Q&A 댓글 삭제 (댓글 존재하는 게시글 삭제를 위함)
	@Override
	public int deleteQnAReply(QnAVO qv) {
		int cnt = delete("qna.deleteReply", qv);
		return cnt;
	}
	
	// Q&A 댓글 존재 여부 확인
	public boolean hasReply(int qNo) {
		int result = selectOne("qna.chkReply", qNo);
	    boolean cnt = result ==1 ? true : false; // null 체크 후 값이 true인 경우에만 true로 설정
	    return cnt;
	}
}
