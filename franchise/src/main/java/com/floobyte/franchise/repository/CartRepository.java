package com.floobyte.franchise.repository;

import com.floobyte.franchise.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

    public Cart findByCustomerId(long userId);
}
