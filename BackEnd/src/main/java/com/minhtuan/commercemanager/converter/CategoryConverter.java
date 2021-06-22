package com.minhtuan.commercemanager.converter;

import com.minhtuan.commercemanager.model.Category;
import com.minhtuan.commercemanager.model.DTO.CategoryDTO;
import com.minhtuan.commercemanager.model.DTO.ProductDTO;
import com.minhtuan.commercemanager.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryConverter {

    @Autowired
    private ProductConverter productConverter;

    public CategoryDTO toDTO(Category category){
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setCategoryName(category.getCategoryname());
        dto.setDeletestatus(category.getDeletestatus());
        List<ProductDTO> listDTO = new ArrayList<ProductDTO>();
        category.getProducts().stream().forEach(s -> {
            ProductDTO dto1 = productConverter.toDTO(s);
            listDTO.add(dto1);
        });
        dto.setProducts(listDTO);
        return dto;
    }
}
