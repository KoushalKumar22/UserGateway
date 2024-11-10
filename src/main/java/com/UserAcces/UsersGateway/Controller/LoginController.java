package com.UserAcces.UsersGateway.Controller;

import com.UserAcces.UsersGateway.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    LoginService loginService;
    @GetMapping("/login")
    public String showLoginPage(){
        return "LoginAndSignUp";
    }
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model){
        boolean isValidUser=loginService.validateUser(username, password);
        if (isValidUser){
            model.addAttribute("message", "loginSuccessful");
            return "welcome";
        }else {
            model.addAttribute("message", "Invalid UserName And Password");
            return "LoginAndSignUp";
        }
    }
}
