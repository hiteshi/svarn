
<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>Welcome to Registration Page</title>
<script src="/svarn/view/js/jquery.min.js"></script>
<script src="/svarn/view/js/jquery-ui.min.js"></script>



<% 

String loginID= (String)session.getAttribute("username");

%>


<script type="text/javascript">
	function validateName() {
		var msg = "";
		var regexp = /^[a-zA-Z\-\,\.\_\;\:\r\n ]*$/;
		var numericExpression = /^[0-9]+$/;
		var remarkRegex = /^[a-zA-Z\-\,\.\_\;\:\r\n ]*$/;

		if (trim(document.forms[0].userName.value) == "") {
			msg += "Username is required\n";
			//alert("llllllllllllll"+msg);
		} else {
			txtvalue = document.forms[0].userName.value;
			remarkRegex = /^[a-zA-Z\-\,\.\_\;\:\r\n ]*$/;
			if (!txtvalue.match(remarkRegex)) {
				msg += "Only alphabets are allowed as Username\n";

			}
		}
		
		var invalid = " "; // Invalid character is a space
		var minLength = 6; // Minimum length
		var pw1 = document.forms[0].userPassword.value;
		var pw2 = document.forms[0].retypeUserPassword.value;
		// check for a value in both fields.
		if (pw1 == '' || pw2 == '') {
		msg+="Please enter your password twice\n"
		return false;
		}
		// check for minimum length
		if (document.forms[0]m.userPassword.value.length < minLength) {
		alert('Your password must be at least ' + minLength + ' characters long. Try again.');
		return false;
		}
		// check for spaces
		if (document.forms[0].userPassword.value.indexOf(invalid) > -1) {
		alert("Sorry, spaces are not allowed.");
		return false;
		}
		else {
		if (pw1 != pw2) {
		alert ("You did not enter the same new password twice. Please re-enter your password.");
		return false;
		}
		else {
		//alert('1111111');
		return true;
		      }
		   }
		
		var spw1 = document.forms[0].transactionPassword.value;
		var spw2 = document.forms[0].retypetransactionPassword.value;
		if (pw1 == '' || pw2 == '') {
			msg+="Please enter your transcation password twice\n";
			return false;
			}
			// check for minimum length
			if (document.forms[0].transactionPassword.value.length < minLength) {
			alert('Your password must be at least ' + minLength + ' characters long. Try again.');
			return false;
			}
			// check for spaces
			if (document.forms[0].transactionPassword.value.indexOf(invalid) > -1) {
			alert("Sorry, spaces are not allowed.");
			return false;
			}
			else {
			if (spw1 != spw2) {
			alert ("You did not enter the same new password twice. Please re-enter your password.");
			return false;
			}
			else {
			//alert('1111111');
			return true;
			      }
			   }
		if (msg != "")
			alert("" + msg + "\n");
		else {
			//alert("11111111111");

			return false;
		}
	}
</script>



<script type="text/javascript">
$(document).ready(function(){
	
	$(window).load(function () {
		  //alert("on window load");
		$('#countinue').attr('disabled', 'disabled');
		});	
	  $("#userName").blur(function(){
		  
		var uname=$("#userName").val();
		var  old=$("#oldUserName").val();
		//alert("userName :"+uname);	
		
		$.ajax({
			type: 'POST',
			url: '/svarn/searchuser',
			data: 'cmd=check'+'&uname='+uname+'&oldUserName='+old, 
			dataType: 'html', 
		}).done(function(msg) {
			
			 
			if($.trim(msg) === 'available') {
				
				$('#countinue').removeAttr('disabled');
				$("#result").html("Available");
				$("#result").css("color","green");
			}
			else{
				
				$('#countinue').attr('disabled', 'disabled');
				$("#result").html("NotAvailable");
				$("#result").css("color","red");
			}
		}); 
	});  
	
});
</script>



<link href="/svarn/view/CSS/MyStyle.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
	
	<div id="header">
		<jsp:include page="/view/generic/Header.jsp" flush="true" />
	</div>
	<div id="content">
		<form action="/svarn/savenewpassword" method="post">
			<table height="700">
				<tr>
					<td>Enter New User Name</td>

					<td><input type="text" id="userName" name="userName" />
					<input type="text" id="oldUserName" name="oldUserName" value=<%=loginID %>>
					</td>
				</tr>
				<tr>
					<td></td>

					<td><div id="result"></div>
					</td>
				</tr>
				<tr>
					<td>Enter New Password</td>

					<td><input type="password" id="userPassword" name="userPassword" />
					</td>
				</tr>
				<tr>
					<td>Re-enter the Password</td>

					<td><input type="password" id="retypeUserPassword"
						name="retypeUserPassword" />
					</td>
				</tr>
				<tr>
					<td>Enter New Transaction Password</td>

					<td><input type="password" id="transactionPassword"
						name="transactionPassword" />
					</td>
				</tr>
				<tr>
					<td>Re-enter the Transaction Password</td>

					<td><input type="password" id="retypeTransactionPassword"
						name="retypeTransactionPassword" />
					</td>
				</tr>
				<tr>
					<td align="right"><input type="submit" id="countinue" name="countinue"
						value="Save" onclick="validateName();return false;"/>
					</td>
				</tr>



			</table>
		</form>
	</div>
	<div id="footer">
		<jsp:include page="/view/generic/Footer.jsp" flush="true" />
	</div>
</body>
</html>