package com.tmt.exception.controller;

import com.tmt.exception.category.ExceptionGlobal;
import com.tmt.exception.entity.Category;
import com.tmt.exception.reposiotry.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    CategoryRepository caterepo;

    // chạy api này trước
    @PostMapping("creat")
    public Category creatCategory(@RequestBody Category category){
        Category categories = caterepo.save(category);
        return categories;
    }

    @GetMapping("get/{id}")
    public Category getByID(@PathVariable Integer id){
    Optional<Category> category = caterepo.findById(id);
    Category checkName = caterepo.findByCategoryName(category.get().getCategoryName());
        if (checkName.getCategoryName().length() <= 5){
            throw new ExceptionGlobal("category name độ dài phải lớn hơn 5");
        }
       return category.get();



    }
}
