package com.sparta.spartagoods.controller;

import com.sparta.spartagoods.entity.image.ImagePhoto;
import com.sparta.spartagoods.security.UserDetailsImpl;
import com.sparta.spartagoods.service.ImageService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/image")
public class ImageController {

    private final ImageService imageService;
    @PostMapping
    public Long saveImage(HttpServletRequest request, @RequestParam(value = "image") MultipartFile images, ImagePhoto imagePhoto, @AuthenticationPrincipal UserDetailsImpl userDetails) throws IOException {
        System.out.println(images);
        System.out.println(imagePhoto);
        return imageService.saveImage(images, imagePhoto, userDetails);
    }
}
