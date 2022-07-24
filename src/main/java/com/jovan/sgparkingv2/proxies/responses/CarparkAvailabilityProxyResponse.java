package com.jovan.sgparkingv2.proxies.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CarparkAvailabilityProxyResponse {

    private List<Item> items;

    @Data
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    private static class Item{
        private ZonedDateTime timestamp;
        private List<CarparkData> carparkData;
    }

    @Data
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    private static class CarparkData{
        private List<CarparkInfo> carparkInfo;
        private String carparkNumber;
        private LocalDateTime updateDatetime;
    }

    @Data
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    private static class CarparkInfo{
        private Integer totalLots;
        private String lotType;
        private Integer lotsAvailable;
    }
}
