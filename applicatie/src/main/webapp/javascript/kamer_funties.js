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
								$('<td></td>').text("Kamer nummer"),
								$('<td></td>').text("Prijs per nacht"),
								$('<td></td>').text("Aantal nachten"),
								$('<td></td>').text("Ontbijt"),
								$('<td></td>').text("Zwembad"),
								$('<td></td>').text("Gast nummer"),
								$('<td></td>').text("Totaal bedrag")))
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
				$("#response").text("Kamer is afgerekend");
			},
			error: function(response){
				$("#response").text("Kamer is niet in gebruik");
			}
		});
	});
	
	$("#wijzig").click(function(){
		var form_data = $("#wijzigKamernr").val() + ',' +
		$("#wijzigPrijs").val() + ',' +
		$("#wijzigAantaln").val() + ',' +
		$("#wijzigOntbijt").val() + ',' +
		$("#wijzigZwembad").val();
		console.log(form_data);
		
		var uri = "restservices/kamer/update/" + $("#huidigKamernr").val();
		$.ajax(uri, {
			method: "put",
			data: form_data,
			dataType: 'application/json',
			contenctType: 'application/json',
			succes: function(response){
				console.log("kamer is gewijzigd")
			}
		});
	});
	
	$("#nieuw").click(function () {
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
			succes: function(result){
				alert("Klant is toegevoegd!");
			}
		});
	});
});