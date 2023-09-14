package recipeReply.service;

import java.util.List;
import java.util.Map;

import recipeReply.vo.RecipeReplyVO;

public interface IRecipeReplyService {

	
	public int regisRecReply(RecipeReplyVO rrv);
	
	public List<RecipeReplyVO> displayRecipeReply(Map<String, Object>map);

	public int removeRecReply(RecipeReplyVO rrv);  
}
