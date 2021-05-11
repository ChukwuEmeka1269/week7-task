package com.example.week7task.controller;

import com.example.week7task.model.User;
import com.example.week7task.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("getLoginPage","Please login");
        return "register2";
    }

    @PostMapping("/register")
    public String signUp(User user, Model model, RedirectAttributes redirectAttributes){
        User userRegister = userService.getUserByEmail(user.getEmail());

        if(userRegister  != null){
            model.addAttribute("getLoginPage","User already exist");
            redirectAttributes.addFlashAttribute("failed", "User already exist");
            return "register2";
        }
        userService.addUser(user);
        model.addAttribute("success","Registration successful");
        redirectAttributes.addFlashAttribute("successMessage", "Registration successful");
        return "redirect:/login";

    }
}
