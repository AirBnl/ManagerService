package com.airbnl.managerservice.controller;

import com.airbnl.managerservice.model.User;
import com.airbnl.managerservice.service.Interfaces.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.result.view.RedirectView;

@Controller
@RequestMapping("/user")
public class authController {
    private final IUserService userService;
    public authController(IUserService userService){
        this.userService = userService;
    }
    @GetMapping(path = "/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping(path = "/signup")
    public String signup(Model model) {
        return "signup";
    }
    @PostMapping(path = "/login")
    public RedirectView  login(User user) {
        User managerFromDb = userService.getByUserName(user.getUsername());
        if(managerFromDb == null)
            return new RedirectView("/user/login");

        return new RedirectView("/hotels/AllByManagerID?managerId=" + managerFromDb.getId());
    }

    @PostMapping(path = "/signup")
    public RedirectView  signup(User user) {
        userService.save(user);
        Long managerId = userService.getByUserName(user.getUsername()).getId();

        return new RedirectView("/hotels/AllByManagerID?managerId=" + managerId);
    }

}
