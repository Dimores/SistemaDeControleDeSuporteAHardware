/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.Peca;
import model.PecaExemplar;
import model.dao.PecaExemplarDAO;

/**
 *
 * @author diego
 */
public class PecaExemplarController {

    PecaExemplar pecaExemplar;
    PecaExemplarDAO repositorio;

    public PecaExemplarController() {
        repositorio = new PecaExemplarDAO();
        pecaExemplar = new PecaExemplar();
    }

    // Métodos para lidar com PecaExemplar
    public void cadastrarExemplarPeca(Long idExemplar, String codigo, String nome, String descricao, double preco,
            int estoque, String categoria, String dataFabricacao, Peca peca) {
        // Lógica para cadastrar um exemplar de Peca
        pecaExemplar.setCodigo(codigo);
        pecaExemplar.setNome(nome);
        pecaExemplar.setDescricao(descricao);
        pecaExemplar.setPreco(preco);
        pecaExemplar.setEstoque(1);
        pecaExemplar.setCategoria(categoria);
        pecaExemplar.setDataFabricacao(dataFabricacao);
        pecaExemplar.setPeca(peca);

        for (int i = 0; i < estoque; i++) {
            repositorio.update(pecaExemplar);
        }
    }

    public void atualizarEstoquePeca(Peca peca) {
        int estoque = 0;
        List<PecaExemplar> lst = repositorio.findAllByNome(peca.getNome());

        estoque = lst.size();

        peca.setEstoque(estoque);

        // Força a atualização do estado da entidade Peca
        repositorio.update(peca);

    }

    // Primeiro pegar o ID da peca que esta relacionada com seus exemplares
    public void excluirExemplarPeca(Peca peca) {
        Long idPeca = peca.getId();

        // Lógica para excluir um exemplar de Peca com o mesmo nome
        List<PecaExemplar> lst = repositorio.findAllByIdPeca(idPeca);

        if (!lst.isEmpty()) {
            PecaExemplar primeiroExemplar = (PecaExemplar) lst.get(0);

            repositorio.delete(primeiroExemplar);

        } else {
            // Trate o caso em que não há exemplares associados à peça
        }
    }

    // OBS SEM EDITAR ESTOQUE
    public void atualizarExemplaresPeca(Peca peca) {
        Long idPeca = peca.getId();
        List<PecaExemplar> lst = repositorio.findAllByIdPeca(idPeca);

        for (int i = 0; i < lst.size(); i++) {
            PecaExemplar exemplar = lst.get(i);
            exemplar.setCategoria(peca.getCategoria());
            exemplar.setCodigo(peca.getCodigo());
            exemplar.setDataFabricacao(peca.getDataFabricacao());
            exemplar.setDescricao(peca.getDescricao());
            exemplar.setPago(peca.isPago());
            exemplar.setNome(peca.getNome());
            exemplar.setPreco(peca.getPreco());

            repositorio.update(exemplar);
        }
    }

    // Se caso o estoque de uma Peça for aumentado, essa função será usada
    public void adicionarExemplares(int quantidade, Peca peca) {
        pecaExemplar.setCategoria(peca.getCategoria());
        pecaExemplar.setCodigo(peca.getCodigo());
        pecaExemplar.setDataFabricacao(peca.getDataFabricacao());
        pecaExemplar.setDescricao(peca.getDescricao());
        pecaExemplar.setEstoque(1);
        pecaExemplar.setPago(peca.isPago());
        pecaExemplar.setNome(peca.getNome());
        pecaExemplar.setPreco(peca.getPreco());
        pecaExemplar.setId(peca.getId());
        pecaExemplar.setPeca(peca);
        for (int i = 0; i < quantidade; i++) {
            repositorio.update(pecaExemplar);
        }
    }

    public void alterarExemplarDeAcordoComEstoque(int estoqueNovo, Peca peca) {
        Long idPeca = peca.getId();
        List<PecaExemplar> lst = repositorio.findAllByIdPeca(idPeca);
        int estoqueAntigo = lst.size();
        int diferenca = estoqueAntigo - estoqueNovo;

        if (diferenca > 0) {

            removerExemplares(diferenca, peca);
        } else if (diferenca < 0) {

            adicionarExemplares(Math.abs(diferenca), peca);
        }
    }

    public void removerExemplares(int quantidade, Peca peca) {
        for (int i = 0; i < quantidade; i++) {
            excluirExemplarPeca(peca);
        }
    }

}
