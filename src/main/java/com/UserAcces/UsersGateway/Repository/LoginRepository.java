package com.UserAcces.UsersGateway.Repository;

import com.UserAcces.UsersGateway.Entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Integer, Login> {
    Optional<Login> findByUsername(String username);
}
