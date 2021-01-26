package com.assgn5;

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
}
