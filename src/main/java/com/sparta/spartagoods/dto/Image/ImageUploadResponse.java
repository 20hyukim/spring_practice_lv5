package com.sparta.spartagoods.dto.Image;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageUploadResponse {
    private Long imageId;
    private String responseAnswer;

    public ImageUploadResponse(Long imageId, String responseSentence) {
        this.imageId = imageId;
        this.responseAnswer = responseSentence;
    }
}
