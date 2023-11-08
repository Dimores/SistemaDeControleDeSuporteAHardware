/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import controller.tableModel.TMRelatorioManutencao;
import controller.tableModel.TMRelatorioRede;
import java.util.List;
import javax.swing.JTable;
import lombok.*;
import model.*;
import model.dao.RelatorioRedeDAO;
import model.exceptions.RelatorioRedeException;
import model.validations.RelatorioRedeValidate;
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
    
    public RelatorioRedeController() {
        repositorio = new RelatorioRedeDAO();
    }
    
    public void atualizarRelatorioRede(Long idRelatorio, String dataRelatorio, String descricao, Cliente clienteRelacionado, Tecnico tecnicoResponsavel, String tipoRede){
        RelatorioRedeValidate valid = new RelatorioRedeValidate();
        RelatorioRede novoRelatorioRede = valid.validaCamposEntrada(idRelatorio, dataRelatorio, descricao, clienteRelacionado, tecnicoResponsavel, tipoRede);

        novoRelatorioRede.setIdRelatorio(idRelatorio);
        repositorio.update(novoRelatorioRede);
        
    }
    
    public void cadastrarRelatorioRede(Long idRelatorio, String dataRelatorio, String descricao, Cliente clienteRelacionado, Tecnico tecnicoResponsavel, String tipoRede){
        RelatorioRedeValidate valid = new RelatorioRedeValidate();
        RelatorioRede novoRelatorioRede = valid.validaCamposEntrada(idRelatorio, dataRelatorio, descricao, clienteRelacionado, tecnicoResponsavel, tipoRede);

        repositorio.save(novoRelatorioRede);
    }
    
    public void atualizarTabela(JTable grd){
        List<Object> lst = repositorio.findAll();

        TMRelatorioRede tmRelatorioRede = new TMRelatorioRede(lst);
        grd.setModel(tmRelatorioRede);
    }
    
    public void excluirRelatorioRede(RelatorioRede relatorioRede){
        if(relatorioRede != null){
            repositorio.delete(relatorioRede);
        }else{
            throw new RelatorioRedeException("Error - Relatorio de Manutencao inexistente."); 
        }
    }
}
