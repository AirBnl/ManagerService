package com.airbnl.managerservice.controller;

import com.airbnl.managerservice.model.Reservation;
import com.airbnl.managerservice.service.Interfaces.IReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/reservations")
public class ReservationController {
    private final IReservationService reservationService;

    public ReservationController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PutMapping
    String save(Reservation reservation, int managerId, Model model) {
        Reservation svedReservation = reservationService.save(reservation, managerId);

        model.addAttribute("reservation" , svedReservation);
        return "reservation";
    }
    @GetMapping(path = "/AllByHotelAndManagerId/{hotelId}/{managerId}")
    String getAllByHotelAndManagerId(@PathVariable int hotelId
            , @PathVariable int managerId, Model model){
        List<Reservation> reservatinList = reservationService.getAllByHotelAndManagerId(hotelId, managerId);

        model.addAttribute("reservationList" , reservatinList);
        return "reservations";
    }
    @GetMapping(path = "/ByReservationIdAndManagerId/{reservationId}/{managerId}")
    String getByReservationIdAndManagerId(@PathVariable int reservationId
            , @PathVariable int managerId, Model model){
        Reservation reservation = reservationService.getByReservationIdAndManagerId(reservationId, managerId);

        model.addAttribute("reservation" , reservation);
        return "reservation";
    }
}
