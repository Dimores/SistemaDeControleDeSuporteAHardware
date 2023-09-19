/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import model.Cliente;
import model.Usuario;

/**
 *
 * @author ruiz
 */
public class ClienteValidate extends UsuarioValidate{
      public Cliente validaCamposEntrada(String id, double salario, String nome, String CPF, String dataNasc, String senha, String email, String telefone){
         Usuario cliente = new Cliente();
         cliente = (Cliente) super.validaCamposEntrada(cliente, id, nome, CPF, dataNasc, senha, email, telefone);
          return (Cliente) cliente; 
      }
}
