/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.standard.bestpratice.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author wallace
 */
public class DateFormater {

    private static final Logger LOG = LoggerFactory.getLogger(DateFormater.class);

    public void createGregorianDate() {
        try {

            final GregorianCalendar now = (GregorianCalendar) GregorianCalendar.getInstance();

            DatatypeFactory dataTypeFactory = DatatypeFactory.newInstance();
            XMLGregorianCalendar xmlStartTime = dataTypeFactory.newXMLGregorianCalendar(now);
            xmlStartTime.setTimezone(0);
            System.out.println(xmlStartTime.toString());

            now.add(Calendar.MINUTE, 1);

            XMLGregorianCalendar xmlStartTime1Minute = dataTypeFactory.newXMLGregorianCalendar(now);
            xmlStartTime1Minute.setTimezone(0);
            System.out.println(xmlStartTime1Minute.toString());

        } catch (DatatypeConfigurationException ex) {
            LOG.error("gregorian date was not instancite correctly", ex);
        }
    }

    public Calendar convertToGmt(Calendar cal) {

        Date date = cal.getTime();
        TimeZone tz = cal.getTimeZone();

        LOG.debug("input calendar has date [" + date + "]");

        //Returns the number of milliseconds since January 1, 1970, 00:00:00 GMT 
        long msFromEpochGmt = date.getTime();

        //gives you the current offset in ms from GMT at the current date
        int offsetFromUTC = tz.getOffset(msFromEpochGmt);
        LOG.debug("offset is " + offsetFromUTC);

        //create a new calendar in GMT timezone, set to this date and add the offset
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.setTime(date);
        gmtCal.add(Calendar.MILLISECOND, offsetFromUTC);

        LOG.debug("Created GMT cal with date [" + gmtCal.getTime() + "]");

        return gmtCal;
    }

    public Calendar convertCalendar(final Calendar calendar, final TimeZone timeZone) {
        Calendar ret = new GregorianCalendar(timeZone);
        ret.setTimeInMillis(calendar.getTimeInMillis()
                + timeZone.getOffset(calendar.getTimeInMillis())
                - TimeZone.getDefault().getOffset(calendar.getTimeInMillis()));
        ret.getTime();
        return ret;
    }

    public void useSimpleDateFormat() {
        final Calendar now = convertCalendar(Calendar.getInstance(), TimeZone.getTimeZone("Etc/Zulu"));

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S'Z'");
//        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dateNow = format.format(now.getTime());

        now.add(Calendar.SECOND, 1);

        String dateNow1Second = format.format(now.getTime());

        LOG.debug("now : " + dateNow);
        LOG.debug("now1Second : " + dateNow1Second);
    }

}
