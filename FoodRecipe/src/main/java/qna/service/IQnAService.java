package qna.service;

import java.util.List;
import java.util.Map;

import qna.vo.QnAVO;

public interface IQnAService {
	
	// Q&A 목록
	public List<QnAVO> qnaList(Map<String, Object> map);
	
	// Q&A 개수_페이징
	public int countList();
	
	// Q&A 글 작성
	public int registQnA(QnAVO qv);

	// Q&A 상세 페이지
	public QnAVO qnoQnA(String qNo);
	
	// Q&A 글 삭제
	public int removeQnA(int qNo);
	
	// Q&A 댓글 삭제 (댓글 존재하는 게시글 삭제를 위함)
	public int removeQnAReply(QnAVO qv);
	
	// Q&A 댓글 존재 여부 확인
	public boolean hasReply(int qNo);
}
