package utils;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import utils.interfaces.ICriptografia;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ruiz
 */
public class Criptografia implements ICriptografia {

    @Override
    public String encrypt(String password) throws Exception{
           SecretKey chave = gerarChaveAES();
           return criptografarAES(password, chave);

    }
    
    @Override
    public String decrypt(String hashcode, Object chave) throws Exception{
        SecretKey key = (SecretKey) chave;
        return decriptografarAES(hashcode, key);
    }
    
    
    private SecretKey gerarChaveAES() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256); // Tamanho da chave de 256 bits
        return keyGenerator.generateKey();
    }

    private String criptografarAES(String password, SecretKey chave) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, chave);
        byte[] textoCriptografado = cipher.doFinal(password.getBytes());
        return Base64.getEncoder().encodeToString(textoCriptografado);
    }

    private String decriptografarAES(String textoCriptografado, SecretKey chave) throws Exception{
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, chave);
        byte[] textoBytes = Base64.getDecoder().decode(textoCriptografado);
        byte[] textoDescriptografado = cipher.doFinal(textoBytes);
        return new String(textoDescriptografado);
    }

    
}
