package com.floobyte.franchise.service.impl;

import com.floobyte.franchise.model.*;
import com.floobyte.franchise.repository.*;
import com.floobyte.franchise.request.OrderRequest;
import com.floobyte.franchise.service.CartService;
import com.floobyte.franchise.service.OrderService;
import com.floobyte.franchise.service.ResturantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private AddessRepository addessRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ResturantService resturantService;

    @Autowired
    private CartService cartService;

    @Override
    public Order createOrder(OrderRequest order, User user) throws Exception {
        Address shippingAddress = order.getDeliveryAddress();

        Address savedAddress = addessRepository.save(shippingAddress);

        if(!user.getAddresses().contains(savedAddress)){
            user.getAddresses().add(savedAddress);
            userRepository.save(user);
        }
        Resturant resturant = resturantService.findResturantById(order.getResturantId());

        Order createdOrder = new Order();
        createdOrder.setCustomer(user);
        createdOrder.setCreatedAt(new Date());
        createdOrder.setOrderStatus("PENDING");
        createdOrder.setDeliveryAddress(savedAddress);
        createdOrder.setResturant(resturant);

        Cart card = cartService.findCartByUserId(user.getId());

        List<OrderItem> orderItems = new ArrayList<>();

        for(CartItem cartItem : card.getItems()){
            OrderItem orderItem = new OrderItem();
            orderItem.setFood(cartItem.getFood());
            orderItem.setIngredients(cartItem.getIngredients());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setTotlePrice(cartItem.getTotlePrice());

            OrderItem saveOrderItem = orderItemRepository.save(orderItem);
            orderItems.add(saveOrderItem);
        }
        Long totalPrice = cartService.calculateCartTotals(card);
        createdOrder.setItems(orderItems);
        createdOrder.setTotlePrice(totalPrice);

        Order saveOrder = orderRepository.save(createdOrder);

        //Which order come which resturant
        resturant.getOrders().add(saveOrder);

        return createdOrder;
    }

    @Override
    public Order updateOrder(Long orderId, String orderStatus) throws Exception {
        Order order = findOrderById(orderId);
        if(orderStatus.equals("OUT-FOR-DELIVERY") ||
                orderStatus.equals("DELIVERED") ||
                orderStatus.equals("COMPLETED") ||
                orderStatus.equals("PENDING")){

            order.setOrderStatus(orderStatus);
            return orderRepository.save(order);
        }
         throw new Exception("Please select a valid order status");
    }

    @Override
    public Order cancelOrder(Long orderId, User user) throws Exception {
        Order order = findOrderById(orderId);

        // user order check same order cancel or not match cancel order
        if(!user.getId().equals(order.getCustomer().getId())){
            throw new Exception("You don't have access to this order");
        }
        order.setOrderStatus("CANCELLED");
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getUserOrder(Long userId) throws Exception {
        return orderRepository.findByCustomerId(userId);
    }

    @Override
    public List<Order> getResturantsOrder(Long resturantId, String orderStatus) throws Exception {
        List<Order> orders = orderRepository.findByResturantId(resturantId);
        if(orderStatus!=null){
            orders=orders.stream().filter(order ->
                             order.getOrderStatus()
                            .equals(orderStatus))
                            .collect(Collectors.toList());   //orderstatus not null check upcoming order by filter
        }
        return orders;
    }

    @Override
    public Order findOrderById(Long orderId) throws Exception {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if(optionalOrder.isEmpty()){
            throw new Exception("Order not found...");
        }
        return optionalOrder.get();
    }
}
