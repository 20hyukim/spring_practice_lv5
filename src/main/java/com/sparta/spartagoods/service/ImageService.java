package com.sparta.spartagoods.service;

import com.sparta.spartagoods.entity.image.ImagePhoto;
import com.sparta.spartagoods.repository.ImageRepository;
import com.sparta.spartagoods.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;

    @Autowired
    private S3Uploader s3Uploader;

    public Long saveImage(MultipartFile images, ImagePhoto imagePhoto, UserDetailsImpl userDetails) throws IOException {
        if(!images.isEmpty()) {
            String storedFileName = s3Uploader.upload(images, "image");
            imagePhoto.setImageUrl(storedFileName);
        }
        ImagePhoto savedImage = imageRepository.save(imagePhoto);
        return savedImage.getImageId();
    }


}
