package com.jovan.sgparkingv2.repositories;

import com.jovan.sgparkingv2.entities.CarparkDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarparkDetailsRepository extends JpaRepository<CarparkDetails, String>{

}
