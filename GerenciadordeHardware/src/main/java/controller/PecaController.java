/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.tableModel.TMCadPeca;
import controller.tableModel.TMCadTecnico;
import java.util.List;
import javax.swing.JTable;
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
    
    public void atualizarTabela(JTable grd){
        List<Object> lst = repositorio.findAll();
        TMCadPeca tmPeca = new TMCadPeca(lst);
        grd.setModel(tmPeca);
        
    }
    
    public void cadastrarPeca(Long idPeca, String codigo, String nome, String descricao, double preco, int estoque, String categoria, String dataFabricacao, String tipo){
        PecaValidate valid = new PecaValidate(); 
        Peca novaPeca = valid.validaCamposEntrada(idPeca, codigo,  nome, descricao, preco, estoque, categoria, dataFabricacao,  tipo); 
        if(repositorio.findByCodigo(codigo) == null){
            repositorio.save(novaPeca);
        }else{
             throw new PecaException("Error - Já existe uma peca com este 'Codigo'.");
        }
        
    }
    
    public void atualizarPeca(Long idPeca, String codigo, String nome, String descricao, double preco, int estoque, String categoria, String dataFabricacao, String tipo){
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
