package com.minhtuan.commercemanager.repository;

import com.minhtuan.commercemanager.model.Order;
import com.minhtuan.commercemanager.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
    List<OrderDetails> findOrderDetailsByOrder(Order order);
}
