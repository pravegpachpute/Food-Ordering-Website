package com.floobyte.franchise.repository;

import com.floobyte.franchise.model.USER_ROLE;
import com.floobyte.franchise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.relation.Role;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String Username);

    User findByRole(USER_ROLE role);
}
