<link href="/svarn/view/CSS/MyStyle.css" rel="stylesheet"
	type="text/css" />

<script type="text/javascript">
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
	}
	function CI() {
		var abc = 1, i;
		principle = document.getElementById("amount").value;
		rate = document.getElementById("rate").value;
		years = document.getElementById("years").value;
		term = document.getElementById("term").value;

		for (i = 0; i < (term * years); i++) {
			abc = abc * (1 + (rate / (100 * term)));
		}

		abc = abc * principle;

		abc = parseFloat(Math.round(abc * 100) / 100).toFixed(2);

		document.getElementById("result").value = abc;
	}
</script>

	<table align="center">
		<tr>
			<td width="200" height="700" class="content_color">
				<table>
					<tr>
						<td><a href="educationdesc.html" target="iframe_a"
							onclick="select(1)" class="image"><img
								src="/svarn/view/Images/education.jpg" height="100" width="150"><br>Education
								Loan</a></td>
					</tr>
					<tr>
						<td><a href="homedesc.html" target="iframe_a"
							onclick="select(2)" class="image"><img
								src="/svarn/view/Images/002.jpg" height="100" width="150"><br>Home
								Loan</a></td>
					</tr>
					<tr>
						<td><a href="cardesc.html" target="iframe_a"
							onclick="select(3)" class="image"><img
								src="/svarn/view/Images/001.jpg" height="100" width="150"><br>Car
								Loan</a></td>
					</tr>
					<tr>
						<td><a href="personaldesc.html" target="iframe_a"
							onclick="select(4)" class="image"><img
								src="/svarn/view/Images/003.jpg" height="100" width="150"><br>Personal
								Loan</a></td>
					</tr>
				</table></td>

			<td width="500" height="700">
				<table align="center">
					<tr>
						<td width="500" height="700"><iframe frameborder="0"
								name="iframe_a" src="/svarn/view/usermgmt/loan/loandesc.html"
								width="500" height="700"></iframe></td>

					</tr>
				</table>
			</td>
			<td width="400" height="700" class="content_color">
				<table align="center" border="0">
					<tr>
						<td width="400" height="500"><h3>EMI calculation</h3>



							<table>
								<tr>
									<td width="20%"><label for="Amount">Amount:<span
											class="compulsary"><font color="red">*</font> </span> </label>
									</td>
									<td width="30%"><input type="text" name="amount"
										id="amount" value="" title="Enter your Last-Name here"
										class="txtfield">
									</td>
								</tr>



								<tr>
									<td width="20%"><label for="Interest">Rate of
											interest :<span class="compulsary"><font color="red">*</font>
										</span> </label>
									</td>
									<td width="30%"><input type="text" name="rate" id="rate"
										readonly="readonly" value="10"
										title="Enter your Last-Name here" class="txtfield">
									</td>
								</tr>


								<tr>
									<td width="20%"><label for="years">time span:<span
											class="compulsary"><font color="red">*</font> </span> </label>
									</td>
									<td width="30%"><select name="years" class="txtfield"
										id="years" size="1">
											<option value=".08">1 month
											<option value=".25">3 month
											<option value=".5">6 month
											<option value="1" selected>1 year
											<option value="2">2 year
											<option value="3">3 year
											<option value="4">4 year
											<option value="5">5 year
											<option value="6">6 year
											<option value="7">7 year
											<option value="8">8 year
											<option value="9">9 year
											<option value="10">10 year
											<option value="11">11 year
											<option value="12">12 year
											<option value="13">13 year
											<option value="14">14 year
									</select>
									</td>
								</tr>

								<tr>
									<td width="20%"><label for="term">term:<span
											class="compulsary"><font color="red">*</font> </span> </label>
									</td>
									<td width="30%"><select name="term" class="txtfield"
										id="term" size="1">
											<option value="12" selected>monthly
											<option value="2">half yearly
											<option value="4">quarterly
											<option value="1">yearly
									</select>
									</td>
								</tr>


								<tr>
									<td width="30%"><input type="button" name="OK"
										onclick="CI()" value="OK">
									</td>
								</tr>



								<tr>
									<td width="20%"><label for="Resultl">Result:<span
											class="compulsary"><font color="red">*</font> </span> </label>
									</td>
									<td width="30%"><input type="text" name="result"
										id="result" value="" readonly="readonly"
										title="Enter your Last-Name here" class="txtfield">
									</td>
								</tr>

							</table>
						</td>

					</tr>

					<tr>
						<td></td>
						<td width="400" height="100"><input type="submit" onClick="location.href='LoanReg.jsp'"
							name="Apply for Loan" value="Apply for loan">
						</td>
					</tr>

				</table></td>
		</tr>
	</table>

