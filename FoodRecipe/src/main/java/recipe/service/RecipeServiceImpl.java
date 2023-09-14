package recipe.service;

import java.util.List;
import java.util.Map;

import recipe.dao.IRecipeDao;
import recipe.dao.RecipeDaoImpl;
import recipe.vo.RecipeVO;

public class RecipeServiceImpl implements IRecipeService {

	private IRecipeDao reDao;

	private static IRecipeService reService;

	private RecipeServiceImpl() {
		reDao = RecipeDaoImpl.getInstance();
	}

	public static IRecipeService getInstance() {
		if (reService == null) {
			reService = new RecipeServiceImpl();
		}
		return reService;
	}

	@Override
	public int registRecipe(RecipeVO rv) {
		int cnt = reDao.insertRecipe(rv);
		return cnt;
	}

	@Override
	public int modifyRecipe(RecipeVO rv) {
		return reDao.updateRecipe(rv);

	}

	@Override
	public boolean checkRecipe(int rNo) {
		return reDao.checkRecipe(rNo);
	}

	@Override
	public int removeRecipe(int rNo) {
		return reDao.deleteRecipe(rNo);
	}

	@Override
	public RecipeVO getRecipe(int rNo) {
		return reDao.getRecipe(rNo);
	}

	@Override
	public List<RecipeVO> displayAllRecipe() {
		return reDao.getAllRecipe();
	}

	@Override
	public List<RecipeVO> getType(String rType) {
		return reDao.getType(rType);
	}
	
	@Override
	public List<RecipeVO> searchRecipe(RecipeVO rv) {
		return reDao.searchRecipe(rv);
	}

	@Override
	public List<RecipeVO> recipeList(Map<String, Object> map) {

		List<RecipeVO> recipeList = null;

		recipeList = reDao.recipeList(map);

		return recipeList;

	}

	@Override
	public String getRMenu(int rNo) {
		return reDao.getRMenu(rNo);
	}


}
