package com.UserAcces.UsersGateway.Services;

import com.UserAcces.UsersGateway.Entity.Login;
import com.UserAcces.UsersGateway.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    LoginRepository loginRepository;
    public boolean validateUser(String username,String password){
        Optional<Login> login=loginRepository.findByUsername(username);
        return login.isPresent() && login.get().getPassword().equals(password);
    }
}
