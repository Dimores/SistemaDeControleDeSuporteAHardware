/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import model.DispositivoDeRede;
import model.Produto;
import model.exceptions.DispositivoRedeException;

/**
 *
 * @author diego
 */
public class DispositivoRedeValidate {

    public DispositivoRedeValidate() {
        
    }
    
    public DispositivoDeRede validaCamposEntrada(Long id, String codigo, String nome, String descricao, double preco, int estoque, String categoria, String dataFabricacao, 
                                            String enderecoIP, String fabricante, String modelo){
        
        ProdutoValidate produtoValidate = new ProdutoValidate();
        Produto produto = produtoValidate.validaCamposEntrada(id, codigo, nome, descricao, preco, estoque, categoria, dataFabricacao);
        
        DispositivoDeRede dispositivoRede = new DispositivoDeRede();      

        
        if(enderecoIP.matches("   .   .  . ")){
            throw new DispositivoRedeException("Error - Campo vazio: 'enderecoIP'.");
        }
        dispositivoRede.setEnderecoIP(enderecoIP);
        
        if(fabricante.isBlank()){
            throw new DispositivoRedeException("Error - Campo vazio: 'fabricante'.");
        }
        dispositivoRede.setFabricante(fabricante);
        
        if(modelo.isBlank()){
            throw new DispositivoRedeException("Error - Campo vazio: 'modelo'.");
        }
        dispositivoRede.setModelo(modelo);
        
        // Agora você pode copiar os valores do produto validado para o dispositivo de rede
        dispositivoRede.setCodigo(produto.getCodigo());
        dispositivoRede.setNome(produto.getNome());
        dispositivoRede.setDescricao(produto.getDescricao());
        dispositivoRede.setPreco(produto.getPreco());
        dispositivoRede.setEstoque(produto.getEstoque());
        dispositivoRede.setCategoria(produto.getCategoria());
        dispositivoRede.setDataFabricacao(produto.getDataFabricacao());
        
        return dispositivoRede;
    }
    
}
