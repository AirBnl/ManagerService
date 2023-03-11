package com.airbnl.managerservice.controller;

import com.airbnl.managerservice.model.Reservation;
import com.airbnl.managerservice.service.Interfaces.IReservationService;
import com.airbnl.managerservice.service.Interfaces.IUserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reservations")
public class ReservationController {
    private final IReservationService reservationService;
    private final IUserService userService;

    public ReservationController(IReservationService reservationService, IUserService userService) {
        this.reservationService = reservationService;
        this.userService = userService;
    }

    @PutMapping
    String save(Reservation reservation, @RequestParam Long managerId, Model model) {
        Reservation svedReservation = reservationService.save(reservation, managerId);

        model.addAttribute("reservation" , svedReservation);
        model.addAttribute("managerId" , managerId);

        return "reservation";
    }
    @GetMapping(path = "/AllByHotelAndManagerId")
    String getAllByHotelAndManagerId(@RequestParam Long hotelId, Model model){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        long managerId = userService.getByUserName(username, "").getId();

        List<Reservation> reservatinList = reservationService.getAllByHotelAndManagerId(hotelId, managerId);

        model.addAttribute("reservationList" , reservatinList);

        return "reservations";
    }
    @GetMapping(path = "/ByReservationIdAndManagerId")
    String getByReservationIdAndManagerId(@RequestParam Long reservationId, Model model){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        long managerId = userService.getByUserName(username, "").getId();

        Reservation reservation = reservationService.getByReservationIdAndManagerId(reservationId, managerId);

        model.addAttribute("reservation" , reservation);

        return "reservation";
    }
}
