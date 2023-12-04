/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.tableModel.TMRelatorioRede;
import java.util.List;
import javax.swing.JTable;
import lombok.*;
import model.*;
import model.dao.RelatorioRedeDAO;
import model.dao.ServicoDAO;
import model.exceptions.RelatorioRedeException;
import model.validations.RelatorioRedeValidate;
import utils.SessionManager;

@Getter //constroi os metodos get
@Setter //constroi os metodos set
@EqualsAndHashCode //constroi os metodos equals e hashCode 
@ToString

/**
 *
 * @author ruiz
 */
public class RelatorioRedeController {

    RelatorioRedeDAO repositorio;
    ServicoDAO servicoRepositorio;

    public RelatorioRedeController() {
        repositorio = new RelatorioRedeDAO();
        servicoRepositorio = new ServicoDAO();
    }

    public void atualizarRelatorioRede(Long idRelatorio, String dataRelatorio, String descricao, Cliente clienteRelacionado,
            Tecnico tecnicoResponsavel, String tipoRede, InstalacaoRede instalacaoRede) {
        RelatorioRedeValidate valid = new RelatorioRedeValidate();
        RelatorioRede novoRelatorioRede = valid.validaCamposEntrada(idRelatorio, dataRelatorio, descricao, clienteRelacionado, tecnicoResponsavel, tipoRede);

        novoRelatorioRede.setInstalacaoRede(instalacaoRede);
        novoRelatorioRede.setIdRelatorio(idRelatorio);
        repositorio.update(novoRelatorioRede);
    }

    public void cadastrarRelatorioRede(Long idRelatorio, String dataRelatorio, String descricao, Cliente clienteRelacionado,
            Tecnico tecnicoResponsavel, String tipoRede, InstalacaoRede instalacaoRede) {
        RelatorioRedeValidate valid = new RelatorioRedeValidate();
        RelatorioRede novoRelatorioRede = valid.validaCamposEntrada(idRelatorio, dataRelatorio, descricao, clienteRelacionado, tecnicoResponsavel, tipoRede);

        novoRelatorioRede.setInstalacaoRede(instalacaoRede);

        repositorio.save(novoRelatorioRede);
    }

    public void atualizarTabela(JTable grd) {
        List<Object> lst = repositorio.findByCliente(SessionManager.getId());

        TMRelatorioRede tmRelatorioRede = new TMRelatorioRede(lst);
        grd.setModel(tmRelatorioRede);
    }

    public void atualizarTabela(JTable grd, Long idCliente) {
        List<Object> lst = repositorio.findAllByCliente(idCliente);

        TMRelatorioRede tmRelatorioRede = new TMRelatorioRede(lst);
        grd.setModel(tmRelatorioRede);
    }

    public void excluirRelatorioRede(RelatorioRede relatorioRede) {
        if (relatorioRede != null) {
            repositorio.delete(relatorioRede);
        } else {
            throw new RelatorioRedeException("Error - Relatorio de Manutencao inexistente.");
        }
    }

}
