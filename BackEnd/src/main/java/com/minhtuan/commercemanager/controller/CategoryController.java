package com.minhtuan.commercemanager.controller;

import com.minhtuan.commercemanager.model.Category;
import com.minhtuan.commercemanager.model.DTO.CategoryDTO;
import com.minhtuan.commercemanager.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<?> getCategory(){
        List<CategoryDTO> categoryList = categoryService.getCategory();
        return new ResponseEntity<> (categoryList, HttpStatus.OK);
    }

    @GetMapping("/category/{categoryName}")
    public ResponseEntity<?> getCategoryName(@PathVariable String categoryName){
        CategoryDTO category = categoryService.getCategoryByName(categoryName);
        return new ResponseEntity<> (category, HttpStatus.OK);
    }

    @GetMapping("/category/id/{id}")
    public ResponseEntity<?> getCategoryName(@PathVariable Long id){
        CategoryDTO category = categoryService.getCategoryById(id);
        return new ResponseEntity<> (category, HttpStatus.OK);
    }

    @PostMapping("/add-category")
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO) {
        System.out.println(categoryDTO.toString());
        Category category = new Category();
        category.setCategoryname(categoryDTO.getCategoryName());
        category.setDeletestatus(0);
        category.setProducts(null);
        categoryService.save(category);
        return ResponseEntity.ok().body(category);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        if (Objects.isNull(category)) {
            throw new RuntimeException("Can't find Category");
        }
        if (category.getProducts().stream().count() == 0) {
            categoryService.delete(id);
            return ResponseEntity.ok().body("Category has been deleted successfully");
        } else {
            category.setDeletestatus(1);
            categoryService.save(category);
            return ResponseEntity.badRequest().body("Delete Status has been set to 1");
        }
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO) {
        System.out.println(categoryDTO.getCategoryName()+id);
        Category category = categoryService.findById(id);
        if (Objects.isNull(category)) {
            throw new RuntimeException("Can't find Category");
        }
        category.setCategoryname(categoryDTO.getCategoryName());
        categoryService.save(category);
        return ResponseEntity.ok().body("Category has been updated successfully");
    }
}
