package nl.hu.v1ipass.applicatie.persistene;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GastDAO extends BaseDAO{
	private List<Gast> getGast(String query) {
		List<Gast> results = new ArrayList<Gast>();
		
		try (Connection con = super.getConnection()) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
			
			while (dbResultSet.next()) {
				int person_id = dbResultSet.getInt("person_id");
				String voornaam = dbResultSet.getString("voornaam");
				String achternaam = dbResultSet.getString("achternaam");
				
				results.add(new Gast(person_id, voornaam, achternaam));
				
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return results;
	}

	public Gast findById(int person_id) {
		return getGast("SELECT person_id, voornaam, achternaa FROM gast WHERE person_id = " +person_id).get(0);
	}

}
