
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
	function validatefund() {
		var msg = "";
		var regexp = /^[a-zA-Z\-\,\.\_\;\:\r\n ]*$/;
		var numericExpression = /^[0-9]+$/;
		var remarkRegex = /^[a-zA-Z\-\,\.\_\;\:\r\n ]*$/;

		if (trim(document.forms[0].tochangeamnt.value) == "") {
			msg += "Amount is required\n";
		} else {

			txtvalue = document.forms[0].tochangeamnt.value;

			if (!txtvalue.match(numericExpression)) {
				msg += "Amount can only be numbers\n";
			}

		}
		if (trim(document.forms[0].remarks.value) == "") {
			msg += "First name is required\n";
			//alert("llllllllllllll"+msg);
		} else {
			txtvalue = document.forms[0].remarks.value;
			remarkRegex = /^[a-zA-Z\-\,\.\_\;\:\r\n ]*$/;
			if (!txtvalue.match(remarkRegex)) {
				msg += "Only alphabets are allowed in Remarks\n";

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




<div class="polo">


	<table>
		<tr>
			
			<td><div class="smalldivz"
					style="height: 100px; width: 845px; border-bottom: 1px solid blue; text-align: center;">
					<p>
						Please select an account where you want to transfer money...<br> <select
							name="xxx" id="xxx" onchange="javascript:sethiddenval('')">

							<option selected="selected">Select Account</option>
							<c:forEach items="${accounts}" var="acc">

								<option value="
									${acc.accountNo}">${acc.accountNo}&nbsp;&nbsp;&nbsp;
									${acc.currentBalance}&nbsp;&nbsp;&nbsp; 
									${acc.accountType}&nbsp;&nbsp;&nbsp; 
									${acc.nickName }&nbsp;&nbsp;&nbsp;
									${acc.branch.branchCode}</option>
							</c:forEach>
						</select>
				</div></td>


		</tr>

	</table>
	<div style="height: 300px; width: 850px;">

		<form action="fundXfer" method="post">
			<table height="300" width="850" align="center" border="0"
				style="text-align: center;">

				<tr>
					<td colspan="3">Please fill in the required details, Thank you
						!!</td>





				</tr>
				<tr>
					<td>Amount <a class="lalsitara">*</a> : <input
						id="tochangeamnt" type="text" name="tochangeamnt"> <input
						id="hidd" type="hidden" name="accTo"> <input id="hidd2"
						type="hidden" name="accFrom">

					</td>
					<td></td>
					<td></td>

				</tr>
				<tr>
					<td>Remarks : <input id="remarks" type="text" maxlength="25"
						name="remarks"> 


					</td>
					<td></td>
					<td></td>

				</tr>
				<tr>
					<td><button type="reset">Reset</button>
						<button onclick="validatefund();return false;">Ok</button></td>
					<td></td>
					<td></td>

				</tr>

			</table>
		</form>
	</div>
	<div style="height: 100px; width: 850px; border-top: 1px solid red">
		</div>


</div>