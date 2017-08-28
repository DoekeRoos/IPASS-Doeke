$(document).ready(function(){
	$('#kinzien').click(function(){
		window.location.assign("http://localhost:5430/applicatie/Kamerinzien.html");
	});
	
	$('#ktoevoegen').click(function(){
		window.location.assign("http://localhost:5430/applicatie/Kamertoevoegen.html");
	});
	
	$('#kupdaten').click(function(){
		window.location.assign("http://localhost:5430/applicatie/Kamerupdaten.html");
	});
	
	$('#kverwijderen').click(function(){
		window.location.assign("http://localhost:5430/applicatie/Kamerverwijderen.html");
	});
	
	$('#backhome-button').click(function(){
		window.location.assign("http://localhost:5430/applicatie/index.html");
	})
})


