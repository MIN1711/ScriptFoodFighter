package recipeReply.dao;

import java.util.List;
import java.util.Map;

import recipeReply.vo.RecipeReplyVO;

public interface IRecipeReplyDao {
	
	public int insertRecReply(RecipeReplyVO rrv);
	
	public List<RecipeReplyVO> getRecipeReply(Map<String, Object> map);
	
	public int deleteRecReply(RecipeReplyVO rrv);
	
	
}
