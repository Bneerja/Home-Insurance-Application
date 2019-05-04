<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script language="javascript">
  function fill(){
    document.adminloginform.username.value = document.loginform.username.value;
	document.adminloginform.userpass.value = document.loginform.userpass.value;
  }
</script> 
<meta charset="ISO-8859-1">
<title>UserLogin</title>
</head>
<body>

	<h1 style="text-align: center;">
		<strong>Home Insurance</strong>
	</h1>

	<form name="loginform" action="UserLoginServlet" method="post" onSubmit="return UserLogin()">
		<table align="center">
			<tr>
				<td>
					<table style="width: 500px; height: 400px;" border="2" align="left">
						<tr>
							<td><p style="text-align: justified, italic">Home
									Insurance,also commonly called hazard Insurance or homeowner's
									insurance, is a type of property insurance that covers a
									private residence,such as a condominium or renter's insurance
									or home or multiple unit buildings.</p>
								<p style="text-align: justified, italic">It is an insuarance
									policy that combines various personal insurance
									protection,which can include losses occurring to one's home,its
									contents, loss of use(additional living expenses),or loss of
									other personal possessions of the homeowner, as well as
									liability insurance for accidents that may happen at the home
									or at the hands of the homeowner within the policy territoy.If
									the home does not meet the underwriting guidelines of a
									standard homeowners policy the residence could qualify for a
									limited coverage dwelling policy.</p></td>
						</tr>
					</table>
				</td>
				<td>
					<table style="width: 500px; height: 400px;" border="2" align="left"
						session=horizontal>
						<tr>
							<td>UserName: &nbsp;&nbsp;<input type="text" name="username" minlength="2"
								maxlength="50" required><br>
								 <br> Password:	&nbsp;&nbsp;&nbsp;<input type="password" 
								name="userpass" minlength="8" maxlength="20" required><br>
								
								<br> <input type="submit" name="login" value="Login"
								href="#" /><br> <br>
								 </form>
								 <form name="adminloginform" action="AdminLoginServlet" method="post">
								 <input type="hidden" name="username" >
								 <input type="hidden" name="userpass" >
								<a href="AdminLogin.jsp" onclick="fill()"><span style="text-decoration: underline;">Admin Login</span>								
									</a></form>	
									 New User? <a href="Registration.jsp"><span
									style="text-decoration: underline;">Register Here</span></a><br>
							</td>
						</tr>
						<%
							if (request.getParameter("message") != null) {
						%>

						<tr>
							<td><%=request.getParameter("message")%></td>
						</tr>
						<%
							}
						%>
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
</style>
	<div id="footer">Copyright &copy 2018 homeinsurance.com. All
		rights reserved.</div>
</body>
</html>
</body>
</html>
