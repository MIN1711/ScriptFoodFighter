package recipe.dao;

import java.util.List;
import java.util.Map;

import recipe.vo.RecipeVO;

public interface IRecipeDao {

	public int insertRecipe(RecipeVO rv);

	public int updateRecipe(RecipeVO rv);

	public int deleteRecipe(int rNo);
	
	public boolean checkRecipe(int rNo);

	public List<RecipeVO> getAllRecipe();
	
	public List<RecipeVO> searchRecipe(RecipeVO rv);

	public RecipeVO getRecipe(int rNo);
	
	public List<RecipeVO> recipeList(Map<String, Object> map);
	
	public List<RecipeVO> getType(String rType);

	public String getRMenu(int rNo);

}
