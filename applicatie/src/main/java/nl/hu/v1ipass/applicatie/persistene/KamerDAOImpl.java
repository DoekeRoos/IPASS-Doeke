package nl.hu.v1ipass.applicatie.persistene;

import java.sql.ResultSet;
import java.util.ArrayList;

import nl.hu.v1ipass.applicatie.persistene.SQLConnection;

public class KamerDAOImpl implements KamerDAO{
	private SQLConnection sqlconn = null;
	
	//Maak connectie met de database
	public KamerDAOImpl(){
		sqlconn = new SQLConnection("org.postgresql.Driver", "jdbc:postgresql://localhost:5433/ipass", "postgres", "8fpd6y4h");
	}
	
	
	//Schrijf een functie die van alle kamers in de database een arraylist maakt
	public ArrayList<Kamer> GetAllKamers() {
		ArrayList<Kamer> result = new ArrayList<Kamer>();
		try {
			sqlconn.setTable("kamer");
			ResultSet rs = sqlconn.Retrieve(String.format("Select * FROM \"%s\"", sqlconn.getTable()));
			while (rs.next()) {
				result.add(new Kamer(rs.getInt("kamer_id"), rs.getInt("prijs_pn"), rs.getInt("aantal_n"), rs.getInt("ontbijt"),
						rs.getInt("zwembad"), rs.getInt("kamer_gast_nr")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//Schrijf een functie die een kamer kan ophalen voor een bepaald kamerid
	public Kamer getKamer(int id) {
		try {
			sqlconn.setTable("kamer");
			ResultSet rs = sqlconn.Retrieve(String.format("Select * FROM \"%s\" WHERE kamer_id= %d", sqlconn.getTable(), id));

			if (rs.next()) {
				return new Kamer(rs.getInt("kamer_id"), rs.getInt("prijs_pn"), rs.getInt("aantal_n"), rs.getInt("ontbijt"),
						rs.getInt("zwembad"), rs.getInt("kamer_gast_nr"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//Schrijf een funtie om een kamer te kunnen updaten
	public boolean UpdateKamer(Kamer k) {
		try {
			sqlconn.setTable("kamer");
			if (sqlconn.Update(String.format(
					"UPDATE \"%s\" SET kamer_id= %d, prijs_pn = '%s', aantal_n = '%s', ontbijt = '%s', zwembad = '%s' WHERE kamer_id=%d",
					sqlconn.getTable(), k.getKamer_id(), k.getPrijs_pn(), k.getAantal_n(), k.getOntbijt(), k.getZwembad(), k.getKamer_id()))) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	//Schrijf een functie om een kamer te verwijderen
	public boolean DeleteKamer(Kamer k) {
		try {
			if (sqlconn.Update(String.format("DELETE FROM \"%s\" WHERE kamer_id = %d", sqlconn.getTable(), k.getKamer_id())))
				;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	//Schrijf een funtie om een kamer toe te kunnen voegen
	public boolean AddKamer(Kamer k){
		try{
			sqlconn.setTable("kamer");
			if (sqlconn.Update(String.format("INSERT INTO \"%s\" (kamer_id, prijs_pn, aantal_n, ontbijt, zwembad, kamer_gast_nr) values(%d, '%s', '%s', '%s', '%s', '%s')"
					, sqlconn.getTable(), k.getKamer_id(), k.getPrijs_pn(), k.getAantal_n(), k.getOntbijt(), k.getZwembad(), k.getKamer_gast_nr())));
			return true;
		} catch (Exception e){
			e.printStackTrace();	
		}
		
		return false;
	}
}
