package com.airbnl.managerservice.service.Interfaces;

import com.airbnl.managerservice.model.Hotel;
import com.airbnl.managerservice.model.Room;

import java.util.List;

public interface IHotelService {
    Hotel save(Hotel hotel);
    List<Hotel> getAllByManagerID(Long managerId);
    Hotel getByHotelIdAndManagerId(Long hotelId, Long managerId);
    Hotel update(Hotel hotel);
    Hotel deleteByIdAndManagerID(Long hotelId,Long managerId);
}
