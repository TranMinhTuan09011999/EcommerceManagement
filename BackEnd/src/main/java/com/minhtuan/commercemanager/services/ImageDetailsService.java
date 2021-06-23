package com.minhtuan.commercemanager.services;

import com.minhtuan.commercemanager.model.ImageDetail;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ImageDetailsService {

    public ImageDetail save(List<ImageDetail> list);
    public void delete(Integer imageId);
}
