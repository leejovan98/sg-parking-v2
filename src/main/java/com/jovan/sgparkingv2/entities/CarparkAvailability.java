package com.jovan.sgparkingv2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "carpark_availability")
public class CarparkAvailability {

    @Id
    @JsonIgnore
    private String carparkNumber;
    private String lotType;
    private Integer totalLots;
    private Integer lotsAvailable;
    private LocalDateTime updateDatetime;

}
