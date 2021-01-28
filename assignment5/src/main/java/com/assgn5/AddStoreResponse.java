package com.assgn5;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddStoreResponse {
    private long cid;
    private String status;

    public static AddStoreResponse generateResponse(Category category, String status){
        return AddStoreResponse.builder().cid(category.getId()).status(status).build(); // Returning category id and status of the store added
    }
}
