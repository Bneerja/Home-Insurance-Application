<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>admin Login</title>
<h1 style="text-align: center; font-size: 58px;">
	<img alt="" height="40px" width="40px" src="./images/house.jpg">Homeowner
	Insurance
</h1>
</head>
<body>
    <form action="PolicyListServlet" method=post>
	<section style="text-align: center; font-size: 25px;"> <a
		href="UserLogin.jsp">Home </a> &nbsp;|&nbsp; <a href="LogOut.jsp">Logout</a>
	</section>
	<hr>
	<h1 style="text-align: center;">Admin Screen</h1>
	<table align="center">
		<tr>
			<td><img alt="" src="./images/house.jpg" width="300px"
				height="250px"></td>
			<td>&nbsp; &nbsp; &nbsp; &nbsp;</td>
			</td>
			<td>
				<table align="center">
					<br>
					<br>
					<tr>
						<td>Search User</td>
					</tr>
					<tr>
						<td><input type="text" name="username" required></td>
					</tr>
					<tr>
						<td><input type="submit" name="search" value="Submit" /></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</form>

</body>
</html>