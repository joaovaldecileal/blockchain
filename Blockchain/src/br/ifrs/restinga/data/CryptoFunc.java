/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrs.restinga.data;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author yk.hjm
 */
public class CryptoFunc {

	
    public static String getSHA2(String m) {

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(m.getBytes(StandardCharsets.UTF_8));
            String sha256 = DatatypeConverter.printHexBinary(hash).toLowerCase();
            return sha256;
        }catch (NoSuchAlgorithmException e) { 
            System.out.println("Exception thrown"+ " for incorrect algorithm: " + e); 
            return null;        
        } 
    }
    public static String DificuldadeString(int dificuldade) {
		return new String(new char[dificuldade]).replace('\0', '0');
	}
    
    
}

