package com.minhtuan.commercemanager.model.DTO;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class CategoryDTO {
    private Long id;
    private String categoryName;
    private List<ProductDTO> products;
}
