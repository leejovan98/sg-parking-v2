package com.jovan.sgparkingv2.services;

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


    public AddressQueryResponse queryAddress(String address){
        log.info("querying address {} via geocode proxy");
        return geocodeProxy.queryAddress(AddressQueryRequest.builder()
                .f(format)
                .countryCode(countryCode)
                .city(city)
                .maxLocations(maxLocations)
                .outSr(coordSys)
                .address(address)
                .build());
    }

}
