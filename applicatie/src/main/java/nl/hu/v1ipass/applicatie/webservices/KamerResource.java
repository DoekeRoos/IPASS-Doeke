package nl.hu.v1ipass.applicatie.webservices;

import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import nl.hu.v1ipass.applicatie.persistene.ServiceProvider;
import nl.hu.v1ipass.applicatie.persistene.Service;
import nl.hu.v1ipass.applicatie.persistene.Kamer;


@Path("/kamer")
public class KamerResource {
	
	@GET
	@Produces("application/json")
	public String getKamers() {
		Service service = ServiceProvider.getService();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (Kamer k : service.getAllKamers()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			
			job.add("kamer_id", k.getKamer_id());
			job.add("prijs_pn", k.getPrijs_pn());
			job.add("aantal_n", k.getAantal_n());
			job.add("ontbijt", k.getOntbijt());
			job.add("zwembad", k.getZwembad());
			job.add("kamer_gast_nr", k.getKamer_gast_nr());
			
			jab.add(job);
		}
		
		
		JsonArray array = jab.build();
		return array.toString();
	}
}
