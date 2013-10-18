<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>

<script type="text/javascript" src="/svarn/view/js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$(".hide").click(function() {
			$("#abc").hide();
			$("#pqr").slideToggle("slow");

		});
		$("#show").click(function() {
			$("#pqr").hide();
			$("#abc").slideToggle("slow");
			//$("#abc").show();
			//$("#pqr").slideToggle("slow");

		});

	});
</script>


<style type="text/css">
div #pqr {
	display: none;
}
</style>
</head>
<body>

	<div id="abc">
		<table width="400" height="210" border="0">
			<tr>
				<td>&nbsp;Login</td>
			</tr>
			<tr>
				<td align="center">
					<!-- <a class="hide" href="/svarn/view/usermgmt/home/Login_page.jsp">Personal Banking</a> -->
					<button class="hide">Personal Banking</button>
				</td>
			</tr>
			<tr>
				<td align="center">
					<!-- <a class="hide" href="/svarn/view/usermgmt/home/Login_page.jsp">Corporate Banking</a> -->
					<button class="hide">Corporate Banking</button>
				</td>
			</tr>
			<tr>
				<td align="center"><a
					href="/svarn/view/usermgmt/home/ibs.jsp"><b>Register for IBS</b></a>
				</td>
			</tr>
		</table>
	</div>



	<div id="pqr">
		<form name="loginform" action="/svarn/login" method="POST">
			<table width="400" height="210" border="0">
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
						<button id="ok">LOGIN</button>
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
	</div>
</body>
</html>