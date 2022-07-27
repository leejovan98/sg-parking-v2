package com.jovan.sgparkingv2.controllers.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jovan.sgparkingv2.entities.CarparkAvailability;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NearbyCarparksResponse {

    private List<CarparkCandidate> carparks;

    @Data
    @Builder
    public static class CarparkCandidate{
        private String address;
        private String carparkType;
        private Double xCoord;
        private Double yCoord;
        private List<CarparkAvailability> lotInformationList;
    }

}
