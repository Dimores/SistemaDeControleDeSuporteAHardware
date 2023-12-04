/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.tableModel.TMManutencaoPreventiva;
import javax.swing.JTable;
import model.*;
import lombok.*;
import java.lang.Long;
import java.util.List;
import model.dao.ManutencaoPreventivaDAO;
import model.dao.ServicoDAO;
import model.exceptions.ManutencaoPreventivaException;
import model.validations.ManutencaoPreventivaValidate;

@Getter //constroi os metodos get
@Setter //constroi os metodos set
@EqualsAndHashCode //constroi os metodos equals e hashCode 
@ToString

/**
 *
 * @author ruiz
 */
public class ManutencaoPreventivaController extends ServicoController {

    ManutencaoPreventivaDAO repositorio;
    ServicoDAO servicoRepositorio;

    public ManutencaoPreventivaController() {
        repositorio = new ManutencaoPreventivaDAO();
        servicoRepositorio = new ServicoDAO();
    }

    public void atualizarManutencaoPreventiva(Long idServico, Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico,
            String dataServico, boolean concluido, String equipamentos, String descricaoManutencao, boolean isPago) {

        ManutencaoPreventivaValidate valid = new ManutencaoPreventivaValidate();
        ManutencaoPreventiva novaManutencaoPreventiva = valid.validaCamposEntrada(idServico, tecnicoResponsavel, clienteAtendido, valor, descricaoServico,
                dataServico, concluido, equipamentos);

        novaManutencaoPreventiva.setPago(isPago);

        novaManutencaoPreventiva.setId(idServico);

        repositorio.update(novaManutencaoPreventiva);

    }

    public void cadastrarManutencaoPreventiva(Long idServico, Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico,
            String dataServico, boolean concluido, String equipamentos, String descricaoManutencao, boolean isPago) {

        ManutencaoPreventivaValidate valid = new ManutencaoPreventivaValidate();
        ManutencaoPreventiva novaManutencaoPreventiva = valid.validaCamposEntrada(idServico, tecnicoResponsavel, clienteAtendido, valor, descricaoServico,
                dataServico, concluido, equipamentos);
        novaManutencaoPreventiva.setPago(isPago);
        novaManutencaoPreventiva.setId(idServico);

        repositorio.save(novaManutencaoPreventiva);

    }

    @Override
    public void atualizarTabela(JTable grd) {
        List<Object> lst = repositorio.findAll();

        TMManutencaoPreventiva tmManutencaoPreventiva = new TMManutencaoPreventiva(lst);
        grd.setModel(tmManutencaoPreventiva);
    }

    @Override
    public void atualizarTabela(JTable grd, Long id) {
        List<Object> lst = servicoRepositorio.findAllManutencaoPreventivaConcluida();

        TMManutencaoPreventiva tmManutencaoPreventiva = new TMManutencaoPreventiva(lst);
        grd.setModel(tmManutencaoPreventiva);
    }

    public void excluirManutencaoPreventiva(ManutencaoPreventiva manutencaoPreventiva) {
        if (manutencaoPreventiva != null) {
            repositorio.delete(manutencaoPreventiva);
        } else {
            throw new ManutencaoPreventivaException("Error - Manutencao preventiva inexistente.");
        }

    }

}
