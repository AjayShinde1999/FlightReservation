package com.psa.flight_reservation_app.service;

import com.psa.flight_reservation_app.dto.ReservationDto;
import com.psa.flight_reservation_app.entities.Reservation;

public interface ReservationService {
	
	Reservation bookFlight(ReservationDto reservationDto);

}
