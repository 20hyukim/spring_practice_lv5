package com.sparta.spartagoods.service;

import com.sparta.spartagoods.dto.Image.ImageUploadResponse;
import com.sparta.spartagoods.entity.image.ImagePhoto;
import com.sparta.spartagoods.entity.item.Item;
import com.sparta.spartagoods.repository.ImageRepository;
import com.sparta.spartagoods.repository.ItemRepository;
import com.sparta.spartagoods.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;

    @Autowired
    private S3Uploader s3Uploader;

    @Autowired
    private ItemRepository itemRepository;

    @Transactional
    public ResponseEntity<ImageUploadResponse> saveImage(MultipartFile images, Long itemId, UserDetailsImpl userDetails) throws IOException {
        ImagePhoto imagePhoto = new ImagePhoto();
        if(!images.isEmpty()) {
            String storedFileName = s3Uploader.upload(images, "image");
            imagePhoto.setImageUrl(storedFileName);
        }
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new IllegalArgumentException("허용되지 않는 item ID :" + itemId));
        imagePhoto.setItem(item);

        ImagePhoto savedImage = imageRepository.save(imagePhoto);
        String responseSentence = "이미지를 성공적으로 업로드 했습니다.";

        ImageUploadResponse response = new ImageUploadResponse(savedImage.getImageId(), responseSentence);
        return ResponseEntity.ok(response);
    }


}
