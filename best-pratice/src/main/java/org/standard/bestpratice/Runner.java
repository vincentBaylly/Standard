package org.standard.bestpratice;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;


public class Runner {

    private static final Logger LOG = LoggerFactory.getLogger(Runner.class);

    private static Integer existingId = 1;

    public static void main(String[] args) {

        LOG.debug("Run fun stuff to be sure we are able to comput in Java");

        String phoneIdI = "0P2";
        String phoneIdJ = "0P1";



        if (Integer.parseInt(phoneIdI.replaceAll("[\\D]", "")) > Integer.parseInt(phoneIdJ.replaceAll("[\\D]", ""))) {
            LOG.debug("Integer " + Integer.parseInt(phoneIdI.replaceAll("[\\D]", "")));
        }


        LOG.debug("We did it right, we can now use it in our code ");
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