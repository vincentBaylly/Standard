package org.standard.bestpratice.serialize;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** JDK before version 7. */
public class Serializer {
	
	// Use Java's logging facilities to record exceptions.
	// The behavior of the logger can be configured through a
	// text file, or programmatically through the logging API.
	private static final Logger LOG = LoggerFactory.getLogger(Serializer.class);
	
	@SuppressWarnings("unchecked")
	public void serialize() {
		// create a Serializable List
		List<String> quarks = Arrays.asList("up", "down", "strange", "charm",
				"top", "bottom");

		// serialize the List
		// note the use of abstract base class references

		try {
			// use buffering
			OutputStream file = new FileOutputStream("src/main/resources/quarks.ser");
			OutputStream buffer = new BufferedOutputStream(file);
			ObjectOutput output = new ObjectOutputStream(buffer);
			try {
				output.writeObject(quarks);
			} finally {
				output.close();
			}
		} catch (IOException ex) {
			LOG.error("Cannot perform output.", ex);
		}

		// deserialize the quarks.ser file
		// note the use of abstract base class references

		try {
			// use buffering
			InputStream file = new FileInputStream("src/main/resources/quarks.ser");
			InputStream buffer = new BufferedInputStream(file);
			ObjectInput input = new ObjectInputStream(buffer);
			try {
				// deserialize the List
				List<String> recoveredQuarks = (List<String>) input
						.readObject();
				// display its data
				for (String quark : recoveredQuarks) {
					LOG.debug("Recovered Quark: " + quark);
				}
			} finally {
				input.close();
			}
		} catch (ClassNotFoundException ex) {
			LOG.error("Cannot perform input. Class not found.",
					ex);
		} catch (IOException ex) {
			LOG.error("Cannot perform input.", ex);
		}
	}

}
