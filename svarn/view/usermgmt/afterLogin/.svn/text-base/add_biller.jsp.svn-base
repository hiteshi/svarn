
<%@page import="com.cdac.svarn.entities.Account"%>
<%@page import="com.cdac.svarn.entities.Company"%>
<%@page import="com.cdac.svarn.entities.Biller"%>
<%@page import="java.util.List"%>
<%
	String account_no = (String) session.getAttribute("account");
  	List<Company> companies=(List<Company>) session.getAttribute("companies");
  	List<Account> companyAcc=(List<Account>) session.getAttribute("companyAcc");
  	
	session.setAttribute("account_no", account_no);
%>
<form action="addBiller" method="post">
	<h3>
				ADD Biller
				</h3>
	<table height="300" width="850">
		
		<tr>
			<td>Select Biller</td>
			<td>:</td>
			<td>
			<select id="companiesName" name="companiesName" onchange="changeOn('setbillername')"><option value=""
						selected="selected" >--Select Biller--</option>
					<%
						for (int i = 0; i < companies.size(); i++) {
					%>
					<option value="<%=companies.get(i).getCompanyId()%>">
					<%=companies.get(i).getName()%>&nbsp;&nbsp;
					<%=companies.get(i).getContactPersonName()%>&nbsp;&nbsp;
					<%=companies.get(i).getContactPersonMobile()%>
					</option>
					<%
						}
					%>

			</select>
			
			

</td></tr><tr><td>Select Account</td>
			<td>:</td>
			<td id="billu"></td>
			
		</tr>
		
		<tr>
			<td >Biller Account No : </td>
			<td>:</td>
			<td><input id="compacc" type="text" readonly="readonly" name="compacc" maxlength="50" />
			</td>
		</tr>
		
		<tr>
			<td >Biller Name</td>
			<td>:</td>
			<td><input id="billername" type="text" name="billername" maxlength="50" />
			</td>
		</tr>
		
		<tr>
			<td>Nick Name</td>
			<td>:</td>
			<td><input id="nickname" type="text" name="nick" maxlength="50" />
			</td>
		</tr>
		<tr>
			<td>Transfer Limit</td>
			<td>:</td>
			<td><input type="text" id="limit" name="limit" maxlength="14" />
			<input id="tpself" type="hidden" name="tpself" value="oo" />
			</td>
		</tr>
		<tr>
			<td align="right" colspan="3"><input id="countinue"
				type="submit" value="Add" />
			</td>
		</tr>
	</table>
</form>
