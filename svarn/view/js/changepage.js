/**
 * changing the page according to the selected link
 */


function radiosel (changediv,accNo) {
	
	if(changediv == "hello"){
		//alert("test successful acc received : "+accNo);
		
		//alert("self : "+$("#fromAccount1").val());
		var self = $("#fromAccount1").val();
		
		$.ajax({
			type: 'POST',
			url: '/svarn/setTpDetails',
			data: 'cmd=addFriend'+'&self='+self+'&tp='+accNo, 
			dataType: 'html', 
		}).done(function(msg) { 

			
			$('#billu').html(msg)
			//alert("after setting billu");
		});
		
	
	
	}
	
	if(changediv == "biller"){
		//alert("biller test successful acc received : "+accNo);
		
		//alert("self : "+$("#fromAccount1").val());
		var self = $("#fromAccount1").val();
		
		$.ajax({
			type: 'POST',
			url: '/svarn/setBillerDetails',
			data: 'cmd=addFriend'+'&self='+self+'&tp='+accNo, 
			dataType: 'html', 
		}).done(function(msg) { 

			
			$('#billu').html(msg)
			//alert("after setting billu");
		});
		
	
	
	}
	
	
	
	
}


function changeOn (changediv) {
//	alert("inside change on");
//	$('div[class^="changedTo"]').css("display","none");
//	$('div.polo').replaceWith($("div[class$="+changediv+"]"));
//	$("div[class$="+changediv+"]").css("display","block");


	
	if(changediv == "hello"){
		alert("test successful");
		
	
	}
	
	if(changediv == "cb"){
//		alert("test successful");
		$('#butt').css("border","1px solid blue");
	
	}
	if(changediv == "cbo"){
//		alert("test successful");
		$('#butt').css("border","none");
	
	}
	
	
	

	if (changediv == 'setbillername'){
		
		//alert("setting biller name");
		
		var companyId = $('select[id=companiesName] option:selected').val();
		
//		$('#compacc').val($('select[id=companiesName] option:selected').val());
//		alert("company acc set to  "+$('#compacc').val());
		
		//alert("companyId : "+companyId );
		$.ajax({
			type: 'POST',
			url: 'setCompany',
			data: 'cmd=addFriend'+'&val=' + companyId, 
			dataType: 'html', 
		}).done(function(msg) { 

			
			$('#billu').html(msg)
//			alert("value of compacc billu : "+$('#compacc').val());
		}); 
		
		
		
	}
	
	
if (changediv == 'setcompacc'){
		
		//alert("setting company account");
		
		var companyId = $('select[id=companyaccountlist] option:selected').val();
		
		$('#compacc').val($('select[id=companyaccountlist] option:selected').val());
		
		//alert("company acc set to  "+$('#compacc').val());
		
			
		
	}
	
	
	
	
	
	
	
	if(changediv == "compacc1"){
		//alert("initial comp companies name "+$('select[id=companiesName] option:selected').val());
		$('#compacc').val($('select[id=companyaccountlist] option:selected').val());
		//alert("company acc set to  "+$('#compacc').val());
	}
		
	if(changediv == "tpto"){
		
		//alert("tp acc added");
		//alert("avle of acc selected"+$("#fromAccount1").val());
		//alert("self value "+$('#tpself').val());
		$("#tpself").val($("#fromAccount1").val());
		//alert("self value set to"+$('#tpself').val());
	
	
	}
	
	if (changediv == "fundtransfer"){
	
		//alert("js funds transfer invoked...");
	
		
		$('div.polo').load("view/usermgmt/afterLogin/fund_transfer.jsp");
		//alert("leaving js funds transfer ...");
		
	}
	else if (changediv == "thirdparty"){
	
	var accountNo = $('select[id=accountNo] option:selected').val();




		//alert(accountNo+"           account no" );
		$.ajax({
			type: 'POST',
			url: 'viewThirdParty',
			data: 'cmd=addFriend'+'&val=' + accountNo, 
			dataType: 'html', 
		}).done(function(msg) { 

			$('div.polo').load("view/usermgmt/afterLogin/third_party_transfer.jsp");
			//alert("after 3p load");
		}); 
		
	}
	
	else if (changediv == "dd")
		$('div.polo').load("view/usermgmt/afterLogin/demand_draft.jsp");
	else if (changediv == "viewprofile"){
		
		//alert(" inside view profile" );
		var accountNo = $('select[id=accountNo] option:selected').val();

		$('div.polo').load("view/usermgmt/afterLogin/view_profile.jsp");


		//alert(accountNo+"           account no" );
		//alert(" inside view profile" );
		$.ajax({
			type: 'POST',
			url: 'viewProfile',
			data: 'cmd=addFriend'+'&self=' + accountNo, 
			dataType: 'html', 
		}).done(function(msg) { 
			
			$('#billu').html(msg);
			
		}); 
		
		
				
//		$('div.polo').load();
	}
	else if (changediv == "changemob")
		$('div.polo').load();
	else if (changediv == "changepassword")
		$('div.polo').load();
	else if (changediv == "add3p")
	{

		var accountNo = $('select[id=accountNo] option:selected').val();

		//alert(accountNo+"           account no" );
		
		$('div.polo').load("view/usermgmt/afterLogin/add_third_party.jsp");

//		$.ajax({
//			type: 'POST',
//			url: 'identifyThirdParty',
//			data: 'cmd=addFriend'+'&val=' + accountNo, 
//			dataType: 'html', 
//		}).done(function(msg) { 
//			$('div.polo').load("view/usermgmt/afterLogin/add_third_party.jsp");
//			
//
//		}); 


	}
	else if (changediv == "modify3p")
		$('div.polo').load("view/usermgmt/afterLogin/modify_third_party.jsp");



	else if (changediv == "view3p"){

		var accountNo = $('select[id=accountNo] option:selected').val();




		//alert(accountNo+"           account no" );
		//alert(" inside view 3p" );
		$.ajax({
			type: 'POST',
			url: 'viewThirdParty',
			data: 'cmd=addFriend'+'&val=' + accountNo, 
			dataType: 'html', 
		}).done(function(msg) { 

			$('div.polo').load("view/usermgmt/afterLogin/view_third_party.jsp");
		}); 

	}
	else if (changediv == "delete3p"){


		var accountNo = $('select[id=accountNo] option:selected').val();




		//alert(accountNo+"           account no" );
		$.ajax({
			type: 'POST',
			url: 'viewThirdParty',
			data: 'cmd=addFriend'+'&val=' + accountNo, 
			dataType: 'html', 
		}).done(function(msg) { 

			$('div.polo').load("view/usermgmt/afterLogin/delete_third_party.jsp");
		}); 

	}


	else if (changediv == "addad")
		$('div.polo').load("view/usermgmt/afterLogin/add_auto_debit.jsp");
	else if (changediv == "modifyad")
		$('div.polo').load("view/usermgmt/afterLogin/modify_auto_debit.jsp");
	else if (changediv == "viewad")
		$('div.polo').load("view/usermgmt/afterLogin/view_auto_debit.jsp");
	else if (changediv == "deletead")
		$('div.polo').load("view/usermgmt/afterLogin/delete_auto_debit.jsp");
	else if (changediv == "addbill"){

		var accountNo = $('select[id=accountNo] option:selected').val();

		//alert(accountNo+"           account no" );

		$.ajax({
			type: 'POST',
			url: 'identifyBiller',
			data: 'cmd=addFriend'+'&val=' + accountNo, 
			dataType: 'html', 
		}).done(function(msg) { 
			$('div.polo').load("view/usermgmt/afterLogin/add_biller.jsp");

		}); 


	}

	else if (changediv == "modifybill")
		$('div.polo').load("view/usermgmt/afterLogin/modify_biller.jsp");
	else if (changediv == "viewbill"){

		var accountNo = $('select[id=accountNo] option:selected').val();




		//alert(accountNo+"           account no" );
		$.ajax({
			type: 'POST',
			url: 'viewBiller',
			data: 'cmd=addFriend'+'&val=' + accountNo, 
			dataType: 'html', 
		}).done(function(msg) { 

			$('div.polo').load("view/usermgmt/afterLogin/view_biller.jsp");
		}); 

	}

	else if (changediv == "deletebill"){


			
		var accountNo = $('select[id=accountNo] option:selected').val();


		//alert("inside delete biller js");
		

//		alert(accountNo+"           account no" );
	
		$.ajax({
			type: 'POST',
			url: 'viewBiller',
			data: 'cmd=addFriend'+'&val=' + accountNo, 
			dataType: 'html', 
		}).done(function(msg) {

			$('div.polo').load("view/usermgmt/afterLogin/delete_biller.jsp");
		}); 

	}

	else if (changediv == "viewstmt")
		$('div.polo').load("view/usermgmt/afterLogin/view_statement.jsp");
	else if (changediv == "pay")
		$('div.polo').load("view/usermgmt/afterLogin/no_text.jsp");


}