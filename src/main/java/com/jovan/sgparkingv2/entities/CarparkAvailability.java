package com.jovan.sgparkingv2.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "carpark_availability")
public class CarparkAvailability {

    @Id
    private String carparkNumber;
    private String lotType;
    private Integer totalLots;
    private Integer lotsAvailable;
    private Timestamp updateDatetime;

}
