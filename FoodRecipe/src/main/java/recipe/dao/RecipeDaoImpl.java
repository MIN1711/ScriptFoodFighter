package recipe.dao;

import java.util.List;
import java.util.Map;

import comm.dao.MyBatisDao;
import recipe.vo.RecipeVO;

public class RecipeDaoImpl extends MyBatisDao implements IRecipeDao{
	
	private static IRecipeDao reDao;
	
	public RecipeDaoImpl() {

	}
	
	public static IRecipeDao getInstance() {
		if(reDao == null) {
			reDao = new RecipeDaoImpl();
		}
		return reDao;
	}

	@Override
	public int insertRecipe(RecipeVO rv) {
		int cnt = insert("recipe.insert", rv);
		return cnt;
	}

	@Override
	public int updateRecipe(RecipeVO rv) {
		int cnt = update("recipe.update", rv);
		return cnt;
	}

	@Override
	public int deleteRecipe(int rNo) {
		int cnt = delete("recipe.delete", rNo);
		return cnt;
	}

	@Override
	public List<RecipeVO> getAllRecipe() {
		List<RecipeVO> reList = selectList("recipe.getAll");
		return reList;
	}

	@Override
	public List<RecipeVO> searchRecipe(RecipeVO rv) {
		List<RecipeVO> reList = selectList("recipe.search", rv);
		return reList;
	}

	@Override
	public RecipeVO getRecipe(int rNo) {
		RecipeVO rv = selectOne("recipe.get", rNo);
		return rv;
	}

	@Override
	public boolean checkRecipe(int rNo) {
		int cnt = selectOne("recipe.check", rNo);
		
		boolean isExist = false;
		
		if(cnt>0) {
			isExist = true;
		}
		return isExist;
	}

	@Override
	public List<RecipeVO> recipeList(Map<String, Object> map) {
		return selectList("recipe.recipeList", map);
	}

	@Override
	public List<RecipeVO> getType(String rType) {
		List<RecipeVO> reList = selectList("recipe.getType", rType);
		return reList;
	}

	@Override
	public String getRMenu(int rNo) {
		return selectOne("recipe.getRMenu", rNo);
	}
	
	

}
