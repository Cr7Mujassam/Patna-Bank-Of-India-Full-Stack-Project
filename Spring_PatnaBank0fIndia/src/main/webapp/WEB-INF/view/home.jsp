<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Normal Getting Data From frontend through ajax call</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<h1 id="google">Welcome Form</h1>
	<input type="text" placeholder="name please" id="name">
	<input type="text" placeholder="Address please" id="Address">
	<button type="submit" onclick="submit()">Submit</button>
	<script type="text/javascript">
		function submit() {
			//stroing the data
			
			var dataName = document.getElementById("name").value;
			var dataAddress = document.getElementById("Address").value;
			var formData = {
					"name": dataName,
					"address" : dataAddress
			}
			$.ajax({
				type : "POST",
				contentType : "application/json;charset=utf-8",
				url : "home/data",
				data : JSON.stringify(formData),
				dataType : 'json',
				 headers: {
				        'Content-Type':'application/json'
				    },
				success : function(data) {
					console.log("SUCCESS:");
				},
				error : function(e) {
					console.log("ERROR: ", e);
				}
			});
		}
	</script>
</body>
</html>