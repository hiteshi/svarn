<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<!---------------- personal details validation script -------------------------------------->

<link href="../../CSS/jquery-ui.css" rel="stylesheet" type="text/css" />
<script src="../../js/jquery.min.js"></script>
<script src="../../js/jquery-ui.min.js"></script>


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
<script type="text/javascript">
	function trim(stringToTrim) {
		return stringToTrim.replace(/^\s+|\s+$/g, "");
	}
	function ltrim(stringToTrim) {
		return stringToTrim.replace(/^\s+/, "");
	}
	function rtrim(stringToTrim) {
		return stringToTrim.replace(/\s+$/, "");
	}

	function validateTab1Details() {
		var msg = "";
		var regexp = /^[a-zA-Z\-\,\.\_\;\:\r\n ]*$/;
		var numericExpression = /^[0-9]+$/;
		var remarkRegex = /^[a-zA-Z\-\,\.\_\;\:\r\n ]*$/;

		if (trim(document.forms[0].firstName.value) == "") {
			msg += "First name is required\n";
		} else {
			txtvalue = document.forms[0].firstName.value;
			remarkRegex = /^[a-zA-Z\-\,\.\_\;\:\r\n ]*$/;
			if (!txtvalue.match(remarkRegex)) {
				msg += "Only alphabets are allowed in First Name\n";

			}
		}

		if (trim(document.forms[0].lastname.value) == "") {
			msg += "Last name is required\n";

		} else {
			txtvalue = trim(document.forms[0].txt_lastname.value);
			remarkRegex = /^[a-zA-Z\-\,\.\_\;\:\r\n ]*$/;
			if (!txtvalue.match(remarkRegex)) {
				msg += "Only alphabets are allowed in Last Name\n";

			}
		}
		if (document.forms[0].dateOfBirth.value == "") {
			msg += "Date of Birth is Required\n";

		} else {
			var dt = new Date();
			var dtcurrentdate = dt.getDate() + "-" + (dt.getMonth() + 1) + "-"
					+ dt.getFullYear();
			var sysdate = dtcurrentdate;
			dtcurrentdate = Date.parse(dtcurrentdate);

			var frmdob = document.forms[0].dateOfBirth.value;
			var dtfrmdob = Date.parse(frmdob);

			var dobdiff = dtcurrentdate - dtfrmdob;

			if (dobdiff < 567648000000) {
				msg = msg + "Applicants age should be more than 18 years\n";
			}

		}

		if (trim(document.forms[0].txt_father_name.value) == "") {
			msg += "Father's Name is required\n";
		} else {
			txtvalue = trim(document.forms[0].txt_father_name.value);
			if (!txtvalue.match(regexp)) {
				msg += "Only alphabets are allowed in Father's Name\n";
			}
		}

		if (trim(document.forms[0].motherName.value) == "") {
			msg += "Mother's Maiden Name is required\n";
		} else {
			txtvalue = trim(document.forms[0].motherName.value);

			if (!txtvalue.match(regexp)) {
				msg += "Only alphabets are allowed in Mothers Maiden Name\n";
			}
		}
		if (document.forms[0].gender.value == "") {
			msg += "Gender is Required\n";
		}

		if (trim(document.forms[0].maritalStatus.value) == "") {
			msg += "Marital Status is required\n";
		}
		if (trim(document.forms[0].mobile.value) == "") {
			msg += "Communication Mobile Number is required\n";
		} else {

			txtvalue = document.forms[0].mobile.value;

			if (txtvalue.length < 10) {
				msg += "Communication Mobile Number cannot be less than 10 digits\n";
			}

			if (!txtvalue.match(numericExpression)) {
				msg += "Communication Mobile Number can only be numbers\n";
			}

		}

		if (trim(document.forms[0].email.value) == "") {
			msg += "Email Id is required\n";
		} else {
			txtvalue = trim(document.forms[0].email.value);
			if (txtvalue != "") {
				var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
				var address = trim(document.forms[0].email.value);

				if (reg.test(address) == false) {
					msg += "Invalid Email Address\n";
				}

			}
		}

		if (document.forms[0].pan.value == "") {
			if (document.forms[0].pan.value == "") {
				msg += "Pan number or Form Type is required\n";
			}

		}

	}
</script>


<!---------------- personal details validation script end -------------------------------------->
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet"
	type="text/css" />
<table align="right">
	<tr>
		<td><a href="/svarn/view/html/DocumentChecklist.html"
			target="_blank">Document Check-list</a>
		</td>
	</tr>
</table>
<table align="center">

	<form name="registrationForm" action="/svarn/register" method="POST">
		<tr>
			<td width="1100" height="700">
				<div id="TabbedPanels1" class="TabbedPanels">
					<!-------------- 00000000000div   -------------------->
					<ul class="TabbedPanelsTabGroup">
						<li class="TabbedPanelsTab">Personal Details</li>
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
									<td width="20%"><label for="firstName">First Name:<span
											class="compulsary"><font color="red">*</font> </span> </label>
									</td>
									<td width="30%"><input type="text" name="firstName"
										title="Enter your First-Name here" class="txtfield"
										maxlength="32" onkeydown="chkMaxLength(this)">
									</td>
								</tr>
								<tr>
									<td width="20%"><label for="lastName">Last Name:<span
											class="compulsary"><font color="red">*</font> </span> </label>
									</td>
									<td width="30%"><input type="text" name="lastName"
										title="Enter your Last-Name here" class="txtfield"
										maxlength="32" onkeydown="chkMaxLength(this)">
									</td>
								</tr>
								<tr>
									<td width="20%"><label for="dateOfBirth">Date of
											Birth:<span class="compulsary"><font color="red">*</font>
										</span> </label>
									</td>
									<td width="30%"><input type="text" readonly="readonly"
										name="dateOfBirth" id="datepicker"
										title="Enter your Login-Id here" class="txtfield"
										maxlength="32" />
									</td>
								</tr>
								<tr>
									<td width="20%"><label for="fatherName">Father's
											Name:<span class="compulsary"><font color="red">*</font>
										</span> </label>
									</td>
									<td width="30%"><input type="text" name="fatherName"
										title="Enter your Login-Id here" class="txtfield"
										maxlength="32">
									</td>
								</tr>
								<tr>
									<td width="20%"><label for="motherName">Mother's
											Name:<span class="compulsary"><font color="red">*</font>
										</span> </label>
									</td>
									<td width="30%"><input type="text" name="motherName"
										title="Enter your Login-Id here" class="txtfield"
										maxlength="13">
									</td>
								</tr>

								<tr>
									<td width="20%"><label for="gender">Gender:<span
											class="compulsary"><font color="red">*</font> </span> </label>
									</td>
									<td width="30%"><select name="gender" class="txtfield"
										size="1">
											<option value="--Select--" selected>--Select--
											<option value="F">F
											<option value="M">M
											<option value="Others">Others</option>
									</select>
									</td>
								</tr>
								<tr>
									<td width="20%"><label for="maritalStatus">Marital
											Status:<span class="compulsary"><font color="red">*</font>
										</span> </label>
									</td>
									<td width="30%"><select name="maritalStatus"
										class="txtfield" size="1">
											<option value="--Select--" selected>--Select--
											<option value="Married">Married
											<option value="Single">Single
									</select>
									</td>
								</tr>
								<tr>
									<td width="20%"><label for="mobile">Mobile:<span
											class="compulsary"><font color="red">*</font> </span> </label>
									</td>
									<td width="30%"><input name="mobile" maxlength="3"
										size="2" value="+91" readonly="readonly" type="text">
										<input name="mobileNo" maxlength="10" size="20" type="text">
									</td>

								</tr>
								<tr>
									<td width="20%"><label for="email">E-mail:<span
											class="compulsary"><font color="red">*</font> </span> </label>
									</td>
									<td><input type="text" name="emailId"
										title="Enter your Login-Id here" class="txtfield"
										maxlength="13" size="20">
									</td>
								</tr>

								<tr>
									<td width="20%"><label for="pan">PAN:<span
											class="compulsary"><font color="red">*</font> </span> </label>
									</td>
									<td width="30%"><input type="text" name="panCard"
										title="Enter your Login-Id here" class="txtfield"
										maxlength="10">
									</td>
								</tr>
								<tr>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td class="txtNormalNoPad" width="20%"><label for="form60">Form
											60 / Form 61: <span class="compulsary"><font
												color="red">*</font> </span> </label>
									</td>
									<td width="30%"><select name="form60"
										onblur="panvalidation()" class="txtfield"><option
												value="" selected="selected">--Select--</option>
											<option value="60">Form 60</option>
											<option value="61">Form 61</option>
									</select>
									</td>
								</tr>
								<tr>
									<td colspan="2" align="center"><input type="button"
										width="50%" name="submit" value="Save &amp; Continue"
										onclick="validatePersonalDetails()">
									</td>

								</tr>


							</table>
						</div>

						<!--------------------personal details  end   ------------------------------>
						<!---------------account details --------------------------->
						<div class="TabbedPanelsContent">
							<table width="100%" height="500" border="0">

								<tr>

									<td width="20%"><label for="accountType">Account
											Type: <span class="compulsary"><font color="red">*</font>
										</span> </label>
									</td>
									<td width="30%"><select name="accountType"
										class="txtfield"><option value="--Select--" selected>--Select--</option>
											<option>Saving Account</option>
											<option>Fixed Deposit</option>
									</select><br>
								</tr>
								<tr>

								</tr>
								<tr>
									<td width="20%" class="headerrow" bgcolor="#CCC">Branch
										details</td>
									<td width="30%" bgcolor="#CCC"></td>
								</tr>
								<tr>
									<td width="20%"><label for="branchState">State:<span
											class="mandTxt"><font color="red">*</font> </span> </label>
									</td>
									<td width="30%"><select name="branchState"
										class="txtfield"><option value="" selected="selected">--Select--</option>

											<option value="DELHI">Delhi</option>

											<option value="KARNATAKA">Karnataka</option>

											<option value="RAJASTHAN">Rajasthan</option>

									</select>
									</td>
								</tr>
								<tr>
									<td width="20%"><label for="branchCity">City:<span
											class="mandTxt"><font color="red">*</font> </span> </label>
									</td>
									<td width="30%"><select name="branchCity" class="txtfield"><option
												value="" selected="selected">--Select--</option>

											<option value="BANGALORE">BANGALORE</option>
											<option value="DELHI">DELHI</option>
											<option value="JODHPUR">JODHPUR</option>

									</select>
									</td>
								</tr>
								<tr>
									<td class="txtNormal"><label for="branchName">Branch:
											<span class="compulsary"><font color="red">*</font> </span> </label>
									</td>
									<td><select name="branchName" class="txtfield"><option
												value="" selected="selected">--Select--</option>
											<option value="DL-CANNOUT PLACE">(DL) CANNOUT PLACE</option>
											<option value="DL-CHANDNI CHOWK">(DL) CHANDNI CHOWK</option>
											<option value="KA-E-CITY">(KA) ELECTRONIC CITY</option>
											<option value="KA-HEBBAL">(KA) HEBBAL</option>
											<option value="RJ-PAOTA">(RJ) PAOTA</option>
											<option value="RJ-PAL ROAD">(RJ) PAL ROAD</option>
									</select>
									</td>
								</tr>
								<tr>

								</tr>
								<tr>
									<td width="20%" bgcolor="#CCCCCC">Communication Address</td>
									<td width="30%" bgcolor="#CCCCCC"></td>
								</tr>
								<tr>
									<td width="20%"><label for="addressLine1"> Address
											Line 1 : <span class="compulsary"><font color="red">*</font>
										</span> </label>
									</td>
									<td width="30%"><input name="addressLine1" maxlength="45"
										type="text" class="txtfield">
									</td>
								</tr>
								<tr>
									<td width="20%"><label for="addressLine2"> Address
											Line 2 : <span class="compulsary"><font color="red">*</font>
										</span> </label>
									</td>
									<td width="30%"><input name="addressLine2" maxlength="45"
										type="text" class="txtfield">
									</td>
								</tr>


								<tr>
									<td class="txtNormal"><label for="state">State: <span
											class="compulsary"><font color="red">*</font> </span> </label>
									</td>
									<td id="commstate"><select name="state" class="txtfield">
											<option value="" selected="selected">--Select--</option>
											<option value="DELHI">DELHI</option>
											<option value="KARNATAKA">KARNATAKA</option>
											<option value="RAJASTHAN">RAJASTHAN</option>
									</select>
									</td>
								</tr>
								<tr>
									<td><label for="city">City:<span
											class="compulsary"><font color="red">*</font> </span> </label>
									</td>
									<td><select name="city" class="city">
											<option value="" selected="selected">--Select--</option>
											<option value="CANNAOUT PLACE">CANNOUT PLACE</option>
											<option value="CHANDNI CHOWK">CHANDNI CHOWK</option>
											<option value="ELECTRONIC CITY">ELECTRONIC CITY</option>
											<option value="HEBBAL">HEBBAL</option>
											<option value="PAOTA">PAOTA</option>
											<option value="PAL ROAD">PAL ROAD</option>

									</select>
									</td>
								</tr>
								<tr>
									<td><label for="pinCode"> PIN code: <span
											class="compulsary"><font color="red">*</font> </span> </label>
									</td>
									<td><input name="pinCode" maxlength="6" type="text"
										class="txtfield">
									</td>
								</tr>
								<tr>
									<td><label for="lanno"> Landline: </label>
									</td>
									<td><input name="contrycode" maxlength="3" size="2"
										value="+91" readonly="readonly" type="text"><input
										name="lanstdcode" maxlength="5" size="3" type="text">
										<input name="lanno" maxlength="8" size="12" type="text"
										width="80%">
									</td>
								</tr>
								<tr>
									<td><label for="offlanno">Office Landline:</label>
									</td>
									<td><input name="contrycode" maxlength="3" size="2"
										value="+91" readonly="readonly" type="text"><input
										name="offstdcode" maxlength="5" size="3" type="text">
										<input name="offlanno" maxlength="8" size="12" type="text">
									</td>
								</tr>
								<tr>


									<td align="right"><input type="button" width="50%"
										name="submit" value="Back">
									</td>
									<td align="left"><input type="submit" width="50%"
										name="submit" value="Save &amp; Continue">
									</td>

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
			</script></td>
		</tr>

	</form>
	</form>

</table>