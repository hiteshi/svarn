<%@page import="com.cdac.svarn.entities.Biller"%>
<%@page import="java.util.List"%>
<%
	String account_no = (String) session.getAttribute("account");
  	List<Biller> billers=(List<Biller>) session.getAttribute("billers");
	session.setAttribute("account_no", account_no);
%>

<!--  THIS IS ACTUALLY PAY BILLS -->


<div class="polo">

	<table>
		<tr>
			<td><div
					style="height: 100px; width: 416px; border-bottom: 1px solid red;">
					list all own account : transfer from account</div></td>
			<td><div
					style="height: 100px; width: 416px; border-bottom: 1px solid blue;">list
					all own account : transfer to account</div></td>
		</tr>
	</table>

	<form action="payBiller" method="post">
		<table height="300" width="850">
			<tr>DELETE BILLER
			</tr>
			<tr>

				<td>Select Biller to Delete</td>
				<td>:</td>
				<td>
<!-- 				<select> -->
<!-- 						<option value="op1">Hiiiii</option> -->
<!-- 						<option value="op2">abc</option> -->
<!-- 						<option value="op3">cdef</option> -->
<!-- 						<option value="op4">hello</option> -->
<!-- 				</select> -->
				<%
		for (int i = 0; i < billers.size(); i++) {
	%>
		<input id="<%=billers.get(i).getBillerAccountNo()%>" type="radio" name="3p"  onchange="radiosel('biller','<%=billers.get(i).getBillerAccountNo()%>'),changeOn('tpto')" ><%=billers.get(i).getBillerAccountNo()%>&nbsp;<%=billers.get(i).getBillerName()%>&nbsp;<%=billers.get(i).getBillerNickName()%>&nbsp;<%=billers.get(i).getTransferLimit()%><br>
		
		
	
	<%
		}
	%>			
				
				</td>
			</tr>
			<tr><div id="billu"></div>
			</tr>
			<tr>
					<td>Amount <a class="lalsitara">*</a> : <input
						id="tochangeamnt" type="text" name="tochangeamnt"> <input id="hidd"
						type="hidden" name="accTo">
						
						<input id="hidd2"
						type="hidden" name="accFrom">
						
						</td>
					

				</tr>
			<tr>
					<td>Remarks : <input id="remarks" type="text" maxlength="25" name="remarks">
<!-- 					<input -->
<!-- 						id="accountFrom" type="text" value="accFrom" name="accFrom"> -->
						
						
						
						
						</td>
					</tr>
					
					
			<input id="tpself" type="hidden" name="self" value="oo" />
		
		</table>
		<input type="submit" value="Delete">
	</form>
</div>
<div style="height: 50px; width: 850px; border-top: 1px solid red">list
	all own account : transfer to account</div>
</div>