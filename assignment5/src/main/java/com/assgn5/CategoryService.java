package com.assgn5;



public interface CategoryService {
    CategoryResponse getById(long cid);    
    // AddStoreResponse addStore(Long cid,String storeName,String openTime,String closeTime, String longitude, String latitude);
    AddStoreResponse addStore(AddStoreRequest request);

}
