package com.floobyte.franchise.repository;

import com.floobyte.franchise.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem , Long> {
}
