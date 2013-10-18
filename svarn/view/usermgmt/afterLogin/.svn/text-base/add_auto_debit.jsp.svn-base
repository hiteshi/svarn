<link href="/svarn/view/CSS/jquery-ui.css" rel="stylesheet" type="text/css" />
<script src="/svarn/view/js/jquery.min.js"></script>
<script src="/svarn/view/js/jquery-ui.min.js"></script>
<!-- <script src="/svarn/view/js/jquery-latest.js"></script> -->
	<script type="text/javascript">
		$(document).ready(function() {

			$("#datepicker").datepicker({
				dateFormat : 'yy-mm-dd',
				yearRange : "1950:2025",
				showAnim : 'fold',
				showOptions : {
					showSpeed : '0'
				},
				changeMonth : true,
				changeYear : true
			});

		});
	</script>

	<div class="polo">

		<table>
			<tr>
				<td><div
						style="height: 60px; width: 845px; border-bottom: 1px solid blue;"></div></td>
			</tr>
		</table>
		<form action="addAutoDeb" method="post">
			<table height="300" width="850">
				<tr>ADD AUTO DEBIT
				</tr>
				<tr>
					<td>Account Number</td>
					<td>:</td>
					<td><input id="accno" type="text" maxlength="10" name="adacc" /></td>
				</tr>
				<tr>
					<td>Auto Debit Amount</td>
					<td>:</td>
					<td><input type="text" id="limit" maxlength="6" name="amount" onclick="changeOn('tpto')"/>
					<input type="hidden" id="tpself" maxlength="6" name="tpself"/>
					
					</td>
				</tr>
				<tr>
					<td>On Date</td>
					<td>: PLEASE ENTER ONLY DATE 1-31</td>
					<td width="30%"><input type="text" name="onDate"
						 id="datepicker1" maxlength="2"></td>
				</tr>
				<tr>
					<td>Minimum Balance</td>
					<td>:</td>
					<td><input type="text" id="limit" maxlength="6" name="minBalance" /></td>
				</tr>
				<tr>
					<td>Nick Name</td>
					<td>:</td>
					<td><input id="nickname" type="text" maxlength="15" name="nick" /></td>
				</tr>


				<tr>
					<td align="right" colspan="3"><input id="countinue"
						type="submit" value="Add" /></td>
				</tr>
			</table>
		</form>
	</div>
	<div style="height: 50px; width: 850px; border-top: 1px solid red"></div>
	</div>