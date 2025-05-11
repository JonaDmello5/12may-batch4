package com.example.realreview.controller;

import com.example.realreview.config.CustomerUserDetails;
import com.example.realreview.entity.Picture;
import com.example.realreview.service.PictureService;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/pictures")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadPicture(
            @AuthenticationPrincipal CustomerUserDetails userDetails,
            @RequestParam("file") MultipartFile file,
            @RequestParam("location") String location
    ) throws IOException {
        String username = userDetails.getUsername();
        Picture picture = pictureService.uploadPicture(username, file, location);
        return ResponseEntity.ok(picture);
    }
}
