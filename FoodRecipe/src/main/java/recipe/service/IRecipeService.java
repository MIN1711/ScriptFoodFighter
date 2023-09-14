package recipe.service;

import java.util.List;
import java.util.Map;

import recipe.vo.RecipeVO;

public interface IRecipeService {

	public int registRecipe(RecipeVO rv);
	
	public int modifyRecipe(RecipeVO rv);
	
	public boolean checkRecipe(int rNo);
	
	public int removeRecipe(int rNo);
	
	public RecipeVO getRecipe(int rNo);
	
	public List<RecipeVO> displayAllRecipe();
	
	public List<RecipeVO> searchRecipe(RecipeVO rv);
	
	public List<RecipeVO> recipeList(Map<String, Object> map);
	
	public List<RecipeVO> getType(String rType);

	public String getRMenu(int rNo);
	
}
