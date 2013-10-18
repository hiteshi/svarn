<%-- <%@page import="in.cdac.svarn.entities.Registration"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>SVARN Bank</title>
<link href="/svarn/view/CSS/MyStyle.css" rel="stylesheet"
	type="text/css" />
 
	
</head>
<body onload="showTable()">
<% String a=(String)request.getAttribute("selectEmployee");%>
<% ArrayList<Registration> users = (ArrayList<Registration>)request.getAttribute("U");%>
<% session.setAttribute("users",users); %>
	
	<div id="header">
		<jsp:include page="/view/generic/Header.jsp" flush="true" />
	</div>

	<div id="content">
		<% if  (a.equals("1")) { %>
		<jsp:include page="/view/employeemgmt/AdminContent.jsp" flush="true" />
		<%} %>
		<% if  (a.equals("2")) { %>
		<jsp:include page="/view/employeemgmt/ManagerContent.jsp" flush="true" />
		<%} %>
		<% if  (a.equals("3")) { %>
		<jsp:include page="/view/employeemgmt/EmployeeContent.jsp" flush="true" />
		<%} %>
	</div>
	<div id="footer">
		<jsp:include page="/view/generic/Footer.jsp" flush="true" />
	</div>

</body>
</html> --%>