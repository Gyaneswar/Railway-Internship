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
	margin-top:80px;
	margin-left:640px;
	width:590px;
	height:auto;
	background: rgba(0,0,50,0.2);
	padding:20px;
	border: 5px;
	border-style: outset;
	border-color:rgb(47,79,79);
	}
	pre{
	background: rgba(0,0,0,0.0);
	color: rgb(0,0,0);
	font-family: sans-serif;
	font-size: large;
	}
	}
	h2
	{
		margin-top:50px;
		color: rgb(204,255,0);
	}
</style>
<title>Add Bills</title>
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
	
	<center><h2>BILLS</h2></center>
	<form action="zap.controller.Bill" method="post">
	<div id="Anbu">
		<pre>
			On account/Final : 	<input type="text" name="Bill" placeholder="On account/Final">
			Invoice no. : 		<input type="text" name="Invoice" placeholder="Invoice No.">
			Item of work : 		<input type="text" name="Item" placeholder="Item of work">
			Quantity : 		<input type="text" name="Quantity" placeholder="Quantity">
			Rate : 			<input type="text" name="Rate" placeholder="Rate">
			Bill Amount : 		<input type="text" name="BillA" placeholder="Bill amount">
			Allocation : 		<input type="text" name="Allocation" placeholder="Allocation">
			<input type="submit" value="Save" class="btn btn-large btn-primary" >
		</pre>
		</div>
	</form>	
	
</body>
</html>