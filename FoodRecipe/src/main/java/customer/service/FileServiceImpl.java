package customer.service;

import java.io.File;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class FileServiceImpl implements IFileService {

	 String uploadPath = "D:/work/highJava/FoodRecipe/WebContent/images";

	private static IFileService atchFileService = new FileServiceImpl();

	private FileServiceImpl() {
	}

	public static IFileService getInstance() {
		return atchFileService;
	}

	@Override
	public String saveFile(HttpServletRequest req) throws Exception {

		Part cusPhotoPart = req.getPart("cusImg");
		String fileName = cusPhotoPart.getSubmittedFileName();
		String saveFilePath = ""; // 저장파일경로
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		if (fileName != null && !fileName.equals("")) { // 파일인 경우

			//long fileSize = cusPhotoPart.getSize(); // 파일 크기

			saveFilePath = uploadPath +  "/"  + fileName;

			// 업로드파일(원본파일) 저장
			cusPhotoPart.write(saveFilePath);

			cusPhotoPart.delete(); // 임시업로드 파일 삭제

		}
		return saveFilePath;
	}





}
