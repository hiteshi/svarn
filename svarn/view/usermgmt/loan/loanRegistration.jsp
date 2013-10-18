<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="../../CSS/jquery-ui.css" rel="stylesheet" type="text/css" />
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet"
	type="text/css" />
<body onkeypress="return disableCtrlKeyCombination(event);" onkeydown="return disableCtrlKeyCombination(event);">
<script src="../../js/jquery.min.js"></script>
<script src="../../js/jquery-ui.min.js"></script>
<script language="javascript" src="CommonScripts.js"></script>

<script type="text/javascript" src="/svarn/view/js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$("#demand").click(function(){
			$("#pqr1").slideToggle("slow");
			$("#pqr2").hide();
		});
		$("#term").click(function(){
			$("#pqr2").slideToggle("slow");
			$("#pqr1").hide();
		});
		//alert("b4");
$("#datepicker").datepicker({dateFormat: 'yy-mm-dd', yearRange: "1950:2025", showAnim: 'fold', showOptions: {showSpeed:'0'},  changeMonth:true,changeYear:true});
		alert("aft");

	});
</script>

<style type="text/css">
div #pqr1 {
	display: none;
}
div #pqr2 {
	display: none;
}
</style>


	<!---------------- personal details validation script -------------------------------------->
<!--
<script>
	  $(document).ready(function() {
	  
				$( "#datepicker" ).datepicker({dateFormat: 'yy-mm-dd', yearRange: "1950:2025", showAnim: 'fold', showOptions: {showSpeed:'0'},  changeMonth:true,changeYear:true});
			
	  });
	  </script>-->
<script type="text/javascript">
	var srchFlag = "0";
	function panvalidation()
	{
		
		var regObj = document.forms[0].panCard.value;
		
		
		
		var ele = document.getElementById("trackIdDisp1");
		
		
		if(regObj == ""){		
			ele.disabled="disabled";
		}
		else{
			srchFlag = "1";
		}
		
	}
	

	function validatePersonalDetails()
	{	
		var msg="";
		var regexp=/^[a-zA-Z\-\,\.\_\;\:\r\n ]*$/;
		var numericExpression = /^[0-9]+$/;
		var remarkRegex = /^[a-zA-Z\-\,\.\_\;\:\r\n ]*$/;
		
		
		if(trim(document.forms[0].firstName.value) == "")
		{
			msg+= "First name is required\n";
			//alert("llllllllllllll"+msg);
		}		
		else
		{
			txtvalue = document.forms[0].firstName.value;
			remarkRegex = /^[a-zA-Z\-\,\.\_\;\:\r\n ]*$/;
			if( !txtvalue.match( remarkRegex ) ) {
				  msg+="Only alphabets are allowed in First Name\n";
				 
			}			
		}
		
		if(trim(document.forms[0].lastName.value) == "")
		{
			msg+= "Last name is required\n";
				
		}
		else
		{
			txtvalue = trim(document.forms[0].lastName.value);
			remarkRegex = /^[a-zA-Z\-\,\.\_\;\:\r\n ]*$/;
			if( !txtvalue.match( remarkRegex ) ) {
				  msg+= "Only alphabets are allowed in Last Name\n";
				  
			}			
		}
		if(document.forms[0].dateOfBirth.value=="")
		{
			msg+="Date of Birth is Required\n";
			
		}
		
		
		if(trim(document.forms[0].fatherName.value) == ""){
			msg+="Father's Name is required\n";			
		}
		else{
			txtvalue = trim(document.forms[0].fatherName.value);
			if( !txtvalue.match( regexp ) ) {
				  msg+="Only alphabets are allowed in Father's Name\n";
			}			
		}

		if(trim(document.forms[0].motherName.value) == ""){
			msg+="Mother's Name is required\n";//	alert("11111111111");		
		}
		else{
			txtvalue = trim(document.forms[0].motherName.value);
			
			if( !txtvalue.match( regexp ) ) {
				  msg+="Only alphabets are allowed in Mothers Name\n";
			}			
		}	
		if(document.forms[0].gender.value == ""){
			msg+="Gender is Required\n";
		}
		
		if (trim(document.forms[0].mobileNo.value) == "") {
		msg+="Communication Mobile Number is required\n";
		}
		 else {
			
			txtvalue = document.forms[0].mobileNo.value;
	
			if (txtvalue.length < 10) {
				 msg+= "Communication Mobile Number cannot be less than 10 digits\n";
			}
	
			if (!txtvalue.match(numericExpression)) {
				 msg+="Communication Mobile Number can only be numbers\n";
			}
			
		} 	
		
		
		if(trim(document.forms[0].emailId.value) == "")
		{
			msg+="Email Id is required\n";
		}
		else
		{
			txtvalue=trim(document.forms[0].emailId.value);
			if( txtvalue != "")
			{		
			   var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
			   var address = trim(document.forms[0].emailId.value);
			   
			   if(reg.test(address) == false) {
				   msg+="Invalid Email Address\n";			      
			   }
			   
			} 
		} 
		if(document.forms[0].panCard.value=="" && document.forms[0].form60.value=="")
		{
		
			msg+="pan no or Form Type is required\n";
				
		}
		
		if(msg!="")
		alert(""+msg+"\n");
		else
		{
			//alert("11111111111");

			return false;
		}
		
		
	
	}

<!---------------- personal details validation script end -------------------------------------->

<!----------------contact details validation ------------------------->


	function validateContactDetails()
	{	
		
		var msg="";
		
		
		if(document.forms[0].branchState.value == "")
		{
			msg+="Branch state is required\n";
		}
		if(document.forms[0].branchCity.value == "")
		{
			msg+="Branch city is required\n";
		}
		if(document.forms[0].branchName.value == "")
		{
			msg+="Branch name is required\n";
		}
		if(document.forms[0].addressLine1.value == "")
		{
			msg+="AddressLine1 is required\n";
		}
		if(document.forms[0].addressLine2.value == "")
		{
			//alert("2222222222211111111111");
			msg+="AddressLine2 is required\n";
		}
		if(document.forms[0].state.value == "")
		{
			msg+="State of communication is required\n";
		}
		if(document.forms[0].city.value == "")
		{
			msg+="City of communication is required\n";
		}
		if (document.forms[0].pinCode.value == "")
		 {
			msg+="Pincode Number is required\n";
		}
		 else {
			
			txtvalue = document.forms[1].pinCode.value;
	
			if (txtvalue.length < 6) {
				 msg+= "Pincode Number cannot be less than 6 digits\n";
			}
	
			if (!txtvalue.match(numericExpression)) {
				 msg+="Pincode Number can only be numbers\n";
			}
			
			} 
		
		if(msg!="")
			alert(""+msg+"\n");
		else
		{
			
			return false;
		}
		
	}
	
	<!----------------loan details validation ------------------------->	
	
	function validatedemand(){
		
		var msg="";
		
		
		if(document.forms[0].timeLimit.value == ""|| document.forms[0].demandType.value==""){
				msg+="Enter values required for Demand type\n";
			}
			if(msg!="")
			alert(""+msg+"\n");
		else
		{
			
			return false;
		}
		
	}
	function validateterm(){
	var msg="";
		if(document.forms[0].premium.value == "" || document.forms[0].periodPremium.value=="" || document.forms[0].termType.value=="")
			msg+="Enter values required for Term type\n";
	
		
		if(msg!="")
			alert(""+msg+"\n");
		else
		{
			
			return false;
		}
		
	}
	
	function validateLoanDetails(){
	var msg="";
	if(document.forms[0].amtRequest.value == "")
		{
			msg+="Enter the required values\n";
		}
				
	if(msg!="")
			alert(""+msg+"\n");
		else
		{
			
			return false;
		}
		
	}
	
	<!----------------loan details validation script ends ------------------------->	
	
	function trim(stringToTrim) {
		return stringToTrim.replace(/^\s+|\s+$/g,"");
	}
	
	
	
</script>


	<!---------------- account details validation script end -------------------------------------->


<form name="registrationForm" action="/svarn/loanRegister" method="post">
		<table align="center">
			<tr>
				<td width="1100" height="700">

					<div id="TabbedPanels1" class="TabbedPanels">
						<ul class="TabbedPanelsTabGroup">
							<li class="TabbedPanelsTab" tabindex="0">Personal Details</li>
							<li class="TabbedPanelsTab" tabindex="1">Contact Details</li>
							<li class="TabbedPanelsTab" tabindex="2">Loan Details</li>
						</ul>
						<div class="TabbedPanelsContentGroup">
							<!-----------------------------Personal Details---------------------------------->

							<div class="TabbedPanelsContent">
								<table border="0" align="center" width=100% height="500">

									<tr>
										<td><font style="font: normal" color="red" size="2">
												* This is a mandatory field </font></td>
										<td></td>
									</tr>
									<tr>
										<td width="20%"><label for="firstName">First
												Name:<span class="compulsary"><font color="red">*</font>
											</span>
										</label></td>
										<td width="30%"><input type="text" name="firstName"
											title="Enter your First-Name here" class="txtfield"
											maxlength="25"></td>
									</tr>
									<tr>
										<td width="20%"><label for="lastName">Last Name:<span
												class="compulsary"><font color="red">*</font> </span>
										</label></td>
										<td width="30%"><input type="text" name="lastName"
											title="Enter your Last-Name here" class="txtfield"
											maxlength="25"></td>
									</tr>
									<tr>
										<td width="20%"><label for="dateOfBirth">Date of
												Birth:<span class="compulsary"><font color="red">*</font>
											</span>
										</label></td>
										<td width="30%"><input type="text" name="dateOfBirth"
											title="Enter your Date of Birth here" class="txtfield"
											maxlength="32" id="datepicker"></td>
									</tr>
									<tr>
										<td width="20%"><label for="fatherName">Father's
												Name:<span class="compulsary"><font color="red">*</font>
											</span>
										</label></td>
										<td width="30%"><input type="text" name="fatherName"
											title="Enter your Father's Name here" class="txtfield"
											maxlength="50"></td>
									</tr>
									<tr>
										<td width="20%"><label for="motherName">Mother's
												Name:<span class="compulsary"><font color="red">*</font>
											</span>
										</label></td>
										<td width="30%"><input type="text" name="motherName"
											title="Enter your Mother's Name here" class="txtfield"
											maxlength="50"></td>
									</tr>

									<tr>
										<td width="20%"><label for="gender">Gender:<span
												class="compulsary"><font color="red">*</font> </span>
										</label></td>
										<td width="30%"><select name="gender" class="txtfield"
											size="1">
												<option value="" selected>--Select--
												<option value="F">Female
												<option value="M">Male</option>
										</select></td>
									</tr>

									<tr>
										<td width="20%"><label for="mobileNo">Mobile:<span
												class="compulsary"><font color="red">*</font> </span>
										</label></td>
										<td width="30%"><input name="mobile" maxlength="3"
											size="2" value="+91" readonly="readonly" type="text">
											<input name="mobileNo" maxlength="10" size="20" type="text"></td>

									</tr>
									<tr>
										<td width="20%"><label for="emailId">E-mail:<span
												class="compulsary"><font color="red">*</font> </span>
										</label></td>
										<td><input type="text" name="emailId"
											title="Enter your Email-Id here" class="txtfield"
											maxlength="70" size="20"></td>
									</tr>


									<tr>
										<td width="20%"><label for="pan">PAN(If you do not have a PAN No. please select Form 60/61):</label></td>
										<td width="30%"><input id="trackIdDisp1" type="text"
											name="panCard" title="Enter your pan no. here"
											class="txtfield" maxlength="10"></td>
									</tr>
									<tr>
										<td></td>
										<td></td>
									</tr>
									<tr>
										<td class="txtNormalNoPad" width="20%"><label
											for="form60">Form 60 / Form 61: </label></td>
										<td width="30%"><select onfocus="panvalidation()"
											name="form60" class="txtfield"><option value=""
													selected="selected">--Select--</option>
												<option value="60">Form 60</option>
												<option value="61">Form 61</option>
										</select></td>
									</tr>
									<tr>
										<td colspan="2" align="center"><input type="button"
											width="50%" value="Validate" class="txtButton"
											onclick="validatePersonalDetails()"></td>

									</tr>


								</table>
							</div>

							<!-----------------------------Personal Details  Ends---------------------------------->

							<!-----------------------------Contact Details---------------------------------->

							<div class="TabbedPanelsContent">
								<table width="100%" height="500" border="0">

									<tr>

									</tr>
									<tr>
										<td width="20%" class="headerrow" bgcolor="#CCC">Branch
											details</td>
										<td width="30%" bgcolor="#CCC"></td>
									</tr>
									<tr>
										<td width="20%"><label for="branchState">State:<span
												class="mandTxt"><font color="red">*</font> </span>
										</label></td>
										<td width="30%"><select name="branchState"
											class="txtfield"><option value=""
													selected="selected">--Select--
												<option value="DELHI">Delhi
												<option value="KARNATAKA">Karnataka
												<option value="RAJASTHAN">Rajasthan</option></select></td>
									</tr>
									<tr>
										<td width="20%"><label for="branchCity">City:<span
												class="mandTxt"><font color="red">*</font> </span>
										</label></td>
										<td width="30%"><select name="branchCity"
											class="txtfield"><option value=""
													selected="selected">--Select--</option>
												<option value="BANGALORE">BANGALORE</option>
												<option value="DELHI">DELHI</option>
												<option value="JODHPUR">JODHPUR</option>
										</select></td>
									</tr>
									<tr>
										<td class="txtNormal"><label for="branchName">Branch:
												<span class="compulsary"><font color="red">*</font> </span>
										</label></td>
										<td><select name="branchName" class="txtfield"><option
													value="" selected="selected">--Select--</option>

												<option value="DL-CANNOUT PLACE">(DL) CANNOUT PLACE</option>
												<option value="DL-CHANDNI CHOWK">(DL) CHANDNI CHOWK</option>
												<option value="KA-E-CITY">(KA) ELECTRONIC CITY</option>
												<option value="KA-HEBBAL">(KA) HEBBAL</option>
												<option value="RJ-PAOTA">(RJ) PAOTA</option>
												<option value="RJ-PAL ROAD">(RJ) PAL ROAD</option>
										</select></td>
									</tr>
									<tr>

									</tr>
									<tr>
										<td width="20%" bgcolor="#CCCCCC">Communication Address</td>
										<td width="30%" bgcolor="#CCCCCC"></td>
									</tr>
									<tr>
										<td width="20%"><label for="addressLine1">
												Address Line 1 : <span class="compulsary"><font
													color="red">*</font> </span>
										</label></td>
										<td width="30%"><input name="addressLine1" maxlength="50"
											type="text" class="txtfield"></td>
									</tr>
									<tr>
										<td width="20%"><label for="addressLine2">
												Address Line 2 : <span class="compulsary"><font
													color="red">*</font> </span>
										</label></td>
										<td width="30%"><input name="addressLine2" maxlength="50"
											type="text" class="txtfield"></td>
									</tr>


									<tr>
										<td class="txtNormal"><label for="state">State: <span
												class="compulsary"><font color="red">*</font> </span>
										</label></td>
										<td id="commstate"><select name="state" class="txtfield">
												<option value="" selected="selected">--Select--
												<option value="DELHI">DELHI
												<option value="KARNATAKA">KARNATAKA
												<option value="RAJASTHAN">RAJASTHAN</option>
										</select></td>
									</tr>
									<tr>
										<td><label for="city">City:<span
												class="compulsary"><font color="red">*</font> </span>
										</label></td>
										<td><select name="city" class="city">
												<option value="" selected="selected">--Select--</option>
												<option value="BANGALORE">BANGALORE
												<option value="DELHI">DELHI
												<option value="JODHPUR">JODHPUR</option>
										</select></td>
									</tr>
									<tr>
										<td><label for="pinCode"> PIN code: <span
												class="compulsary"><font color="red">*</font> </span>
										</label></td>
										<td><input name="pinCode" maxlength="6" type="text"
											class="txtfield"></td>
									</tr>
									<tr>
										<td><label for="lanno"> Landline: </label></td>
										<td><input name="contrycode" maxlength="3" size="2"
											value="+91" readonly="readonly" type="text"><input
											name="lanstdcode" maxlength="5" size="3" type="text">
											<input name="lanno" maxlength="8" size="12" type="text"
											width="80%"></td>
									</tr>
									<tr>
										<td><label for="offlanno">Office Landline:</label></td>
										<td><input name="contrycode" maxlength="3" size="2"
											value="+91" readonly="readonly" type="text"><input
											name="offstdcode" maxlength="5" size="3" type="text">
											<input name="offlanno" maxlength="8" size="12" type="text"></td>
									</tr>
									<tr>


										<td align="right"></td>
										<td align="left"><input type="button" width="50%"
											name="submit" value="Validate"
											onclick="validateContactDetails();return false;"></td>

									</tr>

								</table>
							</div>

							<!-----------------------------Contact Details Ends---------------------------------->

							<!----------------------------Loan Details---------------------------------->

							<div class="TabbedPanelsContent">
								<table width="100%" height="200" border="0">

									<tr>
										<td width="20%"><label for="loanType">Loan Type:<span
												class="compulsary"> <font color="red">*</font></span></label></td>
										<td>
										
											<table>
											<tr>
											<td><div id="abc1">
												<input type="button" width="50%" name="demand"
													value="Demand" class="hide" id="demand" onclick="validatedemand()">
											</div></td>
											<td><div id="abc2">
												<input type="button" width="50%" name="term" id="term" value="Term"
													class="hide" onclick="validateterm()" >
											</div></td>
											</tr>
											</table>
											
											<div id="pqr1">
											<table>
													<tr>
														<td width="20%"><label for="timeLimit">Time
																Limit(in Months):<span class="compulsary"><font color="red">*</font>
															</span>
														</label></td>
														<td width="30%"><input type="text" name="timeLimit"
															title="Enter the time-limit here" class="txtfield"
															maxlength="25"></input></td>
													
													</tr>
													<tr>
														<td width="20%"><label for="demandType">Type:<span
																class="compulsary"><font color="red">*</font> </span>
														</label></td>
														<td width="30%"><select name="demandType"
															class="txtfield"><option value=""
																	selected="selected">--Select--
																<option value="Demand Fixed Deposit">Against
																	Fixed Deposits
																<option value="Demand House">Against House
																<option value="Demand Estate">Real
																	estate/Property
																<option value="Demand Share">Against Shares
																<option value="Demand Gold">Against Gold</option>
														</select></td>
													</tr>
												</table>
											</div>


											<div id="pqr2">
												<table>
													<tr>
														<td width="20%"><label for="premium">Premium:<span
																class="compulsary"><font color="red">*</font> </span>
														</label></td>
														<td width="30%"><input type="text" name="premium"
															title="Enter the premium here" class="txtfield"
															maxlength="25"></td>
													</tr>
													<tr>
														<td width="20%"><label for="periodPremium">Period
																of Premium:<span class="compulsary"><font
																	color="red">*</font> </span>
														</label></td>
														<td width="30%"><input type="text"
															name="periodPremium"
															title="Enter the period of premium here" class="txtfield"
															maxlength="25"></td>
													</tr>
													<tr>
														<td width="20%"><label for="termType">Type:<span
																class="compulsary"><font color="red">*</font> </span>
														</label></td>
														<td width="30%"><select name="termType"
															class="txtfield"><option value=""
																	selected="selected">--Select--
																<option value="Term Education">Education loan															
																<option value="Term Home">Home loan
																<option value="Term Car">Car loan
																<option value="Term Personal">Personal loan</option>
														</select></td>
													</tr>
												</table>
											</div>
											
										</td>
									</tr>

									<tr>

										<td width="20%"><label for="amtRequested">Amount
												Requested:<span class="compulsary"> <font color="red">*</font></span>
										</label></td>
										<td width="30%"><label> <input type="text"
												name="amtRequest" id="amtRequest" class="txtfield"/>
										</label><br></td>
									</tr>

									<tr>
										<td></td>
										<td align="left"><input type="submit" width="50%"
											name="submit" value="Save &amp; Continue"
											onclick="validateLoanDetails()"></td>
									</tr>
									<table height="300"><tr></tr></table>

								</table>
							</div>
						</div>
					</div> <!----------------------------Loan Details Ends---------------------------------->
							<script type="text/javascript">
	<!--
		var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
	</script>
				</td>
			</tr>
		</table>
	</form>
</body>