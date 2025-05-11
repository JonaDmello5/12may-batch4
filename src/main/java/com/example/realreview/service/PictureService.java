package com.example.realreview.service;

import com.example.realreview.entity.Picture;
import com.example.realreview.entity.User;
import com.example.realreview.respository.PictureRepository;
import com.example.realreview.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PictureService {

    private static final String UPLOAD_DIR = "E:/uploads/"; // ✅ add a slash

    @Autowired
    private PictureRepository pictureRepository;

    @Autowired
    private UserRepository userRepository;

    public Picture uploadPicture(String username, MultipartFile file, String location) throws IOException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new RuntimeException("User not found.");
        }

        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        String fullPath = UPLOAD_DIR + fileName;

        File destinationFile = new File(fullPath);
        file.transferTo(destinationFile);

        Picture picture = new Picture();
        picture.setFileName(fileName);
        picture.setFilePath(fullPath);
        picture.setLocation(location);
        picture.setUploadedAt(LocalDateTime.now());
        picture.setUploadedBy(user.get());

        return pictureRepository.save(picture);
    }
}
