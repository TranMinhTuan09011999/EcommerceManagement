package com.minhtuan.commercemanager.controller.admin;

import com.minhtuan.commercemanager.converter.OrderConverter;
import com.minhtuan.commercemanager.message.request.ApiResponse;
import com.minhtuan.commercemanager.model.DTO.OrderDTO;
import com.minhtuan.commercemanager.model.DTO.OrderDetailsDTO;
import com.minhtuan.commercemanager.model.Order;
import com.minhtuan.commercemanager.model.User;
import com.minhtuan.commercemanager.repository.OrderRepository;
import com.minhtuan.commercemanager.repository.UserRepository;
import com.minhtuan.commercemanager.services.OrderDetailsService;
import com.minhtuan.commercemanager.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/order")
public class OrderAdminController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderDetailsService orderDetailsService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderConverter orderConverter;

    @GetMapping("/listOrders")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllOrders() {
        return ResponseEntity.ok().body(orderService.getAllOrders());
    }

    @GetMapping("/get-top-10")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getTop10Orders() {
        return ResponseEntity.ok().body(orderService.getTop10Orders());
    }
}
