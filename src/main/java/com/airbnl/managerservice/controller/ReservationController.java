package com.airbnl.managerservice.controller;

import com.airbnl.managerservice.model.Reservation;
import com.airbnl.managerservice.service.Interfaces.IReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reservations")
public class ReservationController {
    private final IReservationService reservationService;

    public ReservationController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PutMapping
    String save(Reservation reservation, @RequestParam Long managerId, Model model) {
        Reservation svedReservation = reservationService.save(reservation, managerId);

        model.addAttribute("reservation" , svedReservation);
        model.addAttribute("managerId" , managerId);

        return "reservation";
    }
    @GetMapping(path = "/AllByHotelAndManagerId")
    String getAllByHotelAndManagerId(@RequestParam Long hotelId
            , @RequestParam Long managerId, Model model){
        List<Reservation> reservatinList = reservationService.getAllByHotelAndManagerId(hotelId, managerId);

        model.addAttribute("reservationList" , reservatinList);
        model.addAttribute("managerId" , managerId);

        return "reservations";
    }
    @GetMapping(path = "/ByReservationIdAndManagerId")
    String getByReservationIdAndManagerId(@RequestParam Long reservationId
            , @RequestParam Long managerId, Model model){
        Reservation reservation = reservationService.getByReservationIdAndManagerId(reservationId, managerId);

        model.addAttribute("reservation" , reservation);
        model.addAttribute("managerId" , managerId);

        return "reservation";
    }
}
