package com.minhtuan.commercemanager.services.ServicesImpl;

import com.minhtuan.commercemanager.converter.ProductConverter;
import com.minhtuan.commercemanager.model.DTO.ProductDTO;
import com.minhtuan.commercemanager.model.ImageDetail;
import com.minhtuan.commercemanager.model.Product;
import com.minhtuan.commercemanager.repository.ImageDetailRepository;
import com.minhtuan.commercemanager.repository.ProductRepository;
import com.minhtuan.commercemanager.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ImageDetailRepository imageDetailRepository;

    @Autowired
    private ProductConverter productConverter;

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> list =  productRepository.findAll();
        List<ProductDTO> listDTO = new ArrayList<>();
        list.stream().forEach(
                (s) -> {
                    ProductDTO dto = productConverter.toDTO(s);
                    listDTO.add(dto);
                }
        );
        return listDTO;
    }

    @Override
    public List<ProductDTO> getProductPromotion() {
        List<Product> list = productRepository.findTop8ByPromotionGreaterThanOrderByPromotion(0);

        List<ProductDTO> listDTO = new ArrayList<ProductDTO>();

        list.stream().forEach(s -> {
            ProductDTO dto = productConverter.toDTO(s);
            listDTO.add(dto);
        });

        return listDTO;
    }

    @Override
    public Product getProductById(long id) {
        Product product = productRepository.findProductById(id);
        return product;
    }

    @Override
    public ProductDTO getProductByName(String name) {
        Product product = productRepository.findProductByName(name);
        ProductDTO dto = productConverter.toDTO(product);
        return dto;
    }

    @Override
    public List<ImageDetail> getImageId(Integer imageId) {
        List<ImageDetail> list = imageDetailRepository.findImageDetailByImageid(imageId);
        return list;
    }
}
