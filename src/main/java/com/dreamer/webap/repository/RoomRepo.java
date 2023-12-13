package com.dreamer.webap.repository;

import com.dreamer.webap.models.Rooms;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@Repository
@EnableJpaRepositories
public interface RoomRepo extends CrudRepository<Rooms, Integer>{
    @Query("SELECT DISTINCT r.number " +
            "FROM Rooms r " +
            "WHERE r.Room_ID = :roomId ")
    Integer findNumberByID(@Param("roomId") Integer roomId);
}
