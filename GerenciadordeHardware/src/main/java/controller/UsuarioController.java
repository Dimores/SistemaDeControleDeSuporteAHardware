/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import lombok.*;
import model.Tecnico;
import model.dao.TecnicoDAO;
import utils.Criptografia;
import utils.interfaces.ICriptografia;
@Getter //constroi os metodos get
@Setter //constroi os metodos set
@EqualsAndHashCode //constroi os metodos equals e hashCode 
@ToString 

/**
 *
 * @author ruiz
 */
public class UsuarioController {
    private TecnicoDAO repositorio;
    private ICriptografia criptografia;
    
    public void atualizarSenha(String id, double salario, String nome, String CPF, String dataNasc, String senha, String email, String telefone) throws Exception{
        criptografia = new Criptografia();
        senha = criptografia.encrypt(senha);
        Tecnico novoTecnico = new Tecnico(id, salario, nome, CPF, dataNasc,senha, email, telefone);
        repositorio.update(novoTecnico);
    }

    public Tecnico buscarUsuario(String text) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
