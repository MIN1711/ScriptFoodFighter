package recipe.vo;

import java.util.Date;

public class CusFileVo {

		private long CusFileId = -1;	// 첨부파일ID
		private int fileSn = 1;			// 파일순번
		
		private String fileStreCours;	// 파일저장 경로
		private String streFileNm; 		// 저장파일명
		private String orignlFileNm;	// 원본파일명
		private String fileExtsn;		// 확장자명
		private String fileCn;			// 파일 내용
		private long fileSize;		// 파일크기
		private Date creatDt;			// 생성일자
		private String useAt;			// 사용여부
		public long getCusFileId() {
			return CusFileId;
		}
		public void setCusFileId(long CusFileId) {
			this.CusFileId = CusFileId;
		}
		public int getFileSn() {
			return fileSn;
		}
		public void setFileSn(int fileSn) {
			this.fileSn = fileSn;
		}
		public String getFileStreCours() {
			return fileStreCours;
		}
		public void setFileStreCours(String fileStreCours) {
			this.fileStreCours = fileStreCours;
		}
		public String getStreFileNm() {
			return streFileNm;
		}
		public void setStreFileNm(String streFileNm) {
			this.streFileNm = streFileNm;
		}
		public String getOrignlFileNm() {
			return orignlFileNm;
		}
		public void setOrignlFileNm(String orignlFileNm) {
			this.orignlFileNm = orignlFileNm;
		}
		public String getFileExtsn() {
			return fileExtsn;
		}
		public void setFileExtsn(String fileExtsn) {
			this.fileExtsn = fileExtsn;
		}
		public String getFileCn() {
			return fileCn;
		}
		public void setFileCn(String fileCn) {
			this.fileCn = fileCn;
		}
		public long getFileSize() {
			return fileSize;
		}
		public void setFileSize(long fileSize) {
			this.fileSize = fileSize;
		}
		public Date getCreatDt() {
			return creatDt;
		}
		public void setCreatDt(Date creatDt) {
			this.creatDt = creatDt;
		}
		public String getUseAt() {
			return useAt;
		}
		public void setUseAt(String useAt) {
			this.useAt = useAt;
		}

		
		

	}

