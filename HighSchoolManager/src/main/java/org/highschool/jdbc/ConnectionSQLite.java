package org.highschool.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Logger;

public abstract class ConnectionSQLite{
	
	private static final Logger LOG = Logger.getLogger("DAO");
	
    private static final String PROP_FILE = "src/main/resources/dbconfig.properties";

    private static Properties prop = new Properties();
    private static InputStream input;
	
	private static Connection connect;
	
	private static Statement request;
	
	/**
	 * Méthode qui va nous retourner notre instance
	 * et la créer si elle n'existe pas...
	 * @return
	 */
	public static Connection getInstance(){
		return connect;	
	}
	
	/**
	 * Ouvre la base de données spécifiée
	 * 
	 * @return True si la connection à été réussie. False sinon.
	 */
	public static boolean connect() {
		try {
			// Etabli la connection
			
            // charge le fichier de propriete
			try {
				input = new FileInputStream(PROP_FILE);
				prop.load(input);
	        } catch (FileNotFoundException e) {
	            LOG.severe("Properties file not Found: " + e.getMessage());
	        } catch (IOException e) {
	        	LOG.severe("Cannot open properties file: " + e.getMessage());
	        }

			Class.forName("org.sqlite.JDBC");
			connect = DriverManager.getConnection("jdbc:" + prop.getProperty("datamanager") + ":" + prop.getProperty("database"));
			
			// Déclare l'objet qui permet de faire les requêtes
			request = connect.createStatement();

			// Le PRAGMA synchronous de SQLite permet de vérifier chaque écriture
			// avant d'en faire une nouvelle.
			// Le PRAGMA count_changes de SQLite permet de compter le nombre de
			// changements fait sur la base
			// Résultats de mes tests :
			// synchronous OFF, une insertion est 20 fois plus rapide.
			// La différences avec le count_changes est de l'ordre de la µs.
			// Les autres PRAGMA : http://www.sqlite.org/pragma.html

			request.executeUpdate("PRAGMA synchronous = OFF;");
			request.setQueryTimeout(30);
			
			return true;
		} catch (SQLException e) {
			// message = "out of memory" souvent le resultat de la BDD pas trouvée
			LOG.severe(e.getMessage());
			return false;
		} catch (ClassNotFoundException e) {
			LOG.severe(e.getMessage());
		}
		
		return false;
	}
	
	/**
	 * Ferme la connection à la base de données
	 * 
	 * @return True si la connection a bien été fermée. False sinon.
	 */
	public static boolean disconnect() {
		try {
			if (connect != null)
				connect.close();

			return true;
		} catch (SQLException e) {
			LOG.severe(e.getMessage());
			return false;
		}
	}
}
