package notice.dao;

import java.util.List;
import java.util.Map;
import comm.dao.MyBatisDao;
import notice.vo.NoticeVO;

public class NoticeDaoImpl extends MyBatisDao implements INoticeDao {

	private static INoticeDao nDao;

	public NoticeDaoImpl() {
	}

	public static INoticeDao getInstance() {
		if (nDao == null) {
			nDao = new NoticeDaoImpl();
		}
		return nDao;
	}

	@Override
	public int insertNotice(NoticeVO nv) {
		int cnt = insert("ntc.insert", nv);
		return cnt;
	}

	@Override
	public int updateNotice(NoticeVO nv) {
		int cnt = update("ntc.update", nv);
		return cnt;
	}

	@Override
	public int deleteNotice(String nNo) {
		int cnt = delete("ntc.delete", nNo);
		return cnt;
	}

	@Override
	public NoticeVO notList(String nNo) {
		NoticeVO nv = selectOne("ntc.getNno", nNo);
		return nv;
	}

	@Override
	public int countList() {
		return selectOne("ntc.countList");
	}

	@Override
	public List<NoticeVO> noticeList(Map<String, Object> map) {
		return selectList("ntc.noticeList", map);
	}

}
