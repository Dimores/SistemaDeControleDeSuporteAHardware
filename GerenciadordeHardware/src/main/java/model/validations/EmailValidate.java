/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import lombok.Getter;
import lombok.Setter;
import model.interfaces.Ivalidate;

@Getter
@Setter
/**
 *
 * @author ruiz
 */
public class EmailValidate implements Ivalidate{
   
    
    public EmailValidate(){
       
    }
    
    public boolean validar(String email)  {
        if("".equals(email)){
            return false;
        }else if(!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")){
            return false;
        }return true;
                
    }

    @Override
    public boolean validar(int number) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}