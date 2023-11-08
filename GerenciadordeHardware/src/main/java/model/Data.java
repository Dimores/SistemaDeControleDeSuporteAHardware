/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author diego
 */
public class Data {
    
    public static String pegaDataSistema(){
        Date dataAtual = new Date();       
        // Cria um objeto SimpleDateFormat para formatar a data
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = sdf.format(dataAtual);;        
        return dataFormatada;    
    }
}
