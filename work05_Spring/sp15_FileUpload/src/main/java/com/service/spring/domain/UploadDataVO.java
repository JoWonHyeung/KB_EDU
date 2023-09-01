package com.service.spring.domain;

import org.springframework.web.multipart.MultipartFile;

/*
 * 파일 탐색창에서 선택한 파일의 정보를 저장하는  VO  클래스..
 */
public class UploadDataVO {
	private String userName; //사용자명 저장
	private MultipartFile  uploadFile;//업로드 파일 정보 저장
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
}
