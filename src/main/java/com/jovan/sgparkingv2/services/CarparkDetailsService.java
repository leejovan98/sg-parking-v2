package com.jovan.sgparkingv2.services;

import com.jovan.sgparkingv2.entities.CarparkDetails;
import com.jovan.sgparkingv2.repositories.CarparkDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CarparkDetailsService {

    @Autowired
    private CarparkDetailsRepository carparkDetailsRepository;

    public List<CarparkDetails> retrieve10ClosestCarparks(Double x, Double y){
        return carparkDetailsRepository.retrieve10ClosestCarparks(x, y);
    }

}
