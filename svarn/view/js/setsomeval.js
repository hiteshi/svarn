function sethiddenval() {
	// alert("inside setting ");
	// alert($('select[id=xxx] option:selected').val());
	$('#hidd').val($('select[id=xxx] option:selected').val());

//	alert("after setting value2 : TO : " + $("#hidd").val());
	// alert("after setting value : "+$("#hidd").val());
	$("#hidd2").val($("#fromAccount1").val());
//	alert("after setting value2 : FROM : " + $("#hidd2").val());

}


function addtpto(){
	
	//alert("tp acc added");
	$('#tpself').val($("#fromAccount1").val());
	
	
}

function test1(){
	
	alert("alert in test1 : setsomevalue.js");
	
}


function setMainAccount() {

//	alert("b4 setting value : " + $("#fromAccount1").val());
	$('#fromAccount1').val($('select[id=accountNo] option:selected').val());
//	alert("after setting value : " + $("#fromAccount1").val());

}

function xmlpopulate() {
//	alert("hello ji");
	var tiger = $('select[id=cityid] option:selected').val();
	$('#cityoption1').val(tiger);
	$("#ddaccount").val($("#fromAccount1").val());
//	alert("ddaccount: " + $('#ddaccount').val());
//	alert("after setting value : " + $('#cityoption1').val());
	$('#citynames').empty();
//	write id cityid whereever necessary
//	$.ajax({
//		type : "GET",
//		url : "/svarn/view/js/branchlist.xml",//------- this is important url
//		dataType : "xml",
//		success : function(xml) {
//			$(xml).find(tiger).each(
//					function() {
//						alert("inside tiger");
//						$('<option></option>').html('select branch').appendTo(
//								'#update-target select');
//						$(this).find('name').each(
//								function() {
//
//									var name_text = $(this).text()
//									$('<option></option>').html(name_text)
//											.appendTo('#update-target select');
//
//								});
//
//					}); // close each(
//		}
//	}); // close $.ajax(

}









