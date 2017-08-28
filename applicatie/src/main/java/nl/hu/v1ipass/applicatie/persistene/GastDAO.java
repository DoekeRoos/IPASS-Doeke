package nl.hu.v1ipass.applicatie.persistene;

import java.util.ArrayList;

public interface GastDAO {
	public ArrayList<Gast> GetAllGasten();
	
	public Gast getGast(int id);
	
	public boolean AddGast(Gast g);
}
