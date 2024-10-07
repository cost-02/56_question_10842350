package com.example;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESDecryptor {
    public static String decrypt() throws Exception {
        String base64EncodedText = "iz1qFlQJfs6Ycp+gcc2z4w==";
        byte[] decodedBytes = Base64.getDecoder().decode(base64EncodedText);
        
        String key = "1234567812345678";
        String iv = "1234567812345678";
        
        SecretKeySpec keyspec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes("UTF-8"));
        
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
        byte[] decrypted = cipher.doFinal(decodedBytes);
        
        return new String(decrypted, "UTF-8");
    }

    public static void main(String[] args) {
        try {
            String result = decrypt();
            System.out.println("Decrypted text: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
