package com.jovan.sgparkingv2.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PoorAddressMatchException extends RuntimeException{

    private String requestAddress;
    private Integer score;

}
