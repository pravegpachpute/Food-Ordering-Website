package com.floobyte.franchise.repository;

import com.floobyte.franchise.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    public List<Order> findByCustomerId(Long userId);

    public List<Order> findByResturantId(Long resturantId);

    // find total earning
    @Query("SELECT SUM(o.totlePrice) FROM Order o")
    Double sumAllAmounts();

    // find total earning
    @Query("SELECT COUNT(o.id) FROM Order o")
    Integer sumAllOrders();
}
