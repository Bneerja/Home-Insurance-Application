<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WelcomePage</title>
<h1 Style="text-align: left;">
	<strong>Home Insurance</strong>
</h1>
<br>
</head>
<body>

	<a href="UserLogin.jsp"><span style="text-decoration: underline;">Home</span></a>&nbsp;
	<a href="GetQuote.jsp"><span style="text-decoration: underline;">Get
			Quote</span></a>&nbsp;
	<a href="RetrieveQuote.jsp"><span
		style="text-decoration: underline;">Retrieve Quote</span></a> &nbsp;
	<a href="MyPolicies.jsp"><span style="text-decoration: underline;">My
			Policies</span></a>&nbsp;
	<a href="LogOut.jsp"><span style="text-decoration: underline;">Logout</span></a>&nbsp;
	<h2 Style="text-align: left;">
		<strong>Welcome </strong><span style="color: black"><%=session.getAttribute("username")%></span>
	</h2>
	<h2 Style="text-align: left;">
		<strong>Get Started Page</strong>
	</h2>

	<table width="70%" height="300px">
		<tr>
			<td>
				<table border="1" rules="all" width="100%" height="100%">
					<tr>
						<td aligh="left" top="left">Left side block</td>
					</tr>
				</table>
			</td>
			<td>
				<table border="1" rules="all" width="100%" height="100%">
					<tr>
						<td style="align-top:5px;"><a href="GetQuote.jsp" class="button">Get a Quote</a> </br> </br>
						<form action = "RetrieveQuoteServlet" method = post>						
						<input type="submit" name= "RetrieveQuote" value="Retrieve a Quote"></td>
						</form> 
					</tr>
				</table>
			</td>
		</tr>
	</table>

	
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
	<div id="footer">Copyright &copy 2018 homeownerinsurance.com.All
		rights reserved.</div>
</body>
</html>