<html>
<head>
<link rel="icon" href="/svarn/view/Images/logo.ico" type="image/x-icon">

<script type="text/javascript">

	var count = "250";
	function limiter() {
	var tex = document.myform.Feedback.value;
	var len = tex.length;
	if (len > count) {
		tex = tex.substring(0, count);
		document.myform.Feedback.value = tex;
		return false;
	}
	document.myform.limit.value = count - len;
}

	function mail() {
		alert("Your Requst is in Process....!!!");
	}

	
	document.text_form.Feedback.value = ""; //document.getElementById('Feedback').value='';
	
</script>



</head>
<body>
	<h1>For Closing an Account you have to fill the following details.</h1>
	<form name="myform" action="/svarn/closingAccount" method="POST">
		<table>

			<tr>
				<td><label for="CustomerId"> Customer Id</label></td>
				<td><input type="text" name="CustomerId" maxlength="40">
				</td>
			</tr>
			<tr>
				<td><label for="AccountNo"> Account No</label></td>
				<td><input type="text" name="AccountNo" maxlength="40">
				</td>
			</tr>
			<tr>
				<td><label for="AccountNo"> Feedback</label></td>
				<td><textarea rows="10" cols="40" name="Feedback"
						style="resize: none;" onkeypress=limiter()> </textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right"><script type="text/javascript">
					document.write("<input type=text name=limit size=4 readonly value="+count+">");
				</script></td>
			</tr>

			<tr>
				<td colspan="2" align="right"><input type="submit" value="OK"
					onclick="mail()"></td>

			</tr>
		</table>
	</form>
</body>
</html>






<!-- 



<html>
<head>
<script type="text/javascript">
function displaymessage()
{
alert("Hello World!");
}
</script>
</head>

<body>
<form>
<input type="button" value="Click me!" onclick="displaymessage()" />
</form>

<p>By pressing the button above, a function will be called. The function will alert a message.</p>

</body>
</html> -->