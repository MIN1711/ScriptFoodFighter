package milkit.service;

import milkit.vo.MilkitVO;

public interface IMiltkitService {

	public MilkitVO getMilkit(int rNo);

	public int getMPrice(int rNo);
}
