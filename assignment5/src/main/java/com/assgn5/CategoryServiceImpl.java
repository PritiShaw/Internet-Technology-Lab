package com.assgn5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    public CategoryResponse getById(long cid){
        Category category = categoryRepository.getOne(cid);        
        // Select * from Category where id = cid
        return CategoryResponse.generate(category);
    }

    public AddStoreResponse addStore(AddStoreRequest request){
        Category category = categoryRepository.getOne(request.getCid());
        List<Store> stores = category.getStores();
        
        Store newstore = request.addStore();
        if(newstore !=null)
            stores.add(newstore);
        
        category.setStores(stores);
        categoryRepository.save(category);
        
        return AddStoreResponse.generateResponse(category);
    }
}
