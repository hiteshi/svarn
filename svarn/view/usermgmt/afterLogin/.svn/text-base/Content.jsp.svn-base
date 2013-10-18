<%@page import="com.cdac.svarn.entities.Company"%>
<%@page import="com.cdac.svarn.entities.Biller"%>
<%@page import="java.util.List"%>
<%@page import="com.cdac.svarn.entities.ThirdParty"%>
<%@page import="com.cdac.svarn.entities.Account"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cdac.svarn.entities.Customer"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<style type="text/css">
.gbqfb {
    background-color: #4D90FE;
    background-image: -moz-linear-gradient(center top , #4D90FE, #4787ED);
    border: 1px solid #3079ED;
    color: #FFFFFF !important;
    -moz-border-radius: 2px 2px 2px 2px;
    
    
    border: 1px solid #C6C6C6;
    padding: 0 10px;
    
}

.gbqfi {
display: inline-block;
    height: 13px;
    margin: 7px 19px;
    width: 14px;
    }

</style>
<script type="text/javascript" src="/svarn/view/js/jquery-1.7.2.js"></script>
<script type="text/javascript"
	src="/svarn/view/js/AfterLoginDescription.js"></script>
	<script type="text/javascript" src="/svarn/view/js/setsomeval.js"></script>
	
	<!-- <script type="text/javascript" src="/svarn/view/js/prototype.js"></script> -->
	<script type="text/javascript">
	
	
	
	
	
	
	
	
	
	</script>
<script type="text/javascript" src="/svarn/view/js/changepage.js"></script>



<%
	Customer customer = (Customer) session.getAttribute("customer");
	System.out.println("CUSTOMER : "+customer.getCustFirstName());
	session.setAttribute("custFirstName",customer.getCustFirstName());
	session.setAttribute("custLastName",customer.getCustLastName());
	 List<Account> accounts = (List<Account>) session.getAttribute("accounts");
	List<ThirdParty> tps=(List<ThirdParty>) session.getAttribute("tps"); 
	List<Company> companies=(List<Company>) session.getAttribute("companies");
	List<Biller> billers=(List<Biller>) session.getAttribute("billers");
	List<Account> companyAcc=(List<Account>) session.getAttribute("companyAcc");
	
	
	
	
%>


</head>
<body>
<%-- <c:forEach items="${accounts}" var="acc">  --%>
<%--   TH VALUE : ${acc.accountNo} />  --%>
<%-- </c:forEach> --%>

	<table border="0">
		<tr>

			<td width="250" height="200" class="content_color">

				<ul>
					<li><a id="myHeader1"
						href="javascript:showonlyone('transfer');javascript:changeOn('pay');">Payment/Transfer</a>
					</li>
					<li><a id="myHeader2"
						href="javascript:showonlyone('profile');javascript:changeOn('pay');">Manage
							Profile</a>
					</li>
					<li><a id="myHeader3"
						href="javascript:showonlyone('thirdParty');javascript:changeOn('pay');">Manage
							Third Party</a>
					</li>
					<li><a id="myHeader4"
						href="javascript:showonlyone('autoDebit');javascript:changeOn('pay');">Manage
							Auto Debit</a>
					</li>
					<li><a id="myHeader5"
						href="javascript:showonlyone('biller');javascript:changeOn('pay');">Manage
							Biller</a>
					</li>
					<li><a id="myHeader6"
						href="javascript:showonlyone('statement');javascript:changeOn('pay');">View
							Statement</a>
					</li>

				</ul>
			</td>

			<td width="600" height="200">
				<table border="0">
					<tr>
						<td width="600" height="150" class="content_color">

							<div class="xfer" style="display: block">

								<table border="0" align="center"
									style="empty-cells: hide; bottom: auto; height: 150px; width: 600px; text-align: center;"
									class="sublinks">

									<tr>
										<td id="FundTransfer"><div name="newboxes" id="newboxes1"
												style="display: block;">
												<a href="javascript:changeOn('fundtransfer');"
													onmouseout="null1();"
													onmouseover="description('FundsTrasfer');">
<!-- 													<input type="button" class="gbqfb" value="funds xfer"> -->
<!-- 													<button id="butt" style="width:100;height:65" class="gbqfb" onmouseover="changeOn('cb')" onmouseout="changeOn('cbo');"> -->
													Funds
													transfer</button></a>
											</div></td>
										<td><div name="newboxes" id="newboxes2"
												style="display: block;">
												<a href="javascript:changeOn('thirdparty');"
													onmouseout="null1();"
													onmouseover="description('Third party transfer');">Third
													party transfer</a>
											</div></td>

									</tr>
									<tr>
										<td><div name="newboxes" id="newboxes2"
												style="display: block;">
												<a href="javascript:changeOn('dd');" onmouseout="null1();"
													onmouseover="description('Demand Draft');">Demand Draft</a>
											</div></td>
										<td><div name="newboxes" id="newboxes2"
												style="display: block;"></div></td>

									</tr>


								</table>


							</div> <!-- 							AFTER XFER DIV -->



							<div class="profile" style="display: none">

								<table border="0" align="center"
									style="empty-cells: hide; bottom: auto; height: 150px; width: 600px; text-align: center;"
									class="sublinks">

									<tr>
										<td><div name="newboxes" id="newboxes1"
												style="display: block;">
												<a href="javascript:changeOn('viewprofile');"
													onmouseout="null1();"
													onmouseover="description('View Profile');">View Profile</a>
											</div></td>
										<td><div name="newboxes" id="newboxes2"
												style="display: block;">
												<a href="javascript:changeOn('changemob');"
													onmouseout="null1();"
													onmouseover="description('Change Mobile number');">Change
													Mobile number</a>
											</div></td>

									</tr>
									<tr>
										<td><div name="newboxes" id="newboxes2"
												style="display: block;">
												<a href="javascript:changeOn('changepassword');"
													onmouseout="null1();"
													onmouseover="description('Change Password');">Change
													Password</a>
											</div></td>
										<td><div name="newboxes" id="newboxes2"
												style="display: block;"></div></td>

									</tr>


								</table>


							</div> <!-- 							AFTER PROFILE -->

							<div class="iiiparty" style="display: none">

								<table border="0" align="center"
									style="empty-cells: hide; bottom: auto; height: 150px; width: 600px; text-align: center;"
									class="sublinks">

									<tr>
										<td><div name="newboxes" id="newboxes1"
												style="display: block;">
												<a href="javascript:changeOn('add3p');javascript:changeOn('tpto');"
													onmouseout="null1();"
													onmouseover="description('Add Third Party');">Add Third
													Party</a>
											</div></td>
										<td><div name="newboxes" id="newboxes2"
												style="display: block;">
												<a href="javascript:changeOn('modify3p');"
													onmouseout="null1();"
													onmouseover="description('Modify Third Party');">Modify
													Third Party</a>
											</div></td>

									</tr>
									<tr>
										<td><div name="newboxes" id="newboxes2"
												style="display: block;">
												<a href="javascript:changeOn('view3p');"
													onmouseout="null1();"
													onmouseover="description('View Third Party');">View
													Third Party</a>
											</div></td>
										<td><div name="newboxes" id="newboxes2"
												style="display: block;">
												<a href="javascript:changeOn('delete3p');"
													onmouseout="null1();"
													onmouseover="description('Delete Third Party');">Delete
													Third Party</a>
											</div></td>

									</tr>


								</table>


							</div> <!-- 							AFTER IIIPARTY -->

							<div class="auto" style="display: none">

								<table border="0" align="center"
									style="empty-cells: hide; bottom: auto; height: 150px; width: 600px; text-align: center;"
									class="sublinks">

									<tr>
										<td><div name="newboxes" id="newboxes1"
												style="display: block;">
												<a href="javascript:changeOn('addad');"
													onmouseout="null1();"
													onmouseover="description('Add Auto Debit A/C');">Add
													Auto Debit A/C</a>
											</div></td>
										<td><div name="newboxes" id="newboxes2"
												style="display: block;">
												<a href="javascript:changeOn('modifyad');"
													onmouseout="null1();"
													onmouseover="description('Modify Auto Debit A/C');">Modify
													Auto Debit A/C</a>
											</div></td>

									</tr>
									<tr>
										<td><div name="newboxes" id="newboxes2"
												style="display: block;">
												<a href="javascript:changeOn('viewad');"
													onmouseout="null1();"
													onmouseover="description('View Auto Debit A/C');">View
													Auto Debit A/C</a>
											</div></td>
										<td><div name="newboxes" id="newboxes2"
												style="display: block;">
												<a href="javascript:changeOn('deletead');"
													onmouseout="null1();"
													onmouseover="description('Delete Auto Debit A/C');">Delete
													Auto Debit A/C</a>
											</div></td>

									</tr>


								</table>


							</div> <!-- 							AFTER AUTO -->

							<div class="biller" style="display: none">

								<table border="0" align="center"
									style="empty-cells: hide; bottom: auto; height: 150px; width: 600px; text-align: center;"
									class="sublinks">

									<tr>
										<td><div name="newboxes" id="newboxes1"
												style="display: block;">
												<a href="javascript:changeOn('addbill');javascript:changeOn('tpto');"
													onmouseout="null1();"
													onmouseover="description('Add Biller');">Add Biller</a>
											</div></td>
										<td><div name="newboxes" id="newboxes2"
												style="display: block;">
												<a href="javascript:changeOn('modifybill');"
													onmouseout="null1();"
													onmouseover="description('Modify Biller');">Pay Bills
													</a>
											</div></td>

									</tr>
									<tr>
										<td><div name="newboxes" id="newboxes2"
												style="display: block;">
												<a href="javascript:changeOn('viewbill');"
													onmouseout="null1();"
													onmouseover="description('View Biller');">View Biller</a>
											</div></td>
										<td><div name="newboxes" id="newboxes2"
												style="display: block;">
												<a href="javascript:changeOn('deletebill');"
													onmouseout="null1();"
													onmouseover="description('Delete Biller');">Delete
													Biller</a>
											</div></td>

									</tr>


								</table>


							</div> <!-- 							AFTER BILLER -->


							<div class="stmt" style="display: none">

								<table border="0" align="center"
									style="empty-cells: hide; bottom: auto; height: 150px; width: 600px; text-align: center;"
									class="sublinks">

									<tr>
										<td><div name="newboxes" id="newboxes1"
												style="display: block;">
												<a href="javascript:changeOn('viewstmt');"
													onmouseout="null1();"
													onmouseover="description('View Statement');">View
													Statement</a>
											</div></td>
										<td><div name="newboxes" id="newboxes2"
												style="display: block;"></div></td>

									</tr>
									<tr>
										<td><div name="newboxes" id="newboxes2"
												style="display: block;"></div></td>
										<td><div name="newboxes" id="newboxes2"
												style="display: block;"></div></td>

									</tr>


								</table>


							</div> <!-- 							AFTER STMT --></td>
						<!-- 							end of table having sublinks -->
					</tr>
					<tr>
						<td width="600" height="50" class="content_color" id="description">description</td>
					</tr>

				</table>
			<td width="250" height="200" class="content_color">
				<ul>
					<li><%=customer.getCustFirstName()%>&nbsp;&nbsp;<%=customer.getCustLastName()%>
						, welcome to Svarn.</li>
					<li>Last Login : <%=session.getAttribute("LastLogin")%></li>
					<li><a href="/svarn/logout">Logout</a>
					</li>

				</ul>
		</tr>
	</table>

	<table border="0">
		<tr>
			<td width="850" height="400">


				<table border="0">
					<tr>
						<td><input type="hidden" id ="fromAccount1" name="fromacc">    <select id="accountNo" name="branchCity" class="txtfield" onchange="javascript:setMainAccount();"><option
									value="selectvalue" selected="selected">--Select account--</option>
								 <%
								 System.out.println(accounts.size());
					for (int i = 0; i < accounts.size(); i++) {
				%>
								<option  value="<%=accounts.get(i).getAccountNo()%>" >
									<%=accounts.get(i).getAccountNo()%>/
									<%=accounts.get(i).getNickName()%>&nbsp;&nbsp;&nbsp;&nbsp;
									<%=accounts.get(i).getBranch().getBranchCode()%>&nbsp;&nbsp;&nbsp;&nbsp;
									<%=accounts.get(i).getAccountType()%>&nbsp;&nbsp;&nbsp;&nbsp;
									<%=accounts.get(i).getCurrentBalance()%>
								</option>

								<%
					}
				%> 
						</select></td>
					</tr>
					<tr>
						<td><div id="afterlogindiv" class="polo"></div></td>
					</tr>

					<!-- <div id="afterlogindiv" class="polo"> <a class="lalsitara"> Welcome Customer!! </a> Please select something... -->
				</table></td>

			<td width="250" height="500" class="content_color">News</td>

		</tr>

	</table>

</body>
</html>