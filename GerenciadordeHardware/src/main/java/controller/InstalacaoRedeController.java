/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.tableModel.TMInstalacaoRede;
import java.util.Calendar;
import java.util.List;
import javax.swing.JTable;
import model.*;
import lombok.*;
import model.dao.InstalacaoRedeDAO;
import model.dao.ServicoDAO;
import model.exceptions.InstalacaoRedeException;
import model.validations.InstalacaoRedeValidate;
@Getter //constroi os metodos get
@Setter //constroi os metodos set
@EqualsAndHashCode //constroi os metodos equals e hashCode 
@ToString 

/**
 *
 * @author ruiz
 */
public class InstalacaoRedeController extends ServicoController {
    InstalacaoRedeDAO repositorio;
    ServicoDAO servicoRepositorio;
    
    public InstalacaoRedeController() {
        repositorio = new InstalacaoRedeDAO();
        servicoRepositorio = new ServicoDAO();
    }
    
    public void atualizarInstalacaoRede(Long idServico, Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico,
                          String dataServico, boolean concluido, String tipoRede, String enderecoRede, boolean isPago){
        
        InstalacaoRedeValidate valid = new InstalacaoRedeValidate(); 
        InstalacaoRede novaInstalacaoRede = valid.validaCamposEntrada(idServico, tecnicoResponsavel, clienteAtendido, valor, descricaoServico,
                                                dataServico, concluido, tipoRede, enderecoRede); 
        novaInstalacaoRede.setPago(isPago);
        novaInstalacaoRede.setId(idServico); 
        
        repositorio.update(novaInstalacaoRede);
        
    }
    
    public void cadastrarInstalacaoRede(Long idServico, Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico,
                          String dataServico, boolean concluido, String tipoRede, String enderecoRede, boolean isPago){
        
        InstalacaoRedeValidate valid = new InstalacaoRedeValidate(); 
        InstalacaoRede novaInstalacaoRede = valid.validaCamposEntrada(idServico, tecnicoResponsavel, clienteAtendido, valor, descricaoServico,
                                                dataServico, concluido, tipoRede, enderecoRede); 
        novaInstalacaoRede.setPago(isPago);
        novaInstalacaoRede.setId(idServico); 
        
        repositorio.save(novaInstalacaoRede);
    }
    
    public InstalacaoRede buscarInstalacaoRedePorCliente(Long idCliente){
        return (InstalacaoRede) servicoRepositorio.findInstalacaoRedeByCliente(idCliente);
    }
    
    public InstalacaoRede buscarInstalacaoRedeConcluidaPorCliente(Long idCliente){
        return (InstalacaoRede) servicoRepositorio.findInstalacaoRedeByCliente(idCliente);
    }
    
    /*public List<InstalacaoRede> buscarInstalacoesRedeConcluidas(){
        return servicoRepositorio.findAllInstalacaoRedeConcluida();
    }*/
    
    @Override
    public void atualizarTabela(JTable grd, Long id){
        List<Object> lst = servicoRepositorio.findAllInstalacaoRedeConcluidaPorCliente(id);

        TMInstalacaoRede tmInstalacaoRede = new TMInstalacaoRede(lst); 
        grd.setModel(tmInstalacaoRede);
    }
    
    public void atualizarTabela(JTable grd){
        List<Object> lst = repositorio.findAll();

        TMInstalacaoRede tmInstalacaoRede = new TMInstalacaoRede(lst); // Alterado de TMCadAluno para TMCadTecnico
        grd.setModel(tmInstalacaoRede);
    }
    
    public void excluirInstalacaoRede(InstalacaoRede instalacaoRede){
        if(instalacaoRede != null){
            repositorio.delete(instalacaoRede);
        }else{
            throw new InstalacaoRedeException("Error - Instalacao de Rede inexistente."); // Alterado de AlunoException para TecnicoException
        }
    }
}
