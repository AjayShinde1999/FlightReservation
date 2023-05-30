package com.psa.flight_reservation_app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psa.flight_reservation_app.dto.ReservationUpdateDto;
import com.psa.flight_reservation_app.entities.Reservation;
import com.psa.flight_reservation_app.repositories.ReservationRepository;

@RestController//convert java object to json object and json object to java object back
public class ReservationRestController {
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	@RequestMapping("/reservation/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		Optional<Reservation> findById = reservationRepo.findById(id);
		Reservation reservation = findById.get();
		return reservation;
	}
	
	@RequestMapping("/reservation")
	public Reservation updateReservation(@RequestBody ReservationUpdateDto dto ) {
		
		Optional<Reservation> findById = reservationRepo.findById(dto.getId());
		Reservation reservation = findById.get();
		reservation.setCheckedIn(dto.isCheckedIn());
		reservation.setNumberOfBags(dto.getNumberOfBags());
		return reservationRepo.save(reservation);
		
	}

}
