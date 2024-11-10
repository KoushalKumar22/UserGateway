package com.UserAcces.UsersGateway.Controller;

import com.UserAcces.UsersGateway.Entity.Signup;
import com.UserAcces.UsersGateway.Repository.SignupRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class SignupController {

    @Autowired
    private SignupRepository signupRepository;

    @GetMapping("/signup")
    public String showSignUpPage(Model model) {
        // Adding an empty Signup object to bind form data
        model.addAttribute("signup", new Signup());
        return "LoginAndSignUp"; // This renders the LoginAndSignUp.html Thymeleaf template
    }
    @PostMapping("/signup")
    public String signup(@Valid @ModelAttribute("signup") Signup signup,
                         BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasErrors()) {
            // If there are errors, return back to the signup page with errors
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "LoginAndSignUp";
        }
        // Save the signup data
        Signup savedSignup = signupRepository.save(signup);
        // Add a welcome message for the user on the welcome page
        model.addAttribute("message", "Welcome, " + savedSignup.getUsername() + "!");
        return "welcome"; // This renders the welcome.html Thymeleaf template
    }
}
