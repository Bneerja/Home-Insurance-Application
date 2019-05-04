<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.perscholas.homeinsurance.*" %>
<%@page import="java.util.List" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>viewPolicies</title>
<h1 style="text-align: center; font-size: 58px;">
			<img alt="" height="40px" width="40px" src="./images/house.jpg">Homeowner
			Insurance
		</h1>		
</head>
<body>
<%List<PolicyDetails> policylist = (List)session.getAttribute("plist");%>

<section style="text-align: center; font-size: 25px;">
			<a href="UserLogin.jsp">Home </a> &nbsp;|&nbsp; 
			<a href="LogOut.jsp">Logout</a>
		</section>
		<hr>
		<h3 style="text-align: center;">Policy List</h3>		

 
		<table align="center"style="border-color: black; width: 500px;" border="2" cellpadding="10">
				
		<tr>
		<th style="width: 70px; background-color: brown;" scope="row">Policy Id </th>
		<th style="width: 100px; background-color: brown;" scope="row">Quote Id</th>
		<th style="width: 100px; background-color: brown;" scope="row">Policy Effective Date</th>
		<th style="width: 100px; background-color: brown;" scope="row">Policy End Date </th>
		<th style="width: 100px; background-color: brown;" scope="row">Policy Term</th>
		<th style="width: 100px; background-color: brown;" scope="row">Policy Status</th>
		<th style="width: 100px; background-color: brown;" scope="row">Renew Policy</th>
		<th style="width: 100px; background-color: brown;" scope="row">Cancel Policy</th>		
		</tr>
	
		<%for(int i=0;policylist!=null && i<policylist.size();i++){
			PolicyDetails pd = policylist.get(i);		
		%>
		<form action="UpdatePolicyServlet" method="post">
		<tr>
		<%session.setAttribute("pid", pd.getPolicyId()); %>
		<td style="width: 70px;"><%=pd.getPolicyId()%></td>
		<td style="width: 100px;"><%=pd.getQuoteId()%></td>
		<td style="width: 100px;"><%=pd.getPolicyEffectiveDate()%></td>
		<td style="width: 100px;"><%=pd.getPolicyEndDate()%></td>
		<td style="width: 100px;"><%=pd.getPolicyTerms()%></td>
		<td style="width: 100px;"><%=pd.getPolicyStatus()%></td>							
		<td style="width: 100px;"><input type="submit" name="renew" value="RenewPolicy" /></td>
		<%if(pd.getPolicyStatus().equalsIgnoreCase("active")){%>
		
		<td style="width: 100px;"><input type="submit" name="cancel" value="CancelPolicy" /></td><%} %>
		</tr>
		</form>
		<%} %>
		</table>
		
</body>
</html>