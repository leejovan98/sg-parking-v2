package com.jovan.sgparkingv2.services;

import com.jovan.sgparkingv2.exceptions.PoorAddressMatchException;
import com.jovan.sgparkingv2.proxies.GeocodeProxy;
import com.jovan.sgparkingv2.proxies.requests.AddressQueryRequest;
import com.jovan.sgparkingv2.proxies.responses.AddressQueryResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GeocodeProxyService {

    @Autowired
    private GeocodeProxy geocodeProxy;

    @Value("${proxy.arcgis.geocode.format:json}")
    private String format;

    @Value("${proxy.arcgis.geocode.countryCode:SGP}")
    private String countryCode;

    @Value("${proxy.arcgis.geocode.city:Singapore}")
    private String city;

    @Value("${proxy.arcgis.geocode.maxLocations:1}")
    private String maxLocations;

    @Value("${proxy.arcgis.geocode.coordSys:3414}")
    private String coordSys;

    @Value("${com.jovan.sgparkingv2.address.query.min-score:50}")
    private Integer minScore;


    public AddressQueryResponse queryAddress(String address) {
        log.info("querying address {} via geocode proxy", address);
        AddressQueryResponse response = geocodeProxy.queryAddress(AddressQueryRequest.builder()
                .f(format)
                .countryCode(countryCode)
                .city(city)
                .maxLocations(maxLocations)
                .outSr(coordSys)
                .address(address)
                .build());
        verifyScore(address, response, minScore);
        return response;
    }

    private void verifyScore(String address, AddressQueryResponse response, Integer minScore) {
        if(response.getTopCandidate().getScore() < minScore) {
            log.error("address query for {} returned a poor candidate", address);
            throw new PoorAddressMatchException(address, response.getTopCandidate().getScore());
        }
        log.info("address query for {} returned a passable candidate with score {}", address, response.getTopCandidate().getScore());
    }

}
