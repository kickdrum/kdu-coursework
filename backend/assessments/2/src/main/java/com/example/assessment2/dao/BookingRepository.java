package com.example.assessment2.dao;

import com.example.assessment2.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking,Booking> {

    List<Booking> findBooking(Booking bid);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM booking WHERE bio= :bid;", nativeQuery = true)
    void cancelBooking(@Param("bid") Booking bio);
}
