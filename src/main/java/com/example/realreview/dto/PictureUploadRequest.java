package com.example.realreview.dto;

import org.springframework.web.multipart.MultipartFile;

public class PictureUploadRequest {
	private String location;
    private MultipartFile file;
    
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
