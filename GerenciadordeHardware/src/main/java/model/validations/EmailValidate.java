/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 *
 * @author ruiz
 */
public class EmailValidate {
    private String email;
    
    public EmailValidate(String email){
        this.email = email;
    }
    
    public void validarEmail()  {
        if("".equals(this.email)){
            throw new RuntimeException("email Invalido");
        }else{
            System.out.print("email valido");
        }
                
    }
    
}
