package com.example.week7task.service;

import com.example.week7task.model.Post;
import com.example.week7task.model.User;
import com.example.week7task.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public void createPost(Post post, User user) {
        post.setUser(user);
        postRepository.save(post);
    }

    @Override
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }
}
