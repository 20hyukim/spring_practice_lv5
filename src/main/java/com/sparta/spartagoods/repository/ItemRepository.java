package com.sparta.spartagoods.repository;

import com.sparta.spartagoods.entity.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
