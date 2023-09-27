/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import java.util.HashSet;
import java.util.Set;
import model.Peca;
import model.exceptions.PecaException;

/**
 *
 * @author diegomorelo
 */
public class PecaValidate {
    
    public Peca validaCamposEntrada(String idPeca, String codigo, String nome, String descricao, double preco, int estoque, String categoria, String dataFabricacao, String tipo){
        Peca peca = new Peca();
        
        if(codigo.isEmpty())
            throw new PecaException("Error - Campo vazio - 'codigo'");
        
        if(codigo.length() < 8)
            throw new PecaException("Error - Campo invalido - 'codigo'");       
        peca.setCodigo(codigo);
        
        if(nome.isEmpty())
            throw new PecaException("Error - Campo vazio - 'nome'");        
        peca.setNome(nome);
        
        if(descricao.isEmpty())
            throw new PecaException("Error - Campo vazio - 'descricao'");
        peca.setDescricao(descricao);
        
        if(preco <= 0)
            throw new PecaException("Error - Campo invalido - 'preco'");        
        peca.setPreco(preco);
        
        if(estoque <= 0)
            throw new PecaException("Error - Campo invalido - 'estoque'");        
        peca.setEstoque(estoque);

        if(categoria.isEmpty())
            throw new PecaException("Error - Campo vazio - 'categoria'");        
        peca.setCategoria(categoria);
        
        if(dataFabricacao.isEmpty())
            throw new PecaException("Error - Campo vazio - 'dataFabricacao'");        
        peca.setDataFabricacao(dataFabricacao);
                
        if(tipo.isEmpty())
            throw new PecaException("Error - Campo vazio - 'tipo'");        
        peca.setTipo(tipo);
        
        
        return peca;
    }
}

