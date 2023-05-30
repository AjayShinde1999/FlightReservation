package com.psa.flight_reservation_app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psa.flight_reservation_app.dto.ReservationDto;
import com.psa.flight_reservation_app.entities.Flight;
import com.psa.flight_reservation_app.entities.Passenger;
import com.psa.flight_reservation_app.entities.Reservation;
import com.psa.flight_reservation_app.repositories.FlightRepository;
import com.psa.flight_reservation_app.repositories.PassengerRepository;
import com.psa.flight_reservation_app.repositories.ReservationRepository;
import com.psa.flight_reservation_app.utility.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private PassengerRepository passengerRepo;
	
	@Autowired
	private FlightRepository flightRepo;
	
	@Autowired
	private PDFGenerator pdfGenerator;
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	@Override
	public Reservation bookFlight(ReservationDto reservationDto) {
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(reservationDto.getFirstName());
		passenger.setLastName(reservationDto.getLastName());
		passenger.setMiddleName(reservationDto.getMiddleName());
		passenger.setEmail(reservationDto.getEmail());
		passenger.setPhone(reservationDto.getPhone());
		passengerRepo.save(passenger);
		
		long flightId = reservationDto.getFlightId();
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
		
		Reservation reservation = new Reservation();
         reservation.setFlight(flight);
         reservation.setPassenger(passenger);
         reservation.setCheckedIn(false);
         reservation.setNumberOfBags(0);
         reservationRepo.save(reservation);
         String filePath = "D:\\stsversion4.17\\flight_reservation_app\\Tickets\\reservation"+reservation.getId()+".pdf";
         
        // reservationRepo.save(reservation);
         
         pdfGenerator.generatedItinerary(reservation, filePath);
		return reservation;
	}

}
