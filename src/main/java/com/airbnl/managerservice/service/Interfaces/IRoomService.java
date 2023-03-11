package com.airbnl.managerservice.service.Interfaces;

import com.airbnl.managerservice.model.Room;

public interface IRoomService {
    Room save(Room room);
    Room getById(long roomId);
}
