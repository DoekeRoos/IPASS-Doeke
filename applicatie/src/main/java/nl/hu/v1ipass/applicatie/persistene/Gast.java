package nl.hu.v1ipass.applicatie.persistene;

public class Gast {
	private int person_id;
	private String voornaam;
	private String achternaam;
	
	public Gast (int person_id, String voornaam, String achternaam){
		setPerson_id(person_id);
		setVoornaam(voornaam);
		setAchternaam(achternaam);
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
	
	public void setPerson_id(int id) { this.person_id = id; }
	public void setVoornaam(String vrnm) { this.voornaam = vrnm; }
	public void setAchternaam(String achtnm) {this.achternaam = achtnm; }
}

