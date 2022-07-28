package com.jovan.sgparkingv2.batch.tasklets;

import com.jovan.sgparkingv2.proxies.CarparkAvailabilityProxy;
import com.jovan.sgparkingv2.proxies.responses.CarparkAvailabilityProxyResponse;
import com.jovan.sgparkingv2.services.CarparkAvailabilityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.jovan.sgparkingv2.utils.CarparkAvailabilityHelper.mapProxyResponseToCarparkAvailabilities;

@Slf4j
@Component
public class CarparkAvailabilityUpdateTasklet implements Tasklet {

    @Autowired
    private CarparkAvailabilityProxy carparkAvailabilityProxyService;

    @Autowired
    private CarparkAvailabilityService carparkAvailabilityService;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        CarparkAvailabilityProxyResponse response = carparkAvailabilityProxyService.retrieveCarparkAvailability();
        carparkAvailabilityService.updateCarparkAvailabilities(mapProxyResponseToCarparkAvailabilities(response));
        return RepeatStatus.FINISHED;
    }

}
