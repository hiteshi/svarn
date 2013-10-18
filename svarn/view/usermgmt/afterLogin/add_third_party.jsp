
<%String account_no=(String)session.getAttribute("account");

	session.setAttribute("account_no", account_no);

%>
<form action="addThirdParty" method="post">
		<table height="300" width="850">
			<tr><h1>ADD THIRD PARTY </h1>
			</tr>
			<tr>
				<td>Name</td>
				<td>:</td>
				<td><input id="name"  type="text" name="name" maxlength="50" /></td>
			</tr>
			<tr>
				<td>Account Number</td>
				<td>:</td>
				<td><input id="accno" type="text" name="accno" maxlength="12" /></td>
			</tr>
			<tr>
				<td>Nick Name</td>
				<td>:</td>
				<td><input id="nickname" type="text" name="nick" maxlength="50" />
				<input id="tpself" type="hidden" name="tpself" value="oo" />
				</td>
			</tr>
			<tr>
				<td>Transfer Limit</td>
				<td>:</td>
				<td><input type="text" id="limit" name="limit" maxlength="14" />
				</td>
			</tr>
			<tr>
				<td align="right" colspan="3"><input id="countinue"
					type="submit" value="Add" /></td>
			</tr>
		</table>
</form>
