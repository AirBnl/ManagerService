package com.airbnl.managerservice.controller;

import com.airbnl.managerservice.model.User;
import com.airbnl.managerservice.service.Interfaces.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.result.view.RedirectView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class authController {
    private final IUserService userService;

    public authController(IUserService userService) {
        this.userService = userService;
    }

//    @GetMapping(path = {"/login", "/"})
//    public String login(Model model) {
//        return "login";
//    }
//
//    @GetMapping(path = "/signup")
//    public String signup(Model model) {
//        return "signup";
//    }
//
//    @PostMapping(path = "/login")
//    public RedirectView login(@RequestBody String username, @RequestBody String password, RedirectAttributes redirectAttributes) {
//        User managerFromDb = userService.getByUserName(username, password);
//        if (managerFromDb == null)
//            return new RedirectView("/user/login");
////        redirectAttributes.addAttribute("managerId", managerFromDb.getId());
//        try {
//            return new RedirectView("/hotels/AllByManagerID");
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//            return new RedirectView("/user/login");
//        }
//    }
//
//    @PostMapping(path = "/signup")
//    public RedirectView signup(@RequestBody String username, @RequestBody String password, RedirectAttributes redirectAttributes) {
//        userService.save(new User(-1, username, password, username, 1));
//        long managerId = userService.getByUserName(username, password).getId();
//        redirectAttributes.addAttribute("managerId", managerId);
//        return new RedirectView("/hotels/AllByManagerID");
//    }

}
