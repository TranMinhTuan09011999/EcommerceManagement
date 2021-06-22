package com.minhtuan.commercemanager.repository;

import com.minhtuan.commercemanager.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findCategoryByCategoryname(String categoryName);

    Optional<Category> findById(Long id);
}
