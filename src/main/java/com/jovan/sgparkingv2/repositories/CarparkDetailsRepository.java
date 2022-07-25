package com.jovan.sgparkingv2.repositories;

import com.jovan.sgparkingv2.entities.CarparkDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarparkDetailsRepository extends JpaRepository<CarparkDetails, String>{

    @Query(value = "SELECT * FROM carpark_details ORDER BY POWER(POWER((?1 - X_COORD), 2) + POWER((?2 - Y_COORD), 2), 0.5) ASC LIMIT 10", nativeQuery = true)
    public List<CarparkDetails> retrieve10ClosestCarparks(Double x, Double y);

}
