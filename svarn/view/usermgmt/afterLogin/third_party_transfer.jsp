<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@page import="in.cdac.svarn.entities.ThirdParty"%> --%>
<%-- <%@page import="java.util.ArrayList"%> --%>
<%-- <% --%>
<!-- // <!-- 	ArrayList<ThirdParty> tps1 = (ArrayList<ThirdParty>) session.getAttribute("tps"); -->
<!-- %> -->

<div class="polo">


	<table>
		<tr>
			<td><div class="smalldivz"
					style="height: 100px; width: 416px; border-bottom: 1px solid red;">
					<p>list all own account : transfer from account</p>
<%-- 					<c:forEach items="${tps}" var="qq"> --%>
					
<%-- 							hello ${qq.thirdPartyAccountNo} --%>
						
<%-- 					</c:forEach> --%>
<!-- 					<select name="xxx1" id="xxx1" onchange="javascript:sethiddenval('')" > -->
							
<!-- 							<option selected="selected">Select Account   </option> -->
<%-- 							<c:forEach items="${tps}" var="from"> --%>
								
<%-- 								<option> 	${from.thirdPartyAccountNo}   --%>
<%-- 											${from.nameOfThirdParty}  --%>
<%-- 											${from.transferLimit} --%>
<%-- 											${from.tpNickName} --%>
<!-- 											</option> -->
<%-- 							</c:forEach> --%>
<!-- 						</select> -->
					</div></td>
			<td><div class="smalldivz"
					style="height: 100px; width: 416px; border-bottom: 1px solid blue; text-align: center;">
					<p>Please select an account where you want to transfer money...  

							<select name="xxx" id="xxx" onchange="javascript:sethiddenval()" >
							
							<option value="selectvalue" selected="selected">Select Account   </option>
							<c:forEach items="${tps}" var="from">
								
								<option value="${from.tpAccountNo}"> 	${from.tpAccountNo}  
											${from.tpName} 
											${from.transferLimit}
											${from.tpNickName}
											</option>
							</c:forEach>
						</select>


				</div></td>


		</tr>

	</table>
	<div style="height: 300px; width: 850px;">

		<form action="tpXfer" method="post">
			<table height="300" width="850" align="center" border="1"
				style="text-align: center;">

				<tr>
					<!-- 				<td colspan="3">Please fill in the required details, Thank you -->
					<!-- 					!!</td> -->





				</tr>
				<tr>
					<td>Amount <a class="lalsitara">*</a> : <input
						id="tochangeamnt" type="text" name="tochangeamnt" maxlength="10"> <input id="hidd"
						type="hidden" name="accTo">
						
						<input id="hidd2"
						type="hidden" name="accFrom">
						
						</td>
					<td>5</td>
					<td>6</td>

				</tr>
				<tr>
					<td>Remarks : <input id="remarks" type="text" maxlength="70" name="remarks">
<!-- 					<input -->
<!-- 						id="accountFrom" type="text" value="accFrom" name="accFrom"> -->
						
						
						
						
						</td>
					<td>5</td>
					<td>6</td>

				</tr>
				<tr>
					<td><button>Ok</button>
						<button type="reset">Reset</button>
					</td>
					<td>8</td>
					<td>9</td>

				</tr>

			</table>
		</form>
	</div>
	<div style="height: 100px; width: 850px; border-top: 1px solid red">list
		all own account : transfer to account</div>


</div>