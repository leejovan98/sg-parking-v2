package com.jovan.sgparkingv2.services;

import com.jovan.sgparkingv2.entities.CarparkAvailability;
import com.jovan.sgparkingv2.entities.CarparkDetails;
import com.jovan.sgparkingv2.repositories.CarparkAvailabilityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CarparkAvailabilityService {

    @Autowired
    private CarparkAvailabilityRepository carparkAvailabilityRepository;

    public List<CarparkAvailability> retrieveCarparkAvailabilities(List<CarparkDetails> carparkDetailsList){
        return carparkAvailabilityRepository.findAllByCarparkNumberIn(
                carparkDetailsList.stream().map(CarparkDetails::getCarparkNumber).collect(Collectors.toList())
        );
    }

    public List<CarparkAvailability> updateCarparkAvailabilities(List<CarparkAvailability> carparkAvailabilities){
        return carparkAvailabilityRepository.saveAll(carparkAvailabilities);
    }
}
