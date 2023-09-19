/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import model.Usuario;
import model.exceptions.UserException;

/**
 *
 * @author diegomorelo
 */
public class UsuarioValidate {
        CPFValidate validaCPF;
    SenhaValidate validaSenha;
    

    public Usuario validaCamposEntrada(String id, String nome, String CPF, String dataNasc, String senha, String email, String telefone){
        Usuario user = new Usuario();
        
        if (nome.isEmpty())
            throw new UserException("Error - Campo vazio: 'nome'.");
        user.setNome(nome);
        
        if (CPF.isEmpty())
            throw new UserException("Error - Campo vazio: 'CPF'.");
        if(!validaCPF.validar(CPF)){
            throw new UserException("Error - CPF invalido");
        }
        user.setCPF(CPF);
        
        // Nao verificar o calendar por enquanto 
        user.setDataNasc(dataNasc);
        
        if (senha.isEmpty())
            throw new UserException("Error - Campo vazio: 'senha'.");
        if(!validaSenha.validar(senha)){
             throw new UserException("Error - Senha Invalida.");
        }
        user.setSenha(senha);
        
        if (email.isEmpty())
            throw new UserException("Error - Campo vazio: 'email'.");
        user.setEmail(email);
        
        if (telefone.isEmpty())
            throw new UserException("Error - Campo vazio: 'telefone'.");
        user.setTelefone(telefone);
        
                
        return user;
    }
}
