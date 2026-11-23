package com.example.tripease.dto.response;


import jakarta.persistence.Entity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@Entity
@Builder
public class CabResponse {
    private String cabNumber;
    private String cab_Model;
    private  double perKmRate;
    private boolean available;

    private DriverResponse driver;
}
