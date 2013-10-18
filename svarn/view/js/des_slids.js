var svarn_slideSpeed = 10; // Higher value = faster
	var svarn_timer = 10; // Lower value = faster

	var objectIdToSlideDown = false;
	var svarn_activeId = false;
	var svarn_slideInProgress = false;
	var svarn_expandMultiple = false; // true if you want to be able to have multiple items expanded at the same time.

	function showHideContent(e, inputId) {
		if (svarn_slideInProgress)
			return;
		svarn_slideInProgress = true;
		if (!inputId)
			inputId = this.id;
		inputId = inputId + '';
		var numericId = inputId.replace(/[^0-9]/g, '');
		var subheadDiv = document.getElementById('svarn_a' + numericId);

		objectIdToSlideDown = false;

		if (!subheadDiv.style.display || subheadDiv.style.display == 'none') {
			if (svarn_activeId && svarn_activeId != numericId
					&& !svarn_expandMultiple) {
				objectIdToSlideDown = numericId;
				slideContent(svarn_activeId, (svarn_slideSpeed * -1));
			} else {

				subheadDiv.style.display = 'block';
				subheadDiv.style.visibility = 'visible';

				slideContent(numericId, svarn_slideSpeed);
			}
		} else {
			slideContent(numericId, (svarn_slideSpeed * -1));
			svarn_activeId = false;
		}
	}

	function slideContent(inputId, direction) {

		var obj = document.getElementById('svarn_a' + inputId);
		var contentObj = document.getElementById('svarn_ac' + inputId);
		height = obj.clientHeight;
		if (height == 0)
			height = obj.offsetHeight;
		height = height + direction;
		rerunFunction = true;
		if (height > contentObj.offsetHeight) {
			height = contentObj.offsetHeight;
			rerunFunction = false;
		}
		if (height <= 1) {
			height = 1;
			rerunFunction = false;
		}

		obj.style.height = height + 'px';
		var topPos = height - contentObj.offsetHeight;
		if (topPos > 0)
			topPos = 0;
		contentObj.style.top = topPos + 'px';
		if (rerunFunction) {
			setTimeout('slideContent(' + inputId + ',' + direction + ')',
					svarn_timer);
		} else {
			if (height <= 1) {
				obj.style.display = 'none';
				if (objectIdToSlideDown && objectIdToSlideDown != inputId) {
					document.getElementById('svarn_a' + objectIdToSlideDown).style.display = 'block';
					document.getElementById('svarn_a' + objectIdToSlideDown).style.visibility = 'visible';
					slideContent(objectIdToSlideDown, svarn_slideSpeed);
				} else {
					svarn_slideInProgress = false;
				}
			} else {
				svarn_activeId = inputId;
				svarn_slideInProgress = false;
			}
		}
	}

	function initShowHideDivs() {
		var divs = document.getElementsByTagName('DIV');
		var divCounter = 1;
		for ( var no = 0; no < divs.length; no++) {
			if (divs[no].className == 'heading') {
				divs[no].onclick = showHideContent;
				divs[no].id = 'svarn_q' + divCounter;
				var subhead = divs[no].nextSibling;
				while (subhead && subhead.tagName != 'DIV') {
					subhead = subhead.nextSibling;
				}
				subhead.id = 'svarn_a' + divCounter;
				contentDiv = subhead.getElementsByTagName('DIV')[0];
				contentDiv.style.top = 0 - contentDiv.offsetHeight + 'px';
				contentDiv.className = 'subHeading_content';
				contentDiv.id = 'svarn_ac' + divCounter;
				subhead.style.display = 'none';
				subhead.style.height = '1px';
				divCounter++;
			}
		}
	}
	window.onload = initShowHideDivs;