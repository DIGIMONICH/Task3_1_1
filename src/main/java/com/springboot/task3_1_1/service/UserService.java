package com.springboot.task3_1_1.service;


import com.springboot.task3_1_1.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User readUser(long id);

    User deleteUser(long parseUnsignedInt);

    void createOrUpdateUser(User user);
    void createUser (User user);

    void updateUser (User user);
}
