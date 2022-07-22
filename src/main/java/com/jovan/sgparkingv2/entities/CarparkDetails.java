package com.jovan.sgparkingv2.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "carpark_details")
public class CarparkDetails {

    @Id
    private String carparkNumber;
    private String address;
    private Double xCoord;
    private Double yCoord;
    private String carparkType;
    private String typeOfParkingSystem;
    private String shortTermParking;
    private String freeParking;
    private String nightParking;
    private String carparkDecks;
    private Double gantryHeight;
    private String carparkBasement;

}
