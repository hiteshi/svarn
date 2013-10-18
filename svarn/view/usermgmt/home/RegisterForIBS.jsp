<script src="/svarn/view/js/jquery.min.js"></script>
<script src="/svarn/view/js/jquery-ui.min.js"></script>
<script type="text/javascript">
//-->

$(document).ready(function(){
	/////////////////////////////////////
	 /* $("#username").blur(function foo(){
		//alert("called");
		var uname=$("#username").val();
		
		//alert(str);	
		$.ajax({
			type: 'POST',
			url: '/svarn/serchuser',
			data: 'cmd=check'+'&uname='+uname, 
			dataType: 'html', 
		}).done(function(msg) {
			/* alert("msg "+msg); *//*
			if(msg==1) {
				$("#result").html("Available");
				$("#result").css("color","green");
			}
			else{
				$("#result").html("NotAvailable");
				$("#result").css("color","red");
			}
		}); 
	});  */
	/////////////////working/////////////////
	
	$("#ok").click(function FetchData(){
		/* alert("called"); */
		var custid=$("#custid").val();
		var accno=$("#accno").val();
		$("#cid").val(custid);

		
		//alert(str);
		$.ajax({
			type: 'POST',
			url: '/svarn/registeribs',
			data: "cmd=FetchData"+'&cid='+custid+'&acc='+accno,
			dataType: 'html', 
		}).done(function(msg) {
			
			//alert("msg "+msg);
			document.getElementById("detail").innerHTML=msg;
			
		}); 
	});
});

</script>

<table height="700" width="400" align="center">
<tr><td height="200" width="400">
<div id="tabl">
	<fieldset>
		<legend>APPLY FOR IBS</legend>
		<table height="200" width="400">

			<tr>
				<td><list>Customer Id</list></td>
				<td><font color="red"> *</font>
				</td>
				<td><list>:</list>
				</td>
				<td><input id="custid" name="custid" type="text" maxlength="10" />
				</td>
			</tr>
			<tr>
				<td><list>Account No</list></td>
				<td><font color="red"> *</font>
				</td>
				<td><list>:</list>
				</td>
				<td><input id="accno" name="accno" type="text" maxlength="10" />
				</td>
			</tr>
			<tr>
				<td colspan="4" align="right"><input id="ok" type="submit"
					value=" OK " /></td>
			</tr>
		</table>
	</fieldset>
</div>
</td></tr><tr><td>
<div id="detail">
		<table height="200" width="400"><tr><td>
		<!-- <fieldset>
			<legend>CONFORM THE DETAILS</legend>
			<table height="200" width="400">
				<tr>
					<td><list>Customer First Name</list></td>
					<td><list>:</list>
					</td>
					<td><input id="cname" name="cname" readonly type="text" />
					</td>
				</tr>
				<tr>
					<td><list>Phone No</list></td>
					<td><list>:</list>
					</td>
					<td><input id="phno" name="phno" type="text" maxlength="10"
						value="" />
					</td>
				</tr>
				<tr>
					<td><list>Email Id</list></td>
					<td><list>:</list>
					</td>
					<td><input id="emid" name="emid" type="text">
					</td>
					<td><input id="accnum" name="accnum" type="hidden" val="" />
					</td>
				</tr>
				<tr>
					<td colspan="4" align="right"></td>
				</tr>
				<tr>
					<td colspan="4" align="right"><input id="countinue"
						type="submit" value=" Countinue ">
					</td>
				</tr>
			</table>
		</fieldset> -->
		</td></tr></table>
	
</div></td></tr>
</table>

<!-- <div id="available">
	 
		<fieldset>
			<legend>CHOOSE YOUR USER NAME</legend>
			<table height="200" width="350">
				<tr>
					<td><list>User Name</list></td>
					<td><font color="red"> *</font>
					</td>
					<td><list>:</list>
					</td>
					<td><input id="username" name="username" type="text">
					</td>
					<td> <input id="cid" name="cid" type="hidden" val=""/> </td>
					<td id="result" width="100px">
					</td>
				</tr>
				<tr>
					<td colspan="4" align="right"><input id="countinue"
						type="submit" value=" Countinue ">
					</td>
				</tr>
			</table>
		</fieldset>
		
	</div> -->
