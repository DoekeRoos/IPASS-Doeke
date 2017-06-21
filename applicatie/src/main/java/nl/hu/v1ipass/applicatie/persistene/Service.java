package nl.hu.v1ipass.applicatie.persistene;


import java.util.List;

public class Service {
	private KamerDAO kamerDAO = new KamerDAO();
	
	public List<Kamer> getAllKamers() {
		return kamerDAO.getKamer();
	}
	
}
