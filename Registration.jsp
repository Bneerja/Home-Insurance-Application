<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
    function alphanumeric(txt) {    	
        var letters = /^[0-9a-zA-Z]+$/;
        if (!txt.value.match(letters)) {            
            alert('Please input alphanumeric characters only');
            return false;
        } 
    }
</script>
<meta charset="ISO-8859-1">
<title>RegistrationPage</title>
</head>
<body>
 <form name = "form1" action="RegistrationServlet" method="post">
	
		<h1 Style="text-align: center;">
			<strong>Home Insurance</strong>
		</h1>
		<br>
		<h2 Style="text-align: center;">
			<strong>User Details</strong>
		</h2>
		<br> <label> Note: Password must be between 8 and 20
			alphanumeric characters</label><br> <br>
       
		<table align="left">		
			<tr>
			    <td>User Name:</td>
				<td><input type="text" name="username" pattern="[A-Za-z0-9]{2,50}" required></td>				
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="userpass" pattern="[A-Za-z0-9]{8,20}" required></td>
			</tr>
			<tr>
				<td>Password Confirmation :</td>
				<td><input type="password" name="confirmpass" required></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="Register" value="Register"
					onclick="alphanumeric(document.form1.username)|alphanumeric(document.form1.userpass)" ></td>
			</tr>


			<tr>
				<td></td>
				<td><a href="Cancel.jsp"><span
						style="text-decoration: underline;">Cancel </span></a></td>
			</tr>
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