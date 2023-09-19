/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import model.Login;
import model.exceptions.LoginException;
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
        validaSenha = new SenhaValidate();
    }
    
    public Login validar(String email, String senha) throws Exception{
        if (email.isEmpty()  || senha.isEmpty()){
            throw new LoginException("Campo Vazio");
        }
        if(!validaEmail.validar(email)){
            throw new LoginException("Email invalido");
        }if (!validaSenha.validar(senha)){
            throw new LoginException("Senha invalida");
        }
        
        return new Login();               
    }
    
}
