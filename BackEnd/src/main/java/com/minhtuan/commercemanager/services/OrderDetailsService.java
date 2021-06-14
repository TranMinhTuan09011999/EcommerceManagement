package com.minhtuan.commercemanager.services;

import com.minhtuan.commercemanager.message.request.OrderDetailsRequest;
import com.minhtuan.commercemanager.model.DTO.OrderDTO;
import com.minhtuan.commercemanager.model.DTO.OrderDetailsDTO;
import com.minhtuan.commercemanager.model.OrderDetails;

public interface OrderDetailsService {
    OrderDetailsDTO addOrderDetailByOrderId(OrderDetailsRequest orderDetailsRequest) throws Exception;
}
