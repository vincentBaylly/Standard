package org.standard.bestpratice.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileHandling {

	private static final Logger LOG = LoggerFactory
			.getLogger(FileHandling.class);

	private static final String PROP_FILE = "src/main/resources/config.properties";

	private Properties prop = new Properties();
	private OutputStream output;
	private InputStream input;

	public FileHandling() {

		try {
			output = new FileOutputStream(PROP_FILE);
			input = new FileInputStream(PROP_FILE);

		} catch (FileNotFoundException e) {
			LOG.error("Properties file not Found", e);
		}

	}

	public void writeInPropertiesFile() {

		try {
			// set the properties value
			prop.setProperty("database", "localhost");
			prop.setProperty("dbuser", "mkyong");
			prop.setProperty("dbpassword", "password");

			// save properties to project root folder
			prop.store(output, null);
		} catch (IOException ex) {
			LOG.error("Can not write in the properties file", ex);
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					LOG.error("Can not close the properties file after writting", e);
				}
			}
		}

	}

	public void readInPropertiesFile() {

		try {

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			LOG.debug(prop.getProperty("database"));
			LOG.debug(prop.getProperty("dbuser"));
			LOG.debug(prop.getProperty("dbpassword"));

		} catch (IOException ex) {
			LOG.error("Can not read the properties file", ex);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					LOG.error("Can not close the properties file after reading", e);
				}
			}
		}
	}

}
