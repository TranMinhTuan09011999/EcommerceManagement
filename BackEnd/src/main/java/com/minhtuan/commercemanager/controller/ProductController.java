package com.minhtuan.commercemanager.controller;

import com.minhtuan.commercemanager.converter.ImageDetailsConverter;
import com.minhtuan.commercemanager.converter.ProductConverter;
import com.minhtuan.commercemanager.message.request.ApiResponse;
import com.minhtuan.commercemanager.model.AddCart;
import com.minhtuan.commercemanager.model.Category;
import com.minhtuan.commercemanager.model.DTO.AddCartDTO;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    @Autowired
    private ProductConverter productConverter;

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
    public ResponseEntity<?> getProductById(@PathVariable Long id){
        ProductDTO productDTO = productService.getProductDTOById(id);
        return new ResponseEntity<> (productDTO, HttpStatus.OK);
    }

    @GetMapping("/product/{productName}")
    public ResponseEntity<?> getProductName(@PathVariable String productName){
        ProductDTO productDTO = productService.getProductByName(productName);
        return new ResponseEntity<> (productDTO, HttpStatus.OK);
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

    @PutMapping("/product/updateQuantity/{idProduct}")
    public ResponseEntity<?> updateQuantityProduct(@PathVariable long idProduct, @RequestBody HashMap<String, Long> Quantity)
    {
        try {
            String keys[] = { "quantity" };
            Product product = productService.getProductById(idProduct);
            Long quantity = Quantity.get("quantity");
            product.setQuantity(quantity);
            Product updateProduct = productService.save(product);
            ProductDTO productDTO = productConverter.toDTO(updateProduct);
            return ResponseEntity.ok(productDTO);
            //return ResponseEntity.ok("Update quantity successly");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
        }
    }
}
