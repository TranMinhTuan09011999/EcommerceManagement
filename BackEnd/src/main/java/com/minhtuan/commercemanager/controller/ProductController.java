package com.minhtuan.commercemanager.controller;

import com.minhtuan.commercemanager.converter.ImageDetailsConverter;
import com.minhtuan.commercemanager.model.Category;
import com.minhtuan.commercemanager.model.DTO.ImageDetailsDTO;
import com.minhtuan.commercemanager.model.DTO.ProductDTO;
import com.minhtuan.commercemanager.model.ImageDetail;
import com.minhtuan.commercemanager.model.Product;
import com.minhtuan.commercemanager.services.CategoryService;
import com.minhtuan.commercemanager.services.ImageDetailsService;
import com.minhtuan.commercemanager.services.ProductService;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ImageDetailsService imageDetailsService;

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

    @GetMapping("/get-product/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long productId){
        ProductDTO productDTO = productService.getProductDTOById(productId);
        return new ResponseEntity<> (productDTO, HttpStatus.OK);
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
        return ResponseEntity.ok().body("Product has been created successfully");
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (Objects.isNull(product)) {
            throw new RuntimeException("Can't find Product");
        }
        if (product.getOrderDetails().stream().count() == 0) {
            imageDetailsService.delete(product.getId());
            productService.delete(product);
            return ResponseEntity.ok().body("Product has been deleted successfully");
        } else {
            product.setDeletestatus(1);
            productService.save(product);
            return ResponseEntity.ok().body("Delete Status has been set to 1");
        }
    }

    @GetMapping("/product/detail/{imageId}")
    public ResponseEntity<?> getImageId(@PathVariable Long imageId){
        List<ImageDetail> list = productService.getImageId(imageId);
        return new ResponseEntity<> (list, HttpStatus.OK);
    }

    @PostMapping("product/detail")
    public ResponseEntity<?> postImage(@RequestBody List<ImageDetailsDTO> list) {
        list.stream().forEach(s -> {
            imageDetailsService.save(new ImageDetailsConverter().toEntity(s));
        });

        return ResponseEntity.ok().body("Product Images has been created successfully");
    }

    @Transactional
    @PutMapping("product/detail/{id}")
    public ResponseEntity<?> putImage(@PathVariable Long id, @RequestBody List<ImageDetailsDTO> list) {
        System.out.println(id);
        System.out.println(list);

        imageDetailsService.delete(id);

        list.stream().forEach(s -> {
            imageDetailsService.save(new ImageDetailsConverter().toEntity(s));
        });

        return ResponseEntity.ok().body("Product Images has been updated successfully");
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody ProductDTO dto,
                                           @PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (Objects.isNull(product)) {
            throw new RuntimeException("Can't find Product");
        }
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setPromotion(dto.getPromotion());
        product.setDescription(dto.getDescription());
        product.setImage(dto.getImage());
        product.setDeletestatus(dto.getDeletestatus());
        Category category = categoryService.findById(dto.getCategoryId());
        product.setCategory(category);
        product.toString();
//        putImage(product.getId(), list);
        productService.save(product);
        return ResponseEntity.ok().body("Product has been updated successfully");
    }
}
