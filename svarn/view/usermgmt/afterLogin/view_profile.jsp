<%@page import="com.cdac.svarn.entities.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    

<%@page import="java.util.List"%>
<%
	String account_no = (String) session.getAttribute("account");
  	List<Customer> companyAcc=(List<Customer>) session.getAttribute("viewProfile");
	session.setAttribute("account_no", account_no);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="polo">
<div id="billu">

</div>
</div>