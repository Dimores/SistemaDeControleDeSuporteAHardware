/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Random;

/**
 *
 * @author diego
 */
public class CodigoBarra {
    public static String geraCodigoBarras(){
        String codigo = "";
        int num;
        Random gerador = new Random();
        for(int i = 0; i < 8; i++){
            num = gerador.nextInt(10);
            codigo += String.valueOf(num);
        }
        return codigo;
    }
    
}
