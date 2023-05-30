package com.psa.flight_reservation_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psa.flight_reservation_app.dto.ReservationDto;
import com.psa.flight_reservation_app.entities.Reservation;
import com.psa.flight_reservation_app.service.ReservationService;


@Controller
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping("/completeReservation")
	public String completeReservation(ReservationDto reservationDto,ModelMap modelMap) {
		Reservation reservationId = reservationService.bookFlight(reservationDto);
		modelMap.addAttribute("reservationId", reservationId.getId());
		return "confirmReservation";
	}

}
