package com.jovan.sgparkingv2.controllers.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
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
        private List<CarparkCandidateLotInfo> lotInformationList;
        private String address;
        private String carparkType;
        private LocalDateTime updateDatetime;
    }

    @Data
    @Builder
    public static class CarparkCandidateLotInfo{
        private Integer totalLots;
        private Integer lotsAvailable;
        private String lotType;
    }

}
