package com.floobyte.franchise.request;

import lombok.Data;

@Data
public class IngredientsCategoryRequest {
    private String name;

    private Long resturantId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getResturantId() {
        return resturantId;
    }

    public void setResturantId(Long resturantId) {
        this.resturantId = resturantId;
    }
}
