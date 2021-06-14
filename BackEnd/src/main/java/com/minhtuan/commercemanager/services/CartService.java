package com.minhtuan.commercemanager.services;

import com.minhtuan.commercemanager.model.AddCart;
import com.minhtuan.commercemanager.model.DTO.AddCartDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CartService {
    List<AddCartDTO> addCartbyUserIdAndProductId(Long productId, Long userId, Long qty, double price) throws Exception;

    //void updateQtyByCartId(long cartId,int qty,double price) throws Exception;

    List<AddCartDTO> getCartByUserId(long userId);

    void removeCartByUserId(long userId);

    String deleteCartById(Long id) throws Exception;

    AddCart getCartById(Long id) throws Exception;

    Long countCartByUserId(Long userId) throws Exception;
}
