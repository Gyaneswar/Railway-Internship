<%@page import="com.sun.xml.internal.ws.api.ha.StickyFeature"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	if(session.getAttribute("Email")==null || request.getSession(true)==null)
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
	#anbu{
	margin-left:670px;
	margin-top:50px;
	width:450px;
	height:auto;
	color: rgb(204,255,0);
	font-family: sans-serif;
	font-size: x-large;
	font-style: normal;
	}
	.tab
	{
		margin-left:590px;
	}
	#anbu1{
	margin-left: 450px;
	margin-top:60px;
	width:910px;
	height:auto;
	background-color: rgba(0,0,50,0.2);
	border:5px;
	border-style:outset;
	padding: 20px;
	color: rgb(204,255,0);
	font-family: sans-serif;
	font-size: x-large;
	font-style: normal;
	border-color: rgb(47,79,79);
	}
</style>
<title>Item Entry</title>
<link rel="shortcut icon" href="razor.png" type="image/x-icon">
<script>
function addItem(){
var node=document.createElement("input");
var itemnode=document.getElementById("items");
itemnode.style.display="";
document.getElementById("additem").appendChild(itemnode.cloneNode(true));	
itemnode.style.display="none";	
var itemcount=document.getElementById("itemcount").value;
itemcount++;
document.getElementById("itemcount").value=itemcount;

}
</script>
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
	<%
	try
	{
		String Contract=session.getAttribute("Contract").toString();
	}
	catch(Exception e)
	{
		out.print("Error....Enter details first to get Contract value....");
	}
	%>
	<div id="anbu">
		<p class="3">Contract value : ${Contract}$</p>
	</div>
	<div id="items" style="display:none">
	<input type="text" name="Invoice[]" placeholder="Invoice">
			<input type="text" name="Amount[]" placeholder="Amount">
			<input type="text" name="Cumulative[]" placeholder="Cummulative">
			<input type="text" name="Balance[]" placeholder="Balance"><br>
	</div>
	<form action="zap.controller.Fp" method="post">
	<div id="anbu1">
	
			<div id="additem">
			
			</div>
			<input type="hidden" name="itemcount" id="itemcount">
			<input type="button" value="add item" onclick="javascrpit:addItem()" class="btn btn-large btn-primary" >
			<input type="submit" value="Save" class="btn btn-large btn-primary" >
	</div>
	</form>
</body>
</html>