package com.jovan.sgparkingv2.proxies.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class CarparkAvailabilityProxyResponse {

    @JsonProperty("items")
    private List<Item> items;

    @Data
    public static class Item{

        @JsonProperty("timestamp")
        private ZonedDateTime timestamp;

        @JsonProperty("carpark_data")
        private List<CarparkData> carparkData;

    }

    @Data
    public static class CarparkData{

        @JsonProperty("carpark_info")
        private List<CarparkInfo> carparkInfo;

        @JsonProperty("carpark_number")
        private String carparkNumber;

        @JsonProperty("update_datetime")
        private LocalDateTime updateDatetime;

    }

    @Data
    public static class CarparkInfo{

        @JsonProperty("total_lots")
        private Integer totalLots;

        @JsonProperty("lot_type")
        private String lotType;

        @JsonProperty("lots_available")
        private Integer lotsAvailable;
    }
}
