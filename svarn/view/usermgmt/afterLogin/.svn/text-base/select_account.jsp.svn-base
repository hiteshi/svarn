
<%@page import="java.util.ArrayList"%>
<%@page import="in.cdac.svarn.entities.*"%>

<table>
	<tr>
		<td ><select name="branchCity" class="txtfield" ><option
					value="" selected="selected">--Select account--</option>
				<%
					for (int i = 0; i < noOfAccounts; i++) {
				%>
				<option value="<%=accounts.get(i).getAccountNo()%>">
					<%=accounts.get(i).getAccountNo()%>/
					<%=accounts.get(i).getNickName()%>&nbsp;&nbsp;&nbsp;&nbsp;
					<%=accounts.get(i).getBranchCode()%>&nbsp;&nbsp;&nbsp;&nbsp;
					<%=accounts.get(i).getAccountType()%>&nbsp;&nbsp;&nbsp;&nbsp;
					<%=accounts.get(i).getCurrentBalance()%>
				</option>

				<%
					}
				%>
		</select>
		</td>
	</tr>


</table>

