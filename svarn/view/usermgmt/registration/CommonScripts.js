var message = "Right Click is not allowed";
function clickIE4() {
	if (event.button == 2) {
		alert(message);

		return false;
	}
}
function clickNS4(e) {
	if (document.layers || document.getElementById && !document.all) {
		if (e.which == 2 || e.which == 3) {
			alert(message);
			return false;
		}
	}
}

if (document.layers) {
	document.captureEvents(Event.MOUSEDOWN);
	document.onmousedown = clickNS4;
}

else if (document.all && !document.getElementById) {
	document.onmousedown = clickIE4;
}

document.oncontextmenu = new Function("alert(message);return false;");

var fn = function(e) {

	if (!e)
		var e = window.event;

	var keycode = e.keyCode;
	if (e.which)
		keycode = e.which;

	var src = e.srcElement;
	if (e.target)
		src = e.target;

	// 116 = F5
	if (116 == keycode) {
		// Firefox and other non IE browsers
		if (e.preventDefault) {
			e.preventDefault();
			e.stopPropagation();
		}
		// Internet Explorer
		else if (e.keyCode) {
			e.keyCode = 0;
			e.returnValue = false;
			e.cancelBubble = true;
		}
		alert('This function has been disabled.');
		return false;
	}
}

//Assign function to onkeydown event
document.onkeydown = fn;

function disableCtrlKeyCombination(e) {
	// list all CTRL + key combinations you want to disable
	var forbiddenKeys = Array('a', 'n', 'c', 'x', 'v', 'j', 'i', 'h', 'b', 'd',
			'e', 'l', 'o');
	// alert(forbiddenKeys);
	var key;
	var isCtrl;

	if (window.event) {
		key = window.event.keyCode; // IE
		if (window.event.ctrlKey)
			isCtrl = true;
		else
			isCtrl = false;
	} else {
		key = e.which; // firefox
		if (e.ctrlKey)
			isCtrl = true;
		else
			isCtrl = false;
	}

	// if ctrl is pressed check if other key is in forbidenKeys array
	if (isCtrl) {
		// alert('key length'+forbiddenKeys.length);
		for (i = 0; i < forbiddenKeys.length; i++) {
			if (forbiddenKeys[i].toLowerCase() == String.fromCharCode(key)
					.toLowerCase()) {
				alert('Key combination CTRL + ' + String.fromCharCode(key) + ' has been disabled');
				return false;
			}
		}
	}
	return true;
}
