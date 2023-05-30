<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation Details</title>
</head>
<body>
	<h2>Flight Details</h2>
	<table border='1'>
		<tr>
			<td>Flight Number</td>
			<td>${flight.flightNumber }</td>
		</tr>
		<tr>
			<td>Operating Airlines</td>
			<td>${flight.operatingAirlines }</td>
		</tr>
		<tr>
			<td>Departure City</td>
			<td>${flight.departureCity }</td>
		</tr>
		<tr>
			<td>Arrival City</td>
			<td>${flight.arrivalCity }</td>
		</tr>
		<tr>
			<td>Departure Date</td>
			<td>${flight.estimatedDepartureTime }</td>
		</tr>
	</table>
	<br>
	<hr>
	<form action="completeReservation" method="post">
		<h2>Passenger Details</h2>
		<table>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName" /></td>
			</tr>
			<tr>
				<td>Middle Name</td>
				<td><input type="text" name="middleName" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="text" name="phone" /></td>
			</tr>
			<tr>
				<td><input type="hidden" name="flightId" value=${flight.id } /></td>
			</tr>
			
		</table>
		<hr>
		<h2>Payment Details</h2>
		<table>

			<tr>
				<td>Card Holder Name</td>
				<td><input type="text" name="cardHolderName" /></td>
			</tr>
			<tr>
				<td>Card Number</td>
				<td><input type="text" name="cardNumber" /></td>
			</tr>
			<tr>
				<td>CVV Number</td>
				<td><input type="text" name="cvvNumber" /></td>
			</tr>
			<tr>
				<td>Expire Date</td>
				<td><input type="text" name="expireDate" /></td>
			</tr>
			<tr>
				<td style="text-align: center" colspan="2"><input type="submit"
					value="complete reservation" /></td>
			</tr>
		</table>

	</form>

</body>
</html>