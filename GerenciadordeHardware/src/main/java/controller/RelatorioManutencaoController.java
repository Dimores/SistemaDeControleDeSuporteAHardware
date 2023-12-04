/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.tableModel.TMRelatorioManutencao;
import java.util.List;
import javax.swing.JTable;
import lombok.*;
import model.*;
import model.dao.RelatorioManutencaoDAO;
import model.exceptions.RelatorioManutencaoException;
import model.validations.RelatorioManutencaoValidate;

@Getter //constroi os metodos get
@Setter //constroi os metodos set
@EqualsAndHashCode //constroi os metodos equals e hashCode 
@ToString

/**
 *
 * @author ruiz
 */
public class RelatorioManutencaoController {

    RelatorioManutencaoDAO repositorio;

    public RelatorioManutencaoController() {
        repositorio = new RelatorioManutencaoDAO();
    }

    public void atualizarRelatorioManutencao(Long idRelatorio, String dataRelatorio, String descricao, Cliente clienteRelacionado,
            Tecnico tecnicoResponsavel, String equipamentos, ManutencaoPreventiva manutencaoPreventiva) {
        RelatorioManutencaoValidate valid = new RelatorioManutencaoValidate();
        RelatorioManutencao novoRelatorioManutencao = valid.validaCamposEntrada(idRelatorio, dataRelatorio, descricao, clienteRelacionado, tecnicoResponsavel, equipamentos);

        novoRelatorioManutencao.setIdRelatorio(idRelatorio);
        novoRelatorioManutencao.setManutencaoPreventiva(manutencaoPreventiva);
        repositorio.update(novoRelatorioManutencao);

    }

    public void cadastrarRelatorioManutencao(Long idRelatorio, String dataRelatorio, String descricao, Cliente clienteRelacionado,
            Tecnico tecnicoResponsavel, String equipamentos, ManutencaoPreventiva manutencaoPreventiva) {
        RelatorioManutencaoValidate valid = new RelatorioManutencaoValidate();
        RelatorioManutencao novoRelatorioManutencao = valid.validaCamposEntrada(idRelatorio, dataRelatorio, descricao, clienteRelacionado, tecnicoResponsavel, equipamentos);

        novoRelatorioManutencao.setManutencaoPreventiva(manutencaoPreventiva);
        repositorio.save(novoRelatorioManutencao);
    }

    public void atualizarTabela(JTable grd) {
        List<Object> lst = repositorio.findAll();

        TMRelatorioManutencao tmRelatorioManutencao = new TMRelatorioManutencao(lst); // Alterado de TMCadAluno para TMCadTecnico
        grd.setModel(tmRelatorioManutencao);
    }

    public void excluirRelatorioManutencao(RelatorioManutencao relatorioManutencao) {
        if (relatorioManutencao != null) {
            repositorio.delete(relatorioManutencao);
        } else {
            throw new RelatorioManutencaoException("Error - Relatorio de Manutencao inexistente.");
        }
    }

}
