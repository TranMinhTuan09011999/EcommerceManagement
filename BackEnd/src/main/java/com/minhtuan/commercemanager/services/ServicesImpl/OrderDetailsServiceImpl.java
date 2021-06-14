package com.minhtuan.commercemanager.services.ServicesImpl;

import com.minhtuan.commercemanager.converter.OrderConverter;
import com.minhtuan.commercemanager.converter.OrderDetailsConverter;
import com.minhtuan.commercemanager.message.request.OrderDetailsRequest;
import com.minhtuan.commercemanager.model.DTO.AddCartDTO;
import com.minhtuan.commercemanager.model.DTO.OrderDTO;
import com.minhtuan.commercemanager.model.DTO.OrderDetailsDTO;
import com.minhtuan.commercemanager.model.Order;
import com.minhtuan.commercemanager.model.OrderDetails;
import com.minhtuan.commercemanager.model.Product;
import com.minhtuan.commercemanager.model.User;
import com.minhtuan.commercemanager.repository.OrderDetailsRepository;
import com.minhtuan.commercemanager.services.OrderDetailsService;
import com.minhtuan.commercemanager.services.OrderService;
import com.minhtuan.commercemanager.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private OrderDetailsConverter orderDetailsConverter;

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    public OrderDetailsDTO addOrderDetailByOrderId(OrderDetailsRequest orderDetailsRequest) throws Exception {
        try {
            OrderDetails obj = new OrderDetails();
            Order order = orderService.getOrderById(orderDetailsRequest.getOrderId());
            obj.setOrder(order);
            Product product = productService.getProductById(orderDetailsRequest.getProductId());
            obj.setProduct(product);
            obj.setQuantity(orderDetailsRequest.getQuantity());
            obj.setAmount(orderDetailsRequest.getAmount());
            obj.setDiscount(orderDetailsRequest.getDiscount());
            orderDetailsRepository.save(obj);
            return  orderDetailsConverter.toDTO(obj);
        }catch(Exception e) {
            e.printStackTrace();
            logger.error(""+e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
}
