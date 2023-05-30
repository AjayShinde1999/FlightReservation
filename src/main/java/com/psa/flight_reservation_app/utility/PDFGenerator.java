package com.psa.flight_reservation_app.utility;

import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.psa.flight_reservation_app.entities.Reservation;

@Component
public class PDFGenerator {
	
	public void generatedItinerary(Reservation reservation,String filePath) {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document,new FileOutputStream(filePath));
			document.open();
			
			Paragraph p = new Paragraph();
			p.add("Reservation Booking Confirmation");
			p.setAlignment(Element.ALIGN_CENTER);
			document.add(p);
			//PdfPTable generateTable = new PdfPTable(2);
			document.add(generateTable(reservation));
			document.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private PdfPTable generateTable(Reservation reservation) {
		PdfPTable table = new PdfPTable(2);
		PdfPCell cell;
		
		cell = new PdfPCell(new Phrase("Flight Itinerary"));
		cell.setColspan(2);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Flight Details"));
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("Departure City");
		table.addCell(reservation.getFlight().getDepartureCity());
		
		table.addCell("Arrival City");
		table.addCell(reservation.getFlight().getArrivalCity());
		
		table.addCell("Flight Number");
		table.addCell(reservation.getFlight().getFlightNumber());
		
		table.addCell("Operating Airlines");
		table.addCell(reservation.getFlight().getOperatingAirlines());
		
		table.addCell("Departure Date");
		table.addCell(reservation.getFlight().getDateOfDepature().toString());
		
		table.addCell("Departure Time");
		table.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());
		
		cell = new PdfPCell(new Phrase("Passenger Details"));
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("First Name");
		table.addCell(reservation.getPassenger().getFirstName());
		
		table.addCell("Last Name");
		table.addCell(reservation.getPassenger().getLastName());

		table.addCell("Middle Name");
		table.addCell(reservation.getPassenger().getMiddleName());

		table.addCell("Email");
		table.addCell(reservation.getPassenger().getEmail());
		

		table.addCell("Phone");
		table.addCell(reservation.getPassenger().getPhone());
		
		return table;
	}

}
