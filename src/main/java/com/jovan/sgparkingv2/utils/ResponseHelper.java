package com.jovan.sgparkingv2.utils;

import com.jovan.sgparkingv2.controllers.responses.NearbyCarparksResponse;
import com.jovan.sgparkingv2.entities.CarparkAvailability;
import com.jovan.sgparkingv2.entities.CarparkDetails;
import com.jovan.sgparkingv2.proxies.responses.AddressQueryResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResponseHelper {

    @Builder
    public class NearbyCarparksResponseHelper{
        private List<CarparkDetails> carparkDetailsList;
        private List<CarparkAvailability> carparkAvailabilityList;

        public NearbyCarparksResponse toNearbyCarparksResponse(){
            Map<String, CarparkDetails> carparkNumberToCarparkDetails =
                    carparkDetailsList.stream().collect(Collectors.toMap(CarparkDetails::getCarparkNumber, carparkDetails -> carparkDetails));

            List<NearbyCarparksResponse.CarparkCandidate> carparkCandidates = new ArrayList<>();
            carparkNumberToCarparkDetails.forEach((carparkNumber, carparkDetail) ->{
                // TODO
            });
            return null;
        }
    }

    public static NearbyCarparksResponseHelper from(List<CarparkDetails> carparkDetailsList, List<CarparkAvailability> carparkAvailabilityList){
        return NearbyCarparksResponseHelper.builder().carparkDetailsList(carparkDetailsList).carparkAvailabilityList(carparkAvailabilityList).build();
    }

}
