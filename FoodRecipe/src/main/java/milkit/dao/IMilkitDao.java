package milkit.dao;

import milkit.vo.MilkitVO;

public interface IMilkitDao {

	public MilkitVO getMilkit(int rNo);

	public int getMPrice(int rNo);

}
