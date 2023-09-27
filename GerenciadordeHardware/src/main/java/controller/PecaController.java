/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.*;
import lombok.*;
import model.dao.PecaDAO;
@Getter //constroi os metodos get
@Setter //constroi os metodos set
@EqualsAndHashCode //constroi os metodos equals e hashCode 
@ToString 

/**
 *
 * @author ruiz
 */
public class PecaController extends ProdutoController{
    PecaDAO repositorio;
    
    public PecaController(){
        repositorio = new PecaDAO();
    }
    
    public void atualizarTabela(){
        
    }
    
    public void cadastrarPeca(){
        
        
        
    }
    
    public void atualizarPeca(){
        
    }
    
    public void excluirPeca(){
        
    }
    
}
