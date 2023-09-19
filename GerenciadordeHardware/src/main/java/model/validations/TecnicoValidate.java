/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import java.util.Calendar;
import java.util.HashSet;
import model.Tecnico;
import model.exceptions.TecnicoException;

/**
 *
 * @author diego
 */
public class TecnicoValidate  {
    CPFValidate validaCPF;
    SenhaValidate validaSenha;
    

    public Tecnico validaCamposEntrada(String id, double salario, String nome, String CPF, String dataNasc, String senha, String email, String telefone){
        Tecnico tecnico = new Tecnico();
        
        if (salario <= 0){
            throw new TecnicoException("Error - Valor inválido no campo 'salario'.");
        }
        tecnico.setSalario(salario);
        
        if (nome.isEmpty())
            throw new TecnicoException("Error - Campo vazio: 'nome'.");
        tecnico.setNome(nome);
        
        if (CPF.isEmpty())
            throw new TecnicoException("Error - Campo vazio: 'CPF'.");
        if(!validaCPF.validar(CPF)){
            throw new TecnicoException("Error - CPF invalido");
        }
        tecnico.setCPF(CPF);
        
        // Nao verificar o calendar por enquanto 
        tecnico.setDataNasc(dataNasc);
        
        if (senha.isEmpty())
            throw new TecnicoException("Error - Campo vazio: 'senha'.");
        if(!validaSenha.validar(senha)){
             throw new TecnicoException("Error - Campo vazio: 'senha'.");
        }
        tecnico.setSenha(senha);
        
        if (email.isEmpty())
            throw new TecnicoException("Error - Campo vazio: 'email'.");
        tecnico.setEmail(email);
        
        if (telefone.isEmpty())
            throw new TecnicoException("Error - Campo vazio: 'telefone'.");
        tecnico.setTelefone(telefone);
        
                
        return tecnico;
    }
    
}
