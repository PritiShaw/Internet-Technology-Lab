package com.assgn5;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryResponse {
    private Long id;
    private String name;
    private List<Store> stores;    

    public static CategoryResponse generate(Category category) {              
        return CategoryResponse.builder()
                    .id(category.getId())
                    .name(category.getName())
                    .stores(category.getStores())
                    .build();
    }
}
