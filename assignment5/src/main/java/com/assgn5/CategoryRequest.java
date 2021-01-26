package com.assgn5;

public class CategoryRequest {
    
    private int cid;
    private Long storeId;
    private String StoreName;
    private String openTime;
    private String closeTime;
    private Long latitude;
    private Long longitude;

    public Category from(){
        return Category.builder().name(this.StoreName).build();
    }

}
