package com.airbnl.managerservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.beans.Transient;

@AllArgsConstructor
@Getter
@Setter
public class Hotel {
    private int id;
    private String name;
    private int managerId;
    private int countryId;
    private String countryName;
}
