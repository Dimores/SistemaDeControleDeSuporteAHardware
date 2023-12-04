/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import model.Produto;
import model.exceptions.ProdutoException;

/**
 *
 * @author diego
 */
public class ProdutoValidate {

    public Produto validaCamposEntrada(Long id, String codigo, String nome, String descricao,
            double preco, int estoque, String categoria, String dataFabricacao) {

        Produto produto = new Produto();

        if (codigo.isBlank()) {
            throw new ProdutoException("Error - Campo vazio: 'codigo'.");
        } else if (codigo.length() < 8) {
            throw new ProdutoException("Error - Campo inválido: 'codigo'.");
        }
        produto.setCodigo(codigo);

        if (nome.isBlank()) {
            throw new ProdutoException("Error - Campo vazio: 'nome'.");
        }
        produto.setNome(nome);

        if (descricao.isBlank()) {
            throw new ProdutoException("Error - Campo vazio: 'descricao'.");
        }
        produto.setDescricao(descricao);

        if (preco < 0) {
            throw new ProdutoException("Error - Campo invalido: 'preco'.");
        }
        produto.setPreco(preco);

        if (estoque < 0) {
            throw new ProdutoException("Error - Campo invalido: 'estoque'.");
        }
        produto.setEstoque(estoque);

        if (categoria.isBlank()) {
            throw new ProdutoException("Error - Campo vazio: 'categoria'.");
        }
        produto.setCategoria(categoria);

        if (dataFabricacao.matches("  /  /    ")) {
            throw new ProdutoException("Error - Campo vazio: 'dataFabricacao'.");
        }
        produto.setDataFabricacao(dataFabricacao);

        return produto;
    }
}
