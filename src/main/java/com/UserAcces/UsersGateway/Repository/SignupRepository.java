package com.UserAcces.UsersGateway.Repository;

import com.UserAcces.UsersGateway.Entity.Signup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignupRepository extends JpaRepository<Integer, Signup> {
}
