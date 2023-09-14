package recipeReply.dao;

import java.util.List;
import java.util.Map;

import comm.dao.MyBatisDao;
import recipeReply.vo.RecipeReplyVO;

public class RecipeReplyDaoImpl extends MyBatisDao implements IRecipeReplyDao {

	private static IRecipeReplyDao rrDao;
	
	public RecipeReplyDaoImpl() {

	}
	
	public static IRecipeReplyDao getInstance() {
		if(rrDao == null) {
			rrDao = new RecipeReplyDaoImpl();
		}
		return rrDao;
	}

	@Override
	public int insertRecReply(RecipeReplyVO rrv) {
		int cnt = insert("recReply.insert", rrv);
		return cnt;
	}

	@Override
	public List<RecipeReplyVO> getRecipeReply(Map<String, Object> map) {
		return selectList("recReply.getRecipeReply", map);
	}

	@Override
	public int deleteRecReply(RecipeReplyVO rrv) {
		int cnt = delete("recReply.delete", rrv);
		return cnt;
	}
	
	
	
	
}
