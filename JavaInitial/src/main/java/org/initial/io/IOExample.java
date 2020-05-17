package org.initial.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.logging.Logger;

public class IOExample {
	
	private static final Logger LOG = Logger.getLogger("IOExample.class");
	
	public static void main() {
		IOExample.inputOutput();
	}
	
	public static void inputOutput() {
		
		File file = new File("/test.txt");
		Writer writer = null;
		Reader reader = null;
		
		// FileWriter
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
			writer.write("Bienvenue dans la formation Java");
			
			// FileReader
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			
			reader.read();
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			LOG.severe(e.getMessage());
		} catch (IOException e) {
			LOG.severe(e.getMessage());
		}finally {
			try {
				writer.close();
				reader.close();
			} catch (IOException e) {
				LOG.severe(e.getMessage());
			}
		}
		System.out.println();
		
	}
}
