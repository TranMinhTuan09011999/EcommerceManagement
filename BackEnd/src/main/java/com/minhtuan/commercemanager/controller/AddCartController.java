package com.minhtuan.commercemanager.controller;

import com.minhtuan.commercemanager.message.request.AddCartRequest;
import com.minhtuan.commercemanager.message.request.ApiResponse;
import com.minhtuan.commercemanager.model.AddCart;
import com.minhtuan.commercemanager.model.DTO.AddCartDTO;
import com.minhtuan.commercemanager.repository.CartRepository;
import com.minhtuan.commercemanager.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/addcart")
public class AddCartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private CartRepository cartRepository;

    @RequestMapping("/addProduct")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> addCartwithProduct(@RequestBody AddCartRequest addCartRequest) {
        try {
            List<AddCartDTO> obj = cartService.addCartbyUserIdAndProductId(addCartRequest.getProductId(), addCartRequest.getUserId(), addCartRequest.getQty(), addCartRequest.getPrice());
            return ResponseEntity.ok(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
        }
    }

    @GetMapping("/getCartsByUserId/{userId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getCartsByUserId(@PathVariable Long userId) {
        try {
            List<AddCartDTO> obj = cartService.getCartByUserId(userId);
            return ResponseEntity.ok(obj);
        }catch(Exception e) {
            return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
        }
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> deleteCartById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(cartService.deleteCartById(id));
        }catch(Exception e) {
            return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
        }
    }

    @PutMapping("update/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> updateCart(@PathVariable long id, @RequestBody HashMap<String, Long> Quantity)
    {
        try {
            String keys[] = { "quantity" };
            AddCart cart = cartService.getCartById(id);
            Long quantity = Quantity.get("quantity");
            cart.setQuantity(quantity);
            AddCart updatedCart = cartRepository.save(cart);
            Long userId = updatedCart.getUserId();
            List<AddCartDTO> obj = cartService.getCartByUserId(userId);
            return ResponseEntity.ok(obj);
            //return ResponseEntity.ok("Update quantity successly");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
        }
    }

    @GetMapping("/count/{userId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> countCartUserId(@PathVariable Long userId) throws Exception {
        Long count = cartService.countCartByUserId(userId);
        String countStr = count.toString();
        return ResponseEntity.ok(count);
    }
}
