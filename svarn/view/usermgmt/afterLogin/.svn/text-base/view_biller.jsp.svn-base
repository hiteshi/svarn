<%@page import="com.cdac.svarn.entities.Biller"%>
<%@page import="java.util.List"%>
<%
	String account_no = (String) session.getAttribute("account");
	List<Biller> billers = (List<Biller>) session.getAttribute("billers");
	session.setAttribute("account_no", account_no);
%>

<div class="polo">
	<form action="">
		<h3>VIEW BILLER</h3>
		<table border="1">
			<tr>
				<th>Account No</th>
				<th>NickName</th>
				<th>Transfer Limit</th>
				<th>Name</th>
			</tr>
			<%
				for (int i = 0; i < billers.size(); i++) {
			%>
			<tr>
				<td><%=billers.get(i).getBillerAccountNo()%></td>
				<td><%=billers.get(i).getBillerNickName()%></td>
				<td><%=billers.get(i).getBillerName()%></td>
				<td><%=billers.get(i).getTransferLimit()%></td>
			</tr>

			<%
				}
			%>


		</table>
	</form>
</div>