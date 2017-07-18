package nl.hu.v1ipass.applicatie.persistene;

import java.util.ArrayList;

public interface KamerDAO {
	public ArrayList<Kamer> GetAllKamers();
	
	public Kamer getKamer(int id);
	
	public boolean UpdateKamer(Kamer k);
	
	public boolean DeleteKamer(Kamer k);
	
	public boolean AddKamer(Kamer k);
}
