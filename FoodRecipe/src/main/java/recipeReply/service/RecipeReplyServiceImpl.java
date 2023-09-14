package recipeReply.service;

import java.util.List;
import java.util.Map;

import recipeReply.dao.IRecipeReplyDao;
import recipeReply.dao.RecipeReplyDaoImpl;
import recipeReply.vo.RecipeReplyVO;

public class RecipeReplyServiceImpl implements IRecipeReplyService{

	private IRecipeReplyDao rrDao;
	
	private static IRecipeReplyService rrService;
	
	public RecipeReplyServiceImpl() {
		rrDao = RecipeReplyDaoImpl.getInstance();
	}
	
	public static IRecipeReplyService getInstance() {
		if(rrService == null) {
			rrService = new RecipeReplyServiceImpl();
		}
		return rrService;
	}
	
	@Override
	public int regisRecReply(RecipeReplyVO rrv) {
		int cnt = rrDao.insertRecReply(rrv);
		return cnt;
	}

	@Override
	public List<RecipeReplyVO> displayRecipeReply(Map<String, Object> map) {
		List<RecipeReplyVO> recipeReplyList =null;
		
		recipeReplyList = rrDao.getRecipeReply(map);
		
		return recipeReplyList;
	}

	@Override
	public int removeRecReply(RecipeReplyVO rrv) {
		int cnt = rrDao.deleteRecReply(rrv);
		return cnt;
	}
	

}
