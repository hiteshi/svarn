<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<!---------------- personal details validation script -------------------------------------->

<link href="../../CSS/jquery-ui.css" rel="stylesheet" type="text/css" />
<script src="../../js/jquery.min.js"></script>
<script src="../../js/jquery-ui.min.js"></script>

<script type="text/javascript">
	function trim(stringToTrim) {
		return stringToTrim.replace(/^\s+|\s+$/g, "");
	}

	function validatePersonalDetails() {
		var msg = "";
		var regexp = /^[a-zA-Z\-\,\.\_\;\:\r\n ]*$/;
		var numericExpression = /^[0-9]+$/;
		var remarkRegex = /^[a-zA-Z\-\,\.\_\;\:\r\n ]*$/;
		
		if (trim(document.forms[0].companyName.value) == "") {
			msg += "Company name is required\n";
		} else {
			txtvalue = document.forms[0].companyName.value;
			remarkRegex = /^[a-zA-Z\-\,\.\_\;\:\r\n ]*$/;
			if (!txtvalue.match(remarkRegex)) {
				msg += "Only alphabets are allowed in Company Name\n";

			}
		}

		if (trim(document.forms[0].contactPersonName.value) == "") {
			msg += "Contact person name is required\n";

		} else {
			txtvalue = trim(document.forms[0].contactPersonName.value);
			remarkRegex = /^[a-zA-Z\-\,\.\_\;\:\r\n ]*$/;
			if (!txtvalue.match(remarkRegex)) {
				msg += "Only alphabets are allowed in Contact person name\n";

			}
		}

		if (trim(document.forms[0].contactPersonMobile.value) == "") {
			msg += "Communication Mobile Number is required\n";
		} else {

			txtvalue = document.forms[0].contactPersonMobile.value;

			if (txtvalue.length < 10) {
				msg += "Communication Mobile Number cannot be less than 10 digits\n";
			}

			if (!txtvalue.match(numericExpression)) {
				msg += "Communication Mobile Number can only be numbers\n";
			}

		}

		if (trim(document.forms[0].contactPersonemailId.value) == "") {
			msg += "Email Id is required\n";
		} else {
			txtvalue = trim(document.forms[0].contactPersonemailId.value);
			if (txtvalue != "") {
				var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
				var address = trim(document.forms[0].contactPersonemailId.value);

				if (reg.test(address) == false) {
					msg += "Invalid Email Address\n";
				}

			}
		}
		if(msg!="")
			alert(""+msg+"\n");
		else
		{
			//alert("11111111111");
			
			return false;
		}
		

	}
	
	
	
	function validateAccountDetails()
	{	
		
		var msg="";
		
		//alert("11111111111");
		if(document.forms[0].branchState.value == "")
		{
			msg+="Branch State is required\n";
			//alert("2222222222211111111111"+msg);
		}
		if(document.forms[0].branchCity.value == "")
		{
			msg+="Branch City is required\n";
		}
		if(document.forms[0].branchName.value == "")
		{
			msg+="Branch Name is required\n";
		}
		
		
		if(msg!="")
		{
			alert(""+msg+"\n");
			//alert("hrlllllll\n");
		}
		else
		{
			return false;	
			
		}
		
	
	}
</script>

<script>
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


<style type="text/css">
body {
	background: #d8f0cc;
}

#widget { /* width: 580px;
	height: 280px; */
	
}

form {
	
}

select {
	width: 190px;
	/* font: normal 11px verdana;
	 color: #fff;
	background: #000;  */
}

#txtregion { /* width: 98%;
	height: 16px;
	font: normal 12px verdana;
	letter-spacing: .4em;
	margin: auto;
	border-bottom: 1px black solid; */
	
}

#txtplacename { /* width: 98%;
	height: 16px;
	font: normal 10px verdana;
	margin: auto; */
	
}
</style>
<script type="text/javascript" src="city_state.js"></script>

<!---------------- personal details validation script end -------------------------------------->
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet"
	type="text/css" />
<table align="right">
	<tr>
		<td><a href="/svarn/view/html/DocumentChecklist.html"
			target="_blank">Document Check-list</a></td>
	</tr>
</table>
<table align="center">

	<form name="companyRegistrationForm" action="/svarn/companyRegister"
		method="POST">
		<!-- onsubmit="window.open('/svarn/view/generic/RegistrationSuccessful.jsp')" -->
	
	
	<tr>
		<td width="1100" height="700">
			<div id="TabbedPanels1" class="TabbedPanels">
				<!-------------- 00000000000div   -------------------->
				<ul class="TabbedPanelsTabGroup">
					<li class="TabbedPanelsTab" tabindex="0">Personal Details</li>
					<li class="TabbedPanelsTab" tabindex="0">Account Details</li>
				</ul>
				<div class="TabbedPanelsContentGroup">
					<!------11111111111div -------------------->
					<!--------------------personal details------------------------------>
					<div class="TabbedPanelsContent">
						<table border="0" align="center" width=100% height="500">

							<tr bgcolor="#CCC">
								<td>Personal Details</td>
								<td></td>
							</tr>
							<tr>
								<td width="20%"><label for="firstName">Company
										Name:<span class="compulsary"><font color="red">*</font>
									</span>
								</label></td>
								<td width="30%"><input type="text" name="companyName"
									title="Enter your First-Name here" class="txtfield"
									maxlength="50" onkeydown="chkMaxLength(this)"></td>
							</tr>
							<tr>
								<td width="20%"><label for="lastName">Contact
										Person Name:<span class="compulsary"><font color="red">*</font>
									</span>
								</label></td>
								<td width="30%"><input type="text" name="contactPersonName"
									title="Enter your Last-Name here" class="txtfield"
									maxlength="50" onkeydown="chkMaxLength(this)"></td>
							</tr>
							<tr>
								<td width="20%"><label for="mobile">Contact Person
										Mobile:<span class="compulsary"><font color="red">*</font>
									</span>
								</label></td>
								<td width="30%"><input name="extension" maxlength="3"
									size="2" value="+91" readonly="readonly" type="text"> <input
									name="contactPersonMobile" maxlength="10" size="20" type="text"></td>

							</tr>
							<tr>
								<td width="20%"><label for="email">Contact Person
										E-mail:<span class="compulsary"><font color="red">*</font>
									</span>
								</label></td>
								<td><input type="text" name="contactPersonemailId"
									title="Enter your Login-Id here" class="txtfield"
									maxlength="70" size="20"></td>
							</tr>

							<tr>
								<td colspan="2" align="center"><input type="button"
									width="50%" name="submit" value="Validate"
									onclick="validatePersonalDetails()"></td>

							</tr>


						</table>
					</div>

					<!--------------------personal details  end   ------------------------------>
					<!---------------account details --------------------------->
					<div class="TabbedPanelsContent">
						<table width="100%" height="500" border="0">

							<tr>

								<td width="20%"><label for="accountType">Current
										Account </label></td>
								<br>
							</tr>
							<tr>

							</tr>
							<tr>
								<td width="20%" class="headerrow" bgcolor="#CCC">Branch
									details</td>
								<td width="30%" bgcolor="#CCC"></td>
							</tr>


							<div id="widget">

								<tr>
									<td width="20%">Branch State</td>
									<td width="30%"><select name="branchState"
										onchange="set_country(this,branchCity,branchName)" size="1"
										name="region">
											<option value="" selected="selected">SELECT REGION</option>
											<option value=""></option>
											<script type="text/javascript">
														setRegions(this);
													</script>
									</select></td>
								</tr>
								<tr>
									<td width="20%">Branch City</td>
									<td width="30%"><select name="branchCity" size="1"
										disabled="disabled" onchange="set_city_state(this,branchName)"></select></td>
								</tr>
								<tr>
									<td width="20%">Branch Name</td>
									<td width="30%"><select name="branchName" size="1"
										disabled="disabled" onchange="print_city_state(country,this)"></select></td>
								</tr>


							</div>

							</tr>
							<tr>



								<td align="right"></td>
								<td align="left"><input type="submit" width="50%"
									name="submit" value="Save &amp; Continue" /></td>

							</tr>

						</table>
					</div>
					<!---------------account details end--------------------------->
				</div>
				<!------11111111111 div  end   -------------------->
			</div> <!-------------- 00000000000 div  end --------------------> <script
				type="text/javascript">
				<!--
					var TabbedPanels1 = new Spry.Widget.TabbedPanels(
							"TabbedPanels1");
				//-->
				</script>
		</td>
	</tr>


	</form>

</table>