package com.minhtuan.commercemanager.controller;

import com.minhtuan.commercemanager.model.Category;
import com.minhtuan.commercemanager.model.DTO.ImageDetailsDTO;
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



    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts() {
        Iterable<ProductDTO> list = productService.getAllProducts();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/product/{productName}")
    public ResponseEntity<?> getProductName(@PathVariable String productName){
        ProductDTO productDTO = productService.getProductByName(productName);
        return new ResponseEntity<> (productDTO, HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO dto) {
        System.out.println(dto.toString());
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setPromotion(dto.getPromotion());
        product.setDescription(dto.getDescription());
        product.setImage(dto.getImage());
        product.setDeletestatus(dto.getDeletestatus());
        Category category = categoryService.findById(dto.getCategoryId());
        product.setCategory(category);
        product.toString();
        productService.save(product);
        return ResponseEntity.ok().body("OK");
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product.getOrderDetails().stream().count() == 0) {
            productService.delete(product);
            return ResponseEntity.ok().body("NULL with id " + id);
        } else {
            product.setDeletestatus(1);
            productService.save(product);
            return ResponseEntity.ok().body("NOT NULL with id " + id);
        }
    }

    @GetMapping("/product/detail/{imageId}")
    public ResponseEntity<?> getImageId(@PathVariable Integer imageId){
        List<ImageDetail> list = productService.getImageId(imageId);
        return new ResponseEntity<> (list, HttpStatus.OK);
    }

    @PostMapping("product/detail")
    public ResponseEntity<?> postImage(@RequestBody ImageDetailsDTO dto) {
        ImageDetail imageDetail = new ImageDetail();
        imageDetail.setImageid(dto.getImageid());
        imageDetail.setImage(dto.getImage());
        return ResponseEntity.ok().body("OK");
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody ProductDTO dto, @PathVariable Long id) {
        Product product = productService.getProductById(id);
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setPromotion(dto.getPromotion());
        product.setDescription(dto.getDescription());
        product.setImage(dto.getImage());
        product.setDeletestatus(dto.getDeletestatus());
        Category category = categoryService.findById(dto.getCategoryId());
        product.setCategory(category);
        product.toString();
        productService.save(product);
        return ResponseEntity.ok().body("OK");
    }
}
