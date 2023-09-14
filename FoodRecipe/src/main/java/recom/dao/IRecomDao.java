package recom.dao;

import recom.vo.RecomVO;

public interface IRecomDao {

	public int insertRec(RecomVO rv);

	public int deleteRec(RecomVO rv);

	public int checkRec(RecomVO rv);

	public int countRec(RecomVO rv);

}
