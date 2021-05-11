package com.example.week7task.service;

import com.example.week7task.model.Post;
import com.example.week7task.model.User;

import java.util.List;

public interface PostService {
    void createPost(Post post, User user);
    List<Post> getAllPost();

}
