package nl.hu.v1ipass.applicatie.webservices;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import nl.hu.v1ipass.applicatie.persistene.Gast;

@Path("/gast")
public class GastResource {
	private Service s = new Service();
	private String allGastenOutPut= "";
	
	@GET
	@Produces("application/json")
	public Response getGast(){
		JsonObjectBuilder ojob = Json.createObjectBuilder();
		String output = "getGast";
		
		if(allGastenOutPut.equals("")){
			for (Gast g : s.getAllGasten()){
				JsonObjectBuilder job = Json.createObjectBuilder();
				
				job.add("person_id", g.getPerson_id());
				job.add("voornaam", g.getVoornaam());
				job.add("achternaam", g.getAchternaam());
				
				ojob.add(Integer.toString(g.getPerson_id()), job.build());
			}
			output = ojob.build().toString();
			allGastenOutPut = output;
		}else{
			output = allGastenOutPut;
		}
		return Response.status(200).entity(output).build();
	}
	
	@POST
	@Consumes("application/json")
	@Path("/new")
	public Response newGast(String data){
		String[] allParams = data.split(",");
		
		Gast g = new Gast(Integer.parseInt(allParams[0]), allParams[1], allParams[2]);
		boolean succes = s.newGast(g);
		System.out.println(succes);
		
		return Response.status(200).entity(succes).build();
	}
}
