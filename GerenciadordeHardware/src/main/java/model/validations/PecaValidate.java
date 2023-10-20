/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import model.Peca;
import model.exceptions.PecaException;

/**
 *
 * @author diegomorelo
 */
public class PecaValidate {
    
    public Peca validaCamposEntrada(Long idPeca, String codigo, String nome, String descricao, double preco, int estoque, String categoria, String dataFabricacao, String tipo){
        Peca peca = new Peca();
        
        // Dia/Mes/Ano
        String[] partes = dataFabricacao.split("/");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int ano = Integer.parseInt(partes[2]);
        
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
        
        if(preco <= 0 && preco > 20000)
            throw new PecaException("Error - Campo invalido - 'preco'");        
        peca.setPreco(preco);
        
        if(estoque <= 0 & estoque > 5000)
            throw new PecaException("Error - Campo invalido - 'estoque'");        
        peca.setEstoque(estoque);

        if(categoria.isEmpty())
            throw new PecaException("Error - Campo vazio - 'categoria'");        
        peca.setCategoria(categoria);
        
        if(dataFabricacao.isEmpty())
            throw new PecaException("Error - Campo vazio - 'dataFabricacao'");        
        
        if(!(verificaDia(dia) && verificaMes(mes) && verificaAno(ano)))
            throw new PecaException("Error - Campo invalido - 'dataFabricacao'");   
        peca.setDataFabricacao(dataFabricacao);
                
        if(tipo.isEmpty())
            throw new PecaException("Error - Campo vazio - 'tipo'");        
        peca.setTipo(tipo);
        
        
        return peca;
    }
    
    private boolean verificaDia(int dia){
        if(dia >= 0 && dia <= 31)
            return true;
        return false;
    }
    
    private boolean verificaMes(int mes){
        if(mes >= 01 && mes <= 12)
            return true;
        return false;
    }
    
    private boolean verificaAno(int ano){
        if(ano >= 1960 && ano <= 2023)
            return true;
        return false;
    }
}

