package com.assgn5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/{cid}")
    private CategoryResponse getCategoryByCID(@NonNull @PathVariable(value = "cid") Long cid){
        try{
            return categoryService.getById(cid);
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
}
