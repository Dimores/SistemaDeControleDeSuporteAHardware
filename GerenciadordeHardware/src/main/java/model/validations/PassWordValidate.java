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
public class PassWordValidate implements Ivalidate {
    @Override
    public boolean validar(String text) {
       if(text.length() < 8){
           return false;
       }
       if(!text.matches("senha1234")){
           return false;
       }
       return true;
    }

    @Override
    public boolean validar(int number) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
