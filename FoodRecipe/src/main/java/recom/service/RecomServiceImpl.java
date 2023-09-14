package recom.service;

import recom.dao.IRecomDao;
import recom.dao.RecomDaoImpl;
import recom.vo.RecomVO;

public class RecomServiceImpl implements IRecomService {

	private IRecomDao rDao;

	private static IRecomService rService;

	private RecomServiceImpl() {
		rDao = RecomDaoImpl.getInstance();
	}

	public static IRecomService getInstance() {

		if (rService == null) {
			rService = new RecomServiceImpl();
		}

		return rService;
	}

	@Override
	public int insertRec(RecomVO rv) {
		return rDao.insertRec(rv);

	}

	@Override
	public int deleteRec(RecomVO rv) {
		return rDao.deleteRec(rv);

	}

	@Override
	public int checkRec(RecomVO rv) {
		return rDao.checkRec(rv);
	}

	@Override
	public int countRec(RecomVO rv) {
		return rDao.countRec(rv);
	}

}
