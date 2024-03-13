package com.msvc.usuario.service;

import java.util.List;

import com.msvc.usuario.entity.User;

public interface UserService {
  User saveUser(User user);

  List<User> getAllUsers();

  User getUser(String userId);
}
