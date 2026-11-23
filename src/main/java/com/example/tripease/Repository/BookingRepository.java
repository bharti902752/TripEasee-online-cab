package com.example.tripease.Repository;

import com.example.tripease.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
