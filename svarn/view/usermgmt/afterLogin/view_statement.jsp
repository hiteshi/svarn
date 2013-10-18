<link href="/svarn/view/CSS/jquery-ui.css" rel="stylesheet" type="text/css" />
 <script src="/svarn/view/js/jquery.min.js"></script>
 <script src="/svarn/view/js/jquery-ui.min.js"></script>

<script>
  $("#datepicker1").focus(function () {
  
			$( "#datepicker1" ).datepicker({dateFormat: 'yy-mm-dd', yearRange: "1950:2025", showAnim: 'fold', showOptions: {showSpeed:'0'},  changeMonth:true,changeYear:true});
			/* $( "#datepicker2" ).datepicker({dateFormat: 'yy-mm-dd', yearRange: "1950:2025", showAnim: 'fold', showOptions: {showSpeed:'0'},  changeMonth:true,changeYear:true}); */
			$("#accnum1").val($("#fromAccount1").val());
		
  });
  $("#datepicker2").focus(function () {
	  
		/* $( "#datepicker1" ).datepicker({dateFormat: 'yy-mm-dd', yearRange: "1950:2025", showAnim: 'fold', showOptions: {showSpeed:'0'},  changeMonth:true,changeYear:true}); */
		$( "#datepicker2" ).datepicker({dateFormat: 'yy-mm-dd', yearRange: "1950:2025", showAnim: 'fold', showOptions: {showSpeed:'0'},  changeMonth:true,changeYear:true});
	
});
  
  </script>
  

<div class="polo">

	<table>
		<tr>
			<td><div style="height: 100px; width: 416px; border-bottom: 1px solid red;"></div>
			</td>
			<td><div style="height: 100px; width: 416px; border-bottom: 1px solid blue;"></div>
			</td>
		</tr>
	</table>
 
<form action="stmt" method="post">
	<table height="300" width="850">
		<tr>
			<td><div class="smalldivz"
					style="height: 200px; width: 416px; border-bottom: 1px solid red;">
					Select START DATE : <input id="datepicker1" name="startdate" readonly type="text">
				</div></td>
			<td><div class="smalldivz"
					style="height: 200px; width: 416px; border-bottom: 1px solid blue;">
					Select END DATE : <input id="datepicker2" name="enddate" readonly type="text">
				</div></td>
			<td> <input type="hidden" id="accnum1" name="accnum">
			</td>

		</tr>
		<tr> <td colspan="3" align="center"> <button>view</button> </td>
		</tr>

	</table>

</form>


</div>