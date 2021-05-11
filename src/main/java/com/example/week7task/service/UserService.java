package com.example.week7task.service;

import com.example.week7task.model.User;

public interface UserService {

    User getUserByEmail(String email);

    void addUser(User user);

    User getUserByEmailandPassWord(String email, String password);
}
