package com.floobyte.franchise.service;

import com.floobyte.franchise.model.Order;
import com.floobyte.franchise.model.User;
import com.floobyte.franchise.request.OrderRequest;

import java.util.List;

public interface OrderService {

    public Order createOrder(OrderRequest order, User user) throws Exception;

    public Order updateOrder(Long orderId, String orderStatus) throws Exception;

    Order cancelOrder(Long orderId, User user) throws Exception;

    public List<Order> getUserOrder(Long userId) throws Exception;

    public List<Order> getResturantsOrder(Long resturantId, String orderStatus) throws Exception;

    public Order findOrderById(Long orderId)throws Exception;

}
