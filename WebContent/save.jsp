<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	if(session.getAttribute("Email")==null)
	{
		response.sendRedirect("login.html");
	}	
%>
<link href="bootstrap.min.css" rel="stylesheet" type="text/css">
<style type="text/css">
	li
	{
		float: left;
	}
	ul
	{
		list-style-type: none;
		margin: 0;
		padding: 0;
		overflow: hidden;
		background-color:#333; 
	}
	li a
	{
		display: inline-block;
		color: white;
		text-align: center;
		padding: 14px 16px;
		text-decoration: none; 
	}
	li a:HOVER {
	background-color: aqua;
}
	#Anbu
	{
	margin-top:150px;
	margin-left:640px;
	width:650px;
	height:auto;
	background: rgba(0,0,50,0.2);
	padding:20px;
	border: 5px;```````
	border-style: outset;
	border-color:rgb(47,79,79);
	}
	pre{
	background: rgba(0,0,0,0.0);
	color: rgb(0,0,0);
	font-family: sans-serif;
	font-size: large;
	}
</style>
<title>Register</title>
<link rel="shortcut icon" href="razor.png" type="image/x-icon">
</head>
<body background="back.jpg">
	<ul>
		<li> <a href="save.jsp">Save Details</a></li>
		<li> <a href="item.jsp">Item Details</a></li>
		<li> <a href="bill.jsp">Add Bills</a></li>
		<li> <a href="fp.jsp">Financial Progress</a></li>
		<li> <a href="pp.jsp">Physical Progress</a></li>	
		<li> <a href="zap.controller.Logout">Logout</a></li>
	</ul>	
	<div id="Anbu">	
	<form action="zap.controller.Save" method="post">
	<pre>
			Name of work :		<input type="text" name="Name" placeholder="Name of work"><br>
			LOA Number :			<input type="text" name="Loa" placeholder="LOA no."><br>
			Department Name :		<select name="Department">
			<option value="Accounts">Accounts</option>
			<option value="Audit">Audit</option>
			<option value="Gen">Gen. Admin</option>
			<option value="Commercial">Commercial</option>
			<option value="Engineering">Engineering</option>
			<option value="Electrical">Electrical</option>
			<option value="Mechanical">Mechancial</option>
			<option value="Medical">Medical</option>
			<option value="Operating">Operating</option>
			<option value="Personnel">Personnel</option>
			<option value="Snt">Snt</option>
			<option value="Stories">Stories</option>
			<option value="Security">Security</option>
			<option value="Rnb">Rnb</option></select><br>
			Agreement Number :	<input type="text" name="Agree" placeholder="Agreement number"><br>
			Name of Agency :		<input type="text" name="Agency" placeholder="Name of agency"><br>
			Contract value :		<input type="number" name="Contract" placeholder="Contract value"><br>
			Completion :			<input type="date" name="Completion" placeholder="Completion period"><br>
			Source of fund :		<select name="text"><br>
			<option value="Revenue">Revenue</option>
			<option value="Deposit">Deposit</option></select><br>
			<input type="Submit" value="Save" class="btn btn-large btn-primary" >
		</pre>
	</form>	
</div>
</body>
</html>