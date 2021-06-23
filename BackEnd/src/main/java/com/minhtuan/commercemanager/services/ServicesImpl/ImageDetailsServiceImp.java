package com.minhtuan.commercemanager.services.ServicesImpl;

import com.minhtuan.commercemanager.model.ImageDetail;
import com.minhtuan.commercemanager.repository.ImageDetailRepository;
import com.minhtuan.commercemanager.services.ImageDetailsService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ImageDetailsServiceImp implements ImageDetailsService {
    @Autowired
    ImageDetailRepository imageDetailRepository;

    @Override
    public ImageDetail save(List<ImageDetail> list) {
        return null;
    }

    @Override
    public void delete(Integer imageId) {

    }
}
