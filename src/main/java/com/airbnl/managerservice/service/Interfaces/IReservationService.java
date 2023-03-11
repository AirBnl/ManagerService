package com.airbnl.managerservice.service.Interfaces;

import com.airbnl.managerservice.model.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation save(Reservation reservation, Long managerId);
    List<Reservation> getAllByHotelAndManagerId(Long hotelId, Long managerId);
    Reservation getByReservationIdAndManagerId(Long reservationId, Long managerId);
}
