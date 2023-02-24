package com.airbnl.managerservice.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RoomType {
    private int id;
    private String name;
    private double price;
    private int hotelId;

}