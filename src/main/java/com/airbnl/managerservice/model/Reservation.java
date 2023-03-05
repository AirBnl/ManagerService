package com.airbnl.managerservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

@AllArgsConstructor
@Getter
@Setter
public class Reservation {
    private int id;
    private int userId;
    private String username;
    private int roomId;
    private String roomName;
    private double cost;
    private Timestamp dateFrom;
    private Timestamp dateTo;
}
