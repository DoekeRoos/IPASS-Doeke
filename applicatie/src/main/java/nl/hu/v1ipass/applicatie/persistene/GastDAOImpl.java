package nl.hu.v1ipass.applicatie.persistene;

import java.sql.ResultSet;
import java.util.ArrayList;

public class GastDAOImpl implements GastDAO{
	private SQLConnection sqlconn = null;
	
	//Maak connectie met de database
	public GastDAOImpl(){
		sqlconn = new SQLConnection("org.postgresql.Driver", "jdbc:postgresql://localhost:5433/ipass", "postgres", "8fpd6y4h");
	}
	
	public ArrayList<Gast> GetAllGasten(){
		ArrayList<Gast> result = new ArrayList<Gast>();
		try{
			sqlconn.setTable("gast");
			ResultSet rs = sqlconn.Retrieve(String.format("Select * from \"%s\"", sqlconn.getTable()));
			while (rs.next()) {
				result.add(new Gast(rs.getInt("person_id"), rs.getString("voornaam"), rs.getString("achternaam")));
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public Gast getGast(int id) {
		try {
			sqlconn.setTable("gast");
			ResultSet rs = sqlconn.Retrieve(String.format("select * from \"%s\" where id= %d", sqlconn.getTable(), id));

			if (rs.next()) {
				return new Gast(rs.getInt("person_id"), rs.getString("voornaam"),
						rs.getString("achternaam"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean AddGast(Gast g){
		try {
			sqlconn.setTable("gast");
			if (sqlconn.Update(String.format(
					"insert into \"%s\" (person_id, voornaam, achternaam) values (%d, '%s', '%s')",
					sqlconn.getTable(), g.getPerson_id(), g.getVoornaam(), g.getAchternaam()))) {
				return true;
			}
			;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}