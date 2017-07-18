package nl.hu.v1ipass.applicatie.persistene;

public class Kamer {
	private int kamer_id;
	private int prijs_pn;
	private int aantal_n;
	private int ontbijt;
	private int zwembad;
	private int kamer_gast_nr;
	
	public Kamer(int id, int pr, int aantal, int ontb, int zwemb, int gastnr){
		setKamer_id(id);
		setPrijs_pn(pr);
		setAantal_n(aantal);
		setOntbijt(ontb);
		setZwembad(zwemb);
		setKamer_gast_nr(gastnr);
	}
	
	public int getKamer_id(){ return kamer_id; }
	public void setKamer_id(int id) { this.kamer_id = id; }
	
	public int getPrijs_pn(){ return prijs_pn; }
	public void setPrijs_pn(int pr) { this.prijs_pn = pr; }
	
	public int getAantal_n() { return aantal_n; }
	public void setAantal_n(int aantal) { this.aantal_n = aantal; }
	
	public int getOntbijt() { return ontbijt; }
	public void setOntbijt(int ontb) { this.ontbijt = ontb; }
	
	public int getZwembad() { return zwembad; }
	public void setZwembad(int zwemb) { this.zwembad = zwemb; }
	
	public int getKamer_gast_nr() { return kamer_gast_nr; }
	public void setKamer_gast_nr(int gastnr) {this.kamer_gast_nr = gastnr; }
	
	
}
