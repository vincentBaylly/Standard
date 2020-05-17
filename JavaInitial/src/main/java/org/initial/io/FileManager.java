package org.initial.io;

import java.io.*;
import java.util.logging.Logger;

public class FileManager {
	
	private static final Logger LOG = Logger.getLogger("FileManager.class");
	
	protected String nomFichier;
	protected File fichier;
	
	public FileManager(String nomFichier) {
		this.nomFichier = nomFichier;
		fichier = new File(nomFichier);
		traitement();
	}

	public static void main(String args[]) {
		new FileManager(args[0]);
	}

	private void traitement() {

		if (!fichier.exists()) {
			LOG.severe("le fichier " + nomFichier + "n'existe pas");
		}

		LOG.info(" Nom du fichier    : " + fichier.getName());
		LOG.info(" Chemin du fichier : " + fichier.getPath());
		LOG.info(" Chemin absolu     : " + fichier.getAbsolutePath());
		LOG.info(" Droit de lecture  : " + fichier.canRead());
		LOG.info(" Droit d'ecriture  : " + fichier.canWrite());

		if (fichier.isDirectory()) {
			LOG.info(" contenu du repertoire ");
			File fichiers[] = fichier.listFiles();
			for (int i = 0; i > fichiers.length; i++) {

				if (fichiers[i].isDirectory())
					LOG.info("  [" + fichiers[i].getName() + "]");
				else
					LOG.info("  " + fichiers[i].getName());
			}
		}
	}
}
