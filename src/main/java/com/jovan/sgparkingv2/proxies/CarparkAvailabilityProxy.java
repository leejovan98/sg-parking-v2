package com.jovan.sgparkingv2.proxies;

import com.jovan.sgparkingv2.entities.CarparkAvailability;
import com.jovan.sgparkingv2.proxies.responses.CarparkAvailabilityProxyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "carpark-availability-proxy", url = "${proxy.datagov.url}")
public interface CarparkAvailabilityProxy {

    @GetMapping(value = "/v1/transport/carpark-availability")
    public CarparkAvailabilityProxyResponse retrieveCarparkAvailability();

}
