$(document).ready(function(){
	
	$("#button").click(function() {
		$.get("restservices/kamer", function(data, status) {
			for ( var key in data) {
				var value = data[key];
				var kamer_id = value.kamer_id;
				var prijs_pn = value.prijs_pn;
				var aantal_n = value.aantal_n;
				var ontbijt = value.ontbijt;
				var zwembad = value.zwembad;
				var kamer_gast_nr = value.kamer_gast_nr;
				var input = document.getElementById("id").value;
				var prijs_verblijf = value.prijs_pn * value.aantal_n;
				var prijs_totaal = prijs_verblijf + value.ontbijt + value.zwembad;

				
				if(input == kamer_id){
					$('#tabel2').append(
							$('<tr></tr>').append(
									$('<td id="header" colspan="7"></td>').text("")))
					$('#tabel2').append(
						$('<tr></tr>').append(
								$('<th></th>').text("Kamer nummer"),
								$('<th></th>').text("Prijs per nacht"),
								$('<th></th>').text("Aantal nachten"),
								$('<th></th>').text("Ontbijt"),
								$('<th></th>').text("Zwembad"),
								$('<th></th>').text("Gast nummer"),
								$('<th></th>').text("Totaal bedrag")))
					$('#tabel2').append(
						$('<tr></tr>').append(
								$('<td></td>').text(input),
								$('<td></td>').text(prijs_pn),
								$('<td></td>').text(aantal_n),
								$('<td></td>').text(ontbijt),
								$('<td></td>').text(zwembad),
								$('<td></td>').text(kamer_gast_nr),
								$('<td></td>').text(prijs_totaal)))
								
											
								console.log(value.kamer_id, value.prijs_pn, value.aantal_n, value.ontbijt, value.zwembad, value.kamer_gast_nr, prijs_totaal);
				}
			}
		});
	});


	$("#delete").click(function (){
		var uri = "restservices/kamer/delete/" + $("#kamerId").val();
		$.ajax(uri, {
			method: "delete",
			succes: function(response) {
				$("#responseverwijderen").text("Kamer is afgerekend");
				console.log("kamer is verwijderd");
			},
			error: function(response){
				$("#responseverwijderen").text("Kamer niet afrekenen");
			}
		});
	});
	
    $("#wijzig").click(function(response) {

        var data = { "kamer_id": parseInt($("#wijzigKamernr").val()), "prijs_pn": parseInt($("#wijzigPrijs").val()), "aantal_n": parseInt($("#wijzigAantaln").val()), "ontbijt": parseInt($("#wijzigOntbijt").val())
        		, "zwembad": parseInt($("#wijzigZwembad").val())}
        
        console.log(JSON.stringify(data));
        
	     $.post("/applicatie/restservices/kamer/update", data, function(response) {
	                  $("#responseaangepast").text("Kamer is aangepast");
	     });
    });

	$("#gasttoevoegen").click(function(){
		var form_data2 = $("#nieuwPersonid").val() + ',' +
		$("#nieuwVoornaam").val() + ',' +
		$("#nieuwAchternaam").val();
		console.log(form_data2);
		
		var uri = "restservices/kamer/new";
		$.ajax(uri, {
			method: "post",
			data: form_data2,
			dataType: 'application/json',
			contentType: 'application/json',
			succes: function(response){
				alert("Kamer toegevoegd");
			}
		});
	});
 
	
	$("#toevoegen").click(function(){
		var form_data = $("#nieuwKamernr").val() + ',' +
		$("#nieuwPrijs").val() + ',' +
		$("#nieuwAantal").val() + ',' +
		$("#nieuwOntbijt").val() + ',' +
		$("#nieuwZwembad").val() + ',' +
		$("#nieuwGast").val();
		console.log(form_data);
		
		var uri = "restservices/kamer/new";
		$.ajax(uri, {
			method: "post",
			data: form_data,
			dataType: 'application/json',
			contentType: 'application/json',
			succes: function(response){
				$("#responseadd").text("kamer is toegevoegd");
			},
			error: function(response){
				$("#responseadd").text("kamer is niet toegevoegd");
			}
		});
	});
});