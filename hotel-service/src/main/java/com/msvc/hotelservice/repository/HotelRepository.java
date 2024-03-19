package com.msvc.hotelservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msvc.hotelservice.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {}
