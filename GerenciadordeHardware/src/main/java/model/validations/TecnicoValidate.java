/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import model.Tecnico;

import model.exceptions.TecnicoException;

/**
 *
 * @author diego
 */
public class TecnicoValidate  extends UsuarioValidate{
    public Tecnico validaCamposEntrada(Long id, double salario, String nome, String CPF, String dataNasc, String senha, String email, String telefone){
        Tecnico tecnico = new Tecnico(); 
        tecnico = (Tecnico)  super.validaCamposEntrada(tecnico, id, nome, CPF, dataNasc, senha, email, telefone);
        if (salario <= 0){
            throw new TecnicoException("Error - Valor inválido no campo 'salario'.");
        }
        tecnico.setSalario(salario);        
        return tecnico;
    }
    
}
