package com.airbnl.managerservice.service.Interfaces;

import com.airbnl.managerservice.model.Room;

import java.util.List;

public interface IRoomService {
    Room save(Room room);
    Room getById(long roomId);

    List<Room> getAllByHotelIdAndManagerId(long hotelId, long roomId);
}
