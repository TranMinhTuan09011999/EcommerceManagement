package com.minhtuan.commercemanager.controller;

import com.minhtuan.commercemanager.model.DTO.CategoryDTO;
import com.minhtuan.commercemanager.model.DTO.ProductDTO;
import com.minhtuan.commercemanager.model.ImageDetail;
import com.minhtuan.commercemanager.model.Product;
import com.minhtuan.commercemanager.services.CategoryService;
import com.minhtuan.commercemanager.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/promotion")
    public ResponseEntity<?> getPromotion(){
        List<ProductDTO> productList = productService.getProductPromotion();
        return new ResponseEntity<> (productList, HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<?> getCategory(){
        List<CategoryDTO> categoryList = categoryService.getCategory();
        return new ResponseEntity<> (categoryList, HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts() {
        Iterable<ProductDTO> list = productService.getAllProducts();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/category/{categoryName}")
    public ResponseEntity<?> getCategoryName(@PathVariable String categoryName){
        CategoryDTO category = categoryService.getCategoryByName(categoryName);
        return new ResponseEntity<> (category, HttpStatus.OK);
    }

    @GetMapping("/product/{productName}")
    public ResponseEntity<?> getProductName(@PathVariable String productName){
        ProductDTO productDTO = productService.getProductByName(productName);
        return new ResponseEntity<> (productDTO, HttpStatus.OK);
    }

    @GetMapping("/product/detail/{imageId}")
    public ResponseEntity<?> getImageId(@PathVariable Integer imageId){
        List<ImageDetail> list = productService.getImageId(imageId);
        return new ResponseEntity<> (list, HttpStatus.OK);
    }

}
