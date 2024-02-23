<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Existing Customer DashBoard</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
</head>
<body class="text-center">
	<h1 class="display-3 text-danger">Welcome Existing Customers</h1>
	<div style="margin-top: 40px;">
		<p1 class="h4 text-success">See Your Account Number :- </p1><br>
		<p class="h5">Enter Phone:-</p><input type="number" id="AccountNo"/>
		<button class="btn btn-outline-success" onclick="showAccNo()">Click Here</button>
		<p class="h5">This is your Account Number <p id="Customer_AccNo"></p> </p>
	</div>
	<div style="margin-top: 25px;">
		<p1 class="h4 text-success">Withdraw Account Balance :- </p1><br>
		<p class="h5">Enter Account No:-</p><input type="number" id="customerAccNum"/>
		<p class="h5">Enter the Amount to Withdraw</p><input type="number" placeholder="AmmountPlease" id="customerAmount"/>
		<button class="btn btn-outline-success" onclick="withDrawBalance()">Click Here</button>
	<div style="margin-top: 10px;">
		<p class="h5">This is your Remaining Balance <p id="customer_RemainingBalance"></p> </p>
	</div>
	</div>
	
	<div style="margin-top: 25px;">
		<p1 class="h4 text-success">Deposit Balance:- </p1><br>
		<p class="h5">Enter Account No:-</p><input type="number" id="customerAccDepo"/>
		<p class="h5">Enter the Amount to Deposit</p><input type="number" placeholder="AmmountPlease" id="Amount"/>
		<button class="btn btn-outline-success" onclick="depositBalance()">Click Here</button>
	<div style="margin-top: 10px;">
		<p class="h5">This is your Updated Balance <p id="customer_UpdatedBalance"></p> </p>
	</div>
	</div>
	
	
	
	<script type="text/javascript">
	
	//for depositing balance
	function depositBalance(){
		//for getting the account number balance Amount
		var ammount = document.getElementById("Amount").value;
		
		var formData = {
				"accountNumber" : document.getElementById("customerAccDepo").value,
				"depositAmount" : ammount
		}
		
		$.ajax({
			url : "/Spring_PatnaBank0fIndia/PatnaBank/deposit/ammount",
			method : "POST",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(formData),
			success : function(data) {
				document.getElementById("customer_UpdatedBalance").innerHTML = data;
			},
			error : function(e) {
				console.log("ERROR: ", e);
			}
		});
		
	}
	
	//for showing Account Number
	function showAccNo(){
		var formData = {
				"phoneNo" : document.getElementById("AccountNo").value
		}
		
		
		$.ajax({
			url : "/Spring_PatnaBank0fIndia/PatnaBank/display/AccountNo",
			method : "POST",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(formData),
			success : function(data) {
				document.getElementById("Customer_AccNo").innerHTML = data;
			},
			error : function(e) {
				console.log("ERROR: ", e);
			}
		});
		
	}
	
	function withDrawBalance(){
		
		//for getting the account number balance Amount
		var ammount = document.getElementById("customerAmount").value;
		
		var formData = {
				"accountNumber" : document.getElementById("customerAccNum").value,
				"withdrawAmount" : ammount
		}
		
		$.ajax({ 
			url : "/Spring_PatnaBank0fIndia/PatnaBank/withdraw/ammount",
			method : "POST",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(formData),
			success : function(data) {
				console.log("Hey you have withdraw your Balance" + ammount + "and Your Remaining Balnace is " + data);
				document.getElementById("customer_RemainingBalance").innerHTML = data;
			},
			error : function(e){
				console.log("Error: ", e);
			}
		});
	}
	
	
	</script>
</body>
</html>