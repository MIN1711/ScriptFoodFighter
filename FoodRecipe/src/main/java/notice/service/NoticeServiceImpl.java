package notice.service;

import java.util.List;
import java.util.Map;

import board.vo.BoardVO;
import comm.dao.MyBatisDao;
import notice.dao.INoticeDao;
import notice.dao.NoticeDaoImpl;
import notice.vo.NoticeVO;

public class NoticeServiceImpl extends MyBatisDao implements INoticeService {

	private INoticeDao nDao;

	private static INoticeService nService;

	private NoticeServiceImpl() {
		nDao = NoticeDaoImpl.getInstance();
	}

	public static INoticeService getInstance() {
		if (nService == null) {
			nService = new NoticeServiceImpl();
		}
		return nService;
	}

	@Override
	public int registNotice(NoticeVO nv) {
		int cnt = nDao.insertNotice(nv);
		return cnt;
	}

	@Override
	public int modifyNotice(NoticeVO nv) {

		return nDao.updateNotice(nv);
	}

	@Override
	public int removeNotice(String nNo) {

		return nDao.deleteNotice(nNo);
	}

	@Override
	public NoticeVO nnoBoard(String nNo) {

		return nDao.notList(nNo);
	}

	@Override
	public int countList() {

		int countList = 0;

		countList = nDao.countList();

		return countList;
	}

	@Override
	public List<NoticeVO> noticeList(Map<String, Object> map) {

		List<NoticeVO> noticeList = null;
		
		noticeList = nDao.noticeList(map);

		return noticeList;
	}

}
