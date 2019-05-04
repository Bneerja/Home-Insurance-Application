<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GetQuote</title>
</head>
<body>
	<form action="PropertyServlet" method="post">
		<h1 style="text-align: center; font-size: 58px;">
			<img alt="" height="40px" width="40px" src="./images/house.jpg">Homeowner
			Insurance
		</h1>
		<section style="text-align: center; font-size: 25px;">
			<a href="UserLogin.jsp">Home </a> &nbsp;|&nbsp; <a
				href="GetQuote.jsp">Get Quote </a>&nbsp; | &nbsp; <a
				href="RetrieveQuote.jsp">Retrieve Quote</a> &nbsp; | &nbsp; <a
				href="Policy.jsp">My Policies</a> &nbsp; | &nbsp; <a
				href="LogOut.jsp">Logout</a>
		</section>
		<hr>
		<h1 style="text-align: center;">Property Details</h1>
		<table align="center">
			<tr>
				<td>What is the market value of your home?<font color="red">*</font> :  $</td>
				<td><input type="number" required="required" name="marketvalue"></td>
			</tr>
			<tr>
				<td>What year was your home originally built?<font color="red">*</font></td>
				<td><input type="number" required="required" pattern="[0-9]+" name="year"></td>
			</tr>
			<tr>
				<td>Square Footage<font color="red">*</font></td>
				<td><input type="number" name="sqft"  required="required" pattern="[0-9]+">sq ft</td>
			</tr>
			<tr>
				<td>Dwelling Style<font color="red">*</font></td>
				<td><select name="dwellingstyle"  required="required"><option value="">---select---</option>
						<option value="1 Story">1 Story</option>
						<option value="1 1/2 Stories">1 &#189; Stories</option>
						<option value="2 Stories">2 Stories</option>
						<option value="2 1/2 Stories">2 &#189; Stories</option>
						<option value="3 Stories">3 Stories</option>
				</select></td>
			</tr>
			<tr>
				<td>Roof Material<font color="red">*</font></td>
				<td><select name="roofmaterial"  required="required"><option value="">---select---</option>
						<option value="Concrete">Concrete</option>
						<option value="Clay">Clay</option>
						<option value="Rubber">Rubber</option>
						<option value="Steel">Steel</option>
						<option value="Tin">Tin</option>
						<option value="Wood">Wood</option>
				</select></td>
			</tr>
			<tr>
				<td>Type of Garage<font color="red">*</font></td>
				<td><select name="garagetype"  required="required"><option value="">---select---</option>
						<option value="Attached">Attached</option>
						<option value="Detached">Detached</option>
						<option value="Basement">Basement</option>
						<option value="Built-In">Built-In</option>
						<option value="None">None</option>
				</select></td>
			</tr>
			<tr>
				<td>Number of Full-Baths<font color="red">*</font></td>
				<td><select name="fullbath" required="required"><option value="">---select---</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4 or more</option>
				</select></td>
			</tr>
			<tr>
				<td>Number of Half-Baths<font color="red">*</font></td>
				<td><select name="halfbath" required="required"><option value="">---select---</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4 or more</option>
				</select></td>
			</tr>
			<tr>
				<td>Does your home have a swimming pool?<font color="red">*</font></td>
				<td><label class="radio-inline"> <input type="radio"
						name="optradio" required="required" value="yes">Yes
				</label> <label class="radio-inline"><input type="radio"
						name="optradio" value="no">No</label></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="Continue" value="Continue" /></td>
			</tr>
		</table>
		<br>
		<br>
		<br>
		<br>
		<hr />
		<style type="text/css">
#footer {
	bottom: 2px;
	height: 40px;
	margin-top: 40px;
	text-align: center;
	vertical-align: middle;
	position: fixed;
	width: 100%;
}
</style>
		<div id="footer">Copyright &copy 2018 homeownerinsurance.com.All
			rights reserved.</div>
</body>
</html>