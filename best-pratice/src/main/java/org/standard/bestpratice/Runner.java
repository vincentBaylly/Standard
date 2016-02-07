package org.standard.bestpratice;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;


public class Runner {

    private static final Logger LOG = LoggerFactory.getLogger(Runner.class);

    private static Integer existingId = 1;

    public static void main(String[] args) {

        LOG.debug("Run fun stuff to be sure we are able to comput in Java");

                JSONParser parser = new JSONParser();
        
        StringBuilder json = callService();
        
        Object trafficCamInfo;
        try {
            trafficCamInfo = parser.parse(json.toString());
            JSONObject trafficCamInfoJSON = (JSONObject) trafficCamInfo;
            
            //LOG.debug(trafficCamInfoJSON.get("features").toString());
            JSONArray features = (JSONArray)trafficCamInfoJSON.get("features");
            

            //LOG.debug(features.get(1).toString());        
            JSONObject feature1 = (JSONObject)features.get(1);
            
            LOG.debug(feature1.get("geometry").toString());
            JSONObject geometry = (JSONObject)feature1.get("geometry");
            
            LOG.debug(geometry.get("coordinates").toString());
            JSONArray coordinates = (JSONArray)geometry.get("coordinates");
            
            LOG.debug("Lantitude : " + coordinates.get(0).toString() + ", Longitude : " + coordinates.get(1).toString());
            
        } catch (ParseException ex) {
            LOG.error("json parsing want wrong", ex);
        }


        LOG.debug("We did it right, we can now use it in our code ");
    }
    
    /**
     * Call the camera information service for Montreal open data.
     *
     * @return StringBuilder the JSON service output.
     */
    public static StringBuilder callService() throws RuntimeException {

        //TODO add to properties file
        String camInfoURL = "http://ville.montreal.qc.ca/circulation/sites/ville.montreal.qc.ca.circulation/files/cameras-de-circulation.json";

        StringBuilder output = null;

        try {

            URL url = new URL(camInfoURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            output = new StringBuilder();
            String out;
            LOG.debug("Output from Server .... \n");
            while ((out = br.readLine()) != null) {
                output.append(out);
                LOG.debug(out);
            }

            conn.disconnect();

        } catch (MalformedURLException ex) {

            LOG.error("the url to call is not valid : " + camInfoURL, ex);

        } catch (IOException ex) {

            LOG.error("json reading want wrong", ex);

        }

        return output;

    }
    
    public void convertStringToInteger(){
        
        String phoneIdI = "0P2";
        String phoneIdJ = "0P1";

        if (Integer.parseInt(phoneIdI.replaceAll("[\\D]", "")) > Integer.parseInt(phoneIdJ.replaceAll("[\\D]", ""))) {
            LOG.debug("Integer " + Integer.parseInt(phoneIdI.replaceAll("[\\D]", "")));
        }
    }
    
    public void getNextId() {

        int id = 1;
        if (existingId != null) {
            id = existingId + 1;
        }
        final String nextId = "E" + id++;
        existingId = id;

        LOG.debug("id : " + id);
        LOG.debug("nextId : " + existingId);

        LOG.debug("contactType : " + nextId);
    }



    public void increment() {

        LOG.debug("Run fun stuff to be sure we are able to comput in Java");

        int i = 0;
        int j = 1;

        LOG.debug("i: " + ++i + " j: " + j++);
        LOG.debug("i : " + i + " j: " + j);
    }

    public void marchallingUmarshalling() {
        try {

            final JAXBContext jaxbContext = JAXBContext.newInstance("com.charter.enterprise.prefcomm.v1");
            final Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

//                final JAXBElement<SaveContactDatasByValuesListResponse> test =
//                            (JAXBElement<SaveContactDatasByValuesListResponse>) unmarshaller.unmarshal(new File(
//                                    "saveContactDatasByValuesListResponse.xml"));
//                    System.out.println("contact ID " + test.getValue().getReturn().get(0).getContact().getId());
            // Marshal the employees list in console
//                    jaxbMarshaller.marshal(test, System.out);
        } catch (final JAXBException ex) {
            LOG.error("the unmarshalling didn't spend well", ex);
        }
    }

}
