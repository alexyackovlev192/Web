package com.dreamer.webap.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Booking_ID;

    @ManyToOne
    @JoinColumn(name = "User_ID")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "Room_ID")
    private Rooms room;

    @Column(nullable = false)
    private Date start_Date;

    @Column(nullable = false)
    private Date end_Date;

    @Column(nullable = false)
    private Integer count_Guest;

    public Integer getBooking_ID() {
        return Booking_ID;
    }

    public void setBooking_ID(Integer booking_ID) {
        Booking_ID = booking_ID;
    }

    public Rooms getRoom_ID() {
        return room;
    }

    public void setRoom_ID(Rooms room_ID) {
        room = room_ID;
    }

    public Users getUser_ID() {
        return user;
    }

    public void setUser_ID(Users user_ID) {
        user = user_ID;
    }

    public Date getStart_Date() {
        return start_Date;
    }

    public void setStart_Date(Date start_Date) {
        this.start_Date = start_Date;
    }

    public Date getEnd_Date() {
        return end_Date;
    }

    public void setEnd_Date(Date end_Date) {
        this.end_Date = end_Date;
    }

    public Integer getCount_Guest() {
        return count_Guest;
    }

    public void setCount_Guest(Integer count_Guest) {
        this.count_Guest = count_Guest;
    }
}
