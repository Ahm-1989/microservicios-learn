package com.msvc.usuario.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.msvc.usuario.entity.Hotel;
import com.msvc.usuario.entity.Rating;
import com.msvc.usuario.entity.User;
import com.msvc.usuario.exceptions.ResourceNotFoundException;
import com.msvc.usuario.repository.UserRepository;
import com.msvc.usuario.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

  private Logger logger = LoggerFactory.getLogger(UserService.class); 

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private UserRepository userRepository;

  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  @SuppressWarnings("null")
  public User getUser(String userId) {

    User user = userRepository.findById(userId).orElseThrow(
      () -> 
        new ResourceNotFoundException("did not found the user with this userId: " + userId)
      );

    @SuppressWarnings("unchecked")
    Rating[] ratingOfTheUser = 
      restTemplate.getForObject(
        "http://localhost:8083/ratings/users/" + user.getUserId(),
        Rating[].class);

      List<Rating> ratings = Arrays.stream(ratingOfTheUser).collect(Collectors.toList());  
      
      List<Rating> ListOfRatings = ratings.stream().map( rating -> {
        System.out.println(rating.getHotelId());
        ResponseEntity<Hotel> forEntity = 
        restTemplate.getForEntity("http://localhost:8082/hotels/" + rating.getHotelId(),
        Hotel.class);
        Hotel hotel = forEntity.getBody();
        logger.info("Respuesta con codigo de estado: " + forEntity.getStatusCode());

        rating.setHotel(hotel);
        return rating;
      }).collect(Collectors.toList());

    user.setRatings(ListOfRatings);

    return user;
  }

  @Override
  public User saveUser(User user) {
    log.info("entramos al metodo");
    String randomUserId = UUID.randomUUID().toString();
    user.setUserId(randomUserId);
    log.info("salimos al metodo");
    return userRepository.save(user);
  }
}
