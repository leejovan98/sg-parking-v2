package com.jovan.sgparkingv2.batch;

import com.jovan.sgparkingv2.batch.tasklets.CarparkAvailabilityUpdateTasklet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@Slf4j
@Configuration
@EnableBatchProcessing
@EnableScheduling
public class CarparkAvailabilityConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private JobLauncher launcher;

    @Autowired
    private CarparkAvailabilityUpdateTasklet tasklet;

    @Scheduled(fixedRate = 60 * 1000, initialDelay = 0)
    public void updateCarparkAvailability() {

        JobParametersBuilder jobParamBuilder = new JobParametersBuilder();
        jobParamBuilder.addDate("date", new Date());

        try {
            launcher.run(carparkAvailabilityUpdateJob(), jobParamBuilder.toJobParameters());
        } catch(Exception e) {
            log.error("Failed to run 'updateCarparkAvailabilityJob': {}", e.getMessage());
        }
    }

    @Bean
    public Job carparkAvailabilityUpdateJob(){
        log.info("carpark availability update job started");
        return jobBuilderFactory.get("CARPARK_AVAILABILITY_UPDATE_JOB")
                .incrementer(new RunIdIncrementer())
                .start(carparkAvailabilityUpdateStep())
                .build();
    }

    @Bean
    public Step carparkAvailabilityUpdateStep(){
        return stepBuilderFactory.get("CARPARK_AVAILABILITY_UPDATE_STEP")
                .tasklet(tasklet)
                .build();
    }

}
