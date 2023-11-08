/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import lombok.*;

@Getter //constroi os metodos get
@Setter //constroi os metodos set
@EqualsAndHashCode //constroi os metodos equals e hashCode 
@ToString 

/**
 *
 * @author ruiz
 */
public class Login {
    private String email;
    private String passWord;
    private Usuario user;
    
    
    public Login(){
        this.email = "";
        this.passWord = "";
        this.user = null;
    }
    
    public Login(String email, String senha, Usuario user){
        this.email = email;
        this.passWord = senha;
        this.user = user;
    }
    
    
}
