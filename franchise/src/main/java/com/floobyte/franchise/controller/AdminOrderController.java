package com.floobyte.franchise.controller;

import com.floobyte.franchise.model.Order;
import com.floobyte.franchise.model.User;
import com.floobyte.franchise.request.OrderRequest;
import com.floobyte.franchise.service.OrderService;
import com.floobyte.franchise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminOrderController {


    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    //fetch resturant order
    //Get All Orders 1 resturant
    @GetMapping("/order/resturant/{id}")
    public ResponseEntity<List<Order>> getOrderHistory(
            @PathVariable Long id,
            @RequestParam(required = false) String order_status,
            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findByUserJwtToken(jwt);
        List<Order> orders = orderService.getResturantsOrder(id, order_status);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    //order status completed or not
    @PutMapping("/order/{id}/{orderStatus}")
    public ResponseEntity<Order> updateOrderStatus(
            @PathVariable Long id,
            @PathVariable String orderStatus,
            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findByUserJwtToken(jwt);
        Order orders = orderService.updateOrder(id, orderStatus);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
