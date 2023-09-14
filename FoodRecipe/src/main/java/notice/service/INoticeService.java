package notice.service;

import java.util.List;
import java.util.Map;

import notice.vo.NoticeVO;



public interface INoticeService {
	
	public int registNotice(NoticeVO nv);

	public int modifyNotice(NoticeVO nv);

	public int removeNotice(String nNo);
	
	public NoticeVO nnoBoard(String nNo);

	public int countList();

	public List<NoticeVO> noticeList(Map<String, Object> map);


}
