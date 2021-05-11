package com.example.week7task.service;

import com.example.week7task.model.User;
import com.example.week7task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserByEmailandPassWord(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
}