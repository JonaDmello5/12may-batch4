package com.example.realreview.respository;

import com.example.realreview.entity.Picture;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long> {
}
