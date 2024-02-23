<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patna Bank Of India Main Page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>


<body class="text-center"
	style="background-color: rgba(2, 255, 128, .5);">
	<h1 id="MainBanner" class="display-3"
		style="margin-top: 20px; color: hsla(14, 100%, 53%, 0.6);">
		Welcome to <span class="text-success">Patna Bank</span> of India
	</h1>
	<div id="initial_Page" style="margin-top: 150px">
		<a href="http://localhost:8082/Spring_PatnaBank0fIndia/PatnaBank/Options" target="_blank"><button type="button"
				class="btn btn-outline-danger btn-lg ">I have already
				Account</button></a>
	</div>

	<div id="initial_Page_1" style="margin-top: 10px">
		<a href="http://localhost:8082/Spring_PatnaBank0fIndia/PatnaBank/formPage" target="_blank"><button type="button" onclick="" class="btn btn-outline-dark btn-lg ">Want
			to Open An Account</button></a>
	</div>

	<script type="text/javascript">
		function createNewAccount() {
			$.ajax({
				url : "/openAccount",
				method : "GET",
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