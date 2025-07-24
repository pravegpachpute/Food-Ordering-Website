package com.floobyte.franchise.repository;

import com.floobyte.franchise.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddessRepository extends JpaRepository<Address, Long> {
}
