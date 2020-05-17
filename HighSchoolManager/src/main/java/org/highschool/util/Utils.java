/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.highschool.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author vincent baylly
 */
public final class Utils {
	
	/**
	 * the class Utils can not be instantiate
	 */
	private Utils() {

    }
	
	/**
	 * Parse a String date YYYY-MM-DD to a date to the format
	 * YYYY-MM-DD HH:MM:SS.SSS 
	 * @param textFieldContain
	 * @return date parsed
	 */
    public static Date parseToDate(String textFieldContain) throws ParseException{
        return new SimpleDateFormat("YYYY-MM-dd HH:MM:SS.SSS").parse(textFieldContain + " 00:00:00.000");
    }
    
	/**
	 * Parse date to the format YYYY-MM-DD HH:MM:SS.SSS 
	 * @param textFieldContain
	 * @return date parsed
	 */
    public static String parseDate(Date date) throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        return dateFormat.format(date);
    }

}
