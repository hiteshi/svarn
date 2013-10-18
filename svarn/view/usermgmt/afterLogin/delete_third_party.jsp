
<%@page import="com.cdac.svarn.entities.ThirdParty"%>
<%@page import="java.util.List"%>
<%
	List<ThirdParty> tps1 = (List<ThirdParty>) session.getAttribute("tps");
// session.setAttribute("acct_no",tps1.get(0).getSelfAccountNo());
%>


<form action="deleteThirdParty" method="post">


<h3>Please select the Third Party you want to delete from the drop down list.</h3>

	<%
		for (int i = 0; i < tps1.size(); i++) {
	%>
		<input id="<%=tps1.get(i).getTpAccountNo()%>" type="radio" name="3p"  onchange="radiosel('hello','<%=tps1.get(i).getTpAccountNo()%>'),addtpto()" ><%=tps1.get(i).getTpAccountNo()%>&nbsp;<%=tps1.get(i).getTpName()%>&nbsp;<%=tps1.get(i).getTpNickName()%>&nbsp;<%=tps1.get(i).getTransferLimit()%><br>
		
		
	
	<%
		}
	%>
	<input id="tpself" type="hidden" name="tpself" value="oo" />
	<div id="billu"></div>
<input type="submit" value="Delete">
</form>


