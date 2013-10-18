
<%@page import="com.cdac.svarn.entities.ThirdParty"%>
<%@page import="java.util.List"%>
<%
	List<ThirdParty> tps1 = (List<ThirdParty>) session.getAttribute("tps");
%>


<table border="1">
	<tr>
		<th>Name</th>
		<th>Account No.</th>
		<th>Nick Name</th>
		<th>Transfer Limit</th>
	</tr>

	<%
		for (int i = 0; i < tps1.size(); i++) {
	%>
	<tr>
		<td><%=tps1.get(i).getTpName()%></td>
		<td><%=tps1.get(i).getTpAccountNo()%></td>
		<td><%=tps1.get(i).getTpNickName()%></td>
		<td><%=tps1.get(i).getTransferLimit()%></td>
	</tr>
	<%
		}
	%>
</table>
