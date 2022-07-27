package com.jovan.sgparkingv2.utils;

import com.jovan.sgparkingv2.controllers.responses.NearbyCarparksResponse;
import com.jovan.sgparkingv2.entities.CarparkAvailability;
import com.jovan.sgparkingv2.entities.CarparkDetails;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResponseHelper {

    @Builder
    public static class NearbyCarparksResponseHelper{
        private List<CarparkDetails> carparkDetailsList;
        private List<CarparkAvailability> carparkAvailabilityList;

        public NearbyCarparksResponse toNearbyCarparksResponse(){
            Map<String, CarparkDetails> carparkNumberToCarparkDetails =
                    carparkDetailsList.stream().collect(Collectors.toMap(CarparkDetails::getCarparkNumber, carparkDetails -> carparkDetails));

            List<NearbyCarparksResponse.CarparkCandidate> carparkCandidates = new ArrayList<>();
            carparkNumberToCarparkDetails.forEach((carparkNumber, carparkDetail) ->{
                carparkCandidates.add(NearbyCarparksResponse.CarparkCandidate.builder()
                        .carparkType(carparkDetail.getCarparkType())
                        .address(carparkDetail.getAddress())
                        .xCoord(carparkDetail.getXCoord())
                        .yCoord(carparkDetail.getYCoord())
                        .lotInformationList(carparkAvailabilityList.stream().filter(availability -> availability.getCarparkNumber().equals(carparkNumber)).collect(Collectors.toList()))
                        .build());
            });
            return NearbyCarparksResponse.builder().carparks(carparkCandidates).build();
        }
    }

    public static NearbyCarparksResponseHelper from(List<CarparkDetails> carparkDetailsList, List<CarparkAvailability> carparkAvailabilityList){
        return NearbyCarparksResponseHelper.builder().carparkDetailsList(carparkDetailsList).carparkAvailabilityList(carparkAvailabilityList).build();
    }

}
