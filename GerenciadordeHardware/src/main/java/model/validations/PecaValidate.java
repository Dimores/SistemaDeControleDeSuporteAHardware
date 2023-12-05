/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import model.Peca;
import model.exceptions.PecaException;
import utils.Data;

/**
 *
 * @author diegomorelo
 */
public class PecaValidate {

    public Peca validaCamposEntrada(Long idPeca, String codigo, String nome, String descricao, double preco, int estoque, String categoria, String dataFabricacao) {
        Peca peca = new Peca();
        String data = Data.pegaDataSistema();
        String[] partesDataSistema = data.split("/");
        int diaSistema = Integer.parseInt(partesDataSistema[0]);
        int mesSistema = Integer.parseInt(partesDataSistema[1]);
        int anoSistema = Integer.parseInt(partesDataSistema[2]);
        System.out.println(diaSistema + " " + mesSistema +" " +anoSistema);
        // Dia/Mes/Ano
        String[] partes = dataFabricacao.split("/");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int ano = Integer.parseInt(partes[2]);

        if (codigo.isEmpty()) {
            throw new PecaException("Error - Campo vazio - 'codigo'");
        }

        if (codigo.length() < 8) {
            throw new PecaException("Error - Campo invalido - 'codigo'");
        }
        peca.setCodigo(codigo);

        if (nome.isEmpty()) {
            throw new PecaException("Error - Campo vazio - 'nome'");
        }
        peca.setNome(nome);

        if (descricao.isEmpty()) {
            throw new PecaException("Error - Campo vazio - 'descricao'");
        }
        peca.setDescricao(descricao);

        if (preco <= 0 && preco > 20000) {
            throw new PecaException("Error - Campo invalido - 'preco'");
        }
        peca.setPreco(preco);

        if (estoque <= 0 & estoque > 5000) {
            throw new PecaException("Error - Campo invalido - 'estoque'");
        }
        peca.setEstoque(estoque);

        if (categoria.isEmpty()) {
            throw new PecaException("Error - Campo vazio - 'categoria'");
        }
        peca.setCategoria(categoria);

        if (dataFabricacao.isEmpty()) {
            throw new PecaException("Error - Campo vazio - 'dataFabricacao'");
        }

        if (!((dia <= 31 && dia > 0)  && (mes <= 12 && mes > 0 ) && ano <= anoSistema)) {
            throw new PecaException("Error - Campo invalido - 'dataFabricacao'");
        }
        peca.setDataFabricacao(dataFabricacao);

        return peca;
    }

}
