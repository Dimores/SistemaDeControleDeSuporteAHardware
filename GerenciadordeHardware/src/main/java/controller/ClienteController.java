/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.tableModel.TMCadCliente;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import model.*;
import lombok.*;
import model.dao.ClienteDAO;
import model.exceptions.ClienteException;
import model.validations.ClienteValidate;
import utils.Criptografia;
@Getter //constroi os metodos get
@Setter //constroi os metodos set
@EqualsAndHashCode //constroi os metodos equals e hashCode 
@ToString 

/**
 *
 * @author ruiz
 */


public class ClienteController extends UsuarioController{
    ClienteDAO repositorio;
    Criptografia crip;
    public ClienteController(){
        repositorio = new ClienteDAO();
    }
    
    public void atualizarTabela(JTable grdClientes) {
        List<Object> lst = repositorio.findAll();

        TMCadCliente tmCliente = new TMCadCliente(lst); 
        grdClientes.setModel(tmCliente);
    }

    public void atualizarCliente(String id, String nome, String CPF, String dataNasc, String senha, String email, String telefone) throws NoSuchAlgorithmException {
        ClienteValidate valid = new ClienteValidate(); 
        this.crip = new Criptografia();
        Cliente novoCliente = valid.validaCamposEntrada(id, nome, CPF, dataNasc, senha, email, telefone); 
        novoCliente.setId(id);
        System.out.println("Senha: "+ senha );
        
        try {
            
            novoCliente.setSenha(crip.encrypt(senha));
            
        } catch (Exception ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        repositorio.update(novoCliente);
    }

    public void cadastrarCliente(String id, String nome, String CPF, String dataNasc, String senha, String email, String telefone) throws NoSuchAlgorithmException, Exception {
        ClienteValidate valid = new ClienteValidate(); 
        this.crip = new Criptografia();
        Cliente novoCliente = valid.validaCamposEntrada(id, nome, CPF, dataNasc, senha, email, telefone); 
        novoCliente.setSenha(crip.encrypt(senha));
        if(repositorio.findByEmail(email) == null){
            repositorio.save(novoCliente);
        }else{
             throw new ClienteException("Error - Já existe um cliente com este 'Email'.");
        }
    
    }
    
    public Cliente buscarCliente(String email) { // Alterado de buscarAluno para buscarTecnico
        return (Cliente) this.repositorio.findByEmail(email); // Alterado de Aluno para Tecnico
    }

    public void excluirCliente(Cliente clienteExcluido) {
        
        if (clienteExcluido != null) {
            repositorio.delete(clienteExcluido);
        } else {
            throw new ClienteException("Error - Cliente inexistente."); 
        }
    }
    
}
