package com.airbnl.managerservice.controller;

import com.airbnl.managerservice.model.Reservation;
import com.airbnl.managerservice.model.Room;
import com.airbnl.managerservice.model.User;
import com.airbnl.managerservice.service.Interfaces.IReservationService;
import com.airbnl.managerservice.service.Interfaces.IRoomService;
import com.airbnl.managerservice.service.Interfaces.IUserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/reservations")
public class ReservationController {
    private final IReservationService reservationService;
    private final IUserService userService;

    private final IRoomService roomService;

    public ReservationController(IReservationService reservationService, IUserService userService, IRoomService roomService) {
        this.reservationService = reservationService;
        this.userService = userService;
        this.roomService = roomService;
    }

    @PostMapping
    String save(Reservation reservation, @RequestParam Long managerId, Model model) {
        Reservation svedReservation = reservationService.save(reservation, managerId);

        model.addAttribute("reservation", svedReservation);
        model.addAttribute("managerId", managerId);

        return "reservation";
    }

    @GetMapping(path = "/AllByHotelAndManagerId")
    String getAllByHotelAndManagerId(@RequestParam("hotelId") long hotelId, Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        long managerId = userService.getByUserName(username, "").getId();

        List<Reservation> reservations = reservationService.getAllByHotelAndManagerId(hotelId, managerId);

        HashMap<Long, String> users = new HashMap<>();
        HashMap<Long, String> rooms = new HashMap<>();

        User user;
        Room room;

        for (Reservation reservation : reservations) {
            user = userService.getUsernameById(reservation.getUserId());
            room = roomService.getById(reservation.getRoomId());

            users.put(reservation.getId(), user.getFullName());
            rooms.put(reservation.getId(), room.getNumber());
        }

        model.addAttribute("users", users);
        model.addAttribute("rooms", rooms);
        model.addAttribute("reservations", reservations);
        return "reservations";
    }

    @GetMapping(path = "/ByReservationIdAndManagerId")
    String getByReservationIdAndManagerId(@RequestParam long reservationId, Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        long managerId = userService.getByUserName(username, "").getId();

        Reservation reservation = reservationService.getByReservationIdAndManagerId(reservationId, managerId);

        model.addAttribute("reservation", reservation);
        return "reservation";
    }

    @GetMapping(path = "/AllByManagerId")
    String getAllByManagerId(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        long managerId = userService.getByUserName(username, "").getId();

        List<Reservation> reservations = reservationService.getAllByManagerId(managerId);

        HashMap<Long, String> users = new HashMap<>();
        HashMap<Long, String> rooms = new HashMap<>();

        User user;
        Room room;

        for (Reservation reservation : reservations) {
            user = userService.getUsernameById(reservation.getUserId());
            room = roomService.getById(reservation.getRoomId());

            users.put(reservation.getId(), user.getFullName());
            rooms.put(reservation.getId(), room.getNumber());
        }

        model.addAttribute("users", users);
        model.addAttribute("rooms", rooms);
        model.addAttribute("reservations", reservations);
        return "reservations";
    }

    @PostMapping(path = "/edit")
    String update(Reservation reservation, @RequestParam Long managerId, Model model) {
        Reservation savedReservation = reservationService.save(reservation, managerId);

        model.addAttribute("reservation", savedReservation);
        model.addAttribute("managerId", managerId);

        return "reservation";
    }

    @PostMapping(path = "/delete")
    String delete(@RequestParam long reservationId) {
        reservationService.delete(reservationId);

        return "redirect:/";
    }
}
