package notice.dao;

import java.util.List;
import java.util.Map;

import notice.service.INoticeService;
import notice.vo.NoticeVO;

public interface INoticeDao {


	public int insertNotice(NoticeVO nv);

	public int updateNotice(NoticeVO nv);

	public int deleteNotice(String nNo);

	public NoticeVO notList(String nNo);
	
	public int countList();

	public List<NoticeVO> noticeList(Map<String, Object> map);

}
