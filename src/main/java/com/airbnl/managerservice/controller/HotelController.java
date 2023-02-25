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
    public String save(Hotel hotel, Model model) {
        Hotel SavedHotel = hotelService.save(hotel);

        model.addAttribute("hotel", SavedHotel);
        return "hotel";
    }

    @GetMapping(path = "/AllByManagerID/{managerId}")
    public String getAllByManagerID(@PathVariable int managerId, Model model) {
        List<Hotel> hotels = hotelService.getAllByManagerID(managerId);

        model.addAttribute("hotels", hotels);
        return "hotels";
    }

    @GetMapping(path = "/ByHotelIdAndManagerId/{hotelId}/{managerId}")
    public String getByHotelIdAndManagerId(@PathVariable int hotelId
            , @PathVariable int managerId, Model model) {
        Hotel hotel = hotelService.getByHotelIdAndManagerId(hotelId, managerId);
        model.addAttribute("hotel", hotel);
        return "hotel";
    }

    @PutMapping
    public String update(@RequestBody Hotel hotel, Model model) {
        // todo save manager id in hotel
        Hotel updatedHotel = hotelService.update(hotel);
        model.addAttribute("hotel", updatedHotel);
        return "hotel";
    }

    @DeleteMapping(path = "/ByIdAndManagerID/{hotelId}/{managerId}")
    public String deleteByIdAndManagerID(@PathVariable int hotelId
            , @PathVariable int managerId, Model model) {
        Hotel deletedHotel = hotelService.deleteByIdAndManagerID(hotelId, managerId);
        model.addAttribute("hotel", deletedHotel);
        return "hotel";
    }
}
