var value;
$(document).ready(
		function info(){
			$.get("restservices/gast", function(data, status){
				for ( var key in data){
					var value = data[key];
					var person_id = value.person_id;
					var voornaam = value.voornaam;
					var achternaam = value.achternaam;
					console.log(person_id, voornaam, achternaam);
					$('#table1').append(
									$('<tr></tr>').append($('<td></td>').text(person_id),
											$('<td></td>').text(voornaam),
											$('<td></td>').text(achternaam)))
				}
			});
		});


