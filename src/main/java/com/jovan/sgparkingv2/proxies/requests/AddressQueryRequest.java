package com.jovan.sgparkingv2.proxies.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressQueryRequest {

    private String f;
    private String countryCode;
    private String city;
    private String maxLocations;
    private String outSr;
    private String address;

}
