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
import utils.CodigoBarra;
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
    PecaExemplar pecaExemplar;
    Peca novaPeca;
    
    public PecaController(){
        repositorio = new PecaDAO();
        pecaExemplar = new PecaExemplar();
    }
    
    public void atualizarTabela(JTable grd){
        List<Object> lst = repositorio.findAll();
        TMCadPeca tmPeca = new TMCadPeca(lst);
        grd.setModel(tmPeca);
        
    }
    
    public void cadastrarPeca(Long idPeca, String codigo, String nome, String descricao, double preco, int estoque, String categoria, String dataFabricacao){
        PecaValidate valid = new PecaValidate(); 
        novaPeca = valid.validaCamposEntrada(idPeca, codigo,  nome, descricao, preco, estoque, categoria, dataFabricacao); 
        if(repositorio.findByCodigo(codigo) == null){
            repositorio.save(novaPeca);
        }else{
             throw new PecaException("Error - Já existe uma peca com este 'Codigo'.");
        }
        
    }
    
    public void atualizarPeca(Long idPeca, String codigo, String nome, String descricao, double preco, int estoque, String categoria, String dataFabricacao){
        PecaValidate valid = new PecaValidate(); 
        Peca novaPeca = valid.validaCamposEntrada(idPeca, codigo,  nome, descricao, preco, estoque, categoria, dataFabricacao); 
        novaPeca.setId(idPeca); 
        
        repositorio.update(novaPeca);
    }
    
    public void excluirPeca(Peca peca){
        if (peca != null) {
            repositorio.delete(peca);
        } else {
            throw new PecaException("Error - Peca inexistente."); // Alterado de AlunoException para TecnicoException
        }
    }
    
    public void diminuirEstoque(Peca peca){
        int estoque = peca.getEstoque();
        peca.setEstoque(estoque - 1);
        repositorio.update(peca);
    }
   
    
    // Métodos para lidar com PecaExemplar
    public void cadastrarExemplarPeca(Long idExemplar, String codigo, String nome, String descricao, double preco,
            int estoque, String categoria, String dataFabricacao) {
        // Lógica para cadastrar um exemplar de Peca
        pecaExemplar.setCodigo(codigo);
        pecaExemplar.setNome(nome);
        pecaExemplar.setDescricao(descricao);
        pecaExemplar.setPreco(preco);
        pecaExemplar.setEstoque(1);
        pecaExemplar.setCategoria(categoria);
        pecaExemplar.setDataFabricacao(dataFabricacao);
        pecaExemplar.setPeca(novaPeca);
        
        for(int i = 0; i < estoque; i++){
            repositorio.update(pecaExemplar);
        }
    }
    
    public Peca buscarPeca(Long id) {
        return (Peca) this.repositorio.findById(id);   
    }

    public void excluirExemplarPeca(PecaExemplar exemplar) {
        // Lógica para excluir um exemplar de Peca
        
    }
    
}
