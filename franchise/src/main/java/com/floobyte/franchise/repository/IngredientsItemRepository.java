package com.floobyte.franchise.repository;

import com.floobyte.franchise.model.IngredientsCategory;
import com.floobyte.franchise.model.IngredientsItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientsItemRepository extends JpaRepository<IngredientsItem, Long> {

    List<IngredientsItem> findByResturantId(Long resturantId);
}
