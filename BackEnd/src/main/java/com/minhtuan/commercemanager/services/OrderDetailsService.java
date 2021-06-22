package com.minhtuan.commercemanager.services;

import com.minhtuan.commercemanager.message.request.OrderDetailsRequest;
import com.minhtuan.commercemanager.model.DTO.OrderDTO;
import com.minhtuan.commercemanager.model.DTO.OrderDetailsDTO;
import com.minhtuan.commercemanager.model.OrderDetails;

import java.util.List;

public interface OrderDetailsService {
    OrderDetailsDTO addOrderDetailByOrderId(OrderDetailsRequest orderDetailsRequest) throws Exception;
    List<OrderDetailsDTO> getOrderDetailsList(Long orderId) throws Exception;
}
