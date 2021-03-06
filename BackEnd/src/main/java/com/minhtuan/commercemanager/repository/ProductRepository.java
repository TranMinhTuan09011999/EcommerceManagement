package com.minhtuan.commercemanager.repository;

import com.minhtuan.commercemanager.model.DTO.ProductDTO;
import com.minhtuan.commercemanager.model.Product;
import com.minhtuan.commercemanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAllByOrderByIdDesc();

    List<Product> findTop8ByPromotionGreaterThanOrderByIdDesc(Integer promotion);
    Product findProductById(Long id);
    Product findProductByName(String name);
}
