package com.msvc.ratings.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.msvc.ratings.entities.Rating;

import java.util.List;

public interface RatingsRepository extends MongoRepository<Rating, String> {

    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}

/**
- escalabilidad vertical
- tipo de balanceo
- como seleccionar una base de datos
  - Que se debe de tener en cuenta para poder elegir una base de datos
- Cuando ocuapar un rest y un soap (Diferencia)
  - 
   */