package com.minhtuan.commercemanager.repository;

import com.minhtuan.commercemanager.model.ImageDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageDetailRepository extends JpaRepository<ImageDetail, Long> {
    List<ImageDetail> findImageDetailByImageid(Integer imageId);
    void deleteAllByImageid(Integer id);
}
