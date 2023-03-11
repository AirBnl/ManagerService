package com.airbnl.managerservice.service.Interfaces;

import com.airbnl.managerservice.model.Role;

import java.util.List;

public interface IRoleService {
    List<Role> getAll();

    Role getById(long roleId);

    Role save(Role role);
}
