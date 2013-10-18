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
<title>SVARN BANK : STATEMENT</title>
	<style type="text/css">
		* { padding: 0; margin: 0; }
		body {
			padding: 30px;
			font-family: Arial, Helvetica, sans-serif;
		}
		h1 {
			margin-bottom: 1em;
			border-bottom: 1px solid #ccc;
		}
		
		h2 {
			margin-bottom: 1em;
			border-bottom: 1px solid #ccc;
		}
		
		pre {
			border: 1px dotted #ccc;
			background: #f7f7f7;
			padding: 10px;
			margin-bottom: 1em;
		}
        
        h1 {
            margin-bottom: 0.7em;
        }
        
        h2 {
            margin-top: 1em;
        }
	</style>
	<script type="text/javascript" src="/svarn/view/js/base64.js"></script>
	<script type="text/javascript" src="/svarn/view/js/ sprintf.js"></script>
	<script type="text/javascript" src="/svarn/view/js/jspdf.js"></script>
</head>
<body>
<h2>Simple Two-page Text Document</h2>
<pre>var doc = new jsPDF();
doc.text(20, 20, 'Hello world!');
doc.text(20, 30, 'This is client-side Javascript, pumping out a PDF.');
doc.addPage();
doc.text(20, 20, 'Do you like that?');

// Output as Data URI
doc.output('datauri');</pre>
<a href="javascript:demo1()">Run Code</a>

<h2>Example of user input</h2>
<pre>var name = prompt('What is your name?');
var multiplier = prompt('Enter a number:');
multiplier = parseInt(multiplier);

var doc = new jsPDF();
doc.setFontSize(22);	
doc.text(20, 20, 'Questions');
doc.setFontSize(16);
doc.text(20, 30, 'This belongs to: ' + name);

for(var i = 1; i <= 12; i ++) {
	doc.text(20, 30 + (i * 10), i + ' x ' + multiplier + ' = ___');
}

doc.addPage();
doc.setFontSize(22);
doc.text(20, 20, 'Answers');
doc.setFontSize(16);

for(var i = 1; i <= 12; i ++) {
	doc.text(20, 30 + (i * 10), i + ' x ' + multiplier + ' = ' + (i * multiplier));
}	
doc.output('datauri');</pre>
<a href="javascript:demo4()"> Download PDF VERSION <img alt="pdf" src="view/Images/pdf.jpeg" ></a>



<script type="text/javascript">

function demo1() {
	var doc = new jsPDF();
	doc.text(20, 20, 'Hello world!');
	doc.text(20, 30, 'This is client-side Javascript, pumping out a PDF.');
	doc.addPage();
	doc.text(20, 20, 'Do you like that?');
	
	// Output as Data URI
	doc.output('datauri');
}

function demo2() {
	var doc = new jsPDF();
	doc.setFontSize(22);
	doc.text(20, 20, 'This is a title');
	
	doc.setFontSize(16);
	doc.text(20, 30, 'This is some normal sized text underneath.');	
	
	// Output as Data URI
	doc.output('datauri');
}

function demo3() {
	var doc = new jsPDF();
	doc.text(20, 20, 'This PDF has a title, subject, author, keywords and a creator.');
	
	// Optional - set properties on the document
	doc.setProperties({
		title: 'Title',
		subject: 'This is the subject',		
		author: 'James Hall',
		keywords: 'generated, javascript, web 2.0, ajax',
		creator: 'MEEE'
	});
	
	// Output as Data URI
	doc.output('datauri');
}

function demo4() {	
	var name = prompt('What is your name?');
	var multiplier = prompt('Enter a number:');
	multiplier = parseInt(multiplier);

	var doc = new jsPDF();
	doc.setFontSize(22);	
	doc.text(20, 20, 'SVARN BANK STATEMENT');
	doc.setFontSize(16);
	doc.text(20, 30, 'This belongs to: ' + name);
	
	for(var i = 1; i <= 12; i ++) {
		doc.text(20, 30 + (i * 10), i + ' x ' + multiplier + ' = ___');
	}
	
	doc.addPage();
	doc.setFontSize(22);
	doc.text(20, 20, 'Answers');
	doc.setFontSize(16);
	
	for(var i = 1; i <= 12; i ++) {
		doc.text(20, 30 + (i * 10), i + ' x ' + multiplier + ' = ' + (i * multiplier));
	}	
	doc.output('datauri');
	
}

</script>


<script type="text/javascript">
// Google Analytics

var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
</script>
<script type="text/javascript">
try {
var pageTracker = _gat._getTracker("UA-2746979-4");
pageTracker._trackPageview();
} catch(err) {}</script>

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
