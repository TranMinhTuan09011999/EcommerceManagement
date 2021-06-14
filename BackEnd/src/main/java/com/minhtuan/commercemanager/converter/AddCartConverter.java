package com.minhtuan.commercemanager.converter;

import com.minhtuan.commercemanager.model.AddCart;
import com.minhtuan.commercemanager.model.Category;
import com.minhtuan.commercemanager.model.DTO.AddCartDTO;
import com.minhtuan.commercemanager.model.DTO.CategoryDTO;
import com.minhtuan.commercemanager.model.DTO.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddCartConverter {
    @Autowired
    private ProductConverter productConverter;

    public AddCartDTO toDTO(AddCart addCart){
        AddCartDTO dto = new AddCartDTO();
        dto.setId(addCart.getId());
        dto.setProduct(productConverter.toDTO(addCart.getProduct()));
        dto.setQuantity(addCart.getQuantity());
        dto.setPrice(addCart.getPrice());
        dto.setUser_id(addCart.getUserId());
        return dto;
    }
}
