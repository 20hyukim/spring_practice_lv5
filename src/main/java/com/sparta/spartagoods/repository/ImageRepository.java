package com.sparta.spartagoods.repository;

import com.sparta.spartagoods.entity.image.ImagePhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImagePhoto, Long> {
}
