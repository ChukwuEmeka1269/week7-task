package com.example.week7task.controller;

import com.example.week7task.model.Post;
import com.example.week7task.model.User;
import com.example.week7task.service.PostService;
import com.example.week7task.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    PostServiceImpl postService;

    @GetMapping("/")
    public String homePage (Model model, HttpSession httpSession){
        User user = (User)httpSession.getAttribute("user");
        model.addAttribute("allPosts", postService.getAllPost());
        model.addAttribute("post", new Post());
        return "home";
    }


    @PostMapping("/createPost")
    public  String createNewPost(Post post, HttpSession httpSession){
        User user = (User)httpSession.getAttribute("user");

        postService.createPost(post, user);
        return  "redirect:/";
    }

}
