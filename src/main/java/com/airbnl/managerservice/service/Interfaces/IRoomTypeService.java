package com.airbnl.managerservice.service.Interfaces;


import com.airbnl.managerservice.model.RoomType;

import java.util.List;

public interface IRoomTypeService {
    List<RoomType> getAllRoomTypes();

    List<RoomType> getAllRoomTypesByHotelID(long hotelId);

    RoomType getRoomTypeById(long roomTypeId);
}
