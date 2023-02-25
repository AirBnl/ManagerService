package com.airbnl.managerservice.service.Interfaces;

import com.airbnl.managerservice.model.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation save(Reservation reservation, int managerId);
    List<Reservation> getAllByHotelAndManagerId(int hotelId, int managerId);
    Reservation getByReservationIdAndManagerId(int reservationId, int managerId);
}
