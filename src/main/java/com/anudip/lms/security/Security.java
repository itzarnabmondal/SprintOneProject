package com.anudip.lms.security;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * A utility class that provides methods for generating hash values using the
 * SHA-256 algorithm.
 * 
 * @since v1.0
 */
public class Security {

    /**
     * Returns the SHA-256 hash of the input string as a byte array.
     * 
     * @param input the input string to hash
     * @return the SHA-256 hash of the input string as a byte array
     * @throws NoSuchAlgorithmException if the SHA-256 algorithm is not available
     */
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException {
        // Get a MessageDigest instance for the SHA-256 algorithm
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        // Calculate the SHA-256 hash of the input string and return it as a byte array
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Returns the hexadecimal string representation of the given byte array.
     * 
     * @param hash the byte array to convert to a hexadecimal string
     * @return the hexadecimal string representation of the given byte array
     */
    public static String toHexString(byte[] hash) {
        // Convert the byte array to a BigInteger
        BigInteger number = new BigInteger(1, hash);
        // Convert the BigInteger to a hexadecimal string
        StringBuilder hexString = new StringBuilder(number.toString(16));
        // Pad the hexadecimal string with leading zeros until it has a length of 64
        while (hexString.length() < 64) {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }

    /**
     * Returns the SHA-256 hash of the input string as a hexadecimal string.
     * 
     * @param input the input string to hash
     * @return the SHA-256 hash of the input string as a hexadecimal string
     * @throws Exception if an exception occurs while hashing the input string
     */
    public static String getSha256(String input) throws Exception {
        // Calculate the SHA-256 hash of the input string as a byte array
        byte[] hash = getSHA(input);
        // Return the hexadecimal string representation of the hash
        return toHexString(hash);
    }
}