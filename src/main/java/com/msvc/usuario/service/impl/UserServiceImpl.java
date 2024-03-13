package com.msvc.usuario.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msvc.usuario.entity.User;
import com.msvc.usuario.exceptions.ResourceNotFoundException;
import com.msvc.usuario.repository.UserRepository;
import com.msvc.usuario.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public User getUser(String userId) {
    return userRepository.findById(userId)
      .orElseThrow(
        () -> 
          new ResourceNotFoundException("did not found the user with userId: " + userId)
        );
  }

  @Override
  public User saveUser(User user) {
    String randomUserId = UUID.randomUUID().toString();
    user.setUserId(randomUserId);
    return userRepository.save(user);
  }
}
