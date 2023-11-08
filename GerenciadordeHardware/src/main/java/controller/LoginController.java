/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.*;
import lombok.*;
import model.validations.LoginValidate;
@Getter //constroi os metodos get
@Setter //constroi os metodos set
@EqualsAndHashCode //constroi os metodos equals e hashCode 
@ToString 

/**
 *
 * @author ruiz
 */
public class LoginController {

    private UsuarioController usuarioController;
        
    public Login validarLogin(String email , String senha) throws Exception{
        LoginValidate loginValidate = new LoginValidate();
        return loginValidate.validar(email, senha);
    }
    
    public int accessManager(Object obj){
        LoginValidate loginValidate = new LoginValidate();
        return loginValidate.accessManager(obj);
    }
    
}
