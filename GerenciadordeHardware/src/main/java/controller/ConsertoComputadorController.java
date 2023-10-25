/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.tableModel.TMConsertoComputador;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import model.*;

import lombok.*;
import model.dao.ConsertoComputadorDAO;
import model.exceptions.ConsertoComputadorException;
import model.validations.ConsertoComputadorValidate;
@Getter //constroi os metodos get
@Setter //constroi os metodos set
@EqualsAndHashCode //constroi os metodos equals e hashCode 
@ToString 

/**
 *
 * @author ruiz
 */
public class ConsertoComputadorController extends ServicoController{
    ConsertoComputadorDAO repositorio;
    
    public ConsertoComputadorController(){
        repositorio = new ConsertoComputadorDAO();
    }
    
    public void atualizarConsertoComputador(Long idServico, Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico,
                                                        String dataServico, boolean concluido, List pecasSubstituidas){
        
        ConsertoComputadorValidate valid = new ConsertoComputadorValidate(); 
        ConsertoComputador novoConsertoComputador = valid.validaCamposEntrada(idServico, tecnicoResponsavel, clienteAtendido, valor, descricaoServico,
                                                        dataServico, concluido, pecasSubstituidas); 
        novoConsertoComputador.setId(idServico); 
        
        repositorio.update(novoConsertoComputador);
        
        
    }
    
    public void cadastrarConsertoComputador(Long idServico, Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico,
                                                        String dataServico, boolean concluido, List pecasSubstituidas){
        ConsertoComputadorValidate valid = new ConsertoComputadorValidate(); 
        ConsertoComputador novoConsertoComputador = valid.validaCamposEntrada(idServico, tecnicoResponsavel, clienteAtendido, valor, descricaoServico,
                                                        dataServico, concluido, pecasSubstituidas); 
        novoConsertoComputador.setId(idServico); 
        repositorio.save(novoConsertoComputador);
    }
    
    public void buscarConsertoComputador(){
        
    }
    
    @Override
    public void atualizarTabela(JTable grd){
        List<Object> lst = repositorio.findAll();

        TMConsertoComputador tmConsertoComputador = new TMConsertoComputador(lst); // Alterado de TMCadAluno para TMCadTecnico
        grd.setModel(tmConsertoComputador);
    }
    
    public void excluirConsertoComputador(ConsertoComputador consertoComputador){
        if(consertoComputador != null){
            repositorio.delete(consertoComputador);
        }else{
            throw new ConsertoComputadorException("Error - ConsertoComputador inexistente."); // Alterado de AlunoException para TecnicoException
        }
        
    }
    
}
