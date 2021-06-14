package com.minhtuan.commercemanager.repository;

import com.minhtuan.commercemanager.model.ImageDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageDetailRepository extends JpaRepository<ImageDetail, Long> {
    List<ImageDetail> findImageDetailByImageid(Integer imageId);
}
