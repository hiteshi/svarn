<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<script src="/svarn/view/js/prototype.js">
	
</script>
<script src="/svarn/view/js/jquery.min.js"></script>
<script src="/svarn/view/js/jquery-ui.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Closing an Account</title>
<link href="/svarn/view/CSS/tabs.css" rel="stylesheet" type="text/css" />



<script language="Javascript">






$(document).ready(function(){

	
	$("#approve").click(function(){
		
		var amount=$("#amount").val();
		alert("value of selected======================"+amount);
		$.ajax({
			type: 'POST',
			url: '/svarn/approveClosing',
			data: "cmd="+registrationId+'&amount='+amount,
			dataType: 'html', 
		}).done(function(msg) {
			
			//alert("msg "+msg);
			document.getElementById("result").innerHTML=msg;
			
		}); 
		
		
		showTable();
	});
	
	
	
	$("#reject").click(function (){
	
		
		alert("value of selected======================"+registrationId);
		$.ajax({
			type: 'POST',
			url: '/svarn/rejecteClosing',
			data: "cmd="+registrationId+'&cid='+selected,
			dataType: 'html', 
		}).done(function(msg) {
			
			//alert("msg "+msg);
			document.getElementById("result").innerHTML=msg;
			
		}); 
		
		showTable();
	});
	
});







	var account=0;
	var selected=0;
	var ibs=10000;
	var registrationId=0;
	
	function xmlhttpPost(ii, id) 
	{
		registrationId=id;
		selected = ii;
		
		//alert("for redistarityon id ================               "+selected+", "+registrationId);
		new Ajax.Request("/svarn/ClosingDetails",
		{
				method: "post",
				parameters:"qq=" + ii,

				onComplete: function (asd){
				
					document.getElementById("result").innerHTML = asd.responseText;
				
				}
		});
		
		showTable();
	}
		
	function showTable()
	{
		
		var ii=9;			
		new Ajax.Request("/svarn/ClosingTable",
				{
				method: "post",
				parameters:"qq=" + ii,

				onComplete: function (asd){
					
				document.getElementById("applicationTable").innerHTML = asd.responseText;
				}
		});
		
	}
</script>

</head>
<body onload="showTable()">
	<ol id="toc">
		<li><a href="AccountApplication.jsp"><span>AccountApplication</span></a></li>
		<li><a href="IBSApplication.jsp"><span>IBSApplication</span></a></li>
		<li><a href="CompanyApplication.jsp"><span>CompanyApplication</span></a></li>
		<li><a href="LoanApplication.jsp"><span>LoanApplication</span>
		</a></li>
		<li><a href="Settings.jsp"><span>Settings</span></a></li>
		<li class="current"><a href="ClosingAccount.jsp"><span>ClosingAccount</span></a></li>
	</ol>
	<div class="content">
	<table border="1">
	<tr>
	<td width="400" height="600" >
	<div  id="applicationTable">
		
	</div>
	</td>
	<td width="600" height="600">
	<div id="result">
	
	
	</div>
	
	<input type="submit" id="reject" value="reject"/>
	<input type="submit" id="approve" value="approve"/>
	
	</td>
	</tr>
	</table>
	
	</div>
	
</body>
</html>
