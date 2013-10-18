<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>SVARN Bank</title>
<link href="/svarn/view/CSS/MyStyle.css" rel="stylesheet"
	type="text/css" />
<script src="/svarn/view/js/jquery-latest.js"></script>


<script type="text/javascript">
	$(document).ready(function() {

		$("#clear").click(function() {

			$.ajax({
				type: 'POST',
				url: '/svarn/registeribs',
				data: "cmd=FetchData",
				dataType: 'html', 
			}).done(function(msg) {
				
				//alert("msg "+msg);
				document.getElementById("detail").innerHTML=msg;
				
			}); 

		});
	});
</script>

</head>
<body>




	<div id="header">
		<jsp:include page="/view/generic/Header.jsp" flush="true" />
	</div>
	<div id="content">

		<form name="registrationForm" action="/svarn/employee" method="POST">
			<table width="1100" height="700" border="1">
				<tr>
					<td>
						<table border="1" align="center">
							<tr>
								<td align="center">
									<!--<form name="loginform" action="/svarn/login" method="POST">  -->
									<table width="400" height="230" border="1">
										<tr>
											<td width="20%">UserName:<span><font color="red">*</font>
											</span></td>
											<td width="30%" align="center"><input type="text"
												id="uname" name="uname"
												title="Enter your First-Name here" class="txtfield"
												maxlength="32" size="25"> <input type="hidden"
												name="sessId" value="<%=session.getId()%>" /></td>
										</tr>
										<tr>
											<td width="20%">Password:<span><font color="red">*</font>
											</span></td>
											<td width="30%" align="center"><input type="password"
												id="paswd" name="paswd" title="Enter your PASSWORD here"
												class="txtfield" maxlenght="32" size="25">
											</td>
										</tr>

										<tr>



											<td width="35%" align="left"><a href="path.jsp">Forgot password</a>
											</td>
											<td align="right"><input type="button" widht="50%"
												id="clear" name="clear" value="Clear"> <input
												type="submit" width="50%" name="submit" value="OK">
											</td>
										</tr>
									</table> <!-- </form> --></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</div>

	<div id="footer">
		<jsp:include page="/view/generic/Footer.jsp" flush="true" />
	</div>
</body>
</html>