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
		<h1 style="text-align: center;">Buy Policy</h1>
		<table align="center" width="50%">
			<tr>
				<td><span>Quote Id : <%=request.getParameter("quoteId")%></span>
				</td>
			</tr>
			<tr>
				<td><p>
						<b>Note : The policy state date can not be more than 60 days
							from today date</b></br>
					</p></td>
			</tr>
			<tr>
				<td>Enter Policy Start Date : <input type="text"
					name="policyStatedate" /> (mm/dd/YYYY)</br></td>
			</tr>
			<tr>
				<td><a href="terms.jsp">Please click here to read
						terms and conditions before buying the policy</br>
				</a></td>
			</tr>
			<
			<tr>
				<td><input type="checkbox" name="termsAndCondition" id="1" required/> This is
					to acknowledge that I have read the terms and conditions of the
					policy</br></td>
			</tr>
			<tr align="center">
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
		<input type="hidden" name="quoteId" value="<%=request.getParameter("quoteId")%>"/>
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