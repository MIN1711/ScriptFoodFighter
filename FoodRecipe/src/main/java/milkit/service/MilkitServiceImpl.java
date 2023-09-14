package milkit.service;

import milkit.dao.IMilkitDao;
import milkit.dao.MilkitDaoImpl;
import milkit.vo.MilkitVO;

public class MilkitServiceImpl implements IMiltkitService {
	
	private IMilkitDao mkDao;
	
	private static IMiltkitService mkService;
	
	private MilkitServiceImpl() {
		mkDao = MilkitDaoImpl.getInstance();
	}
	
	public static IMiltkitService getInstance() {
		if (mkService == null) {
			mkService = new MilkitServiceImpl();
		}
		return mkService;
	}

	@Override
	public MilkitVO getMilkit(int rNo) {
		return mkDao.getMilkit(rNo);
	}

	@Override
	public int getMPrice(int rNo) {
		return mkDao.getMPrice(rNo);
	}

}
