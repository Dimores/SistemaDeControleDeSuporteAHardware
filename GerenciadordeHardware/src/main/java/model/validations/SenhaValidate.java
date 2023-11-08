/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import model.interfaces.Ivalidate;

/**
 *
 * @author ruiz
 */
public class SenhaValidate implements Ivalidate {
    
    String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$!%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]).*$";
    @Override
     public boolean validar(Object o) {
        String text = (String) o;
       if(text.length() < 8){
           return false;
       }
       return text.matches(regex);
    }

}
