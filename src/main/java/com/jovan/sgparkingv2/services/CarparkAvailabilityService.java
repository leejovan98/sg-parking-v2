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

import static com.jovan.sgparkingv2.utils.CarparkAvailabilityHelper.mapProxyResponseToCarparkAvailabilities;

@Service
@Slf4j
public class CarparkAvailabilityService {

    @Autowired
    private CarparkAvailabilityRepository carparkAvailabilityRepository;

    public List<CarparkAvailability> retrieveCarparkAvailabilities(List<CarparkDetails> carparkDetailsList){
        log.info("retrieving carpark availabilities");
        return carparkAvailabilityRepository.findAllByCarparkNumberIn(
                carparkDetailsList.stream().map(CarparkDetails::getCarparkNumber).collect(Collectors.toList())
        );
    }

    public List<CarparkAvailability> updateCarparkAvailabilities(List<CarparkAvailability> carparkAvailabilities){
        log.info("updating carpark availabilities");
        return carparkAvailabilityRepository.saveAll(carparkAvailabilities);
    }
}
