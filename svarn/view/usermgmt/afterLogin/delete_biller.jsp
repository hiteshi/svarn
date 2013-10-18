<%@page import="com.cdac.svarn.entities.Biller"%>
<%@page import="java.util.List"%>
<%
	String account_no = (String) session.getAttribute("account");
	List<Biller> billers = (List<Biller>) session
			.getAttribute("billers");
	session.setAttribute("account_no", account_no);
%>


<div class="polo">

	<h3>DELETE BILLER</h3>
	<form action="deleteBiller" method="post">
		<table >

			<tr>

				<td>Select Biller to Delete</td>
				<td>:</td>
				<td>
					<%
						for (int i = 0; i < billers.size(); i++) {
					%> 
					
					<input id="<%=billers.get(i).getBillerAccountNo()%>" type="radio"
					name="3p"
					onchange="radiosel('biller','<%=billers.get(i).getBillerAccountNo()%>'),changeOn('tpto')"><%=billers.get(i).getBillerAccountNo()%>&nbsp;<%=billers.get(i).getBillerName()%>&nbsp;<%=billers.get(i).getBillerNickName()%>&nbsp;<%=billers.get(i).getTransferLimit()%><br>

					<%
						}
					%>

				</td>
			</tr>
			
		</table>
		<input id="tpself" type="hidden" name="self" value="oo" />
			<div id="billu"></div>
		<input type="submit" value="Delete">
	</form>
</div>
<div style="height: 50px; width: 850px; border-top: 1px solid red">list
	all own account : transfer to account</div>
</div>