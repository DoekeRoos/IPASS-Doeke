package nl.hu.v1ipass.applicatie.persistene;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KamerDAO extends BaseDAO{
	private GastDAO gastDAO = new GastDAO();
	
	private List<Kamer> selectKamers(String query){
		List<Kamer> result = new ArrayList<Kamer>();
		
		try (Connection con = super.getConnection()){
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
			
			while (dbResultSet.next()) {
				int kamerid = dbResultSet.getInt("kamer_id");
				int prijs = dbResultSet.getInt("prijs_pn");
				int aantal = dbResultSet.getInt("aantal_n");
				int ontbijt = dbResultSet.getInt("ontbijt");
				int zwembad = dbResultSet.getInt("zwembad");
				int gastnr = dbResultSet.getInt("kamer_gast_nr");
				
				System.out.println(kamerid);

				Kamer newKamer = new Kamer(kamerid, prijs, aantal, ontbijt, zwembad, gastnr);
				
				result.add(newKamer);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return result;
	}
	
	public List<Kamer> getKamer() {
		return selectKamers("SELECT * FROM kamer");
	}
	
	public Kamer findById(int kamer_id) {
		return selectKamers("SELECT kamer_id, prijs_pn, aantal_n, ontbijt, zwembad, kamer_gast_nr FROM kamer "
							+ "WHERE kamer_id = " +kamer_id).get(0);
	}
}
