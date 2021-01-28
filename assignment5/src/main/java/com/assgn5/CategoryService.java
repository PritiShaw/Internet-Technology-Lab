package com.assgn5;



public interface CategoryService {
    CategoryResponse getById(long cid);    
    AddStoreResponse addStore(AddStoreRequest request);
}
