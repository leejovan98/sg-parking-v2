package com.jovan.sgparkingv2.repositories;

import com.jovan.sgparkingv2.entities.CarparkAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarparkAvailabilityRepository extends JpaRepository<CarparkAvailability, String>{

}
