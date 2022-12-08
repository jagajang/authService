package com.jagajang.dbserver.encrypt.hash;

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class HashSHA256 implements Hash {
    @Override
    public String hash(String message) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(message.getBytes());

            return String.format("%64x", new BigInteger(1, messageDigest.digest()));
        } catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
