package com.airbnl.managerservice.controller;

import com.airbnl.managerservice.model.User;
import com.airbnl.managerservice.service.Interfaces.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class authController {
    private final IUserService userService;

    public authController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String signupForm() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signupSubmit(@RequestParam("username") String username, @RequestParam("password") String password) {
        userService.save(new User(-1, username, password, username, 1));
        return "redirect:/login";
    }
}
