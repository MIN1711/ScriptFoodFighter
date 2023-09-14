package recom.dao;

import comm.dao.MyBatisDao;
import recom.vo.RecomVO;

public class RecomDaoImpl extends MyBatisDao implements IRecomDao {

	private static IRecomDao rDao;

	public RecomDaoImpl() {
	}

	public static IRecomDao getInstance() {
		if (rDao == null) {
			rDao = new RecomDaoImpl();
		}
		return rDao;
	}

	@Override
	public int insertRec(RecomVO rv) {
		return insert("rec.insert", rv);

	}

	@Override
	public int deleteRec(RecomVO rv) {
		return delete("rec.delete", rv);

	}

	@Override
	public int checkRec(RecomVO rv) {

		return selectOne("rec.check", rv);
	}

	@Override
	public int countRec(RecomVO rv) {

		return selectOne("rec.count", rv);

	}

}
