package com.airbnl.managerservice.controller;

import com.airbnl.managerservice.model.Room;
import com.airbnl.managerservice.service.Interfaces.IHotelService;
import com.airbnl.managerservice.service.Interfaces.IRoomService;
import com.airbnl.managerservice.service.Interfaces.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/room")
public class RoomController {
    private final IRoomService roomService;
    public RoomController(IRoomService roomService) {
        this.roomService = roomService;
    }
    @PostMapping(path = "/save")
    public String saveRoom(Room room, Model model) {
        room.setId(-1);
        Room savedRoom = roomService.save(room);

        model.addAttribute("room", savedRoom);

        return "room";
    }
    @GetMapping(path = "/getById")
    public String getRoom(@RequestParam long roomId , Model model) {
        Room roomFromDb = roomService.getById(roomId);

        model.addAttribute("room", roomFromDb);

        return "room";
    }
}
