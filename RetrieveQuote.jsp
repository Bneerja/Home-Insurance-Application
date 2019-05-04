<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.perscholas.homeinsurance.*" %>
<%@page import="java.util.List" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RetrieveQuote</title>
</head>
<body>
<%List<QuoteLocation> qlist = (List)session.getAttribute("QuoteLocationList");%>
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
		<h3 style="text-align: center;">Quote Details</h3>	<br><br>	
		
		<table align="center"style="border-color: black; width: 500px;" border="2" cellpadding="10">
				
		<tr>
		<th style="width: 70px; background-color: brown;" scope="row">Quote Id </th>
		<th style="width: 100px; background-color: brown;" scope="row">Residence Type</th>
		<th style="width: 100px; background-color: brown;" scope="row">Address line 1 </th>
		<th style="width: 100px; background-color: brown;" scope="row">Address line2 </th>
		<th style="width: 100px; background-color: brown;" scope="row">City </th>
		<th style="width: 100px; background-color: brown;" scope="row">State</th>
		<th style="width: 100px; background-color: brown;" scope="row">Zip </th>
		<th style="width: 100px; background-color: brown;" scope="row">Residence Use </th>
		<th style="width: 100px; background-color: brown;" scope="row">QuoteSummary</th>
		</tr>
	
		<%for(int i=0;i<qlist.size();i++){
			QuoteLocation qloc = qlist.get(i);			
		%>
		<tr>
		<td style="width: 70px;"><%=qloc.getQuoteId()%></td>
		<td style="width: 100px;"><%=qloc.getResidenceType()%></td>
		<td style="width: 100px;"><%=qloc.getAddressline1()%></td>
		<td style="width: 100px;"><%=qloc.getAddressline2()%></td>
		<td style="width: 100px;"><%=qloc.getCity()%></td>
		<td style="width: 100px;"><%=qloc.getState()%></td>
		<td style="width: 100px;"><%=qloc.getZipCode()%></td>
		<td style="width: 100px;"><%=qloc.getResidenceUse()%></td>	
		<%session.setAttribute("locId",qloc.getLocationId()); %>								
		<td style="width: 100px;"><input type="submit" name="proceed" value="QuoteSummary" /></td>
		</tr>
		<%} %>
		</table>
		</form>
</body>
</html>