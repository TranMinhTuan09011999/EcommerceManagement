package com.minhtuan.commercemanager.model.DTO;

import com.minhtuan.commercemanager.model.Order;
import com.minhtuan.commercemanager.model.Product;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class OrderDetailsDTO {
    private Order order;

    private Product product;

    private Long quantity;

    private Double amount;

    private Integer discount;
}
