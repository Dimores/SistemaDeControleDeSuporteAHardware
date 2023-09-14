/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import model.Login;
import model.interfaces.Ivalidate;

/**
 *
 * @author ruiz
 */
public class LoginValidate {
    Ivalidate validaEmail;
    Ivalidate validaSenha;
    
    public LoginValidate (){
        validaEmail = new EmailValidate();
        validaSenha = new PassWordValidate();
    }
    
    public Login validar(String email, String senha) throws Exception{
        if (email.isEmpty()  || senha.isEmpty()){
            throw new Exception("Campo Vazio");
        }
        if(!validaEmail.validar(email)){
            throw new Exception("Email invalido");
        }if (!validaSenha.validar(senha)){
            throw new Exception("Senha invalida");
        }
        
        return new Login();               
    }
    
}
