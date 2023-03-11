package com.airbnl.managerservice.service.Interfaces;

import com.airbnl.managerservice.model.Reservation;
import com.airbnl.managerservice.model.User;

public interface IUserService {
    User save(User user);
    User getByUserName(String username,String password);
}
