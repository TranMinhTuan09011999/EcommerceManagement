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
    public ImageDetail save(ImageDetail imageDetail) {
        return imageDetailRepository.save(imageDetail);
    }

    @Override
    public void saveListImageDetails(List<ImageDetail> imageDetails) {
        imageDetails.stream().forEach(s -> {
            imageDetailRepository.save(s);
        });
    }

    @Override
    public void delete(Integer imageId) {
        imageDetailRepository.deleteAllByImageid(imageId);
    }
}
