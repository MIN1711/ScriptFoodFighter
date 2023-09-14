package milkit.dao;

import comm.dao.MyBatisDao;
import milkit.vo.MilkitVO;

public class MilkitDaoImpl extends MyBatisDao implements IMilkitDao {

	private static IMilkitDao mkDao;
	
	public MilkitDaoImpl() {

	}
	
	public static IMilkitDao getInstance() {
		if(mkDao == null) {
			mkDao = new MilkitDaoImpl();
		}
		return mkDao;
	}

	@Override
	public MilkitVO getMilkit(int rNo) {
		MilkitVO mkv = selectOne("milkit.getmk", rNo);
		return mkv;
	}

	@Override
	public int getMPrice(int rNo) {
		return selectOne("milkit.getmkp", rNo);
	}


}
