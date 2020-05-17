package org.initial.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Example {
	
	@SuppressWarnings("unused")
	public static void main() throws SQLException {

		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/test", "jumbo", "12345");

		// insertion d'un enregistrement dans la table client

		String requete = "INSERT INTO client VALUES (3,'client 3','prenom 3')";
		try {
			Statement stmt = con.createStatement();
			int nbMaj = stmt.executeUpdate(requete);
			System.out.println("nb mise a jour = " + nbMaj);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		requete = "INSERT INTO client VALUES (4,'client 4','prenom 4')";
		try {
			Statement stmt = con.createStatement();
			ResultSet résultats = stmt.executeQuery(requete);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
