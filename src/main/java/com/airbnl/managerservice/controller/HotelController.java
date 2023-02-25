package com.airbnl.managerservice.controller;

import com.airbnl.managerservice.model.Hotel;
import com.airbnl.managerservice.service.Interfaces.IHotelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HotelController {
    private final IHotelService hotelService;

    public HotelController(IHotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    String save(Hotel hotel, Model model) {
        Hotel SavedHotel = hotelService.save(hotel);

        model.addAttribute("hotel", SavedHotel);
        return "hotel";
    }

    @GetMapping
    String getAllByManagerID(int managerId, Model model) {
        List<Hotel> hotelList = hotelService.getAllByManagerID(managerId);
        model.addAttribute("hotelList", hotelList);
        return "hotels";
    }

    @GetMapping
    String getByHotelIdAndManagerId(int hotelId, int managerId, Model model) {
        Hotel hotel = hotelService.getByHotelIdAndManagerId(hotelId, managerId);
        model.addAttribute("hotel", hotel);
        return "hotel";
    }

    @PutMapping
    String update(Hotel hotel, Model model) {
        // todo save manager id in hotel
        Hotel updatedHotel = hotelService.update(hotel);
        model.addAttribute("updatedHotel", updatedHotel);
        return "hotel";
    }

    @DeleteMapping
    String deleteByIdAndManagerID(int hotelId, int managerId, Model model) {
        Hotel deletedHotel = hotelService.deleteByIdAndManagerID(hotelId, managerId);
        model.addAttribute("deletedHotel", deletedHotel);
        return "hotel";
    }
}
