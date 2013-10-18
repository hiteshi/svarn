<%@page import="java.util.Calendar"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.cdac.svarn.entities.Transaction"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="/svarn/view/CSS/MyStyle.css" rel="stylesheet"
	type="text/css" />
<div id="header1">
	<jsp:include page="/view/generic/Header.jsp" flush="true" />
</div>

<div id="content">


	<html>
<head>
<%
	List<Transaction> trans = (List<Transaction>) request
			.getAttribute("trans");

	String startDate = (String) session.getAttribute("startdate");
	String endDate = (String) session.getAttribute("enddate");

	System.out.println("in jsp stmt : sdate" + startDate);

	DateFormat formatter;
	Date sdate = null;
	Date edate = null;
	formatter = new SimpleDateFormat("yyyy-MM-dd");
	try {
		sdate = (Date) formatter.parse(startDate);
		edate = (Date) formatter.parse(endDate);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		System.out.println("in catch of date");
		e.printStackTrace();
	}

	Long time = edate.getTime();

	time += (1000L * 60 * 60 * 24 - 1000);

	edate.setTime(time);
	System.out.println("date we got for s date :" + sdate);
	System.out.println("date we got for e date :" + edate);

	// 	DateFormat formatter1 ;
	// 	formatter = new SimpleDateFormat("dd");
	// 	Calendar cal = Calendar.getInstance();
	// 	   System.out.println("CALENDER PART :"+DateFormat.DATE_FIELD);
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<td><b>Return Back :</b>
			</td>
			<td width="700" align="center">
				<form action="xs" method="post">
					<button>Back</button>
				</form>
			</td>
		</tr>
	</table>
	</br>
	</br>

	<table border="1">



		<tr>
			<th>Transaction Amount</th>
			<th>Transaction Type</th>
			<th>Transaction Date</th>
			<th>Remarks</th>
			<th>Credit/Debit</th>


		</tr>
		<%
			for (int i = 0; i < trans.size(); i++) {
				if ((trans.get(i).getTransactionDate().after(sdate))
						&& (trans.get(i).getTransactionDate().before(edate))) {
		%>

		<tr align="center" style="list-style: disc;">
			<td style="text-align: center; list-style-type: circle;"><%=trans.get(i).getTransactionAmount()%></td>
			<td style="text-align: center;"><%=trans.get(i).getTransactionType()%></td>
			<td style="text-align: center;"><%=trans.get(i).getTransactionDate()%></td>
			<td style="text-align: center;"><%=trans.get(i).getRemarks()%></td>
			<td style="text-align: center;"><%=trans.get(i).getCreditDebit()%></td>

		</tr>


		<%
			}
			}
		%>
		<tr>
			<th>Return Back</th>
			<td colspan="4" align="center"><form action="xs" method="post">
					<button>Back</button>
				</form>
		</tr>
	</table>
</body>
	</html>
</div>
<div id="footer">
	<jsp:include page="/view/generic/Footer.jsp" flush="true" />
</div>