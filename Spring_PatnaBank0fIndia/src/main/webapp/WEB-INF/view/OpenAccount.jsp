<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Open New Account</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
 <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>       
</head>
<body class="bg-secondary">
        <div>
            <h1 class="display-2 text-light text-center">Please Enter Your Details</h1>
        </div>

        <div style="margin-right: 300px; margin-left: 300px;">
                <form>
                    <div class="form-group">
                        <label for="Name" class="display-4 text-dark">Name</label>
                        <input type="text" class="form-control" id="NameInput" placeholder="Aamir Khan">
                    </div>

                    <div class="form-group">
                        <label for="Address" class="display-4 text-dark">Address</label>
                        <input type="text" class="form-control" id="AddressInput" placeholder="Patna">
                    </div>

                    <div class="form-group">
                        <label for="MobileNumber" class="display-4 text-dark">Mobile Number</label>
                        <input type="number" class="form-control" id="MobileNumberInput" placeholder="123456789">
                    </div>

                    <div class="form-group">
                        <label for="DepositBalance" class="display-4 text-dark">Balance Deposit Amount</label>
                        <input type="number" class="form-control" id="DepositInput" placeholder="5000">
                    </div>
                </form>
                <button type="submit" onclick="createNewAccount()" class="btn btn-outline-danger btn-block">Open Account</button>
        </div>

        <script type="text/javascript">
        function createNewAccount() {
        	var cstName = document.getElementById("NameInput").value;
        	var cstAddress = document.getElementById("AddressInput").value;
        	var cstMobileNo = document.getElementById("MobileNumberInput").value;
        	var cstDepositAmount = document.getElementById("DepositInput").value;
        	var formData = {
        			"customerName":cstName,
        			"customerAddress":cstAddress,
        			"customerMobileNo":	cstMobileNo,
        			"customerDepositAmount":cstDepositAmount
        	}
			$.ajax({
				url : "Spring_PatnaBank0fIndia/openNewAccount",
				method : "POST",
				contentType : "application/json;charset=utf-8",
				data : JSON.stringify(formData),
				/* dataType : 'json', */
				/* headers: {
			        'Content-Type':'application/json'
			    }, */
				success : function(data) {
					alert("Account Created" + data);
					      setTimeout(function(){// wait for 5 secs(2)
					           location.reload(); // then reload the page.(3)
					      }, 5000); 
				},
				error : function(e) {
					console.log("ERROR: ", e);
				}
			});
        	
        }
        </script>
    </body>
</html>