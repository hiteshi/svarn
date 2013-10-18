<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>

	<%
	
	
	
// 	 if(session.getAttribute("authenticated")!=null && session.getAttribute("authenticated").equals(true))
// 	{
// 	   response.sendRedirect("/svarn/view/usermgmt/afterLogin/HomePageAfterLogin.jsp");
	
// 	} 	
	
	 
		
	%>
	<form name="loginform" action="/svarn/login" method="POST">
			<table width="400" height="210" border="0" align="center">
				<tr>
					<td>User Name</td><td> <input name="UserName" type="text" value="" />
					</td>
				</tr>
				<tr>
					<td>Password </td><td><input name="Password" type="password" value="" />
					</td>
				</tr>
				<tr><td>
					<input type="hidden" name="sessId" value="<%=session.getId()%>" /></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="button" value="CANCEL" id="show">
						<button id="ok" >LOGIN</button>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><a
						href="/svarn/view/usermgmt/home/Login_page.jsp">Forgot
							Password</a>
					</td>
				</tr>
			</table>
		</form>
</body>
</html>
