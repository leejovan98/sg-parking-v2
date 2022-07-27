package com.jovan.sgparkingv2.services;

import com.jovan.sgparkingv2.entities.CarparkAvailability;
import com.jovan.sgparkingv2.entities.CarparkDetails;
import com.jovan.sgparkingv2.proxies.responses.CarparkAvailabilityProxyResponse;
import com.jovan.sgparkingv2.repositories.CarparkAvailabilityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CarparkAvailabilityService {

    @Autowired
    private CarparkAvailabilityRepository carparkAvailabilityRepository;

    public List<CarparkAvailability> createCarparkAvailabilities(List<CarparkAvailability> carparkAvailabilityList){
        return carparkAvailabilityRepository.saveAll(carparkAvailabilityList);
    }

    public List<CarparkAvailability> createCarparkAvailabilities(CarparkAvailabilityProxyResponse carparkAvailabilityProxyResponse){
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
        return createCarparkAvailabilities(carparkAvailabilityList);
    }

    public List<CarparkAvailability> retrieveCarparkAvailabilities(List<CarparkDetails> carparkDetailsList){
        return carparkAvailabilityRepository.findAllByCarparkNumberIn(
                carparkDetailsList.stream().map(CarparkDetails::getCarparkNumber).collect(Collectors.toList())
        );
    }

    public List<CarparkAvailability> updateCarparkAvailabilities(List<CarparkAvailability> carparkAvailabilities){
        return carparkAvailabilityRepository.saveAll(carparkAvailabilities);
    }
}
