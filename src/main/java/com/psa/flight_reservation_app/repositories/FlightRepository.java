package com.psa.flight_reservation_app.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.psa.flight_reservation_app.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    
	@Query("from Flight where departureCity=:departureCity and arrivalCity=:arrivalCity and dateOfDepature=:dateOfDeparture")
	List<Flight> findFlights(@Param("departureCity")String from,@Param("arrivalCity") String to,@Param("dateOfDeparture") Date departureDate);

}
