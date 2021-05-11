package com.example.week7task.controller;

import com.example.week7task.model.User;
import com.example.week7task.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    private UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("invalid", null);
        model.addAttribute("newregistration", null);

        return "login";
    }

    //login session
    @PostMapping("/login")
    public String login (HttpSession session, User user, Model model) {
        User gottenUser;
        gottenUser = userService.getUserByEmail(user.getEmail());
        if (gottenUser == null) {
            //error message if email does not exist in database
            model.addAttribute("invalid", "User does not exist. Check login details or register.");
            return "login";
        }

        gottenUser = userService.getUserByEmailandPassWord(user.getEmail(), user.getPassword());
        if (gottenUser == null) {
            //error message if email exists but wrong password provided
            model.addAttribute("invalid", "Incorrect password");
            return "login";
        }
        session.setAttribute("user", gottenUser);
        return "redirect:/";
//        return "login";
    }

    //logout
    @GetMapping("/logout")
    public String logout(Model model, HttpSession session) {
        if (session != null) {
            session.invalidate();
        }

        model.addAttribute("user", new User());
        model.addAttribute("invalid", null);
        return "redirect:/auth/login";
    }
}
