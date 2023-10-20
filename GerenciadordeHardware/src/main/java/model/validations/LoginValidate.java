/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import model.Cliente;
import model.Gerente;
import model.Login;
import model.Tecnico;
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
    
    public int  accessManager(Object obj){
        if(obj instanceof Cliente){
            return 1;
        }if(obj instanceof Tecnico){
            return 2;
        }if(obj instanceof Gerente){
            return 3;
        }
        return 0;
    }
    
}
