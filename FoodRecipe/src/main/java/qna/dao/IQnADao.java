package qna.dao;

import java.util.List;
import java.util.Map;

import qna.vo.QnAVO;

public interface IQnADao {
	
	// Q&A 목록
	public List<QnAVO> qnaList(Map<String, Object> map);
	
	// Q&A 개수_페이징
	public int countList();
	
	// Q&A 글 작성
	public int insertQnA(QnAVO qv);

	// Q&A 상세 페이지
	public QnAVO qnaList(String qNo);
	
	// Q&A 글 삭제
	public int deleteQnA(int qNo);
	
	// Q&A 댓글 삭제 (댓글 존재하는 게시글 삭제를 위함)
	public int deleteQnAReply(QnAVO qv);
	
	// Q&A 댓글 존재 여부 확인
	public boolean hasReply(int qNo);

}
