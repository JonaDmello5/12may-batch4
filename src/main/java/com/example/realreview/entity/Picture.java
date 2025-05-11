package com.example.realreview.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pictures")
public class Picture {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	 private String fileName;
	 private String filePath;
	 private String location;
	 private LocalDateTime uploadedAt;

	 @ManyToOne
	 @JoinColumn(name = "user_id")
	 private User uploadedBy;

	 public User getUploadedBy() {
		return uploadedBy;
	 }

	 public void setUploadedBy(User uploadedBy) {
		this.uploadedBy = uploadedBy;
	 }

	 public LocalDateTime getUploadedAt() {
		return uploadedAt;
	 }

	 public void setUploadedAt(LocalDateTime uploadedAt) {
		this.uploadedAt = uploadedAt;
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

	 public Long getId() {
		return id;
	 }

	 public void setId(Long id) {
		this.id = id;
	 }
	 
	 
}
