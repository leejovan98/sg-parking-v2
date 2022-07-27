package com.jovan.sgparkingv2.controllers;

import com.jovan.sgparkingv2.controllers.responses.NearbyCarparksResponse;
import com.jovan.sgparkingv2.entities.CarparkAvailability;
import com.jovan.sgparkingv2.entities.CarparkDetails;
import com.jovan.sgparkingv2.proxies.responses.AddressQueryResponse;
import com.jovan.sgparkingv2.services.CarparkAvailabilityService;
import com.jovan.sgparkingv2.services.CarparkDetailsService;
import com.jovan.sgparkingv2.services.GeocodeProxyService;
import com.jovan.sgparkingv2.utils.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/carparks")
public class CarparksController {

    @Autowired
    private GeocodeProxyService geocodeProxyService;

    @Autowired
    private CarparkAvailabilityService carparkAvailabilityService;

    @Autowired
    private CarparkDetailsService carparkDetailsService;

    @GetMapping("/nearby")
    public NearbyCarparksResponse retrieveNearbyCarparkAndAvailability(@RequestParam String address){
        AddressQueryResponse addressQueryResponse = geocodeProxyService.queryAddress(address);
        List<CarparkDetails> carparkDetailsList = carparkDetailsService.retrieve10ClosestCarparks(
                addressQueryResponse.getTopCandidate().getLocation().getX(),
                addressQueryResponse.getTopCandidate().getLocation().getY()
        );
        List<CarparkAvailability> carparkAvailabilityList = carparkAvailabilityService.retrieveCarparkAvailabilities(carparkDetailsList);
        return ResponseHelper.from(carparkDetailsList, carparkAvailabilityList).toNearbyCarparksResponse();
    }


}
