package com.example.tripease.model;

import com.example.tripease.model.Booking;
import com.example.tripease.model.Cab;
import jakarta.persistence.*;
import lombok.*;

import  java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "driver")
@Builder
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int driverId;
    private String name;
    private int age;
    @Column(unique = true, nullable = false)
    private String emailId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id")
    List<Booking> bookings = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cab_id")
    Cab cab;

}
