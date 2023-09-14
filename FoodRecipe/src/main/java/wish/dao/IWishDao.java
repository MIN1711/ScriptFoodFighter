package wish.dao;

import java.util.List;

import recom.vo.RecomVO;
import wish.vo.WishVO;

public interface IWishDao {

	public int insertWish(WishVO wv);

	public int deleteWish(WishVO wv);

	public int checkWish(WishVO wv);

	public int countWish(WishVO wv);
	
}
