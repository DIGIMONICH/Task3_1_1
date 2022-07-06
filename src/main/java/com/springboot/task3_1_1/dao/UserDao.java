package com.springboot.task3_1_1.dao;


import com.springboot.task3_1_1.model.User;

import java.util.List;

public interface UserDao {

   List<User> getAllUsers();

   void createUser(User user);

   void updateUser(User user);

   User readUser(long id);

   User deleteUser(long id);
}