package nl.hu.v1ipass.applicatie.webservices;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import nl.hu.v1ipass.applicatie.persistene.*;

@Path("/kamer")
public class KamerResource {

	private Service s = new Service();
	private String allKamersOutPut = "";
	
	
	//GET methode om informatie op te halen uit de database
	@GET
	@Produces("application/json")
	public Response getKamer() {
		JsonObjectBuilder ojob = Json.createObjectBuilder();
		String output = "getKamer";

		if (allKamersOutPut.equals("")) {
			for (Kamer k : s.getAllKamers()) {
				JsonObjectBuilder job = Json.createObjectBuilder();

				job.add("kamer_id", k.getKamer_id());
				job.add("prijs_pn", k.getPrijs_pn());
				job.add("aantal_n", k.getAantal_n());
				job.add("ontbijt", k.getOntbijt());
				job.add("zwembad", k.getZwembad());
				job.add("kamer_gast_nr", k.getKamer_gast_nr());
				
				ojob.add(Integer.toString(k.getKamer_id()), job.build());
			}
			
			output = ojob.build().toString();
			allKamersOutPut = output;
			
		} else {
			output = allKamersOutPut;
		}
		return Response.status(200).entity(output).build();
	}
	
	//DELETE methode om een kamer uit de database te verwijderen
	@DELETE
	@Path("/delete/{data}")
	public Response deleteKamer(@PathParam("data") String data){
		return Response.status(200).entity(s.removeKamer(s.getKamerByID(data))).build();
	}

	//PUT methode om een kamer te kunnen aanpassen
	@PUT
	@Consumes("application/json")
	@Path("/update/{data}")
	public Response wijzigKamer(String data){
		
		System.out.println(data);
		String[] allParams = data.split(",");
	
		System.out.println("hoi " + allParams[0]);
		Kamer k = s.getKamerByID(allParams[0]);
		k.setKamer_id(Integer.parseInt(allParams[1]));
		k.setPrijs_pn(Integer.parseInt(allParams[2]));
		k.setAantal_n(Integer.parseInt(allParams[3]));
		k.setOntbijt(Integer.parseInt(allParams[4]));
		k.setZwembad(Integer.parseInt(allParams[5]));
		
		boolean succes = s.updateKamer(k);
		System.out.println(succes);
		return Response.status(200).entity(succes).build();
		
	}
	
	//POST methode om een kamer toe te kunnen voegen aan de database
	@POST
	@Consumes("application/json")
	@Path("/new")
	public Response newKamer(String data){
		String[] allParams = data.split(",");
		
		Kamer k = new Kamer(Integer.parseInt(allParams[0]), Integer.parseInt(allParams[1]), Integer.parseInt(allParams[2]), Integer.parseInt(allParams[3]),
				Integer.parseInt(allParams[4]), Integer.parseInt(allParams[5]));
		
		boolean succes = s.newKamer(k);
		System.out.println(succes);
		return Response.status(200).entity(succes).build();
	}
}
