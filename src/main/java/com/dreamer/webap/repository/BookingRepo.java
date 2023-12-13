package com.dreamer.webap.repository;

import com.dreamer.webap.models.Bookings;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface BookingRepo extends CrudRepository<Bookings, Integer> {

    @Query("SELECT DISTINCT b.Booking_ID, r.number, b.start_Date, b.end_Date, b.count_Guest " +
            "FROM Bookings b " +
            "JOIN Users u ON b.user.User_ID = :UserID " +
            "JOIN Rooms r ON b.room.Room_ID = r.Room_ID " +
            "ORDER BY b.start_Date ASC")
    Iterable<Object[]> findBookings(@Param("UserID") Integer userId);

    @Query("SELECT DISTINCT b.Booking_ID, r.number, b.start_Date, b.end_Date, b.count_Guest " +
            "FROM Bookings b " +
            "JOIN Users u ON b.user.User_ID = :UserID " +
            "JOIN Rooms r ON b.room.Room_ID = r.Room_ID " +
            "WHERE b.start_Date <= current_date AND b.end_Date >= current_date " +
            "ORDER BY b.start_Date ASC")
    Iterable<Object[]> findActiveBookings(@Param("UserID") Integer userId);

    @Query("SELECT DISTINCT b.start_Date FROM Bookings b WHERE b.start_Date IS NOT NULL AND b.room.Room_ID = :roomId")
    List<Date> findDistinctStartDatesByID(@Param("roomId") Integer roomId);

    @Query("SELECT DISTINCT b.end_Date FROM Bookings b WHERE b.end_Date IS NOT NULL AND b.room.Room_ID = :roomId")
    List<Date> findDistinctEndDatesByID(@Param("roomId") Integer roomId);
}