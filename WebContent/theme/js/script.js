
var timeleft = (120) * 60
// TODO var examID = examID
var sendLast = false;

var counterJS = setInterval(function() {
	timeLeft--;
	var hours = 0;
	var min = parseInt(timeLeft / 60, 10);
	var sec = parseInt(timeLeft % 60, 10);
	// dureeRestante = dureeRestante * 60;

	while (min >= 60) {
		min -= 60;
		hours++;
	}

	if (min == -1) {
		min = 58;
		hours--;
	}

	// Display the result in the element with id="demo"
	document.getElementById("compteur").innerHTML = hours + "h " + min + "m " + sec
			+ "s ";

	// If the count down is finished, write some text
	if (timeLeft <= 0) {
		clearInterval(counterJS);
		document.getElementById("compteur").innerHTML = "Temps écoulé";
		$("#anchorBlock").css("display", "block");
	}
}, 1000);

var counterSaveDB = setInterval(function() {
	// Add 1 to timeSpend in database
	if ($("#demo").text() == "Temps écoulé" && !sendLast) {
		sendLast = true;
		$.ajax({
			type : "POST",
			url : "/QCM_JavaEE/Candidate/AjaxSaveExam",
			data : {examID: examID, finished: true},
			datatype : "html"
		});
		
	} else if($("#demo").text() != "Temps écoulé") {
		$.ajax({
			type : "POST",
			url : "/QCM_JavaEE/Candidate/AjaxSaveExam",
			data : "examID=" + examID,
			datatype : "html"
		});
	}

}, 60000);