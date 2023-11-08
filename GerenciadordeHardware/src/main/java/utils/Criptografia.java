package utils;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Random;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

import utils.interfaces.ICriptografia;

public class Criptografia implements ICriptografia {
    private SecretKey key;

    // Chave fixa (coloque a sua chave aqui)
    private static final String CHAVE_FIXA = "[B@1ebddasdasdasddsfe45@akdjfalk";

    public Criptografia() throws NoSuchAlgorithmException {
        // Use a chave fixa para criar a chave AES
        this.key = gerarChaveAES(CHAVE_FIXA);
        
    }

    @Override
    public String encrypt(String password) throws Exception {
        return criptografarAES(password, this.key);
    }

    @Override
    public String decrypt(String hashcode) throws Exception {
        return decriptografarAES(hashcode);
    }

    private SecretKey gerarChaveAES(String chave) {
        // Converte a chave em bytes
        byte[] chaveBytes = chave.getBytes();
        // Cria a chave secreta usando o algoritmo AES
        return new SecretKeySpec(chaveBytes, "AES");
    }

    private String criptografarAES(String password, SecretKey chave)
            throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, chave);
        byte[] textoCriptografado = cipher.doFinal(password.getBytes());
        return Base64.getEncoder().encodeToString(textoCriptografado);
    }
    
    private void gerarChaveAES() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        System.out.println(keyGenerator.generateKey().getEncoded()); // Tamanho da chave de 256 bits
    }

    private String decriptografarAES(String textoCriptografado) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, this.key);
        byte[] textoBytes = Base64.getDecoder().decode(textoCriptografado);
        byte[] textoDescriptografado = cipher.doFinal(textoBytes);
        return new String(textoDescriptografado);
    }
    
    public static String generateRandomCode() {
        // Defina os caracteres permitidos para o código
        String allowedCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        
        // Crie um objeto Random para gerar números aleatórios
        Random random = new Random();
        
        // Crie uma string vazia para armazenar o código gerado
        StringBuilder code = new StringBuilder(4); // 4 caracteres
        
        // Gere 4 caracteres aleatórios
        for (int i = 0; i < 4; i++) {
            int randomIndex = random.nextInt(allowedCharacters.length());
            char randomChar = allowedCharacters.charAt(randomIndex);
            code.append(randomChar);
        }
        
        return code.toString();
    }
    
    
}
