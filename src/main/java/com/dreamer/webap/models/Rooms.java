package com.dreamer.webap.models;

import jakarta.persistence.*;

@Entity
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Room_ID;
    @Column(nullable = false)
    private Integer number;
    @Column(nullable = false)
    private Integer capacity;
    @Column(nullable = false)
    private String class_Room;



    public Integer getRoom_ID() {
        return Room_ID;
    }

    public void setRoom_ID(Integer room_ID) {
        Room_ID = room_ID;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getClass_Room() {
        return class_Room;
    }

    public void setClass_Room(String class_Room) {
        this.class_Room = class_Room;
    }
}
