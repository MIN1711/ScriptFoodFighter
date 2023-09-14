package customer.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * 첨부파일 저장을 위한 공통 서비스용 인터페이스
 */
public interface IFileService {
	
	/**
	 * 파일을 저장하기 위한 메서드
	 * @param req Part정보를 꺼내기 위한 요청객체
	 * @return 첨부파일경로
	 */
	public String saveFile(HttpServletRequest req) throws Exception;
	
}
