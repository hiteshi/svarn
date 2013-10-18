<html>
<head>
<style type="text/css" >


body{
	font-family: Trebuchet MS, Lucida Sans Unicode, Arial, sans-serif;	/* Font to use */
	margin:0px;

}

.heading{	/* Styling Heading */
	/* Start layout CSS */
	color:#FFF;
	font-size:14;
	background-color:#317082;
	width:220px;
	margin-bottom:2px;
	margin-top:2px;
	padding-left:2px;
	background-image:url('rounded.gif');
	background-repeat:no-repeat;
	background-position:top right;
	height:20px;

	/* End layout CSS */

	overflow:hidden;
	cursor:pointer;
}
.subHeading{	/* Parent box of slide down content */
	/* Start layout CSS */
	border:1px solid #317082;
	background-color:#E2EBED;
	width:200px;

	/* End layout CSS */

	visibility:hidden;
	height:0px;
	overflow:hidden;
	position:relative;

}
.subHeading_content{	/* Content that is slided down */
	padding:1px;
	font-size:14;
	position:relative;
}

</style>
<script type="text/javascript">

var svarn_slideSpeed = 10;	// Higher value = faster
var svarn_timer = 10;	// Lower value = faster

var objectIdToSlideDown = false;
var svarn_activeId = false;
var svarn_slideInProgress = false;
var svarn_expandMultiple = false; // true if you want to be able to have multiple items expanded at the same time.

function showHideContent(e,inputId)
{
	if(svarn_slideInProgress)return;
	svarn_slideInProgress = true;
	if(!inputId)inputId = this.id;
	inputId = inputId + '';
	var numericId = inputId.replace(/[^0-9]/g,'');
	var subheadDiv = document.getElementById('svarn_a' + numericId);

	objectIdToSlideDown = false;

	if(!subheadDiv.style.display || subheadDiv.style.display=='none'){
		if(svarn_activeId &&  svarn_activeId!=numericId && !svarn_expandMultiple){
			objectIdToSlideDown = numericId;
			slideContent(svarn_activeId,(svarn_slideSpeed*-1));
		}else{

			subheadDiv.style.display='block';
			subheadDiv.style.visibility = 'visible';

			slideContent(numericId,svarn_slideSpeed);
		}
	}else{
		slideContent(numericId,(svarn_slideSpeed*-1));
		svarn_activeId = false;
	}
}

function slideContent(inputId,direction)
{

	var obj =document.getElementById('svarn_a' + inputId);
	var contentObj = document.getElementById('svarn_ac' + inputId);
	height = obj.clientHeight;
	if(height==0)height = obj.offsetHeight;
	height = height + direction;
	rerunFunction = true;
	if(height>contentObj.offsetHeight){
		height = contentObj.offsetHeight;
		rerunFunction = false;
	}
	if(height<=1){
		height = 1;
		rerunFunction = false;
	}

	obj.style.height = height + 'px';
	var topPos = height - contentObj.offsetHeight;
	if(topPos>0)topPos=0;
	contentObj.style.top = topPos + 'px';
	if(rerunFunction){
		setTimeout('slideContent(' + inputId + ',' + direction + ')',svarn_timer);
	}else{
		if(height<=1){
			obj.style.display='none';
			if(objectIdToSlideDown && objectIdToSlideDown!=inputId){
				document.getElementById('svarn_a' + objectIdToSlideDown).style.display='block';
				document.getElementById('svarn_a' + objectIdToSlideDown).style.visibility='visible';
				slideContent(objectIdToSlideDown,svarn_slideSpeed);
			}else{
				svarn_slideInProgress = false;
			}
		}else{
			svarn_activeId = inputId;
			svarn_slideInProgress = false;
		}
	}
}



function initShowHideDivs()
{
	var divs = document.getElementsByTagName('DIV');
	var divCounter = 1;
	for(var no=0;no<divs.length;no++){
		if(divs[no].className=='heading'){
			divs[no].onclick = showHideContent;
			divs[no].id = 'svarn_q'+divCounter;
			var subhead = divs[no].nextSibling;
			while(subhead && subhead.tagName!='DIV'){
				subhead = subhead.nextSibling;
			}
			subhead.id = 'svarn_a'+divCounter;
			contentDiv = subhead.getElementsByTagName('DIV')[0];
			contentDiv.style.top = 0 - contentDiv.offsetHeight + 'px';
			contentDiv.className='subHeading_content';
			contentDiv.id = 'svarn_ac' + divCounter;
			subhead.style.display='none';
			subhead.style.height='1px';
			divCounter++;
		}
	}
}
window.onload = initShowHideDivs;
</script>

</head>
<body>
<div class="heading"> <li> Deposit Accounts </li> </div>
<div class="subHeading">
	<div>
		<ul>
			<li><a href="/svarn/view/html/SavingAccount.html" target="_blank">Savings Account</a></li>
			<li><a href="/svarn/view/html/CurrentAccount.html" target="_blank">Current Account</a></li>
			<li><a href="/svarn/view/html/FixedDeposit.html" target="_blank">Fixed Deposit</a></li>
		</ul>
	</div>
</div>
<div class="heading"><li> Loans </li></div>
<div class="subHeading">
	<div>
		<ul>
			<li><a href="/svarn/view/html/DemandLoan.html" target="_blank">Demand Loan</a></li>
			<li><a href="/svarn/view/html/TermLoan.html" target="_blank">Term Loan</a></li>
			<li><a href="/svarn/view/html/OverDraft.html" target="_blank">Over Draft</a></li>
		</ul>
	</div>
</div>
<div class="heading"><li> E-Mail & SMS </li></div>
	<div class="subHeading"> 
		<div>
			<li><a href="/svarn/view/html/LodgeComplain.html" target="_blank">You can enable Mail/SMS Service</a></li>
		</div>
	</div>
<div class="heading"><li> Spot Us </li></div>
	<div class="subHeading"> 
		<div>
			<li><a href="/svarn/view/html/FindATM.html" target="_blank">Find nearest ATM/Branch</a></li>
		</div>
	</div>
<div class="heading"><li> Career </li></div>
	<div class="subHeading"> 
		<div>
			<li><a href="/svarn/view/html/Career.html" target="_blank">Career with SVARN</a></li>
		</div>
	</div>
</body>
</html>