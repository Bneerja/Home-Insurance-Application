<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.perscholas.homeinsurance.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quote Summary</title>
</head>
<body>
	<center><h1>Quote Summary</h1></center>
	<%LocationPage  location = (LocationPage) session.getAttribute("location");
	HomeOwner owner = (HomeOwner)session.getAttribute("owner");
	PropertyDetails property = (PropertyDetails)session.getAttribute("propertyDetails");
	QuoteDetails quote = (QuoteDetails)session.getAttribute("quoteDetails");
	%>
	<table align="center" width="80%">
		<tr>
		<td width="50%"><center><br><a href="LogOut.jsp" class="button">Log Out</a></center>
			<table width="100%">
				<tr >
					<td colspan="2" align="center"><h2>Location Details</h2></td>
				</tr>				
				
				<tr>
				<td width="50%">Quote Id</td> <td width="50%"><%=quote.getQuoteId() %></td>
				</tr>
				<tr>
				<td>Residency Type</td> <td><%=location.getResidenceType() %></td>
				</tr>
				<tr>
				<td>Address Line 1</td> <td><%=location.getAddressline1() %></td>
				</tr>
				<tr>
				<td>Address Line 2</td> <td><%=location.getAddressline2() %></td>
				</tr>
				<tr>
				<td>City</td> <td><%=location.getCity() %></td>
				</tr>
				<tr>
				<td>State</td> <td><%=location.getState() %></td>
				</tr>
				<tr>
				<td>Zip</td> <td><%=location.getZipCode() %></td>
				</tr>
				<tr>
				<td>Residency Use</td> <td><%=location.getResidenceUse() %></td>
				</tr>
			</table>
		</td>
		<td width="50%">
			<table width="100%">
				<tr >
					<td colspan="2"><center><h2>House Owner Details</h2></center></td>
				</tr>
				<tr>
				<td width="50%">First Name</td> <td width="50%"><%=owner.getFirstName() %></td>
				</tr>
				<tr>
				<td>Last Name</td> <td><%=owner.getLastName() %></td>
				</tr>
				<tr>
				<td>Date of Birth</td> <td><%=owner.getDateofbirth() %></td>
				</tr>
				<tr>
				<td>Is Retired</td> <td><%=owner.isRetired() %></td>
				</tr>
				<tr>
				<td>SSN</td> <td><%=owner.getSsn() %></td>
				</tr>
				<tr>
				<td>Email Address</td> <td><%=owner.getEmail()%></td>
				</tr>
			</table>
		</td>
		</tr>
		
		<tr>
		<td width="50%">
			<table width="100%">
				<tr >
					<td colspan="2"><center><h2>Property Details</h2></center></td>
				</tr>
				<tr>
				<td width="50%">Market Value</td> <td width="50%"><%=property.getMarketvalue() %></td>
				</tr>
				<tr>
				<td>Year Built</td> <td><%=property.getYear() %></td>
				</tr>
				<tr>
				<td>Square Foot</td> <td><%=property.getSquarefoot() %></td>
				</tr>
				<tr>
				<td>Dwelling Style</td> <td><%=property.getDwellingStyle() %></td>
				</tr>
				<tr>
				<td>Roof Meterial</td> <td><%=property.getRoofingMaterial() %></td>
				</tr>
				<tr>
				<td>Garage Type</td> <td><%=property.getGarageType() %></td>
				</tr>
				<tr>
				<td>Number of full baths</td> <td><%=property.getNumberOfFullbaths() %></td>
				</tr>
				<tr>
				<td>Number of half baths</td> <td><%=property.getNumberOfHalfbaths() %></td>
				</tr>
				<tr>
				<td>Has Swimming pool</td> <td><%=property.getSwimmingPool() %></td>
				</tr>
			</table>
		</td>
		<td width="50%">
			<table width="100%">
				<tr >
					<td colspan="2"><center><h2>Coverage  Details</h2></center></td>
				</tr>
				<tr>
				<td width="50%">Monthly Premium</td> <td width="50%"><%=quote.getMonthlyPremium() %></td>
				</tr>
				<tr>
				<td>Dwelling Coverage</td> <td><%=quote.getDwellingCoverage() %></td>
				</tr>
				<tr>
				<td>Detached Coverage</td> <td><%=quote.getDeductable() %></td>
				</tr>
				<tr>
				<td>Personal Property</td> <td><%=quote.getPersonalProperty() %></td>
				</tr>
				<tr>
				<td>Additional Living Expense</td> <td><%=quote.getAddLivingExp() %></td>
				</tr>
				<tr>
				<td>Medical Expense</td> <td><%=quote.getMedicalExpenses() %></td>
				</tr>
			</table>
		</td>
		</tr>
	</table>
	<center><a href="buyPolicy.jsp?quoteId=<%=quote.getQuoteId() %>" class="button">Buy Quote</a></center>
</body>
<style>
.button {
	font: bold 11px Arial;
	text-decoration: none;
	background-color: #b2c8d8;
	color: #333333;
	padding: 2px 6px 2px 6px;
	border-top: 1px solid #CCCCCC;
	border-right: 1px solid #333333;
	border-bottom: 1px solid #333333;
	border-left: 1px solid #CCCCCC;
}

</style>
</html>