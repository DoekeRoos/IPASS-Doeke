package nl.hu.v1ipass.applicatie.persistene;

public class Kamer {
	private int kamer_id;
	private int prijs_pn;
	private int aantal_n;
	private int ontbijt;
	private int zwembad;
	private int kamer_gast_nr;
	
	public Kamer(int id, int pr, int aantal, int ontb, int zwemb, int gastnr){
		this.kamer_id = id;
		this.prijs_pn = pr;
		this.aantal_n = aantal;
		this.ontbijt = ontb;
		this.zwembad = zwemb;
		this.kamer_gast_nr = gastnr;
	}
	
	public int getKamer_id(){ return kamer_id; }
	
	public int getPrijs_pn(){ return prijs_pn; }
	
	public int getAantal_n() { return aantal_n; }
	
	public int getOntbijt() { return ontbijt; }
	
	public int getZwembad() { return zwembad; }
	
	public int getKamer_gast_nr() { return kamer_gast_nr; }
}
