<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<!-- <script src="/svarn/view/js/jquery.min.js"></script> -->
<!-- <script src="/svarn/view/js/jquery-ui.min.js"></script> -->
<script src="/svarn/view/js/jquery-latest.js"></script>
<script type="text/javascript">
	//-->

	$(document).ready(
			function() {

				$("#calculate").click(function() {

					$.ajax({
						type: 'POST',
						url: '/svarn/savinginterest',
						data: "cmd=CalculateSavingInterest",
						dataType: 'html', 
					}).done(function(msg) {
						
						alert(msg);
						document.getElementById("success").innerHTML=msg;
						
					}); 

				});
				
				

				$("#ok1").click(
						function() {

							var accountName = $("#Name1").val();
							var accRate = $("#Rate1").val();
							alert("called" + accountName + " " + accRate);
							//alert(str);
							$.ajax(
									{
										type : 'POST',
										url : '/svarn/accExistance',
										data : 'cmd=SaveNewData'
												+ '&accountName=' + accountName
												+ '&accRate=' + accRate,
										dataType : 'html',
									}).done(function(msg) {

							});
						});
				$("#ok2").click(
						function() {

							var accountName = $("#Name2").val();
							var accRate = $("#Rate2").val();
							alert("called" + accountName + " " + accRate);
							//alert(str);
							$.ajax(
									{
										type : 'POST',
										url : '/svarn/accExistance',
										data : 'cmd=SaveLoanData'
												+ '&accountName=' + accountName
												+ '&accRate=' + accRate,
										dataType : 'html',
									}).done(function(msg) {

							});
						});
				$("#ok3").click(
						function() {

							var accountName = $("#Name3").val();
							var accRate = $("#Rate3").val();
							alert("called" + accountName + " " + accRate);
							//alert(str);
							$.ajax(
									{
										type : 'POST',
										url : '/svarn/accExistance',
										data : 'cmd=UpdateData'
												+ '&accountName=' + accountName
												+ '&accRate=' + accRate,
										dataType : 'html',
									}).done(function(msg) {

							});
						});
				$("#ok4").click(
						function() {

							var accountName = $("#Name4").val();
							var accRate = $("#Rate4").val();
							alert("called" + accountName + " " + accRate);
							//alert(str);
							$.ajax(
									{
										type : 'POST',
										url : '/svarn/accExistance',
										data : 'cmd=UpdateLoanData'
												+ '&accountName=' + accountName
												+ '&accRate=' + accRate,
										dataType : 'html',
									}).done(function(msg) {

							});
						});

			});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Settings</title>
<link href="/svarn/view/CSS/tabs.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<ol id="toc">
		<li><a href="AccountApplication.jsp"><span>AccountApplication</span></a></li>
		<li><a href="IBSApplication.jsp"><span>IBSApplication</span></a></li>
		<li><a href="CompanyApplication.jsp"><span>CompanyApplication</span></a></li>
		<li><a href="LoanApplication.jsp"><span>LoanApplication</span>
		</a></li>
		<li class="current"><a href="Settings.jsp"><span>Settings</span></a></li>
		<li><a href="ClosingAccount.jsp"><span>ClosingAccount</span></a></li>
	</ol>
	<div class="content">
		<h2>Settings</h2>
		Calculate Interest for today
		<input type="button" value="Calculate" id="calculate" name="calculate">
		<br>
		<div id="success"></div>
		<br>
		<br>
		<br>
		Create new Account Type and set its interest rate
		<table>
		<tr><td>
			<table>

				<tr>
					<td>Deposit</td>
				</tr>
				<tr>
					<td>Create new Deposit account</td>

				</tr>
				<tr>
					<td>Create new Loan account</td>

				</tr>
				<tr>
					<td>Alter rate of deposit</td>

				</tr>
				<tr>
					<td>Alter Rate of loan</td>

				</tr>

			</table>
			</td><td>
			<table>
				<tr>
					<td>Name</td>
					<td>Rate</td>
				</tr>
				<tr>
					<td><input type="text" value="" id="Name1" name="Name1"></input></td>
					<td><input type="text" value="" id="Rate1" name="Rate1"></input></td>
					<td><input type="button" id="ok1" value="OK"></input></td>
					<td><div id="result"></div></td>
					<!-- 					</form> -->
				</tr>
				<tr>
					<td><input type="text" value="" id="Name2" name="Name2"></input></td>
					<td><input type="text" value="" id="Rate2" name="Rate2"></input></td>
					<td><input type="button" value="OK" id="ok2"></input></td>
				</tr>
				<tr>
					<td><input type="text" value="" id="Name3" name="Name3"></input></td>
					<td><input type="text" value="" id="Rate3" name="Rate3"></input></td>
					<td><input type="button" value="OK" id="ok3"></input></td>
				</tr>
				<tr>
					<td><input type="text" value="" id="Name4" name="Name4"></input></td>
					<td><input type="text" value="" id="Rate4" name="Rate4"></input></td>
					<td><input type="button" value="OK" id="ok4"></input></td>
				</tr>

			</table>
			</td>
			</tr>
		</table>
	</div>
</body>
</html>
