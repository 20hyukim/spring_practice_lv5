package com.sparta.spartagoods.service;

import com.sparta.spartagoods.entity.image.ImagePhoto;
import com.sparta.spartagoods.entity.item.Item;
import com.sparta.spartagoods.repository.ImageRepository;
import com.sparta.spartagoods.repository.ItemRepository;
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

    @Autowired
    private ItemRepository itemRepository;

    public Long saveImage(MultipartFile images, Long itemId, ImagePhoto imagePhoto, UserDetailsImpl userDetails) throws IOException {
        if(!images.isEmpty()) {
            String storedFileName = s3Uploader.upload(images, "image");
            imagePhoto.setImageUrl(storedFileName);
        }
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new IllegalArgumentException("허용되지 않는 item ID :" + itemId));
        imagePhoto.setItem(item);

        ImagePhoto savedImage = imageRepository.save(imagePhoto);
        return savedImage.getImageId();
    }


}
