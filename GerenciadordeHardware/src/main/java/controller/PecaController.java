/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.*;
import lombok.*;
import model.dao.PecaDAO;
import model.exceptions.PecaException;
import model.validations.PecaValidate;
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
    
    public void cadastrarPeca(String idPeca, String codigo, String nome, String descricao, double preco, int estoque, String categoria, String dataFabricacao, String tipo){
        PecaValidate valid = new PecaValidate(); 
        Peca novaPeca = valid.validaCamposEntrada(idPeca, codigo,  nome, descricao, preco, estoque, categoria, dataFabricacao,  tipo); 
        if(repositorio.findByCodigo(codigo) == null){
            repositorio.save(novaPeca);
        }else{
             throw new PecaException("Error - Já existe um tecnico com este 'Codigo'.");
        }
        
    }
    
    public void atualizarPeca(String idPeca, String codigo, String nome, String descricao, double preco, int estoque, String categoria, String dataFabricacao, String tipo){
        PecaValidate valid = new PecaValidate(); 
        Peca novaPeca = valid.validaCamposEntrada(idPeca, codigo,  nome, descricao, preco, estoque, categoria, dataFabricacao,  tipo); 
        novaPeca.setIdPeca(idPeca); 
        
        repositorio.update(novaPeca);
    }
    
    public void excluirPeca(Peca peca){
        if (peca != null) {
            repositorio.delete(peca);
        } else {
            throw new PecaException("Error - Peca inexistente."); // Alterado de AlunoException para TecnicoException
        }
    }
    
}
