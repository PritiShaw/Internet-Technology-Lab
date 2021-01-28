package com.assgn5;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddStoreResponse {
    private long cid;

    public static AddStoreResponse generateResponse(Category category){
        return AddStoreResponse.builder().cid(category.getId()).build(); // Returniing category id of the store added
    }
}
