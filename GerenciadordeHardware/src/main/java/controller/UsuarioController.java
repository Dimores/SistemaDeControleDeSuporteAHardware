/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.ArrayList;
import java.util.List;
import lombok.*;
import model.Cliente;
import model.Gerente;
import model.Tecnico;
import model.Usuario;
import model.dao.ClienteDAO;
import model.dao.GerenteDAO;
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
    private GerenteDAO repositorioGerente;
    
    private ICriptografia criptografia;
    
    public void atualizarSenha(Usuario user, String senha) throws Exception{
        user.atualizarSenha(senha);
        if(user instanceof Cliente){
            repositorioCliente.update(user);
        }if(user instanceof Tecnico){
            repositorioTecnico.update(user);
        }if(user instanceof Gerente){
            repositorioGerente.update(user);
        }
        
    }
    

    public Object buscarUsuario(String text) {
        repositorioTecnico = new TecnicoDAO();
        repositorioCliente = new ClienteDAO();
        repositorioGerente = new GerenteDAO();
        Object usuario;
        usuario = repositorioTecnico.findByEmail(text);
        if(usuario == null){
            usuario = repositorioCliente.findByEmail(text);
        }  
        if(usuario == null){
            usuario = repositorioGerente.findByEmail(text);
        }  
        return usuario;
    }
    
}
