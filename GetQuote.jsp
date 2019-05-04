<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GetQuote</title>
</head>
<body>
	<form action="QuoteServlet" method="post">
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
		<h1 style="text-align: center;">GetQuote</h1>


		<table align="center">
			<tr>
				<td><img alt="" src="./images/house.jpg" width="300px"
					height="250px"></td>
				<td>&nbsp; &nbsp; &nbsp; &nbsp;</td>
				</td>
				<td>
					<table align="center">
						<tr>
							<td>Residence Type *</td>
							<td><select name="residencetype" required="required"><option
										value="">---select---</option>
									<option value="Single Family Home">Single Family Home</option>
									<option value="Condo">Condo</option>
									<option value="Townhouse">Townhouse</option>
									<option value="Rowhouse">Rowhouse</option>
									<option value="Duplex">Duplex</option>
									<option value="Apartment">Apartment</option>
							</select></td>
						</tr>
						<tr>
							<td>Address Line 1*</td>
							<td><input required="required" minlength="3" maxlength="50" type="text"
								name="addressline1"></td>
						</tr>
						<tr>
							<td>Address Line 2</td>
							<td><input type="text" required="required" minlength="3" maxlength="50" name="addressline2"></td>
						</tr>
						<tr>
							<td>City *</td>
							<td><input type="text" required="required"  minlength="2" maxlength="25" name="city"></td>
						</tr>
						<tr>
							<td>State *</td>
							<td><input type="text" required="required" name="state"></td>
						</tr>
						<tr>
							<td>Zip *</td>
							<td><input type="text" required="required" name="zipcode"></td>
						</tr>
						<tr>
							<td>Residence Use *</td>
							<td><select name="residenceuse" required="required"><option
										value="Primary">Primary</option>
									<option value="Secondary">Secondary</option>
									<option value="Rental Property">Rental Property</option>
							</select></td>
						</tr>
						<tr align="center">

							<td colspan="2" align="center"></br>
							<input type="submit" name="Continue" value="Continue"></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

	</form>
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