package nl.hu.v1ipass.applicatie.webservices;

import nl.hu.v1ipass.applicatie.persistene.*;
import java.util.List;

public class Service {
	
	private List<Kamer> allKamers;
	private KamerDAO kdao;
	
	private List<Gast> allGasten;
	private GastDAO gdao;
	
	//Deze functie zorgt er voor dat de klasse "KamerDAO" kan worden aangeroepen
	public Service(){
		kdao = new KamerDAOImpl();
		allKamers = kdao.GetAllKamers();
		
		gdao = new GastDAOImpl();
		allGasten = gdao.GetAllGasten();
	}
	
	public List<Kamer> getAllKamers(){
		return allKamers;
	}
	
	public List<Gast> getAllGasten(){
		return allGasten;
	}
	
	public Kamer getKamerByID(String id) {
		Kamer result = null;
		int id2 = Integer.parseInt(id);
		
		for ( Kamer k: allKamers) {
			if (k.getKamer_id() == id2) {
				result = k;
			}
		}
		return result;
	}
	
	public boolean updateKamer(Kamer k){
		kdao.UpdateKamer(k);
		return true;
	}
	
	public boolean removeKamer(Kamer k){
		kdao.DeleteKamer(k);
		return true;
	}
	
	//Zorg ervoor dat 
	public boolean newKamer(Kamer k){
		kdao.AddKamer(k);
		return true;
	}
	
	public boolean newGast(Gast g){
		gdao.AddGast(g);
		return true;
	}
}
