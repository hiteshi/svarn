
<link href="/svarn/view/CSS/MyStyle.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="/svarn/view/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
function CI(){
	principle = document.getElementById("amount").value;
	rate = document.getElementById("rate").value;
	instalments = document.getElementById("monthly").value;

//alert("Checking : principle"+principle+" rate :"+rate+" installments :"+instalments);
	$.ajax({
		type: 'POST',
		url: '/svarn/chart',
		data: 'principle='+principle+'&rate=' + rate+'&installment=' + instalments, 
		dataType: 'html', 
	}).done(function(msg) { 
		//document.getElementById("chart").innerHTML=msg.
		document.getElementById("chart").innerHTML = msg;
	}); 


	
}

var selected;
function select(i) {
	selected = i;

	if (i == 1) {
		document.getElementById("rate").value = "10";

	}
	if (i == 2) {
		document.getElementById("rate").value = "12";

	}
	if (i == 3) {
		document.getElementById("rate").value = "13";

	}
	if (i == 4) {
		document.getElementById("rate").value = "14";

	}
	if (i == 5) {
		document.getElementById("rate").value = "15";

	}
}
</script>

<table align="center">
	<tr>
		<td width="200" height="700" class="content_color">
			<table>
				<tr>
					<td><a href="againstfd.html" target="iframe_a"
						onclick="select(1)">Against Fixed Deposits</a></td>
				</tr>
				<tr>
					<td><a href="againsthome.html" target="iframe_a"
						onclick="select(2)">Against House </a></td>
				</tr>
				<tr>
					<td><a href="realestate.html" target="iframe_a"
						onclick="select(3)">Real estate/Property </a></td>
				</tr>
				<tr>
					<td><a href="shares.html" target="iframe_a"
						onclick="select(4)">Against Shares </a></td>
				</tr>
				<tr>
					<td><a href="againstgold.html" target="iframe_a"
						onclick="select(5)">Against Gold </a></td>
				</tr>
			</table>
		<td width="400" height="700"><iframe frameborder="0"
				name="iframe_a" src="/svarn/view/usermgmt/loan/loandesc.html"
				width="400" height="700"></iframe></td>
		<td width="500" height="700" class="content_color">
			<table align="center" border="0" width="500" height="700">
				<tr>
					<td width="500" height="200"><h3>EMI calculation</h3>
						<table border="1">
							<tr>
								<td>
										<tr>
											<td width="20%"><label for="Amount">Amount:<span
													class="compulsary"><font color="red">*</font> </span> </label>
											</td>
											<td width="30%"><input type="text" name="amount"
												id="amount" value="" title="Enter your amount here"
												class="txtfield">
											</td>
										</tr>
								</td>
							</tr>
							<tr>
								<td width="20%"><label for="Interest">Rate of
										interest :<span class="compulsary"><font color="red">*</font>
									</span> </label>
								</td>
								<td width="30%"><input type="text" name="rate" id="rate"
									readonly="readonly" value="10"
									title="Enter your intrest-rate here" class="txtfield">
								</td>
							</tr>

							<tr>
								<td width="20%"><label for="Monthly">Monthly
										Installment:<span class="compulsary"><font color="red">*</font>
									</span> </label>
								</td>
								<td width="30%"><input type="text" name="monthly"
									id="monthly" value=""
									title="Enter your monthly installment here" class="txtfield">
								</td>
							</tr>

							<tr>
								<td></td>
								<td width="30%"><input
										type="button" name="OK" onclick="CI()" value="OK">
								</td>
							</tr>
						</table>
				<tr>
					<td width="500" height="400"><div id="chart"></div>
					</td>
				</tr>
				<tr>
					<td width="500" height="100"></td>
				</tr>
				<tr>
						<td></td>
						<td width="400" height="100"><input type="submit" onClick="location.href='LoanReg.jsp'"
							name="Apply for Loan" value="Apply for loan">
						</td>
					</tr>
			</table>
		</td>
	</tr>
</table>
</td>
</tr>
</table>