package com.sparta.spartagoods.dto.item;

import com.sparta.spartagoods.entity.item.ItemCategoryEnum;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class ItemRequestDto {

    private String itemName;
    private Long price;
    private Long count;
    private String intro;

    private ItemCategoryEnum category;
}
