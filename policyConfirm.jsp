<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GetQuote</title>
</head>
<body>
	<form action="policyConfirmServlet" method="post">
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
		<h1 style="text-align: center;">Policy Confirmation</h1>
		<table align="center" width="50%">
			
			<tr>
				<td colspan="2"><p>
						<b>Our customer service representative will contact you shortly for premium collection arrangements</b></br>
					</p></td>
			</tr>
			<tr>
				<td>QuoteId : </td><td><%=session.getAttribute("quoteid") %></td>
			</tr>
			<tr>
				<td>Policy Key : </td><td><%=session.getAttribute("policyid") %></td>
			</tr>
			<tr>
				<td>Policy effective date : </td><td><%=session.getAttribute("policyStateDate") %></td>
			</tr>
			<tr>
				<td>Policy end date : </td><td><%=session.getAttribute("policyEndDate") %></td>
			</tr>
			<tr>
				<td>Policy status : </td><td>Active</td>
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