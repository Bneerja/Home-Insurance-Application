<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GetQuote</title>
</head>
<body>
	<form action="QuoteSummaryServlet" method="post">
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
		<h1 style="text-align: center;">Coverage Details</h1>
		<table align="center">
			<tr>
				<td><img alt="" src="./images/house.jpg" width="300px"
					height="250px"></td>
				<td>&nbsp; &nbsp; &nbsp; &nbsp;</td>
				</td>
				<td>
					<table align="center">
						<a href="AdditionalInfo.jsp"><h4 style="text-decoration: underline" align="center">
							Additional Info</h4></a>
						<tr>
							<td>Quote Id &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
								&nbsp;</td>
							<td><span style="color: black"><%=session.getAttribute("qid")%></span></td>
						</tr>
						<tr>
							<td>Monthly Premium &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
								&nbsp;</td>
							<td><span style="color: black"><%=session.getAttribute("qpremium")%></span></td>
						</tr>
						<tr>
							<td>Dwelling Coverage &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
								&nbsp;</td>
							<td><span style="color: black"><%=session.getAttribute("qcoverage")%></span></td>
						</tr>
						<tr>
							<td>Detached Structure &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
								&nbsp;</td>
							<td><span style="color: black"><%=session.getAttribute("qstructure")%></span></td>
						</tr>
						<tr>
							<td>Personal Property &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
								&nbsp;</td>
							<td><span style="color: black"><%=session.getAttribute("qproperty")%></span></td>
						</tr>
						<tr>
							<td>Additional living expense &nbsp; &nbsp; &nbsp; &nbsp;
								&nbsp;</td>
							<td><span style="color: black"><%=session.getAttribute("qlivexp")%></span></td>
						</tr>
						<tr>
							<td>Medical expense &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
								&nbsp;</td>
							<td><span style="color: black"><%=session.getAttribute("qmedexp")%></span></td>
						</tr>
						<tr>
							<td>Deductable &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</td>
							<td><span style="color: black"><%=session.getAttribute("qded")%></span></td>
						</tr>

						<tr>
							<td><input type="submit" name="proceed"
								value="Proceed to buy" href="#" /></td>
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
	<div id="footer">Copyright &copy 2018 homeinsurance.com. All
		rights reserved.</div>
</body>
</html>