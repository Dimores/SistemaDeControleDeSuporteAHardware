/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import java.awt.Color;
import model.Cabo;
import model.Peca;
import model.exceptions.CaboException;

/**
 *
 * @author diego
 */
public class CaboValidate {

    public Cabo validaCamposEntrada(Long id, String codigo, String nome, String descricao, double preco,
            int estoque, String categoria, String dataFabricacao, int comprimento, Color cor, int bitola, String tipoDeCabo) {
        
        PecaValidate pecaValidate = new PecaValidate();
        Peca peca = pecaValidate.validaCamposEntrada(id, codigo, nome, descricao, preco, estoque, categoria, dataFabricacao);
        
        Cabo cabo = new Cabo();
        
        if(comprimento <= 0){
            throw new CaboException("Error - Campo invalido: 'comprimento'.");
        }
        cabo.setComprimento(comprimento);
        
        if(cor == null){
            throw new CaboException("Error - Campo vazio: 'Cor'.");
        }
        cabo.setCor(cor);
        
        if(bitola <= 0){
            throw new CaboException("Error - Campo invalido: 'bitola'.");
        }
        cabo.setBitola(bitola);
        
        if(tipoDeCabo.isBlank()){
            throw new CaboException("Error - Campo vazio: 'tipoDeCabo'.");
        }
        cabo.setTipoDeCabo(tipoDeCabo);
        
        // Agora você pode copiar os valores do peca validado para o cabo
        cabo.setCodigo(peca.getCodigo());
        cabo.setNome(peca.getNome());
        cabo.setDescricao(peca.getDescricao());
        cabo.setPreco(peca.getPreco());
        cabo.setEstoque(peca.getEstoque());
        cabo.setCategoria(peca.getCategoria());
        cabo.setDataFabricacao(peca.getDataFabricacao());

        return cabo;
    }
}
