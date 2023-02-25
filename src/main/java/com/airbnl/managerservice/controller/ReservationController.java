package com.airbnl.managerservice.controller;

import com.airbnl.managerservice.service.Interfaces.IReservationService;
import org.springframework.stereotype.Controller;

@Controller
public class ReservationController {
    private final IReservationService reservationService;

    public ReservationController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }
}
