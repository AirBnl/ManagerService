package com.airbnl.managerservice.controller;

import com.airbnl.managerservice.model.Hotel;
import com.airbnl.managerservice.service.Interfaces.IHotelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/hotels")
public class HotelController {
    private final IHotelService hotelService;

    public HotelController(IHotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    public String save(Hotel hotel, @RequestParam long managerId, Model model) {
        Hotel SavedHotel = hotelService.save(hotel);

        model.addAttribute("hotel", SavedHotel);
        model.addAttribute("managerId", managerId);

        return "hotel";
    }

    @GetMapping(path = "/AllByManagerID")
    public String getAllByManagerID(@RequestParam long managerId, Model model) {
        List<Hotel> hotels = hotelService.getAllByManagerID(managerId);

        model.addAttribute("hotels", hotels);
        model.addAttribute("managerId", managerId);

        return "hotels";
    }

    @GetMapping(path = "/ByHotelIdAndManagerId")
    public String getByHotelIdAndManagerId(@RequestParam long hotelId
            , @RequestParam long managerId, Model model) {
        Hotel hotel = hotelService.getByHotelIdAndManagerId(hotelId, managerId);

        model.addAttribute("hotel", hotel);
        model.addAttribute("managerId", managerId);

        return "hotel";
    }

    @PutMapping
    public String update(@RequestBody Hotel hotel, @RequestParam long managerId
            , Model model) {
        // todo save manager id in hotel
        Hotel updatedHotel = hotelService.update(hotel);

        model.addAttribute("hotel", updatedHotel);
        model.addAttribute("managerId", managerId);

        return "hotel";
    }

    @DeleteMapping(path = "/ByIdAndManagerID")
    public String deleteByIdAndManagerID(@RequestParam long hotelId
            , @RequestParam long managerId, Model model) {
        Hotel deletedHotel = hotelService.deleteByIdAndManagerID(hotelId, managerId);
        model.addAttribute("hotel", deletedHotel);
        return "hotel";
    }
}
