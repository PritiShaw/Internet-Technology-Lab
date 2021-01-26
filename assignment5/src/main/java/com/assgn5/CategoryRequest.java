package com.assgn5;

import java.util.List;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CategoryRequest {
    private Long id;
    private List<Store> stores;
    private String name;        

    public Category generate(){
        return Category.builder().id(id).name(name).stores(stores).build();
    }

}
