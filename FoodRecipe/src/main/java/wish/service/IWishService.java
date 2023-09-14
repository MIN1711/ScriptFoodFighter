package wish.service;

import java.util.List;

import wish.vo.WishVO;

public interface IWishService {

	public int insertWish(WishVO wv);

	public int deleteWish(WishVO wv);

	public int checkWish(WishVO wv);

	public int countWish(WishVO wv);
}
