package com.jovan.sgparkingv2.proxies.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressQueryResponse {

    @JsonProperty("spatialReference")
    private SpatialReference spatialReference;

    @JsonProperty("candidates")
    private List<Candidate> candidates;

    public Candidate getTopCandidate(){
        return candidates.get(0);
    }

    @Data
    public static class SpatialReference{

        @JsonProperty("wkid")
        private Integer wkid;

        @JsonProperty("latestWkid")
        private Integer latestWkid;
    }

    @Data
    public static class Candidate{

        @JsonProperty("address")
        private String address;

        @JsonProperty("location")
        private Location location;

        @JsonProperty("score")
        private Integer score;
    }

    @Data
    public static class Location{

        @JsonProperty("x")
        private Double x;

        @JsonProperty("y")
        private Double y;
    }

}
