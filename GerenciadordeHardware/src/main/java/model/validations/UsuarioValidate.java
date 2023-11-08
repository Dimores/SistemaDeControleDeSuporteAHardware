/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import model.Tecnico;
import model.Usuario;
import model.exceptions.UserException;

/**
 *
 * @author diegomorelo
 */
public class UsuarioValidate {
    CPFValidate validaCPF;
    SenhaValidate validaSenha;
    EmailValidate validaEmail;
    

    public Usuario validaCamposEntrada(Usuario user, Long id, String nome, String CPF, String dataNasc, String senha, String email, String telefone){
        
        validaCPF = new CPFValidate();
        validaSenha = new SenhaValidate();
        validaEmail = new EmailValidate();
        
        if (nome.isEmpty())
            throw new UserException("Error - Campo vazio: 'nome'.");
        user.setNome(nome);
        
        if (CPF.isEmpty())
            throw new UserException("Error - Campo vazio: 'CPF'.");
        if(!validaCPF.validar(CPF)){
            throw new UserException("Error - CPF invalido");
        }
        user.setCPF(CPF);
        if(dataNasc.isEmpty()){
            throw new UserException("Error - Campo vazio: 'Data de nascimento'.");
        }
        user.setDataNasc(dataNasc);
        
        if (senha.isEmpty())
            throw new UserException("Error - Campo vazio: 'senha'.");
        if(!validaSenha.validar(senha)){
             throw new UserException("Error - Senha Invalida.");
        }
        user.setSenha(senha);
        
        if (email.isEmpty())
            throw new UserException("Error - Campo vazio: 'email'.");
        if(!validaEmail.validar(email)){
             throw new UserException("Error -'email' invalido.");
        }
        user.setEmail(email);
        
        if (telefone.isEmpty())
            throw new UserException("Error - Campo vazio: 'telefone'.");
        user.setTelefone(telefone);
        
                
        return user;
    }
}
