package com.jovan.sgparkingv2.services;

import com.jovan.sgparkingv2.proxies.CarparkAvailabilityProxy;
import com.jovan.sgparkingv2.proxies.responses.CarparkAvailabilityProxyResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CarparkAvailabilityProxyService {

    @Autowired
    private CarparkAvailabilityProxy carparkAvailabilityProxy;

    public CarparkAvailabilityProxyResponse retrieveCarparkAvailability(){
        return carparkAvailabilityProxy.retrieveCarparkAvailability();
    }
}
