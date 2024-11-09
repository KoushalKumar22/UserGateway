package com.UserAcces.UsersGateway.Repository;

import com.UserAcces.UsersGateway.Entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Integer, Login> {
}
