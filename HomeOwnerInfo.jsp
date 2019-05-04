<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GetQuote</title>
</head>
<body>
	<form action="HomeownerInfoServlet" method="post">
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
		<h1 style="text-align: center;">Homeowner Information</h1>

		<table align="center">
			<tr>
				<td><img alt="" src="./images/house.jpg" width="300px"
					height="250px"></td>
				<td>&nbsp; &nbsp; &nbsp; &nbsp;</td>
				</td>
				<td>
					<table align="center">
						<tr>
							<td>First Name<font color="red">*</font></label></td>
							<td><input type="text" name="firstname" required="required" maxlength="20" pattern="[a-zA-Z0-9\s]+"></td>
						</tr>
						<tr>
							<td>Last Name<font color="red">*</font></td>
							<td><input type="text" name="lastname" required="required" maxlength="20" pattern="[a-zA-Z0-9\s]+"></td>
						</tr>
						<tr>
							<td>Date of Birth<font color="red">*</font></td>
							<td><input type="date" name="dateofbirth" required="required"></td>
						</tr>
						<tr>
							<td>Are you retired?<font color="red">*</font> &nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td><label class="radio-inline"> <input type="radio"
									name="optradio" value="yes">Yes
							</label> <label class="radio-inline"><input type="radio"
									name="optradio" value="no">No</label></td>
						</tr>
						<tr>
							<td>Social Security Number<font color="red">*</font></td>
							<td><input type="text" name="ssn" required="required" maxlength="9" pattern="[0-9]+"
								placeholder="enter 9 digits for ssn"></td>
						</tr>
						<tr>
							<td>Email Address<font color="red">*</font></td>
							<td><input type="text" name="email" required="required" maxlength="50"></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" name="Continue" value="Continue" /></td>
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