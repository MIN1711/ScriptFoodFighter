package qna.service;

import java.util.List;
import java.util.Map;

import qna.dao.IQnADao;
import qna.dao.QnADaoImpl;
import qna.vo.QnAVO;

public class QnAServiceImpl implements IQnAService{

	private IQnADao qnaDao;

	private static IQnAService QnAService;

	private QnAServiceImpl() {
		qnaDao = QnADaoImpl.getInstance();
	}

	public static IQnAService getInstance() {
		if (QnAService == null) {
			QnAService = new QnAServiceImpl();
		}
		return QnAService;
	}
	
	// Q&A 목록
	@Override
	public List<QnAVO> qnaList(Map<String, Object> map) {
		List<QnAVO> qnaList = null;
		qnaList = qnaDao.qnaList(map);
		return qnaList;
	}
	
	// Q&A 개수_페이징
	@Override
	public int countList() {
		int countList = 0;
		countList = qnaDao.countList();
		return countList;
	}

	// Q&A 글 작성
	@Override
	public int registQnA(QnAVO qv) {
		int cnt = qnaDao.insertQnA(qv);
		return cnt;
	}
	
	// Q&A 상세 페이지
	@Override
	public QnAVO qnoQnA(String qNo) {
		return qnaDao.qnaList(qNo);
	}
	
	// Q&A 글 삭제
	@Override
	public int removeQnA(int qNo) {
		return qnaDao.deleteQnA(qNo);
	}
	
	// Q&A 댓글 삭제 (댓글 존재하는 게시글 삭제를 위함)
	@Override
	public int removeQnAReply(QnAVO qv) {
		return qnaDao.deleteQnAReply(qv);
	}
	
	// Q&A 댓글 존재 여부 확인
	@Override
	public boolean hasReply(int qNo) {
		return qnaDao.hasReply(qNo);
	}
}
