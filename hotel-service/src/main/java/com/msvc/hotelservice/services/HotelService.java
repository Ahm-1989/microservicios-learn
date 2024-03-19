package com.msvc.hotelservice.services;

import java.util.List;

import com.msvc.hotelservice.entity.Hotel;

public interface HotelService {
  Hotel create(Hotel hotel);

  List<Hotel> getAll();

  Hotel getOne(String hotelId);
}
