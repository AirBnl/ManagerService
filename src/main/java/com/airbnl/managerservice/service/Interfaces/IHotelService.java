package com.airbnl.managerservice.service.Interfaces;

import com.airbnl.managerservice.model.Hotel;

import java.util.List;

public interface IHotelService {
    Hotel save(Hotel hotel);
    List<Hotel> getAllByManagerID(int managerId);
    Hotel getByHotelIdAndManagerId(int hotelId, int managerId);
    Hotel update(Hotel hotel);
    Hotel deleteByIdAndManagerID(int hotelId,int managerId);
}
