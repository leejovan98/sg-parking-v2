package com.jovan.sgparkingv2.proxies;

import com.jovan.sgparkingv2.proxies.requests.AddressQueryRequest;
import com.jovan.sgparkingv2.proxies.responses.AddressQueryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "arcgis-geocode-proxy", url = "${proxy.arcgis.geocode.url}")
public interface GeocodeProxy {


    @GetMapping(value = "/findAddressCandidates")
    AddressQueryResponse queryAddress(@SpringQueryMap AddressQueryRequest request);

}
