package nl.hu.v1ipass.applicatie.persistene;

public class Gast {
	private int person_id;
	private String voornaam;
	private String achternaam;
	
	public Gast (int person_id, String voornaam, String achternaam){
		this.person_id = person_id;
		this.voornaam = voornaam;
		this.achternaam = achternaam;
	}
	
	public int getPerson_id(){
		return person_id;
	}
	
	public String getVoornaam(){
		return voornaam;
	}
	
	public String getAchternaam(){
		return achternaam;
	}
}

