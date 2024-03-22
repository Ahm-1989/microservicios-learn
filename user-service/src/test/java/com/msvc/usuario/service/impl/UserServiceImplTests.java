package com.msvc.usuario.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.msvc.usuario.entity.User;
import com.msvc.usuario.repository.UserRepository;

@DataJpaTest
public class UserServiceImplTests {

  @InjectMocks
  UserServiceImpl userServiceImpl;

  @Mock
  private UserRepository userRepository;

  @Test
  @SuppressWarnings("null")
  void when_saveUser_verifyThatthisMetothodCallTheRepositorySave() {
    User user = new User(
        "NombreTest",
        "testEmail@test.com",
        "This information is part of the unit test with JUnit");

    assertNotEquals(user, userServiceImpl.saveUser(user));
    when(userRepository.save(any())).thenReturn(user);
    assertNotNull(userServiceImpl.saveUser(user));
  }

  @Test
  @SuppressWarnings("null")
  void when_saveUser_then_checksCreateUserId() {
    User user = new User(
        "NombreTest",
        "testEmail@test.com",
        "This information is part of the unit test with JUnit");

    when(userRepository.save(any())).thenReturn(user);
    userServiceImpl.saveUser(user);
    assertNotNull(user.getUserId());
  }

  @Test
  @SuppressWarnings("null")
  void when_saveUser_then_virifyTheObjectHasAllProperties() {
    User user = new User(
        "NombreTest",
        "testEmail@test.com",
        "This information is part of the unit test with JUnit");

    when(userRepository.save(any())).thenReturn(user);
    User userSaved = userServiceImpl.saveUser(user);
    assertThat(userSaved, hasProperty("userId"));
    assertThat(userSaved, hasProperty("name"));
    assertThat(userSaved, hasProperty("email"));
    assertThat(userSaved, hasProperty("information"));
  }

  @SuppressWarnings("null")
  @Test
  void when_saveUser_then_verifyThrownConnect() {
    User user = new User();
    //UserServiceImpl userServiceImplfake = mock(UserServiceImpl.class);
    when(userRepository.save(any())).thenThrow(new NullPointerException("Error ocurred"));
    assertThrows(NullPointerException.class, () -> userServiceImpl.saveUser(user));
  }
}
