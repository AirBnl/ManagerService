package com.airbnl.managerservice.controller;

import com.airbnl.managerservice.model.Hotel;
import com.airbnl.managerservice.service.Interfaces.IHotelService;
import com.airbnl.managerservice.service.Interfaces.IUserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping({"/hotels","/"})
public class HotelController {
    private final IHotelService hotelService;
    private final IUserService userService;
    public HotelController(IHotelService hotelService, IUserService userService) {
        this.hotelService = hotelService;
        this.userService = userService;
    }

    @PostMapping
    public String save(Hotel hotel, Model model) {
        Hotel SavedHotel = hotelService.save(hotel);

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        model.addAttribute("hotel", SavedHotel);

        return "hotel";
    }

    @GetMapping(path = {"/AllByManagerID","/"})
    public String getAllByManagerID( Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        long managerId = userService.getByUserName(username, "").getId();

        List<Hotel> hotels = hotelService.getAllByManagerID(managerId);

        model.addAttribute("hotels", hotels);

        return "hotels";
    }

    @GetMapping(path = "/ByHotelIdAndManagerId")
    public String getByHotelIdAndManagerId(@RequestParam long hotelId, Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        long managerId = userService.getByUserName(username, "").getId();

        Hotel hotel = hotelService.getByHotelIdAndManagerId(hotelId, managerId);

        model.addAttribute("hotel", hotel);
        model.addAttribute("managerId", managerId);

        return "hotel";
    }

    @PutMapping
    public String update(@RequestBody Hotel hotel, Model model) {
        Hotel updatedHotel = hotelService.update(hotel);

        model.addAttribute("hotel", updatedHotel);

        return "hotel";
    }

    @DeleteMapping(path = "/ByIdAndManagerID")
    public String deleteByIdAndManagerID(@RequestParam long hotelId, Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        long managerId = userService.getByUserName(username, "").getId();

        Hotel deletedHotel = hotelService.deleteByIdAndManagerID(hotelId, managerId);

        model.addAttribute("hotel", deletedHotel);

        return "hotel";
    }
}
