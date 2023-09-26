/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import lombok.*;
import model.dao.ClienteDAO;
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
    private TecnicoDAO repositorioTecnico;
    private ClienteDAO repositorioCliente;
    private ICriptografia criptografia;
    
    public void atualizarSenha(String id, double salario, String nome, String CPF, String dataNasc, String senha, String email, String telefone) throws Exception{
        criptografia = new Criptografia();
        senha = criptografia.encrypt(senha);
  
    }

    public Object buscarUsuario(String text) {
        repositorioTecnico = new TecnicoDAO();
        repositorioCliente = new ClienteDAO();
        Object usuario;
        usuario = repositorioTecnico.findByEmail(text);
        if(usuario == null){
            usuario = repositorioCliente.findByEmail(text);
        }  
        return usuario;
    }
    
}
