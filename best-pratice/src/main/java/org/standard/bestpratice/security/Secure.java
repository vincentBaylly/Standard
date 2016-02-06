/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.standard.bestpratice.security;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import org.apache.commons.codec.binary.Base64;
import org.jasypt.digest.StandardStringDigester;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author wallace
 */
public class Secure {

    private static final Logger LOG = LoggerFactory.getLogger(Secure.class);

    public void secure() {
        StandardStringDigester digester = new StandardStringDigester();
        digester.setAlgorithm("SHA-1");   // optionally set the algorithm
        digester.setIterations(2500);
        digester.setSaltSizeBytes(8);
        String digest = digester.digest("9s_X$3Bo6");

        encodeRampartNonce();

        LOG.debug("password : " + digest);

        LOG.debug("random Id " + getSaltString());
    }

    public String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 32) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    public void encodeRampartNonce() {
        Random random = null;
        try {
            random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(System.currentTimeMillis());
        } catch (final NoSuchAlgorithmException ex) {
            LOG.error("Sha 1 not find", ex);
        }
        final byte[] r = new byte[16];
        random.nextBytes(r);
        String nonceBase64 = Base64.encodeBase64String(r);

        LOG.debug(r.toString());
        nonceBase64 = nonceBase64.replaceAll("[\r\n]+", "");
        LOG.debug(nonceBase64);
        LOG.debug("saut de ligne");
        //dHxHn8NcEjzaQ4KQX6j27Q==
        //ZlMIni/fEyY4qpBCJXAIxQ==
        //tAzmLb8dbvHtHARq1EF5OQ==
        //0BoFd08zqh1z8htR9WqtrUCayXY=
    }

}
