package com.floobyte.franchise.controller;


import com.floobyte.franchise.model.Order;
import com.floobyte.franchise.model.User;
import com.floobyte.franchise.request.OrderRequest;
import com.floobyte.franchise.response.PaymentResponse;
import com.floobyte.franchise.service.OrderService;
import com.floobyte.franchise.service.PaymentService;
import com.floobyte.franchise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private UserService userService;

    //Create Order
    @PostMapping("/order")
    public ResponseEntity<PaymentResponse> createOrder(
            @RequestBody OrderRequest req,
            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findByUserJwtToken(jwt);
        Order order = orderService.createOrder(req, user);
        PaymentResponse response = paymentService.createPaymentLink(order);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // get users oder
    @GetMapping("/order/user")
    public ResponseEntity<List<Order>> getOrderHistory(

            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findByUserJwtToken(jwt);
        List<Order> orders = orderService.getUserOrder(user.getId());
        return new ResponseEntity<>(orders, HttpStatus.CREATED);
    }

    // report cancel orders
    @PutMapping("/{orderId}/cancel")
    public ResponseEntity<Order> cancelOrder(
            @PathVariable Long orderId,
            @RequestHeader("Authorization") String jwt)
            throws Exception {
        User user = userService.findByUserJwtToken(jwt);
        Order orders = orderService.cancelOrder(orderId, user);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
