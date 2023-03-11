package com.airbnl.managerservice.service.Interfaces;

import com.airbnl.managerservice.model.Country;

import java.util.List;

public interface ICountryService {
    List<Country> getAll();
    Country save(Country country);
}
