package com.jovan.sgparkingv2.utils;

import com.jovan.sgparkingv2.entities.CarparkAvailability;
import com.jovan.sgparkingv2.proxies.responses.CarparkAvailabilityProxyResponse;

import java.util.ArrayList;
import java.util.List;

public class CarparkAvailabilityHelper {

    public static List<CarparkAvailability> mapProxyResponseToCarparkAvailabilities(CarparkAvailabilityProxyResponse carparkAvailabilityProxyResponse){
        List<CarparkAvailability> carparkAvailabilityList = new ArrayList<>();
        carparkAvailabilityProxyResponse.getItems()
                .forEach(item -> {
                    item.getCarparkData().forEach(data ->{
                        data.getCarparkInfo().forEach(info -> {
                            carparkAvailabilityList.add(
                                    CarparkAvailability.builder()
                                            .carparkNumber(data.getCarparkNumber())
                                            .totalLots(info.getTotalLots())
                                            .lotType(info.getLotType())
                                            .lotsAvailable(info.getLotsAvailable())
                                            .updateDatetime(data.getUpdateDatetime())
                                            .build()
                            );
                        });
                    });
                });
        return carparkAvailabilityList;
    }
}
