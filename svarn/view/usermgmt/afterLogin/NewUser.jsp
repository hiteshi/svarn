<%@ page contentType="text/html; charset=UTF-8"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/svarn/view/CSS/MyStyle.css" rel="stylesheet"
	type="text/css" />
<script src="/svarn/view/js/jquery-latest.js"></script>
<!-- <script src="/svarn/view/js/jquery-ui.min.js"></script> -->

<% String logId=(String)request.getAttribute("loginId"); %>


<script type="text/javascript">

	$(function() {

		$('#submit').attr("disabled", true);
		
		 $("#username").blur(function(){
			
			 var uname = $("#username").val(); 
			//alert("User name = "+uname); 
			if(uname != null || uname != ""){
			
				
				$.ajax({
					
					type: 'POST',
					url: '/svarn/searchuser',
					data: 'cmd=check'+'&uname='+uname, 
					dataType: 'html',
					
				}).done(function(msg) {
					
					if(uname == "" || uname == null)
					{
						$("#result").html("Enter User Name");
						$("#result").css("color","blue");
					}else {
						if(msg==1) {
							
							$("#result").html("Available");
							$("#result").css("color","green");
						}
						else{
							
							$("#result").html("NotAvailable");
							$("#result").css("color","red");
						}
					}
				});
			} else {
				
				$("#result").html("Enter User Name");
				$("#result").css("color","blue");
			}
		}); 
		
		$("#repaswd").blur(function() {
			
			//alert("called"); 
			var paswd = $("#paswd").val();
			var repaswd = $("#repaswd").val();
			if (paswd == repaswd) {

				$('#submit').attr("disabled", false);

			} else {
				$('#submit').attr("disabled", true);
				alert("Passwords not Match")
			}
		});
	});
</script>
</head>
<body>




	<div id="header1">
		<jsp:include page="/view/generic/Header.jsp" flush="true" />
	</div>
	<form action="/svarn/paswdreset" method="post">
	<div id="content">
		<table width="1100" height="700" >
			<tr>
				<td align="center">
					CHOOSE YOUR USER NAME
				</td>
			</tr>
			<tr>
				<td align="center">
					<div id="available">
					<table>
						<tr>
							<td><list>User Name</list></td>
							<td><font color="red"> *</font>
							</td>
							<td><list>:</list>
							</td>
							<td><input id="username" name="username" type="text">
							</td>
							<td><input id="cid" name="cid" type="hidden" val="" />
							</td>
							<td id="result" width="100px"></td>
						</tr>
					</table>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					
						<table align="center" >
							<tr>
								<td>Please Enter New Password<font color="red">*</font></td>
								<td>:</td>
								<td><input id="paswd" name="paswd" type="password"
									maxlength="30">
								</td>
							</tr>
							<tr>
								<td>Re-enter New Password<font color="red">*</font></td>
								<td>:</td>
								<td><input id="repaswd" name="repaswd" type="password"
									maxlength="30"></td>
							</tr>
							<tr>
								<td>Transaction Password<font color="red">*</font></td>
								<td>:</td>
								<td><input id="tpaswd" name="tpaswd" type="password"
									maxlength="30"></td>
							</tr>
							<tr>
								<td>Re-enter Transaction Password<font color="red">*</font></td>
								<td>:</td>
								<td><input id="retpaswd" name="retpaswd" type="password"
									maxlength="30"></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td><input id="loginid" name="loginid" type="hidden"
									value="<%=logId %>"></td>
							</tr>
							
							<tr>
								<td colspan="4" align="right"><input id="submit"
									type="submit" value=" Submit ">
								</td>
							</tr>
						</table>
					</td>
			</tr>
		</table>
	</div>
	</form>
	<div id="footer">
		<jsp:include page="/view/generic/Footer.jsp" flush="true" />
	</div>

</body>
</html>