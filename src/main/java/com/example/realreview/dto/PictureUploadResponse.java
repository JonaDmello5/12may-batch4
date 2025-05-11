package com.example.realreview.dto;

public class PictureUploadResponse {
	 private String message;
	 private String fileName;
	 private String filePath;
	 private String location;

	 public PictureUploadResponse(String message, String fileName, String filePath, String location) {
		 this.setMessage(message);
	     this.setFileName(fileName);
	     this.setFilePath(filePath);
	     this.setLocation(location);
	 }

	 public String getLocation() {
		return location;
	 }

	 public void setLocation(String location) {
		this.location = location;
	 }

	 public String getFilePath() {
		return filePath;
	 }

	 public void setFilePath(String filePath) {
		this.filePath = filePath;
	 }

	 public String getFileName() {
		return fileName;
	 }

	 public void setFileName(String fileName) {
		this.fileName = fileName;
	 }

	 public String getMessage() {
		return message;
	 }

	 public void setMessage(String message) {
		this.message = message;
	 }
	 
}
