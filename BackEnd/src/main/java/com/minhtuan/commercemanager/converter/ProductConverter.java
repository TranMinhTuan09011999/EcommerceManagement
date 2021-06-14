package com.minhtuan.commercemanager.converter;

import com.minhtuan.commercemanager.model.DTO.ProductDTO;
import com.minhtuan.commercemanager.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public ProductDTO toDTO(Product product){
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setImage(product.getImage());
        dto.setDeletestatus(product.getDeletestatus());
        dto.setDescription(product.getDescription());
        dto.setPromotion(product.getPromotion());
        return dto;
    }
}
